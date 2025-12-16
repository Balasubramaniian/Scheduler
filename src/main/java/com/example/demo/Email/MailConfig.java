//package com.example.demo.Email;
//
//import java.util.Properties;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MailConfig {
//
//    @Value("${mail.smtp.host}")
//    private String host;
//
//    @Value("${mail.smtp.port}")
//    private String port;
//
//    @Value("${mail.smtp.auth}")
//    private String auth;
//
//    @Value("${mail.smtp.starttls.enable}")
//    private String starttls;
//
//    @Bean
//    public Properties mailProperties() {
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.auth", auth);
//        props.put("mail.smtp.starttls.enable", starttls);
//        return props;
//    }
//}
//
