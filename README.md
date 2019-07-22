Employee Service - API's for employee management. You can create, edit, get and delete the employee's. Employee's are categorized into MANAGER, SOFTWARE_DEVELOPER, SITE_ADMIN and CONTRACTOR. Further, MANAGER is a must for SOFTWARE_DEVELOPER and SITE_ADMIN's cant have Manager.
The whole project is integrated with Swagger UI for documentation and API testing.

How to Build and Run :

Download the project zip or clone URI. You can either import the extracted project into an IDE (Eclipse, STS etc) or directly build using MAVEN.
Goal: clean install (In IDE run configuration)
MAVEN: mvn clean install

Once build, you can run the application by running the jar generated in target folder : "employee-service-0.0.1-SNAPSHOT-spring-boot.jar"
Command to Run : java -jar "employee-service-0.0.1-SNAPSHOT-spring-boot.jar"

The service will start on port 9765. Optionally you can also provide the host port using -Dport at command line or in vm arguments.

Once the Spring boot service starts, you can navigate to Swagger UI for service info : "http://localhost:9765/swagger-ui.html"
