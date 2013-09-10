package com.hatenablog.masquerade0324;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//TODO どのクラスを継承するか確定
public class ArticleView extends Pane {

	private Article article;
	private static final double WIDTH = 320;
	private static final double HEIGHT = 240;
	private LinkAction linkAction = new LinkAction();

	/**
	 * Constructor
	 * @param article
	 */
	public ArticleView(Article article) {
		this.article = article;
		//TODO 全体のレイアウト確定
		// パネルサイズ設定1
		this.setId("article-view");
		this.setMaxSize(WIDTH, HEIGHT);
		this.setMinSize(WIDTH, HEIGHT);
		this.getStylesheets().add(ArticleView.class.getResource("ArticleViewStyle.css").toExternalForm());
		
		VBox vbox = new VBox();
		vbox.setMaxSize(WIDTH, HEIGHT);		

		// Title設定
		TextArea title = new TextArea(this.article.getTitle());
		title.setMaxWidth(WIDTH);
		title.setEditable(false);
		title.setWrapText(true);
/*
		//TODO 画像のサイズ調整
		// 画像
		Image image = null;
		try {
			image = new Image(new FileInputStream("/Users/tatsuya/chihya.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageView iView = new ImageView(image);
*/
		// Link設定
		Hyperlink link = new Hyperlink(this.article.getLink());
		//TODO レイアウト確定及び調整後，linkに画像を設定
		//link.setGraphic(iView);
		link.setAlignment(Pos.BASELINE_RIGHT);
		link.setText("記事へ");
		link.setMaxWidth(WIDTH);
		link.setMaxHeight(HEIGHT / 3.0);
		link.setWrapText(true);
		linkAction.setLink(this.article.getLink());
		link.setOnAction(linkAction);

		// レイアウト設定
		vbox.getChildren().add(title);
		vbox.getChildren().add(link);
		this.getChildren().add(vbox);
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * リンククリック時のアクションクラス
	 * @author meteorakey
	 *
	 */
	class LinkAction implements EventHandler<ActionEvent> {
		private String link;
		@Override
		public void handle(ActionEvent t) {
			System.out.println("clicked.");
			// リンク読み込み
			WebView webView = new WebView();
			WebEngine engine = new WebEngine();
			engine = webView.getEngine();
			engine.load(link);
			
			// 組み込みブラウザ表示設定
			Scene scene = new Scene(webView);
			Stage stage = new Stage();
			stage.setWidth(1080);
			stage.setHeight(800);
			stage.setScene(scene);
			stage.show();
		}
		void setLink(String str) {
			this.link = str;
		}
	}
}
