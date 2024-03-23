package com.coderscampus;

import java.io.IOException;

public class Assignment4Application {

	public static void main(String[] args) throws IOException {

		FileService fileService = new FileService();
		Student[] students = fileService.getUserInfo("student-master-list.csv");
		fileService.writeStudentsToFiles(students);
		
		
		}
	}

		