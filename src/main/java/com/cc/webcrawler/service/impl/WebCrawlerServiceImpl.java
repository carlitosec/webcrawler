package com.cc.webcrawler.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.jsoup.nodes.Document;

import com.cc.webcrawler.bean.Entry;
import com.cc.webcrawler.service.WebCrawlerConnectorService;
import com.cc.webcrawler.service.WebCrawlerParserService;
import com.cc.webcrawler.service.WebCrawlerService;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerServiceImpl implements WebCrawlerService {
	
	private WebCrawlerConnectorService webCrawlerConnectorService;

	@Override
	public List<Entry> getItemsByLimit(String url, Integer limit) {
		
		WebCrawlerParserService parserService = new WebCrawlerParserServiceImpl();
		
		webCrawlerConnectorService = new WebCrawlerConnectorServiceImpl();
       	Document document = webCrawlerConnectorService.getDocument(url);
       	return parserService.parseDocument(document, limit);
	}
	
	@Override
	public List<Entry> filterItemsByPredicate(List<Entry> entries, Predicate<Entry> predicate ) {
		List<Entry> filterEntries = new ArrayList<Entry>();
		
		for (Entry entry : entries) {
			if (predicate.test(entry)) {
				filterEntries.add(entry);
			}
		}
		
		return filterEntries;
	}
}