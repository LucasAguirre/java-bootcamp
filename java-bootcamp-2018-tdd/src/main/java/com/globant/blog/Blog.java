package com.globant.blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {
	/**
	 * Blog class, here a series of Posts are administered
	 */

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
		if (posts.contains(post)) {
			posts.remove(post);
		}
	}

	public List<Post> getLastPost(int quantity) {
		/**
		 * returns the required number of post in order to the most recent, if the
		 * amount is greater than the total all existing ones are returned
		 */
		if (quantity < posts.size()) {
			return posts.subList(posts.size() - quantity, posts.size());
		}
		return posts.subList(0, posts.size());
	}

}
