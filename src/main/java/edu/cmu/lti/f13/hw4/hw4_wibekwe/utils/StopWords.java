package edu.cmu.lti.f13.hw4.hw4_wibekwe.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class StopWords {
	public static String  removeStopWords( String document ) throws FileNotFoundException{
      //  System.out.println(System.getProperty("user.dir"));
		//System.out.println(document);
		Scanner sw =new Scanner(new File(System.getProperty("user.dir") + "/src/main/resources/stopwords.txt"));
		ArrayList<String> dict =new ArrayList<String>();
		while( sw.hasNextLine()){
			dict.add(sw.nextLine().trim());
		}
		sw.close();
		
		for( String word: dict ){
			document = document.replaceAll("\\s*\\b" + word+"\\b\\s*", " ");
		}
		//System.out.println(document);

		return document;
	}

}
