package com.example.demo.schedularwithannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Schduler {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(Schduler.class);

//	@Scheduled(cron = "0 28 23 * * *")
//	public void runReportTask() {
//	        try {
//	            String sql = "SELECT report_url FROM report WHERE report_code = 'Student_report' LIMIT 1";
//	            String url = jdbcTemplate.queryForObject(sql,String.class);
//
//	            if (url != null) {
//	                log.info("Fetched report URL: {}", url);
//	                String response = restTemplate.getForObject(url, String.class);
//	                log.info("URL Response: {}", response);
//	            } else {
//	                log.warn("No report_url found for report_code 'Student'");
//	            }
//	        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
//	            log.warn("No row returned for report_code 'Student'", ex);
//	        } catch (Exception ex) {
//	            log.error("Error running scheduled job", ex);
//	        }
//	    
//	}
}
