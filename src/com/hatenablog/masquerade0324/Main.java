package com.hatenablog.masquerade0324;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		 HBox hbox = new HBox();
		 Scene scene = new Scene(hbox);
		 hbox.getChildren().add(new Label("Hello, World"));
		 
		 stage.setScene(scene);
		 stage.setTitle("Hello");
		 stage.show();
	}

	public static void main(String[] args) {
		String endadget = "http://feed.rssad.jp/rss/engadget/rss";
		String gigazine = "http://feed.rssad.jp/rss/gigazine/rss_2.0";
		ArticlesBuilder articlesBuilder = new ArticlesBuilder();
		ArrayList<Article> articleList = articlesBuilder.parseRSS(gigazine);
		articleList.addAll(articlesBuilder.parseRSS(endadget));
		for (Article article: articleList) {
			System.out.println(article);
		}
		launch(args);
	}
}
