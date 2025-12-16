package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Details;
import com.example.demo.entity.Report;

@Repository
public class ReportDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void saveReport(List<Report> reports) {

	    String sql = "INSERT INTO Report (report_code, report_name) VALUES (?, ?)";

	    jdbcTemplate.batchUpdate(sql, reports, reports.size(),
	        (ps, report) -> {
	            ps.setString(1, report.getReportCode());
	            ps.setString(2, report.getReportName());
	        }
	    );
	}

	
	
	
	@SuppressWarnings("unchecked")
	public List<Report> getReport(){
		
		String sql ="Select id,report_code,report_name from report";
		RowMapper rowMapper= new BeanPropertyRowMapper(Report.class);
		return jdbcTemplate.query(sql,rowMapper);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<?> getReportDetails(String reportCode){
		
		String sql ="SELECT * FROM details_table,report r WHERE r.reportCode =? ;";
		RowMapper rowMapper= new BeanPropertyRowMapper(Details.class);
		return jdbcTemplate.query(sql,rowMapper,reportCode);

	}

}
