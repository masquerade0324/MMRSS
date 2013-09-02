package com.hatenablog.masquerade0324;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MMRSSViewer extends Application{

	ArticlesPanel panel = new ArticlesPanel();
	
	@Override
	public void start(Stage stage) { // シーングラフを構築
		Scene panelScene = new Scene(panel);
		stage.setScene(panelScene);
		
		// ウィンドウのタイトルとサイズを決定
		stage.setTitle("MMRSS");
		stage.setWidth(800);
		stage.setHeight(600);
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
