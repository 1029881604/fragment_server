package team.antelope.fg.service.impl;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import team.antelope.fg.service.IVisitorReqVeriCodeService;

public class VisitorServiceImpl implements IVisitorReqVeriCodeService {

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
		props.setProperty("mail.host", "smtp.qq.com");
//		props.setProperty("mail.host", "smtp.163.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

	}

	@Override
	public String returnVeriCode(String reqEmail) {
		// TODO 自动生成的方法存根
		initMember();
		setProps();
		String text = String.valueOf(this.createVeriCode());
		Session session = Session.getInstance(props);
		Message msg = new MimeMessage(session);
		Transport transport = null;
		try {
			msg.setSubject("验证码");
			msg.setText(text);
			msg.setFrom(new InternetAddress(respEmail));
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
