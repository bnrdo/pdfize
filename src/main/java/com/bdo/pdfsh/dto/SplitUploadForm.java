package com.bdo.pdfsh.dto;

public class SplitUploadForm extends UploadForm{

	private ESplitStrategy splitStrategy;
	
	public SplitUploadForm(){
		this.splitStrategy = ESplitStrategy.PER_PAGE;
	}

	public ESplitStrategy getSplitStrategy() {
		return splitStrategy;
	}

	public void setSplitStrategy(ESplitStrategy splitStrategy) {
		this.splitStrategy = splitStrategy;
	}
}
