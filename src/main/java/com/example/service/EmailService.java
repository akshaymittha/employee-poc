//package com.example.service;
//
//import com.example.email.EmployeeEmail;
//import jakarta.inject.Singleton;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//@Singleton
//public class EmailService {
//
//    public static void sendEmail(EmployeeEmail employeeEmail) {
//
//        Properties properties = System.getProperties();
//
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getDefaultInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("akshaymittha7@gmail.com", "tzmqrdnrvvotofis");
//            }
//        });
//
//        Message message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress("akshaymittha7@gmail.com"));
//            message.setSubject(employeeEmail.getSubject());
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(employeeEmail.getTo()));
//            message.setText(employeeEmail.getMessage());
//
//            Transport.send(message);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
