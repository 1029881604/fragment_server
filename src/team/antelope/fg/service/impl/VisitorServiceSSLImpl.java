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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	private void setProps() {
		props.setProperty("mail.debug", "true");
		// ���ͷ�������Ҫ�����֤
		props.setProperty("mail.smtp.auth", "true");
		System.out.println(1111);
		// �����ʼ�������������
//		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.ssl.enable", "true");
        //���䷢�ͷ������˿�,��������Ϊ465�˿�
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
		// �����ʼ�Э������
		props.setProperty("mail.transport.protocol", "smtp");

	}

	@Override
	public String returnVeriCode(String reqEmail) {
		// TODO �Զ����ɵķ������
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
			msg.setSubject("��֤��");
			msg.setText(text);
			msg.setFrom(new InternetAddress(respEmail));
			   //�����ռ���,toΪ�ռ���,ccΪ����,bccΪ����
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reqEmail, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(reqEmail, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(reqEmail, false));
            //���÷��͵�����
            msg.setSentDate(new Date());
			transport = session.getTransport();
			transport.connect(user, password);
			transport.sendMessage(msg, new Address[] { new InternetAddress(reqEmail) });
		} catch (MessagingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					// TODO �Զ����ɵ� catch ��
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
