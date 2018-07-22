package com.globant.blog;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class BlogTest {
	private Blog blog = new Blog("FakeBlog");

	@Test
	public final void testPostNewEntry() {
		blog.addEntry(new Post("postTitle", "postText"));
		assertEquals("the new entry, did not enter correctly", 1, blog.quantityPost());
	}

	@Test
	public final void testDeleteEntry() {
		blog.addEntry(new Post("postTitle1", "postText"));
		blog.addEntry(new Post("postTitle2", "postText"));
		blog.addEntry(new Post("postTitle3", "postText"));
		blog.addEntry(new Post("postTitle4", "postText"));
		blog.deleteEntry(new Post("postTitle1", "postText"));
		assertEquals("the functionality of deleting an entry does not work correctly", 3, blog.quantityPost());
	}

	@Test
	public final void testShowLastEntries() {
		// create a List with 12 entries
		ArrayList<Post> postsToTest = new ArrayList<Post>();
		postsToTest.add(new Post("postTitle1", "postText"));
		postsToTest.add(new Post("postTitle2", "postText"));
		postsToTest.add(new Post("postTitle3", "postText"));
		postsToTest.add(new Post("postTitle4", "postText"));
		postsToTest.add(new Post("postTitle5", "postText"));
		postsToTest.add(new Post("postTitle6", "postText"));
		postsToTest.add(new Post("postTitle7", "postText"));
		postsToTest.add(new Post("postTitle8", "postText"));
		postsToTest.add(new Post("postTitle9", "postText"));
		postsToTest.add(new Post("postTitle10", "postText"));
		postsToTest.add(new Post("postTitle11", "postText"));
		postsToTest.add(new Post("postTitle12", "postText"));
		// add the entries to the blog
		for (Post post : postsToTest) {
			blog.addEntry(post);
		}
		// remove the first 2 post in the list
		Iterator<Post> iterator = postsToTest.iterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		// the 10 last post in the blog should be the list
		assertEquals("the recent entries is incorrect", postsToTest, blog.getLastPost(10));

	}

}
