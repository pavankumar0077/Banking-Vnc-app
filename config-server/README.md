# Config Server is used to configure DB properties without touch the application code or without disturbing application.

- We can always change properties based up on the env.

Android application properties
--
``` https://github.com/5gucl-idrbt/config-server ```

Backend application properties
--
``` https://github.com/5gucl-idrbt/VNC-Bankend-config-server ```


- This code "config-server" only for Backend part for the android application


Imp things to be done 
--
1) Before starting the backend service we first have to start config-server
2) Config-server will check for the DB properties that are available in the Cloud - Github repo.

CONFIG-SERVER
--
A Spring boot microservice project which takes the DB properties from Github repo.

Prerequisites
--
## Install Java on Ubuntu 22.04
### Update & Upgrade pkgs
``` sudo apt update && apt upgrade ```
### Install java
``` sudo apt install openjdk-17-jdk ```
### Check java version 
``` java --version ```

## Install Maven
### Download maven 
``` wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz ```
### Exract the file 
``` tar -xvf apache-maven-*-bin.tar.gz ```
### Move it to /usr/share/
``` sudo mv apache-maven-3.8.5 /usr/share/maven ```
###  Add the Maven folder to the System path
``` echo 'export PATH="$PATH:/usr/share/maven"' >> ~/.bashrc
    echo 'export PATH="$PATH:/usr/share/maven/bin"' >> ~/.bashrc
```
### Reload Bash profile
``` source ~/.bashrc ``` 

### Check the MVN version
``` mvn -v ```

How to Download and use the application
--
### Git clone the project using 
``` https://github.com/pavankumar0077/Client-Server-Vnc-Project.git ```
### Use any IDE like STS or Eclipse download link is here
``` https://download.springsource.com/release/STS4/4.19.1.RELEASE/dist/e4.28/spring-tool-suite-4-4.19.1.RELEASE-e4.28.0-linux.gtk.x86_64.tar.gz ```
### Import and Run the application (GUI)
1) Select File (Top-left corner) --> Select Open Projects from file system --> Select file path using Directory option --> and Click on Finish
2) Right click on the project --> Run as -->  Spring boot application

### Run the application using CLI
```
1) Go the path where application is clone and cd to Account-Service/
2) To build the package(jar file) use this command ``` mvn package ``` or ``` mvn clean install ```
3) Go to target folder in which is available at the root folder ``` cd target ```
4) 1st way : To Run the application If maven is installed then use ``` mvn spring-boot:run``` in the root folder
5) 2nd way : Use ``` ./mvnw spring-boot:run ``` if maven is not installed in the root folder
6) 3rd way : cd to target folder and run ```java -jar Account-Service-0.0.1-SNAPSHOT.jar ```
```

How to Generate Jar file
--
### Using STS tool
1) Right click on the springboot applicaiton --> Run as --> Maven install --> If Build is successful we will get jar file
2) Check the target folder present in the root folder --> Check for ..Jar file

### Using CLI
1) cd to project folder ---> mvn clean install
2) If build is successsful we will get jar file
3) Check in the target folder

Test the Applicaton
--
1) It runs on 8888 Port, Allow ufw rules
2) ``` sudo ufw allow 8888 ```
3) Check http://<instance-ip>:8888/actuator/refresh or /actuator

Change IP and re-build the application if needed
--
![image](https://github.com/5g-ucl-idrbt/Banking-Vnc-app/assets/131157072/d869ce70-eb15-4580-aa8b-0fb1e36cac53)

Step 1: Goto application root folder, Check for src/main/resources 
Step 2: Open application.properties file
Step 3: ![image](https://github.com/5g-ucl-idrbt/Banking-Vnc-app/assets/131157072/9e92bc36-42ea-4cbb-ae91-885d50897336)
- Change server.address = Your desired IP address

Step 4: Rebuild the application 
- Right click on the application
- Click on Run as
- Select Maven Install
![image](https://github.com/5g-ucl-idrbt/Banking-Vnc-app/assets/131157072/2bea165e-54fe-48f0-bb5d-86390f46dd4a)

Step 5: Check build is successfully or not, if yes 
Step 6: Goto root folder of the application --> Goto target folder --> You will find config-server.jar file 


