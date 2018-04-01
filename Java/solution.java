package com.hellokoding.account;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		solution("a0Ba");
	}

	public static int solution(String S) {
		int counter = 0;
		List<Integer> validPasswordSize = new ArrayList<Integer>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < S.length() + 1; i++) {
			if (i != S.length() && !isDigit(S.substring(i, i + 1))) {
				list.add(S.substring(i, i + 1));
				counter = counter + 1;
			} else {
				if (counter == 0) {
					continue;
				}
				if (isValid(list)) {
					validPasswordSize.add(list.size());
					list.clear();
					counter = 0;
				} else {
					list.clear();
					counter = 0;
				}
			}
		}

		return (counter == 0 && validPasswordSize.isEmpty()) ? -1 : bigValue(validPasswordSize);

	}

	// paramatre olarak alýnan listenin içerisinde büyük harf olup olmadýðýný
	// kontrol eder.
	public static boolean isValid(List<String> list) {
		for (String s : list) {
			if (s.matches("[A-Z]")) {
				return true;
			}
		}
		return false;
	}

	// gelen parametrenin digit olup olmadýðýnýn bilgisini döner.
	public static boolean isDigit(String value) {
		if (value.matches("[0-9]")) {
			return true;
		}
		// for (int i = 0; i < digits.length; i++) {
		// if (value.equals(String.valueOf(digits[i]))) {
		// return true;
		// }
		// }
		return false;
	}

	// kullanýlabilir parola dizesinin size'ý en büyük elemanýný bulur.
	public static int bigValue(List<Integer> validPasswordSize) {
		int maxSize = validPasswordSize.get(0);
		for (int i = 0; i < validPasswordSize.size(); i++) {
			if (validPasswordSize.get(i) > maxSize) {
				maxSize = validPasswordSize.get(i);
			}
		}
		return maxSize;
	}

}
