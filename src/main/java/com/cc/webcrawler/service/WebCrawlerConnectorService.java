package com.cc.webcrawler.service;

import org.jsoup.nodes.Document;

/**
 * @author ccarrillo
 *
 */
public interface WebCrawlerConnectorService {

	Document getDocument(String url);
}
