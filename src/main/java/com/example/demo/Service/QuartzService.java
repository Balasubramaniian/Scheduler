package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quartz;

@Service
public class QuartzService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@SuppressWarnings("rawtypes")
	public void createJob(Quartz quartz) {
		
		String sql ="insert into quartz (code,config_type,cron,unique_code,status) values(?,?,?,?,?)";
		
		 jdbcTemplate.update(
	                sql,
	                quartz.getCode(),
	                quartz.getConfigType(),
	                quartz.getCron(),
	                quartz.getUniqueCode(),
	                quartz.getStatus()
	        );
	    
	}
}
