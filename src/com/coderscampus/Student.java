package com.coderscampus;

public class Student implements Comparable<Student>{

	private String id;
	private String name;
	private String course;
	private String grade;

	Student(String id, String name, String course, String grade) {

		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(Student that) {

        int grade1 = Integer.parseInt(this.getGrade());
        int grade2 = Integer.parseInt(that.getGrade());
        
        return Integer.compare(grade2, grade1);
	}
}
