package com.cc.webcrawler.service;

import java.util.List;

import com.cc.webcrawler.bean.Entry;

/**
 * @author ccarrillo
 *
 */
public interface WebCrawlerPrinterService {

	void printItems(List<Entry> items);
	
	void printItemsOrderedByPoints(List<Entry> items);
	
	void printItemsOrderedByAmountComments(List<Entry> items);
}
