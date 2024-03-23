package com.coderscampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileService{

	Student[] students = new Student[105];
	private int i = 0;

	public Student[] getUserInfo(String fileName) throws IOException {
		// read data from csv file line by line
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		String line;

		try {
			while ((line = fileReader.readLine()) != null) {
				// split each line into different pieces
				String[] linePieces = line.split(",");

				String id = linePieces[0];
				String name = linePieces[1];
				String course = linePieces[2];
				String grade = linePieces[3];

				students[i] = new Student(id, name, course, grade);
				i++;

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			fileReader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return students;
	}

	public void writeStudentsToFiles(Student[] students) throws IOException {
		BufferedWriter compsciWriter = null;
		BufferedWriter statWriter = null;
		BufferedWriter apmthWriter = null;

		try {
			compsciWriter = new BufferedWriter(new FileWriter("course1.csv"));
			compsciWriter.write("Grade,Student ID,Name,Course\n");
			
			statWriter = new BufferedWriter(new FileWriter("course2.csv"));
			statWriter.write("Grade,Student ID,Name,Course\n");
			
			apmthWriter = new BufferedWriter(new FileWriter("course3.csv"));
			apmthWriter.write("Grade,Student ID,Name,Course\n");
			
			Integer nonNullCount = 0;
			for (Student student : students) {
			    if (student != null) {
			        nonNullCount++;
			    }
			}

			Student[] nonNullStudents = new Student[nonNullCount];

			Integer nonNullStudentCount = 0;
			for (Student student : students) {
			    if (student != null) {
			        nonNullStudents[nonNullStudentCount++] = student;
			    }
			}

			students = nonNullStudents;
			
			Arrays.sort(students);
			
			for (Student student : students) {
				if (student != null) {
					String course = student.getCourse();
					BufferedWriter writer = null;
					if (course.startsWith("COMPSCI")) {
						writer = compsciWriter;
					} else if (course.startsWith("STAT")) {
						writer = statWriter;
					} else if (course.startsWith("APMTH")) {
						writer = apmthWriter;
					}
					if (writer != null) {
						writer.write(student.getGrade() + "," + student.getId() + "," + student.getName() + ","
								+ student.getCourse() + "\n");
					}
				}
			}
		} finally {
			if (compsciWriter != null) {
				compsciWriter.close();
			}
			if (statWriter != null) {
				statWriter.close();
			}
			if (apmthWriter != null) {
				apmthWriter.close();
			}
		}
	}

}
