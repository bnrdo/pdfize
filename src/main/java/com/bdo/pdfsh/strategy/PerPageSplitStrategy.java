package com.bdo.pdfsh.strategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PerPageSplitStrategy implements SplitStrategy{

	@Override
	public void splitPDF(InputStream inputStream, ZipOutputStream zipOut) throws IOException, DocumentException{
		
		PdfReader reader = new PdfReader(inputStream);
		PdfReader.unethicalreading = true;
		
		int pageCount = reader.getNumberOfPages();
		int ctr = 1;
		
		while(ctr <= pageCount){
			Document document = new Document();
	        
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			
			document.open();
			
			PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
	        PdfImportedPage page;
	        
	        document.newPage();
	        page = writer.getImportedPage(reader, ctr);
	        cb.addTemplate(page, 0, 0);
			
	        document.close();
	        
	        ZipEntry entry = new ZipEntry("page" + ctr++ + ".pdf");
	        zipOut.putNextEntry(entry);
	        zipOut.write(baos.toByteArray());
		}
		
		reader.close();
        zipOut.close();
	}
	
}
