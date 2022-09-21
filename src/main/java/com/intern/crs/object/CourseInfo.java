package com.intern.crs.object;

public class CourseInfo {

	private int courseId;
	private String courseName;
	private String duration;
	private String eligibility;
	private String placementOpportunities;
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the eligibility
	 */
	public String getEligibility() {
		return eligibility;
	}
	/**
	 * @param eligibility the eligibility to set
	 */
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	/**
	 * @return the placementOpportunities
	 */
	public String getPlacementOpportunities() {
		return placementOpportunities;
	}
	/**
	 * @param placementOpportunities the placementOpportunities to set
	 */
	public void setPlacementOpportunities(String placementOpportunities) {
		this.placementOpportunities = placementOpportunities;
	}
	
	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration
				+ ", eligibility=" + eligibility + ", placementOpportunities=" + placementOpportunities + "]";
	}

	
}
