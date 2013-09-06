package com.hatenablog.masquerade0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArticlesManager {
	private ArrayList<String> siteNames = new ArrayList<String>();
	private ArrayList<Article> articleList = new ArrayList<Article>();
	private ArticleObserver articleObserver;
	
	// サイト名 site の記事を取得
	public ArrayList<Article> getArticles(String site) {
		ArrayList<Article> articles = new ArrayList<Article>();
		for (Article article: articleList) {
			if (article.getSiteName().equals(site)) {
				articles.add(article);
			}
		}
		return articles;
	}
	
	// すべての記事を取得
	public ArrayList<Article> getAllArticles() {
		return articleList;
	}
	
	// RSSフィードのサイトを登録
	public void registerSite(String site) {
		siteNames.add(site);
	}
	
	public void addArticles(ArrayList<Article> articles) {
		articleList.addAll(articles);
	}

	// 記事のリストを新しい順にソート
	private void sortArticles(ArrayList<Article> articles) {
		Collections.sort(articles, new Comparator<Article>() {
			public int compare(Article a1, Article a2) {
				return a2.getCal().compareTo(a1.getCal());
			}
		});
	}
	
	public void execute() {
		articleList.clear();
		ArticlesBuilder articlesBuilder = new ArticlesBuilder();
		for (String site: siteNames) {
			addArticles(articlesBuilder.parseRSS(site));
		}
		sortArticles(articleList);
		articleObserver.update(this);
	}

	public ArticleObserver getArticleObserver() {
		return articleObserver;
	}

	public void setArticleObserver(ArticleObserver articleObserver) {
		this.articleObserver = articleObserver;
	}
}