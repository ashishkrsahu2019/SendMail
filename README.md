# SendMail
Code to send mail from Gmail.

Send mail folder contain code and pom.xml

dailyjobs folder contains sample pdf file

Resume1 folder contains resume and cover letter

To enable Guide to use Gmail accounts, please do the following:

Login to Gmail through Windows, using Internet Explorer.
Once signed in, navigate to: https://www.google.com/settings/security/lesssecureapps
Select the radio button to allow "Less Secure Apps" on.
Sign out of Gmail, restart Guide and select 1 from the Main Menu for Emails. Emails should now be working.


*Pre-requisites*
1. set path of resume folder in ConfigConsts FILE_PATH , FILE_FULL_PATH
2. update FROM_EMAIL_ADDRESS, USER_NAME_EMAIL, USER_PASSWORD, EMAIL_SUBJECT , EMAIL_BODY

* How to Use*
* Download code and run PDFReader.java as java application it will generate email.csv in c:\temp folder
* Verify email.csv and then execute SendEmailWithAttachments as java application.
* Verify if mail is send in your send  
