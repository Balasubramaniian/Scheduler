package com.example.demo.schdulerJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quartz;

@Repository
public class Schduledao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Quartz> getJobDetails(){
		
		String sql ="Select * from quartz";
		
		RowMapper mapper =new BeanPropertyRowMapper(Quartz.class);
		return  jdbcTemplate.query(sql,mapper);
		
	}
	
	public String getCron(String reportCode) {
		
		String sql = "Select cron from quartz where code = ? limit 1";

		return jdbcTemplate.queryForObject(sql, String.class, reportCode);

	}
	
	
	public String getUrl(String reportCode) {
		String sql = "SELECT report_url FROM report WHERE reportCode = ?  LIMIT 1";
		String url = jdbcTemplate.queryForObject(sql, String.class,reportCode);

		return url;

	}
	
	

}
