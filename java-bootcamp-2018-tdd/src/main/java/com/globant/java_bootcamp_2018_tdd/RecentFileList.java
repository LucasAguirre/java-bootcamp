package com.globant.java_bootcamp_2018_tdd;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentFileList {

	private ArrayList<File> list;
	private int maxSize = 15;

	public RecentFileList() {
		this.list = new ArrayList<File>();
	}

	public RecentFileList(int size) {
		this.list = new ArrayList<File>();
		this.maxSize = size;
	}

	public int size() {
		return list.size();
	}

	public void openFile(File file) {
		if (list.size() >= maxSize) {
			Iterator<File> iterator =list.iterator();
			iterator.next();
			iterator.remove();
		}
		if (!list.contains(file)) {
			list.add(file);
		} else {
			list.remove(file);
			list.add(file);
		}
	}

	public boolean exist(File file) {
		return list.contains(file);
	}

	public int positionOfFile(File file) {
		// return the position of 1 file in the recent opened files, or -1 if not exist
		// in this.
		if (this.exist(file)) {
			return list.indexOf(file);
		}
		return -1;
	}

	public File lastElemment() {
		return list.get(list.size() - 1);
	}

	public void deleteFile(File file) {
		if (list.contains(file)) {
			list.remove(file);
		}
	}

	public int getPosition(File file) {
		//returns the position of a file in the list
		//return -1 if don´t exist
		if(list.contains(file)) {
			return list.indexOf(file);
		}
		return -1;
	}

	public List<File> getLastFiles(int n) {
		if (n < list.size()) {
			return list.subList(list.size() - 1 - n, list.size());
		}
		return list.subList(0, list.size());
	}
}
