/**
 * 
 */
package com.cc.webcrawler.service.impl;

import java.util.Collections;
import java.util.List;

import com.cc.webcrawler.bean.Entry;
import com.cc.webcrawler.service.WebCrawlerPrinterService;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerPrinterServiceImpl implements WebCrawlerPrinterService{

	@Override
	public void printItems(List<Entry> items) {
		for (Entry entry : items) {
			printEntry(entry);
		}
	}
	
	private void printEntry(Entry entry) {
		System.out.println(entry.getOrder() + " " + entry.getTitle() + " " + entry.getPoint() + " " + entry.getComment());
	}
	
	@Override
	public void printItemsOrderedByPoints(List<Entry> items) {
		Collections.sort(items, (a, b) -> a.getAmountPoint() < b.getAmountPoint() ? -1 : a.getAmountPoint() == b.getAmountPoint() ? 0 : 1);
		for (Entry entry : items) {
			printEntry(entry);
		}
	}
	
	@Override
	public void printItemsOrderedByAmountComments(List<Entry> items) {
		Collections.sort(items, (a, b) -> a.getAmountComment() < b.getAmountComment() ? -1 : a.getAmountComment() == b.getAmountComment() ? 0 : 1);
		for (Entry entry : items) {
			printEntry(entry);
		}
	}
}
