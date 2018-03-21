package team.antelope.fg.service.impl;

import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import team.antelope.fg.service.IVisitorReqVeriCodeService;

public class VisitorServiceSSLImpl implements IVisitorReqVeriCodeService {
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static String respEmail, user, password;
	Properties props = new Properties();

	public void initMember(){
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config/email/email.properties"));
			respEmail = props.getProperty("respEmail");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	private void setProps() {
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		System.out.println(1111);
		// 设置邮件服务器主机名
//		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.ssl.enable", "true");
        //邮箱发送服务器端口,这里设置为465端口
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

	}

	@Override
	public String returnVeriCode(String reqEmail) {
		// TODO 自动生成的方法存根
		initMember();
		setProps();
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		
		String text = String.valueOf(this.createVeriCode());
		Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		Message msg = new MimeMessage(session);
		Transport transport = null;
		try {
			msg.setSubject("验证码");
			msg.setText(text);
			msg.setFrom(new InternetAddress(respEmail));
			   //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reqEmail, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(reqEmail, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(reqEmail, false));
            //设置发送的日期
            msg.setSentDate(new Date());
			transport = session.getTransport();
			transport.connect(user, password);
			transport.sendMessage(msg, new Address[] { new InternetAddress(reqEmail) });
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				transport = null;
			}
		}
		return text;
	}

	@Override
	public int createVeriCode() {
		Random random = new Random();
		int code = random.nextInt(9999 - 1000 + 1) + 1000;
		return code;
	}

}
