package com.bdo.pdfsh.controller;

import java.io.IOException;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdo.pdfsh.dto.CryptoUploadForm;
import com.bdo.pdfsh.dto.SplitUploadForm;
import com.bdo.pdfsh.service.PDFService;
import com.itextpdf.text.DocumentException;

@Controller
public class MainController {
	
	@Autowired
	private PDFService pdfService;
	
	/*@RequestMapping(value = {"split.do", ""}, method = RequestMethod.GET)
	public String split(){
		return "split";
	}
	
	@RequestMapping(value = "crypto.do", method = RequestMethod.GET)
	public String crypto(){
		return "crypto";
	}
	
	@RequestMapping(value = "convert.do", method = RequestMethod.GET)
	public String convert(){
		return "convert";
	}
	
	@RequestMapping(value = "compress.do", method = RequestMethod.GET)
	public String compress(){
		return "compress";
	}*/

	@RequestMapping(value = "upload/split.do", method = RequestMethod.POST)
	@ResponseBody
	public void split(SplitUploadForm form, HttpServletResponse response){
		
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment;filename=test.zip");
		
		try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
	        
			pdfService.generateThenZipSplitPDF(form, zipOut);
	        
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="upload/crypto.do", method=RequestMethod.POST)
	@ResponseBody
	public void crypto(CryptoUploadForm form, HttpServletResponse response){
		System.out.println("yikes");	
	}
}
