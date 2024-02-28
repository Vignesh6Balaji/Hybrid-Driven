Feature: Login

Scenario: Successful Login with valid credentials
		Given User Launch Chrome Browser
		When User open URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And User Enters Username as "Admin" and Password as "admin123"
		And Click on Login
		Then Page Title should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
		When User Click on Logout link
		Then Page Title should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And Close Browser
		
Scenario Outline: Login Data Driven
		Given User Launch Chrome Browser
		When User open URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And User Enters Username as "<user>" and Password as "<pass>"
		And Click on Login
		Then Page Title should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
		When User Click on Logout link
		Then Page Title should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And Close Browser
		
		Examples:
				| user | pass |
				| Admin | admin123 |
				| admin | admin123 |