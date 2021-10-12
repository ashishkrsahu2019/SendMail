package com.ashish.mail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

	public void createCSV() throws IOException {
		// Loading an existing document
		PDFReader preader = new PDFReader();
		StringBuffer sb = new StringBuffer();
		File directoryPath = new File("C:\\dailyjobs");
		// List of all files and directories
		File filesList[] = directoryPath.listFiles();
		for (File file : filesList) {
			sb.append(preader.readPDF(preader, file));

			System.out.println("File path: " + file.getAbsolutePath());
		}
		preader.getEmail(sb.toString());

	}

	String readPDF(PDFReader pread, File file) throws IOException {
		PDDocument document = PDDocument.load(file);
		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		// Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		System.out.println(text);
		// Closing the document
		document.close();
		return text;

	}

	void getEmail(String text) {
		BufferedReader bfr = null;
		StringBuilder sb = new StringBuilder();
		String line = "";
		BufferedWriter out = null;
		try {

			bfr = new BufferedReader(new StringReader(text));

			while ((line = bfr.readLine()) != null) {
				String[] arr = line.split(" ");
				for (String s : arr) {
					if (s.length() < 3)
						continue;
					if (s.contains("@")) {
						sb.append(s);
						// lst.add(s);
						sb.append("\n");
						break;
					}

				}
				out = new BufferedWriter(new FileWriter("C:\\temp\\email.csv"));
				out.append(sb.toString());
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			sb = null;
			try {
				bfr.close();

				bfr = null;
				out.close();
				out = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		PDFReader pr = new PDFReader();
		try {
			pr.createCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}