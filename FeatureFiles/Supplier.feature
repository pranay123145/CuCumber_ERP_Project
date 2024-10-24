@tag
Feature:
As admin user i want user Supplier Module
@supplier
Scenario Outline:
i want to add suppliers with multiple data
Given launch Browser
Given launch url
When  wait for username with "name" and "username" and "10"
When enter user name with "name" and "username" and "admin"
When enter password with "name" and "password" and "master"
When click submit button with "xpath" and "//button[@id='btnsubmit']"
When wait for supplier link with "xpath" and "(//a[contains(text(),'Suppliers')])[2]" and "10"
When click on supplier link with "xpath" and "(//a[contains(text(),'Suppliers')])[2]"
When wait for addIcon link with "xpath" and "(//span[@data-caption='Add'])[1]" and "10"
When click on addicon link with "xpath" and "(//span[@data-caption='Add'])[1]"
When wait for supplier number with "name" and "x_Supplier_Number" and "10"
When capture supplier number with "name" and "x_Supplier_Number"
When enter in "<SupplierName>" with "name" and "x_Supplier_Name"
When enter in "<Address>" with "xpath" and "//textarea[@id='x_Address']"
When enter in "<City>" with "xpath" and "//input[@id='x_City']"
When enter in "<Country>" with "xpath" and "//input[@id='x_Country']"
When enter in "<CPerson>" wih "xpath" and "//input[@id='x_Contact_Person']"
When enter in "<Pnumber>" with "xpath" and "//input[@id='x_Phone_Number']"
When enter in "<email>" with "xpath" and "//input[@id='x__Email']"
When enter in "<Mnumber>" with "xpath" and "//input[@id='x_Mobile_Number']"
When enter in "<notes>" with "name" and "x_Notes"
When click add button with "id" and "btnAction"
When wait for confirm ok button with "xpath" and "//button[normalize-space()='OK!']" and "10"
When click on confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When wait for alert ok button with "xpath" and "//button[@class='ajs-button btn btn-primary']" and "10"
When click on alert ok button with "xpath" and "//button[@class='ajs-button btn btn-primary']"
When verify supplier number
Then  click logout link with "xpath" and "(//a[starts-with(text(),' Logout')])[2]"
Then  close Browser
Examples:
|SupplierName|Address|City|Country|CPerson|Pnumber|email|Mnumber|notes|
|Testing1|Ameerpet|hyderabd|India|Qedge|5165665161|qedge@gmail.com|1234567890|Iam a new Supplier|
|Testing1|Ameerpet1|hyderabd1|India|Qedge|5165665161|qedge@gmail.com|1234567890|Iam a new Supplier|
|Testing1|Ameerpet2|hyderabd2|India|Qedge|5165665161|qedge@gmail.com|1234567890|Iam a new Supplier|
|Testing1|Ameerpet3|hyderabd|3India|Qedge|5165665161|qedge@gmail.com|1234567890|Iam a new Supplier|


