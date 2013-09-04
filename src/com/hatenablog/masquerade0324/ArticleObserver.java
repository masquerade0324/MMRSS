package com.hatenablog.masquerade0324;

import java.util.ArrayList;

<<<<<<< HEAD
	public boolean update() {
		return true;
	}
	
=======
public class ArticleObserver {
	public void update(ArticlesManager manager) {
		// 未実装
		System.out.println("update");
		ArrayList<Article> articles = manager.getAllArticles();
		for (Article article: articles) {
			System.out.println("------------------------------");
			System.out.println(article);
			System.out.println("------------------------------\n");
		}
		System.out.println("done");
	}
>>>>>>> masquerade0324
}
