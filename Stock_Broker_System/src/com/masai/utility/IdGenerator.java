package com.masai.utility;

public class IdGenerator {
	public static int generateId() {
		return (int) (Math.random() * 1000000);
	}
}
