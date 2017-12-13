/**
 * 
 */
package com.cc.webcrawler.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cc.webcrawler.bean.Entry;
import com.cc.webcrawler.service.WebCrawlerParserService;
import com.cc.webcrawler.util.StringUtil;

/**
 * @author ccarrillo
 *
 */
public class WebCrawlerParserServiceImpl implements WebCrawlerParserService{

	@Override
	public List<Entry> parseDocument(Document document, Integer limit) {
		List<Entry> entries = new ArrayList<Entry>();
		Elements elements = document.select("table.itemlist tr td");
    	
    	int i = 1;
    	boolean hasOrder = false;
    	boolean hasTitle = false;
    	boolean hasPoint = false;
    	boolean hasComment = false;
    	
    	String order = null;
    	String title = null;
    	String point = null;
    	String comment = null;
    	 
    	for (Element element : elements) {
    		String orderTmp = element.select(".title span.rank").text().trim();
    		if (!orderTmp.equals("")) {
    			order = orderTmp;
    			hasOrder = true;
    		}
    		
   			String titleTmp = element.select(".title a.storylink").text().trim();
   			if (!titleTmp.equals("")) {
   				title = titleTmp;
   				hasTitle = true;
   			}
    		
    		String pointTmp = element.select(".subtext span.score").text().trim();
    		if (!pointTmp.equals("")) {
    			point = pointTmp;
    			hasPoint = true;
    		}
    		
    		String tmp  = element.select(".subtext a[href^=\"item?id\"]").text();
    		int index = tmp.lastIndexOf("ago");        		
    		String commentTmp = tmp.substring(index + 1).replaceAll("go ", "");
    		if (!commentTmp.equals("")) {
    			comment = commentTmp;
    			hasComment = true;
    		}
    		
    		if (i <= limit && (hasOrder && hasTitle && hasPoint && hasComment)) {
    			Entry entry = Entry.newEntry()
        				.order(StringUtil.getOrderValue(order))
        				.title(title)
        				.point(point)
        				.comment(comment)
        				.amountPoint(StringUtil.getNumber(point))
        				.amountComment(StringUtil.getNumber(comment))
        				.build();
        		entries.add(entry);
        		
        		i += 1;
        		hasOrder = false;
            	hasTitle = false;
            	hasPoint = false;
            	hasComment = false;
    		}
    		
    		
    	}
    	
    	return entries;
	}
}
