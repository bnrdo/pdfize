package com.bdo.pdfsh.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.DocumentException;

public interface SplitStrategy {
	void splitPDF(InputStream inputStream, ZipOutputStream zipOut) throws IOException, DocumentException;
}
