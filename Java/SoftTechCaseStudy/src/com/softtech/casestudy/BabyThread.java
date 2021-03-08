package com.softtech.casestudy;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class BabyThread extends WordCounterThread {
	private List<String> queue = new ArrayList<String>();
	private int sentenceCount = 0;

	public void addSentences(String sentence) {
		queue.add(sentence);
		setSentenceCount(sentenceCount + 1);
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void interrupt() {
		Thread.currentThread().interrupt();
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (queue.size() > 0) {
				addCounter(queue.get(0));
				queue.remove(0);
			}
		}
	}

	public void addCounter(String sentence) {
		ArrayList<String> words = splitWords(sentence);
		for (String word : words) {
			if (!counter.containsKey(word)) {
				counter.put(word, 1);
			} else {
				counter.put(word, counter.get(word) + 1);
			}
		}
	}

	public ArrayList<String> splitWords(String sentence) {
		BreakIterator iterator = BreakIterator.getWordInstance();
		iterator.setText(sentence);
		int start = iterator.first();
		ArrayList<String> words = new ArrayList<String>();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
			String word = sentence.substring(start, end);
			if (Character.isLetterOrDigit(word.charAt(0))) {
				words.add(word);
			}
		}
		addWordCount(words.size());
		return words;
	}

	public synchronized void addWordCount(int count) {
		wordCount = wordCount + count;
	}

	public int getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(int sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

}
