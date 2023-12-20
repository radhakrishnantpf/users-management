User Management Module:
 Run Application: 
   To Run the application in local, 
   1. Install Latest version of Maven and Java Minimum 8 into your local machine.
   2. Use "Java -Version" command to validate the Java version.
   3. Follow the below Command to Run the application in local:
      --> Move your current directory location into project folder and issue the maven command
      --> mvn clean install -DskipTests=true spring-boot:run.
   4. After bring up the application in local environment, please enter the below URL to access the openapi specification in the browser,
      - http://localhost:8080/swagger-ui/index.html
   5. Try to get all the user details using the below restPoint
      -GET /userdetails, you can filter the result with firstname and lastname as well.
      -PATCH /userdetails/ to update the user details.