package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.StudentReport;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public void saveStudent(StudentReport report) {
		dao.saveStudent(report);
		
	}
	
	public List<StudentReport> getStudent() {
		return dao.getStudent();
		
	}
}
