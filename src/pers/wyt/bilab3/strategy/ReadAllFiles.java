package pers.wyt.bilab3.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class ReadAllFiles {

	/**
	 * 读取某个文件夹下的所有文件
	 */
	public static ArrayList<String> readfile(String filepath) throws FileNotFoundException, IOException {
		ArrayList<String> allFiles = new ArrayList();
		try {

			File file = new File(filepath);
			if (!file.isDirectory()) {
				//System.out.println("path=" + file.getPath());
				//System.out.println("absolutepath=" + file.getAbsolutePath());
				allFiles.add(file.getAbsolutePath());
				//System.out.println("name=" + file.getName());

			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						//System.out.println("path=" + readfile.getPath());
						//System.out.println("absolutepath=" + readfile.getAbsolutePath());
						//System.out.println("name=" + readfile.getName());
						allFiles.add(readfile.getAbsolutePath());

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i]);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		
		/*
		for(String a:allFiles) {
			System.out.println(a);
		}
		*/
		return allFiles;
	}

	public static void main(String[] args) {
		try {
			readfile("D:\\Cytochrome C");
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}
}
