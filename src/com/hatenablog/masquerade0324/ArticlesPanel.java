package com.hatenablog.masquerade0324;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * 
 *  @author meteorakey
 * 記事の一覧を表示するパネル
 */
public class ArticlesPanel extends ScrollPane {

    private ArrayList<ArticleView> articleList = new ArrayList<ArticleView>();
    private GridPane articlesPane = new GridPane();
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

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

	int row = 0;
	for (int i = 0; i < 12; i++) {
	    ArticleView articleView = new ArticleView();
	    articlesPane.add(articleView, i % 2, row);
	    if (i % 2 == 1) row++;  
	}
    }

    public void update() {
	this.getChildren().clear();
    }
}
