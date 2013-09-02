package com.hatenablog.masquerade0324;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ArticleView extends Pane {

	private Article article;
	
	ArticleView() {
		// パネルサイズ設定
		this.setWidth(340);
		this.setHeight(200);
		this.setMaxWidth(340);
		this.setMaxHeight(200);
		
		// Title設定
		TextArea title = new TextArea("Article");
		title.setMaxWidth(340);
		this.getChildren().add(title);
		
		// URL
		// 画像
		// 説明
		//Canvas canvas = new Canvas();
		//GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setFill(Color.GRAY);
		//Image image = new Image("~/Dropbox/ICONs/aricia.png");
		//gc.drawImage(image, 0, 0);
		//this.getChildren().add(canvas);
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
