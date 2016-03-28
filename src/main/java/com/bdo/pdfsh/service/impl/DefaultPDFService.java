package com.bdo.pdfsh.service.impl;

import java.io.IOException;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Service;

import com.bdo.pdfsh.dto.SplitUploadForm;
import com.bdo.pdfsh.service.PDFService;
import com.itextpdf.text.DocumentException;

@Service
public class DefaultPDFService implements PDFService{
	
	@Override
	public void generateThenZipSplitPDF(SplitUploadForm form, ZipOutputStream zipOut) throws IOException, DocumentException{
		form.getSplitStrategy().create().splitPDF(form.getFile().getInputStream(), zipOut);
	}
}
