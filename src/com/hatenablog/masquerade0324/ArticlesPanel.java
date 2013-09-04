package com.hatenablog.masquerade0324;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * 
 *  @author meteorakey
 * 記事の一覧を表示するパネル
 */
public class ArticlesPanel extends ScrollPane implements ArticleObserver {

	private ArrayList<Article> articleList = new ArrayList<Article>();
	private GridPane articlesPane = new GridPane();

	public ArticlesPanel() {
		// スクロールバーの設定
		this.setLayoutX(40);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setContent(articlesPane);

		// 記事リストを表示するパネル設定
		articlesPane.setVgap(40);
		articlesPane.setHgap(40);
		articlesPane.setAlignment(Pos.CENTER);
	}

	public void update(ArticlesManager articleManager) {
		//this.getChildren().clear();
		System.out.println("panel update.");
		this.articleList = articleManager.getAllArticles();
		int row = 0;
		for (int i = 0; i < this.articleList.size(); i++) {
			ArticleView articleView = new ArticleView(this.articleList.get(i));
			articlesPane.add(articleView, i % 2, row);
			if (i % 2 == 1) row++;  
		}
	}
}
