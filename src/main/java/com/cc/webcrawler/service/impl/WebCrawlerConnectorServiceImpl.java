package com.cc.webcrawler.service.impl;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.cc.webcrawler.service.WebCrawlerConnectorService;
import com.cc.webcrawler.util.Constant;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerConnectorServiceImpl implements WebCrawlerConnectorService {

	@Override
	public Document getDocument(String url) {
		Connection connection = Jsoup.connect(url).userAgent(Constant.USER_AGENT);
		try {
			return connection.get();
		} catch (IOException ioe) {
			return null;
		}
	}

}
