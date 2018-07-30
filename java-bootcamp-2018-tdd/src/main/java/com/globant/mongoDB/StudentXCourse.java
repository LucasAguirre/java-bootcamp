package com.globant.mongoDB;

import org.mongodb.morphia.annotations.Entity;

@Entity
/**
 * StudentXCourse entity
 *
 */
public class StudentXCourse extends BaseEntity {
	private Integer studentId;
	private Integer courseId;
	private Integer partialNote1;
	private Integer partialNote2;
	private Integer partialNote3;
	private Integer finalNote;

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

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
	 * @return the partialNote1
	 */
	public Integer getPartialNote1() {
		return partialNote1;
	}

	/**
	 * @param partialNote1
	 *            the partialNote1 to set
	 */
	public void setPartialNote1(Integer partialNote1) {
		this.partialNote1 = partialNote1;
	}

	/**
	 * @return the partialNote2
	 */
	public Integer getPartialNote2() {
		return partialNote2;
	}

	/**
	 * @param partialNote2
	 *            the partialNote2 to set
	 */
	public void setPartialNote2(Integer partialNote2) {
		this.partialNote2 = partialNote2;
	}

	/**
	 * @return the partialNote3
	 */
	public Integer getPartialNote3() {
		return partialNote3;
	}

	/**
	 * @param partialNote3
	 *            the partialNote3 to set
	 */
	public void setPartialNote3(Integer partialNote3) {
		this.partialNote3 = partialNote3;
	}

	/**
	 * @return the finalNote
	 */
	public Integer getFinalNote() {
		return finalNote;
	}

	/**
	 * @param finalNote
	 *            the finalNote to set
	 */
	public void setFinalNote(Integer finalNote) {
		this.finalNote = finalNote;
	}

}
