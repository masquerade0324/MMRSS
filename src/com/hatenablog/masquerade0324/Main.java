package com.hatenablog.masquerade0324;

public class Main {
	
	public static void main(String[] args) {
		MMRSSViewer viewer = new MMRSSViewer();
		viewer.run(args);
    /*
=======
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
		
		ArticlesManager manager = new ArticlesManager();
		manager.registerSite(endadget);
		manager.registerSite(gigazine);
		manager.execute();
		
		launch(args);
>>>>>>> masquerade0324
    */
	}
}
