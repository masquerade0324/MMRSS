package com.hatenablog.masquerade0324;

public class Article {
	private String title;
	private String date;
	private String link;
	private String description;
	private String image;
	private String siteName;
	private boolean marked;
	
	Article() {
		title = "";
		date = "";
		link = "";
		description = "";
		image = "";
		siteName = "";
		marked = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSiteName() {
		return siteName;
	}
	
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public boolean getMarked() {
		return marked;
	}
	
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	@Override
	public String toString() {
		return "記事のタイトル：" + title + "\n記事のURL：" + link + 
				"\n記事の説明：" + description + "\n記事の発行日時：" + date;
	}
}
