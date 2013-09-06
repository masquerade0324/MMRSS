package com.hatenablog.masquerade0324;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MMRSSViewer extends Application {

	private ArticlesPanel articlesPanel = new ArticlesPanel();
	private ArticlesManager manager;// = new ArticlesManager();
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 900;
	
	public ArticlesPanel getArticlesPanel() {
		return articlesPanel;
	}

	public void setArticlesPanel(ArticlesPanel articlesPanel) {
		this.articlesPanel = articlesPanel;
	}

	@Override
	public void start(Stage stage) {
		// ArticlesPanelの設定
		Scene scene = new Scene(articlesPanel);
		stage.setScene(scene);
		
		// ウィンドウのタイトルとサイズを決定
		stage.setTitle("MMRSS");
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);
		stage.setResizable(false);
		stage.setX(0);
		stage.setY(0);
		stage.show();
		
		System.out.println("Aplication start.");
		
		manager = new ArticlesManager();
		manager.setArticleObserver(this.getArticlesPanel());
		manager.registerSite("http://feed.rssad.jp/rss/gigazine/rss_2.0");
		
		//manager.registerSite("http://www.itmedia.co.jp/info/rss/"); // たぶんrss1.0
		
		manager.registerSite("http://feeds.gizmodo.jp/rss/gizmodo/index.xml");
		manager.registerSite("http://feed.rssad.jp/rss/engadget/rss");
		manager.registerSite("http://www.engadget.com/rss.xml");
		manager.registerSite("http://jp.techcrunch.com/feed/");
		manager.registerSite("http://rss.cnn.com/rss/edition.rss");
		manager.execute();
		/*
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(60),
						new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								manager.execute();
							}
				}));
		timeline.play();
		*/
	}

	@Override
	public void stop() { // 終了時に呼び出し
		System.out.println("Application Ended.");
	}


	public void run() {
		launch();

	}
}
