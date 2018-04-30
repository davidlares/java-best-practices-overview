package com.davidlares.aw.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Report {

	private String title;
	private String nameFile;
	private String content;
	private String extension;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public void makeReport() {
		
		// not empty
		if((getNameFile() != null) && (getTitle() != null) && (getContent() != null)) {
			try {
				// creating a file
				File file = new File(getNameFile() + "." + getExtension());
				// read the characters in a Stream
				FileOutputStream fos = new FileOutputStream(file); // file to write bytes
				// convert stream - bytes into files
				OutputStreamWriter osw = new OutputStreamWriter(fos); // stream to bytes
				// write elements faster config
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(getContent()); // writing content
				bw.close();
			} catch (IOException e) {
				System.out.println("IO error" + e);
			}
		}
	}
	private String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
}
