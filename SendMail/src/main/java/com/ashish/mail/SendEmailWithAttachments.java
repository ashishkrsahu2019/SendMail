package com.ashish.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SendEmailWithAttachments {
	Session session;
	List<File> listOfFlies;
	static int rowCount = 1;

	public static void main(String[] args) {
		SendEmailWithAttachments smail = new SendEmailWithAttachments();
		PDFReader pr = new PDFReader();
		try {

//			pr.createCSV();

			// String toEmailAddess = ConfigConsts.TO_EMAIL_ADDRESS;
			String pathToCsv = "c:\\temp\\email.csv";
			// Set Java Mail Properties
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", ConfigConsts.SMPT_HOST_ADDRESS);
			props.put("mail.smtp.port", ConfigConsts.SMPT_HOST_PORT);
			props.put("mail.smtp.ssl.trust", ConfigConsts.SMPT_HOST_ADDRESS);

			// Get the Session object.
			smail.session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(ConfigConsts.USER_NAME_EMAIL, ConfigConsts.USER_PASSWORD);
				}
			});

			// Get all files in Folder
			File filesInPath = new File(ConfigConsts.FILE_PATH);
			smail.listOfFlies = Arrays.asList(filesInPath.listFiles());
			List<String> lst = getEmailId(pathToCsv);
			for (String emailAddress : lst) {
				sendMail(smail.session, emailAddress, smail.listOfFlies);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getEmailId(String pathToCsv) {
		// String pathToCsv = "c:\\temp\\email.csv";
		String row = "";
		BufferedReader csvReader = null;
		List<String> lst = new ArrayList<String>();
		try {
			csvReader = new BufferedReader(new FileReader(pathToCsv));

			while ((row = csvReader.readLine()) != null) {
				// String[] data = row.split(",");
				lst.add(row);
				// do something with the data
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lst;

	}

	public static void sendMail(Session sess, String toEmailAddress, List<File> lst) {
		try {

			// Create a default MimeMessage object.
			Message message = new MimeMessage(sess);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(ConfigConsts.FROM_EMAIL_ADDRESS));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));

			// Set Subject: header field
			message.setSubject(ConfigConsts.EMAIL_SUBJECT);

			// Create the message part
			/*
			 * BodyPart messageBodyPart = new MimeBodyPart();
			 * messageBodyPart.setContent(ConfigConsts.EMAIL_BODY, "text/html");
			 * messageBodyPart.setText(ConfigConsts.EMAIL_BODY);
			 */

			// Get Multipart Object with Message Body and Attachments
			Multipart multipart = MailMessageUtils.messageMultipart(lst);
			// multipart.addBodyPart(messageBodyPart);
			// Set the multiplart object (message body + files) to the message object
			message.setContent(multipart);

			// Now set the actual message
			// message.setText(ConfigConsts.EMAIL_BODY);

			// Send message
			Transport.send(message);

			System.out.println("S.No. " + rowCount++ + " Sent message successfully.... from "
					+ ConfigConsts.FROM_EMAIL_ADDRESS + " to " + toEmailAddress);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}