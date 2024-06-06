Feature: As Admin User add Customer

  @Customer
  Scenario Outline: Validate add Customer with multiple  data
    Given user navigate Browser
    When user lunch Url
    When user wait for Username "Xpath" and "//input[@id='username']"
    Then user enter username with "name" and "username" and "admin"
    Then user enter  password with  "name" and "password" and "master"
    Then user Click on LoginButton "id" and "btnsubmit"
    Then user should wait for Customer link with "Xpath" and "(//a[contains(.,'Customers')])[2]"
    When user  click on Customer link with "Xpath" and "(//a[contains(.,'Customers')])[2]"
    Then user should wait for Add+ icon with "Xpath" and "(//span[contains(@data-caption,'Add')])[1]"
    When user click on Add+icon with "Xpath" and "(//span[contains(@data-caption,'Add')])[1]"
    Then user should wait for CustomerNumber with "Xpath" and "(//input[@id='x_Customer_Number'])[1]"
    When user Capture CustomerNumber with "Xpath" and "(//input[@id='x_Customer_Number'])[1]"
    When enter in "<CustomerName>" with "Xpath" and "(//input[@id='x_Customer_Name'])[1]"
    When enter in "<CustomerAdress>" with "Xpath" and "(//textarea[@id='x_Address'])[1]"
    When enter in "<CustomerCity>" with "Xpath" and "(//input[@id='x_City'])[1]"
    When enter in "<CustomerCountry>" with "Xpath" and "(//input[@id='x_Country'])[1]"
    When enter in "<CustomerContactperson>" with "Xpath" and "(//input[@id='x_Contact_Person'])[1]"
    When enter in "<CustomerEmail>" with "Xpath" and "(//input[@id='x__Email'])[1]]"
    When enter in "<mobilenumber>" with "Xpath" and "(//input[@id='x_Mobile_Number'])[1]"
    When enter in "<CustomerNotes>" with "Xpath" and "(//input[contains(@type,'text')])[9]"
    Then user Click on AddButton with "id" and "btnAction"
    Then user should wait for Conformok button "Xpath" and "//button[normalize-space()='OK!']"
    Then user Click on ConformOk  with "Xpath" and "//button[normalize-space()='OK!']"
    Then user should Wait for Alertok button with "Xpath" and "//button[@class='ajs-button btn btn-primary']"
    Then user click on AlertOk button with "Xpath" and "//button[@class='ajs-button btn btn-primary']"
    Then user validate Customer Table
    When user click on logoutlink with "Xpath" and "(//a[contains(.,'Logout')])[3]"
    Then user close application

    Examples: 
      | CustomerName | CustomerAdress | CustomerCity | CustomerCountry | CustomerContactperson | CustomerContactnumber | CustomerEmail           | mobilenumber | CustomerNotes    |
      | Thahir       | Charminar      | Hyderabad    | India           |            9985253908 |              98765432 | shaikThahir12@gmail.com |   1234567890 | ReactJsDeveloper |
