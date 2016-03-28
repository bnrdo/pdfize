package com.bdo.pdfsh.service;

import java.io.IOException;
import java.util.zip.ZipOutputStream;

import com.bdo.pdfsh.dto.SplitUploadForm;
import com.itextpdf.text.DocumentException;

public interface PDFService {
	void generateThenZipSplitPDF(SplitUploadForm form, ZipOutputStream zipOut) throws IOException, DocumentException;
}
