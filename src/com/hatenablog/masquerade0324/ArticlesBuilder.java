package com.hatenablog.masquerade0324;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ArticlesBuilder {
	public ArrayList<Article> parseRSS(String url) {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		Document doc = null;
		try {
			HttpURLConnection urlConn = (HttpURLConnection)(new URL(url)).openConnection();
			urlConn.connect();
			
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = docBuilder.parse(urlConn.getInputStream());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Element rss = doc.getDocumentElement();
		//System.out.println("タグの名前；" + rss.getTagName());
		
		NodeList channels = rss.getElementsByTagName("channel");
		//System.out.println("タグの数：" + channels.getLength());
		
		for (int i = 0; i < channels.getLength(); i++) {
			Element channel = (Element)channels.item(i);
			
			String siteName = getContentByTagName(channel, "title");
			String siteLink = getContentByTagName(channel, "link");
			String siteDescription = getContentByTagName(channel, "description");
			
			//System.out.println("サイトの名前：" + siteName);
			System.out.println("サイトのURL：" + siteLink);
			//System.out.println("サイトの説明：" + siteDescription);
			
			NodeList items = channel.getElementsByTagName("item");
			System.out.println("item要素の数：" + items.getLength());
			for (int j = 0; j < items.getLength(); j++) {
				Element item = (Element)items.item(j);
				
				Article article = new Article();
				article.setSiteName(siteName);
				
				String title = getContentByTagName(item, "title");
				article.setTitle(title);
				String link = getContentByTagName(item, "link");
				article.setLink(link);
				String description = getContentByTagName(item, "description");
				article.setDescription(description);
				//System.out.println(description);
				
				String date = getContentByTagName(item, "pubDate");
				Calendar cal;
				if (date.equals("")) {
					date = getContentByTagName(item, "dc:date");
					cal = toCalenedar(date, "dc:date");
				} else {
					cal = toCalenedar(date, "pubDate");
				}
				//articne.setDate(date);
				article.setCal(cal);
				article.setDateFromCal();
				//System.out.println(date);
				//System.out.println(cal);
				
				articles.add(article);
			}
		}
		
		return articles;
	}
	
	private String getContentByTagName(Element elem, String tagName) {
		NodeList nodeList = elem.getElementsByTagName(tagName);
		if (nodeList.getLength() != 0 && nodeList.item(0).getFirstChild() != null) {
			return nodeList.item(0).getFirstChild().getNodeValue(); 
		}
		return "";
	}
	
	private Calendar toCalenedar(String date, String tagName) {
		String pattern;
		if (tagName.equals("pubDate")) {
			pattern = "EEE, dd MMM yyyy HHmmss Z";
		} else if (tagName.equals("dc:date")) {
			pattern = "yyyy-MM-dd'T'HHmmssZ";
		} else {
			pattern = "";
		}
		DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.US);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date.replace(":", "")));
		} catch (Exception e) {
			System.out.println(e);
		}
		return cal;
	}
}