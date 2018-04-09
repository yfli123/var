package com.yfli.test.middle;

import java.io.File;

public class FileList {
	public static void main(String[] args) {
		File f = new File("C:/filetest/file/");
		getFolderFile(f);
	}
	
	
	public static void getFolderFile(File f1) {
		File[] fileList = f1.listFiles();
		for(File x:fileList) {
			if(x.isDirectory()) {
				getFolderFile(x);
			} else {
				System.out.println(x);
			}
		}
		
		
	}
	
}
