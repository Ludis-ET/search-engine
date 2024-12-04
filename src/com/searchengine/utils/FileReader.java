package com.searchengine.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FileReader {
    /**
     * Reads text content from a `.txt` file.
     * @param file The text file to read.
     * @return Content of the file as a String.
     */
    public static String readTextFile(File file) {
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            System.err.println("Error reading text file: " + e.getMessage());
            return "";
        }
    }

    /**
     * Extracts text content from a `.pdf` file.
     * @param file The PDF file to read.
     * @return Extracted text content as a String.
     */
    public static String extractTextFromPDF(File file) {
        try (PDDocument pdfDocument = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(pdfDocument);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
