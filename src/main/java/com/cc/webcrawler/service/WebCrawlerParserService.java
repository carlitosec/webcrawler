package com.cc.webcrawler.service;

import java.util.List;

import org.jsoup.nodes.Document;

import com.cc.webcrawler.bean.Entry;

/**
 * @author ccarrillo
 *
 */
public interface WebCrawlerParserService {
	
	List<Entry> parseDocument(Document document, Integer limit) ;

}
