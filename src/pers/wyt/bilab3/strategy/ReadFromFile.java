package pers.wyt.bilab3.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFile {

	public static String ReadFasta(String path) {
		File file = new File(path);
		Scanner scanner = null;
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		String text = "";
		List<String> words = new ArrayList<>();
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (scanner != null) {
			while (scanner.hasNextLine()) {
				text += scanner.nextLine();
			}
			scanner.close();
		}
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			words.add(matcher.group());
		}
		//¸ÄÎªbufferstring
		String w = "";
		for (String s : words) {
			w += s;
		}
		return w;		
	}
}
