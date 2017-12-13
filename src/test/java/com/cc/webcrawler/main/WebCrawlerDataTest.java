package com.cc.webcrawler.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cc.webcrawler.bean.Entry;
import com.cc.webcrawler.service.WebCrawlerConnectorService;
import com.cc.webcrawler.service.WebCrawlerPrinterService;
import com.cc.webcrawler.service.WebCrawlerService;
import com.cc.webcrawler.service.impl.WebCrawlerConnectorServiceImpl;
import com.cc.webcrawler.service.impl.WebCrawlerPrinterServiceImpl;
import com.cc.webcrawler.service.impl.WebCrawlerServiceImpl;
import com.cc.webcrawler.util.StringUtil;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerDataTest {
	
	private String url;
	private Integer limit;
	private Integer numberWords;
	private WebCrawlerConnectorService connector;
	private WebCrawlerService service;
	private WebCrawlerPrinterService printer;
	private List<Entry> entries;
	
	@Before
	public void setUp() {
		url = "https://news.ycombinator.com//";
		limit = 20;
		numberWords = 5;
		service = new WebCrawlerServiceImpl();
		printer = new WebCrawlerPrinterServiceImpl();
		connector = new WebCrawlerConnectorServiceImpl();
		entries = service.getItemsByLimit(url, limit);
	}
	
	@Test
	public void countItemsFromWebSite() {
		Assert.assertEquals(20, entries.size()); 
	}
	
	@Test
	public void validateSizesItemsLessThanNWords() {
		List<Entry> entriesLessThanNWords = service.filterItemsByPredicate(entries, (Entry e) -> StringUtil.getNumberWords(e.getTitle()) <= numberWords);
		Assert.assertNotSame(limit, entriesLessThanNWords.size());
	}
	
	@Test
	public void validateSizesItemsMoreThanNWords() {
		List<Entry> entriesMoreThanNWords = service.filterItemsByPredicate(entries, (Entry e) -> StringUtil.getNumberWords(e.getTitle()) > numberWords);
		Assert.assertNotSame(limit, entriesMoreThanNWords.size());
	}
	
	@Test
	public void validateWrongDocumentInformation() {
		url = "http://www.google.com/";
		entries = service.getItemsByLimit(url, limit);
		Assert.assertTrue(entries.isEmpty());
	}
	
	@Test
	public void validateIncorrectURL() {
		url="http://anything";
		Assert.assertNull(connector.getDocument(url));
	}
	
	@Test
	public void printItems() {
		printer.printItems(entries);
		printer.printItemsOrderedByAmountComments(entries);
		printer.printItemsOrderedByPoints(entries);
	}

}
