package com.hatenablog.masquerade0324;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * 記事を一覧表示するパネルのクラス
 *  @author meteorakey
 * 
 */
public class ArticlesPanel extends ScrollPane implements ArticleObserver {

	private ArrayList<Article> articleList = new ArrayList<Article>();
	private GridPane articlesPane = new GridPane();
	private final int GAP = 40;

	/**
	 * Constructor
	 */
	public ArticlesPanel() {
		// スクロールバーの設定
		this.setLayoutX(GAP * 3);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setContent(articlesPane);

		// 記事リストを表示するパネル設定
		articlesPane.setVgap(GAP);
		articlesPane.setHgap(GAP);
		articlesPane.setAlignment(Pos.CENTER);
	}

	@Override
	public void update(ArticlesManager articleManager) {
		articlesPane.getChildren().clear();
		System.out.println("panel update.");
		this.articleList = articleManager.getAllArticles();
		int row = 0;
		int showNum = Math.min(articleList.size(), 100);
		for (int i = 0; i < showNum; i++) { //this.articleList.size(); i++) {
			ArticleView articleView = new ArticleView(this.articleList.get(i));
			articlesPane.add(articleView, i % 3, row);
			if (i % 3 == 2) row++;  
		}
	}
}
