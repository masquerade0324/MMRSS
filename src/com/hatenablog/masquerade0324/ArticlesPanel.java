package com.hatenablog.masquerade0324;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author meteorakey
 * 記事の一覧を表示するパネル
 */
public class ArticlesPanel extends GridPane {

	ArrayList<ArticleView> articleList = new ArrayList<ArticleView>();

	ArticlesPanel() {
		this.setWidth(680);
		this.setHeight(600);
		this.setMaxWidth(680);
		this.setMaxHeight(600);
		this.setVgap(40);
		this.setHgap(40);
		this.setAlignment(Pos.TOP_CENTER);
		
		int row = 0;
		for (int i = 0; i < 8; i++) {
			ArticleView aView = new ArticleView();
			this.add(aView, i % 2, row);
			if (i % 2 == 1) row++;  
		}
	}
	
	public void update() {
		this.getChildren().clear();
	}
}
