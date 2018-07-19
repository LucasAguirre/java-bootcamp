package com.globant.java_bootcamp_2018_tdd;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;


public class RecentFileListTest {


	// For this tests the list of recent opened files have a size of 5, the
	// predetermined(in the recent file list class) is 15
	RecentFileList list = new RecentFileList(5);

	@Test
	public final void whenTheProgramIsRunForTheFirstTimeTheListIsEmpty() {
		assertEquals("The list is not empty when the program run for de first time", 0, list.size());
	}

	@Test
	public final void whenAFileIsOpenedItIsAddedToTheRecentFileList() {
		File file = new File("t2");
		list.openFile(file);
		assert (list.exist(file));
	}

	@Test
	public final void ifAnOpenedFileAlreadyExistsInTheRecentFileListItIsBumpedToTheTopNotDuplicatedInTheList() {
		File file1 = new File("t3-1");
		File file2 = new File("t3-2");
		File file3 = new File("t3-3");
		list.openFile(file1);
		list.openFile(file2);
		list.openFile(file3);
		list.openFile(file1);
		assertEquals("A reopen file is not on the top of the list",file1, list.lastElemment());
	}

	@Test
	public final void ifTheRecentFileListGetsFullTheOldestItemIsRemovedWhenANewItemIsAdded() {
		File file1 = new File("t4-1");
		File file2 = new File("t4-2");
		File file3 = new File("t4-3");
		File file4 = new File("t4-4");
		File file5 = new File("t4-5");
		File file6 = new File("t4-6");
		list.openFile(file1);
		list.openFile(file2);
		list.openFile(file3);
		list.openFile(file4);
		list.openFile(file5);
		list.openFile(file6);
		assert (!list.exist(file1));
		assert (list.exist(file2));
	}

	@Test
	public final void testDeleteAEntry() {
		File file=new File("t5-1");
		list.openFile(file);
		list.deleteFile(file);
		assert(!list.exist(file));
	}
	@Test
	public final void testShowTheLastNFiles() {
		File file1 = new File("t6-1");
		File file2 = new File("t6-2");
		File file3 = new File("t6-3");
		File file4 = new File("t6-4");
		list.openFile(file1);
		list.openFile(file2);
		list.openFile(file3);
		list.openFile(file4);
		List <File> testList= new ArrayList<File>();
		testList.add(file1);
		testList.add(file2);
		testList.add(file3);
		testList.add(file4);
		assertEquals("The elements returned in getLastFiles are incorrect ",testList.toString(),list.getLastFiles(3).toString());
	}
}
