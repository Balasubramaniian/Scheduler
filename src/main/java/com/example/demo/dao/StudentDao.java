package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentReport;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveStudent(StudentReport report) {

		String sql = "INSERT INTO studentreport (reportCode, studentName,mobileNo, Address) VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(sql, report.getReportCode(), report.getStudentName(), report.getMobileNo(),
				report.getAddress());

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<StudentReport> getStudent() {

		String sql = "Select  * from studentreport";
		RowMapper rowMapper = new BeanPropertyRowMapper(StudentReport.class);

		return jdbcTemplate.query(sql, rowMapper);
	}

}
