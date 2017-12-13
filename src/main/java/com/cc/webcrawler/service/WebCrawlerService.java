package com.cc.webcrawler.service;

import java.util.List;
import java.util.function.Predicate;

import com.cc.webcrawler.bean.Entry;

public interface WebCrawlerService {

	List<Entry> getItemsByLimit(String url, Integer limit);
	
	List<Entry> filterItemsByPredicate(List<Entry> entries, Predicate<Entry> predicate );
}
