package com.ashish.mail;

public final class ConfigConsts {

    // Recipient's email ID needs to be mentioned.
    public static String TO_EMAIL_ADDRESS = "ashishkrsahu2016@gmail.com";

    // Sender's email ID needs to be mentioned
    public static final String FROM_EMAIL_ADDRESS = "snpsnp137@gmail.com";

    // Email address for Login
    public static final String USER_NAME_EMAIL = "snpsnp137@gmail.com";

    // Email password for Login
    public static final String USER_PASSWORD = "Zaq1@wsx";

    // Physical Folder Path
    public static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\Resume1";
    
 // Physical Folder Path
    public static final String FILE_FULL_PATH = "C:\\Users\\Admin\\Desktop\\Resume1\\Shiv-7.8Yrs-Exp-Testing-CV.docx";

    // Set SMTP Server Address - GMAIL, OUTLOOK, YAHOO or ZOHO
    public static final String SMPT_HOST_ADDRESS = MailServers.GMAIL.getAddress();
    
    // Set SMTP Server port Address 
    public static final String SMPT_HOST_PORT = "587";

    // Server name - gets reflected in email message Subject and body
    public static final String SMPT_HOST_NAME = MailServers.GMAIL.getName();
    
    // Server Subject
    
    public static final String EMAIL_SUBJECT = "Shivnarayan Patwa | Senior QA Consultant (Automation using Selenium and Java, Manual, Mobile App and API Testing) | 7.8 Years Exp. | Pune";
    
    public static final String EMAIL_BODY ="Dear Sir/Mam,\r\n" + 
    		"\r\n" + 
    		"Please consider this email as my interest for the post of 'Software Test Engineer' (QA). I am very good in \"Automation Testing using Selenium WebDriver, TestNG, Cucumber & Java, Manual Testing Techniques, API Testing using Postman & Swagger and Mobile Testing�. I am answering your job posting for the role of Software Testing. My skill set seems to be a perfect match.\r\n" + 
    		"\r\n" + 
    		"I attached my resume in this email.\r\n" + 
    		"Please review the same and I would be happy to hear back from you regarding this opportunity.\r\n" + 
    		"	\r\n" + 
    		"Thanks & Regards,\r\n" + 
    		"Shivnarayan Patwa	\r\n" + 
    		"+91-9663607907\r\n" + 
    		"";

}
