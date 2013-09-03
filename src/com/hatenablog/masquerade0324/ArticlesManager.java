package com.hatenablog.masquerade0324;

import java.util.ArrayList;

public class ArticlesManager {
	private ArrayList<String> siteNames = new ArrayList<String>();
	private ArrayList<Article> articleList = new ArrayList<Article>();
	private ArticleObserver articleObserver = new ArticleObserver();
	
	public ArrayList<Article> getArticles(String site) {
		ArrayList<Article> articles = new ArrayList<Article>();
		for (Article article: articleList) {
			if (article.getSiteName().equals(site)) {
				articles.add(article);
			}
		}
		return articles;
	}
	
	public ArrayList<Article> getAllArticles() {
		return articleList;
	}
	
	public void registerSite(String site) {
		siteNames.add(site);
	}
	
	public void addArticles(ArrayList<Article> articles) {
		articleList.addAll(articles);
	}
	
	public void execute() {
		articleList.clear();
		ArticlesBuilder articlesBuilder = new ArticlesBuilder();
		for (String site: siteNames) {
			addArticles(articlesBuilder.parseRSS(site));	
		}
		articleObserver.update(this);
	}
}