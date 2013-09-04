package com.hatenablog.masquerade0324;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MMRSSViewer extends Application {

	private ArticlesPanel articlesPanel = new ArticlesPanel();
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
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
		
		ArticlesManager manager = new ArticlesManager();
		manager.setArticleObserver(this.getArticlesPanel());
		manager.registerSite("http://feed.rssad.jp/rss/gigazine/rss_2.0");
		manager.execute();
	}

	@Override
	public void stop() { // 終了時に呼び出し
		System.out.println("Application Ended.");
	}


	public void run() {
		launch();

	}
}
