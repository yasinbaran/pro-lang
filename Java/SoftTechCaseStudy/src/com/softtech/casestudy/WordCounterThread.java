package com.softtech.casestudy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCounterThread extends Thread {

	public final static int THREAD_POOL_SIZE = 5;
	public static Map<String, Integer> counter = null;
	public static int sentenceCount = 0;
	public static int wordCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dosyanın sistemdeki adresini giriniz(C:/example1.txt): ");
		String path = sc.nextLine();
		String content = null;
		try {
			content = readTextFile(path);
		} catch (IOException e1) {
			System.out.println("Dosya okunurken hata oluştu.");
		}

		if (null == content) {
			System.out.println("Dosya içeriği bulunamadı.");
			return;
		}

		System.out.print("Thread sayısını giriniz: ");
		int threadCount = sc.nextInt();
		if (threadCount == 0)
			threadCount = THREAD_POOL_SIZE;

		counter = Collections.synchronizedMap(new HashMap<String, Integer>());

		ArrayList<String> sentences = splitSentences(content);
		sentenceCount = sentences.size();
		System.out.println("Sentence Count: " + sentenceCount);

		List<BabyThread> babyThreadList = new ArrayList<BabyThread>();
		for (int i = 0; i < threadCount; i++) {
			BabyThread babyThread = new BabyThread();
			babyThread.start();
			babyThreadList.add(babyThread);
		}

		do {
			for (BabyThread babyThread : babyThreadList) {
				if (sentences.size() == 0) {
					break;
				}
				babyThread.addSentences(sentences.get(0));
				sentences.remove(0);
			}
		} while (sentences.size() != 0);

		int babySize = babyThreadList.size();
		do {
			for (BabyThread babyThread : babyThreadList) {
				if (babyThread.isQueueEmpty()) {
					babyThread.interrupt();
					babySize--;
				}
			}
		} while (babySize != 0);

		System.out.println("Avg. Word Count: " + wordCount / sentenceCount);
		System.out.println("Thread counts: ");
		for (BabyThread babyThread : babyThreadList) {
			System.out.println("ThreadId=" + babyThread.getId() + " Count=" + babyThread.getSentenceCount());
		}
		sortCounter();
		printCounter();
		Thread.currentThread().interrupt();
	}

	public static void sortCounter() {
		counter = counter.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
	}

	public static void printCounter() {
		System.out.println(counter);
	}

	public static String readTextFile(String fileName) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		return content;
	}

	public static ArrayList<String> splitSentences(String input) {
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(input);
		int start = iterator.first();
		ArrayList<String> sentences = new ArrayList<String>();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
			sentences.add(input.substring(start, end));
		}
		return sentences;
	}

}
