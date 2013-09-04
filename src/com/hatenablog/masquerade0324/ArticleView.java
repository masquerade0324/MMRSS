package com.hatenablog.masquerade0324;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class ArticleView extends Pane {

	private Article article;
	private static final int WIDTH = 340;
	private static final int HEIGHT = 200;


	public ArticleView(Article article) {
		this.article = article;
		// パネルサイズ設定
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setMaxSize(WIDTH, HEIGHT);

		// Title設定
		TextArea title = new TextArea(this.article.getTitle());
		title.setMaxWidth(WIDTH);
		title.setEditable(false);
		title.setWrapText(true);
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
