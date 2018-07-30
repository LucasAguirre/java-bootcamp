package com.globant.mongoDB;

import org.mongodb.morphia.annotations.Entity;

@Entity
/**
 * Course entity
 *
 */
public class Course extends BaseEntity {

	private String name;
	private Integer assignedTeacher;
	private Integer hoursByWeek;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the assignedTeacher
	 */
	public Integer getAssignedTeacher() {
		return assignedTeacher;
	}

	/**
	 * @param assignedTeacher
	 *            the assignedTeacher to set
	 */
	public void setAssignedTeacher(Integer assignedTeacher) {
		this.assignedTeacher = assignedTeacher;
	}

	/**
	 * @return the hoursByWeek
	 */
	public Integer getHoursByWeek() {
		return hoursByWeek;
	}

	/**
	 * @param hoursByWeek
	 *            the hoursByWeek to set
	 */
	public void setHoursByWeek(Integer hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

}
