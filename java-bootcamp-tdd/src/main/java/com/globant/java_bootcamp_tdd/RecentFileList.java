package com.globant.java_bootcamp_tdd;

import java.io.File;
import java.util.ArrayList;

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
			list.remove(0);
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
}
