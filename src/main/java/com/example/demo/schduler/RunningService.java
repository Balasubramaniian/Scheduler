package com.example.demo.schduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.schedularwithannotation.Schduler;

@Service
public class RunningService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private RestTemplate restTemplate;
	

	private static final Logger log = LoggerFactory.getLogger(Schduler.class);
	
	
	public void runReportTask() {
        try {
            String sql = "SELECT report_url FROM report WHERE reportCode = 'Student_report' LIMIT 1";
            String url = jdbcTemplate.queryForObject(sql,String.class);

            if (url != null) {
                log.info("Fetched report URL: {}", url);
                String response = restTemplate.getForObject(url, String.class);
                log.info("report_url found for report_code 'Student'");
                log.info("URL Response: {}", response);
            } else {
                log.warn("No report_url found for report_code 'Student'");
            }
        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
            log.warn("No row returned for report_code 'Student'", ex);
        } catch (Exception ex) {
            log.error("Error running scheduled job", ex);
        }
        
        
    
}

}
