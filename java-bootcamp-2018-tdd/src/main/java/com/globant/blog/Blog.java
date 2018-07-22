package com.globant.blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private String name;
	private ArrayList<Post> posts;

	public Blog(String name) {
		this.setName(name);
		this.posts = new ArrayList<Post>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEntry(Post post) {
		this.posts.add(post);
	}
	public int quantityPost() {
		return this.posts.size();
	}

	public void deleteEntry(Post post) {
	/*	for(Post it:posts) {
			if(it.)
		}*/
		if (posts.contains(post)) {
			posts.remove(post);
		}
	}

	public List<Post> getLastPost(int quantity) {
		if (quantity < posts.size()) {
			return posts.subList(posts.size()- quantity, posts.size());
		}
		return posts.subList(0, posts.size());
	}

	
}
