package com.globant.mongoDB;

import org.mongodb.morphia.annotations.Entity;

@Entity
/**
 * ScheduleTime Entity
 */
public class ScheduleTime extends BaseEntity {

	private Integer courseId;
	private String dayOfWeek;
	private String startHour;
	private String finishHour;

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek
	 *            the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the startHour
	 */
	public String getStartHour() {
		return startHour;
	}

	/**
	 * @param startHour
	 *            the startHour to set
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	/**
	 * @return the finishHour
	 */
	public String getFinishHour() {
		return finishHour;
	}

	/**
	 * @param finishHour
	 *            the finishHour to set
	 */
	public void setFinishHour(String finishHour) {
		this.finishHour = finishHour;
	}
}
