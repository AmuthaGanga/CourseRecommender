package com.intern.crs.object;

import java.util.List;

public class CollegeInfo {
	
	private int collegeId;
	private String collegeName;
	private String city;
	private String university;
	private String website;
	private String accreditatedBy;
	private String naacScore;
	private List<CourseInfo> coursesList;
	
	/**
	 * @return the collegeId
	 */
	public int getCollegeId() {
		return collegeId;
	}
	/**
	 * @param collegeId the collegeId to set
	 */
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}
	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the accreditatedBy
	 */
	public String getAccreditatedBy() {
		return accreditatedBy;
	}
	/**
	 * @param accreditatedBy the accreditatedBy to set
	 */
	public void setAccreditatedBy(String accreditatedBy) {
		this.accreditatedBy = accreditatedBy;
	}
	/**
	 * @return the naacScore
	 */
	public String getNaacScore() {
		return naacScore;
	}
	/**
	 * @param naacScore the naacScore to set
	 */
	public void setNaacScore(String naacScore) {
		this.naacScore = naacScore;
	}
	
	/**
	 * @return the coursesList
	 */
	public List<CourseInfo> getCoursesList() {
		return coursesList;
	}
	/**
	 * @param coursesList the coursesList to set
	 */
	public void setCoursesList(List<CourseInfo> coursesList) {
		this.coursesList = coursesList;
	}
	
	@Override
	public String toString() {
		return "CollegeInfo [collegeId=" + collegeId + ", collegeName=" + collegeName + ", city=" + city
				+ ", university=" + university + ", website=" + website + ", accreditatedBy=" + accreditatedBy
				+ ", naacScore=" + naacScore + "]";
	}

}
