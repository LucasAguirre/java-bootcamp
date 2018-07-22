package com.globant.blog;

import java.util.Date;

public class Post {

	private String title;
	private String text;

	public Post(String title, String text) {
		this.setTitle(title);
		this.setText(text);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int compareTo(Post post) {
		if ((post.getTitle().equals(this.title)) && (post.getText().equalsIgnoreCase(this.text))) {
			return 0;
		}
		return 1;
	}

	@Override
	public boolean equals(Object post) {
		if ((((Post) post).getTitle().equalsIgnoreCase(this.title)) && (((Post)post).getText().equalsIgnoreCase(this.text))) {
			return true;
		}
		return false;
	}

}
