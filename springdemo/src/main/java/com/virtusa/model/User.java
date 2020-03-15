package com.virtusa.model;

import java.util.Date;

import javax.validation.constraints.Size;

import com.virtusa.validator.IsValidHobby;

public class User {

	private String studentName;
	@Size(min=2,max=100) @IsValidHobby()
	private String studentHobby;
	private Date studentDOB;
	
	
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	
	@Override
	public String toString() {
		return "User [studentName=" + studentName + ", studentHobby=" + studentHobby + ", studentDOB=" + studentDOB
				+ "]";
	}
	
	
	
	
}
