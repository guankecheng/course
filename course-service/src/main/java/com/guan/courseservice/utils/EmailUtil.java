package com.guan.courseservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * @author:Guan
 * @date 2019/5/26,15:44
 **/
@Service
public class EmailUtil {
    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.host}")
    private String host;
/**
 * 发送纯文本的简单邮件
 * @param to
 */

public void sendEmail(String to,String code){
   try{
       Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
       final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
       Properties props = new Properties();
       props.setProperty("mail.smtp.host", host);
       props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
       props.setProperty("mail.smtp.socketFactory.fallback", "false");
       //邮箱发送服务器端口,这里设置为465端口
       props.setProperty("mail.smtp.socketFactory.port", "465");
       props.setProperty("mail.smtp.port", "465");


       props.put("mail.smtp.auth", "true");
       final  String username = from;
       final String pass = password;
       Session session = Session.getDefaultInstance(props, new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, pass);
           }
       });
       session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
        message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
        message.setSubject("注明激活");
        message.setText("你好，你的注册码为："+String.valueOf(code)+"。");
        message.setSentDate(new Date());
        Transport.send(message);
        System.out.println("发送成功");
   }catch (Exception e){

   }


}
}


