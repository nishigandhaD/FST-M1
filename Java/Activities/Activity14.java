package activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\newFolder\\javaexample.txt");
		boolean fStatus = file.createNewFile();
		String content="This is a new java program";
		if(fStatus) {
			System.out.println("File is created sucessfully");
		}
		else {
			System.out.println("File alredy exist");
		}
		
		try {
			FileUtils.writeStringToFile(file,content,"UTF-8");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//File fileUtil = FileUtils.getFile("C:\\\\newFolder\\\\javaexample.txt");
		try {
			String fileData = FileUtils.readFileToString(file,"UTF-8");
			System.out.println("Data inside the file: "+ fileData);
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		File destDir = new File("C:\\resources");
		FileUtils.copyFileToDirectory(file, destDir);
		
		File newFile = FileUtils.getFile("C:\\resources\\javaexample.txt");
		try {
			String newFileData = FileUtils.readFileToString(newFile, "UTF8");
			System.out.println("Data inside the file inside new directory: "+ newFileData);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
