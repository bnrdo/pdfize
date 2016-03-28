package com.bdo.pdfsh.dto;

import com.bdo.pdfsh.strategy.PerBookmarkSplitStrategy;
import com.bdo.pdfsh.strategy.PerPageSplitStrategy;
import com.bdo.pdfsh.strategy.SplitStrategy;

public enum ESplitStrategy {
	PER_BOOKMARK {
		@Override public SplitStrategy create() {
			return new PerBookmarkSplitStrategy();
		}
	}, PER_PAGE {
		@Override public SplitStrategy create() {
			return new PerPageSplitStrategy();
		}
	};
	
	public abstract SplitStrategy create();
}
