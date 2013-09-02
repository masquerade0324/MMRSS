package com.hatenablog.masquerade0324;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ArticlesBuilder {
	ArticlesManager articleManeger;
	
	ArticlesBuilder() {
		
	}
	
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
		System.out.println("タグの名前；" + rss.getTagName());
		
		NodeList channels = rss.getElementsByTagName("channel");
		System.out.println("タグの数：" + channels.getLength());
		
		for (int i = 0; i < channels.getLength(); i++) {
			Element channel = (Element)channels.item(i);
			
			String siteName = getContentByTagName(channel, "title");
			String siteLink = getContentByTagName(channel, "link");
			String siteDescription = getContentByTagName(channel, "description");
			
			System.out.println("サイトの名前：" + siteName);
			System.out.println("サイトのURL：" + siteLink);
			System.out.println("サイトの説明：" + siteDescription);
			
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
				String date = getContentByTagName(item, "pubDate");
				if (date.equals("")) {
					date = getContentByTagName(item, "dc:date");
				}
				article.setDate(date);
				
				articles.add(article);
			}
		}
		
		return articles;
	}
	
	private static String getContentByTagName(Element elem, String tagName) {
		NodeList nodeList = elem.getElementsByTagName(tagName);
		return nodeList.getLength() != 0 ? nodeList.item(0).getFirstChild().getNodeValue() : "";
	}
}
