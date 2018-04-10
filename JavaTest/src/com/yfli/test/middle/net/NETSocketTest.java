package com.yfli.test.middle.net;

public class NETSocketTest {
	public static void main(String[] args) {
		new NETSocketServer().start();
		new NETSocketClient().start();
	}
}
