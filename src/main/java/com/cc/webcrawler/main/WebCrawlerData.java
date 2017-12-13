/**
 * 
 */
package com.cc.webcrawler.main;

import java.util.List;

import com.cc.webcrawler.bean.Entry;
import com.cc.webcrawler.service.WebCrawlerPrinterService;
import com.cc.webcrawler.service.WebCrawlerService;
import com.cc.webcrawler.service.impl.WebCrawlerPrinterServiceImpl;
import com.cc.webcrawler.service.impl.WebCrawlerServiceImpl;
import com.cc.webcrawler.util.StringUtil;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerData {
	
	public static void main(String[] args) {
		String url = "https://news.ycombinator.com//";
		WebCrawlerService service = new WebCrawlerServiceImpl();
		WebCrawlerPrinterService printer = new WebCrawlerPrinterServiceImpl(); 
		List<Entry> entries = service.getItemsByLimit(url, 10);
		
		printer.printItems(entries);
		
		System.out.println("\n\nEntries with more than five words with predicate:");
		List<Entry> moreThanEntries = service.filterItemsByPredicate(entries, (Entry e) -> StringUtil.getNumberWords(e.getTitle()) > 5);
		printer.printItemsOrderedByAmountComments(moreThanEntries);
		
		System.out.println("\n\nEntries with less than or equal five words with predicate:");
		List<Entry> lessThanEqualEntries = service.filterItemsByPredicate(entries, (Entry e) -> StringUtil.getNumberWords(e.getTitle()) <= 5);
		printer.printItemsOrderedByPoints(lessThanEqualEntries);
		
	}
}