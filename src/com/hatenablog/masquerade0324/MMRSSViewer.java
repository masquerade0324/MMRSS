package com.hatenablog.masquerade0324;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MMRSSViewer extends Application{

	ArticlesPanel articlesPanel = new ArticlesPanel();
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	@Override
	public void start(Stage stage) { // シーングラフを構築
/*
 		// シーングラフのルートを構成予定
		HBox root = new HBox();
		root.setPrefSize(WIDTH, HEIGHT);
		root.setMaxSize(WIDTH, HEIGHT);
		root.setAlignment(Pos.TOP_CENTER);
		Button button = new Button();
		root.getChildren().add(button);
		root.getChildren().add(articlesPanel);
*/
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
	}

	@Override
	public void stop() { // 終了時に呼び出し
		System.out.println("Application Ended.");
	}


	public void run(String[] args) {
		launch(args);

	}

}
