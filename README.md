# Banking Application in VNC

## Required services 
1) Account-Service docker image
2) User-Login-Inter-Com docker image
3) Mysql docker image
4) Vnc server docker image
5) Android application


## To Set up and Run Mysql DB

### Pull the latest image of mysql from dockerhub
```sudo docker pull mysql:latest ``` 

### Run the docker image
``` sudo docker run -e MYSQL_ROOT_PASSWORD=iDRBT@007 -d mysql ```

### Get the ip address of the mysql container 
```
sudo docker inspect <container-id> 

get the ip address

mysql -h <container-ip> -u root -p
```

### Connect to mysql 
```
mysql -h 172.17.0.2 -u root -p
pwd : iDRBT@007
```
### Create databases

``` show databases; ```
``` create database accounts_info; ```
``` create database users_info; ```

### To switch the database 
``` use <database-name> ```
output:
```
mysql> SHow databases;
+--------------------+
| Database           |
+--------------------+
| accounts_info      |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| users_info         |
+--------------------+
```


### To show tables in database
``` show tables ```
output: 
``` 
mysql> show tables;
+-------------------------+
| Tables_in_accounts_info |
+-------------------------+
| accounts                |
+-------------------------+
1 row in set (0.00 sec)
```


### To check the records in the table
``` select * from <table-name ```

output:
```
mysql> select * from accounts;
```

## To Set up and Run Account-Service

### Pull the docker image
``` sudo docker pull pavan0077/vnc-accounts:v1 ```

OR

**To directly download and run the docker image**

``` sudo docker run -d -p 9901:9901 pavan0077/vnc-accounts:v1 ``` 

### To check the container with rest end point use container docker ip


```
``` sudo docker ps ```
``` sudo docker inspect <container-ip> ```
``` sudo docker inspect c6c36ddb79f5 ```

And check for IPAddress
``` "IPAddress": "172.17.0.5" ``` 

```

## To Set up and Run User-Login-Inter-Com

### Pull the docker image
``` sudo docker pull pavan0077/vnc-login:v2 ```

OR

**To directly download and run the docker image**

``` sudo docker run -d -p 9902:9902 pavan0077/vnc-login:v2 ``` 

### To check the container with rest end point use container docker ip


```
``` sudo docker ps ```
``` sudo docker inspect <container-ip> ```
``` sudo docker inspect c6c36ddb79f5 ```

And check for IPAddress
``` "IPAddress": "172.17.0.4" ``` 

```

## Build and Run android application 

**In this repo we have three folders use ``` Bank-Mag``` folder to Build android application**

**To Build clone the repo and import Bank-Mag in Android studio and click on Run icon or Build the apk file using option Build --> Build Bundle --> Build APK**

**You can also find the apk file in the BankMag folder in this repo.**

### To change the rest endpoint in future like IP or Port then do some modification

**Step 1:**

Open the android application in android studio and go to java folder ---> and pkg-name (com.idrbt.bank_mag) --> Go to Login class code 
Go to line number 53 and find apiUrl and change the IP ADDRESS OR PORT number as required
```
 String apiUrl = "http://192.168.138.156:9902/api/login/account/" + accountNumber;

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
``` 
This code will be present in loginUser() method
```
private void loginUser()
```

**Step 2:**

### NOTE : ONLY CHANGE IP ADDRESS AND PORT

**Open the android application in android studio and go to java folder ---> and pkg-name (com.idrbt.bank_mag) --> Go to Registration class code
Go to line number 92 and 136. Find the below lines**
```
private void registerUser(){
 
 Request request = new Request.Builder()
                .url("http://192.168.138.156:9902/api/login/createLogin")
                .post(requestBody)
                .build();
}
```
and change url ``` .url("http://192.168.138.156:9902/api/login/createLogin") ``` change the IP ADDRESS OR PORT as required in the registerUser() method.

```
private void openAccount() {

Request request = new Request.Builder()
                .url("http://192.168.138.156:9901/api/accounts/createAccount")
                .post(requestBody)
                .build();

}
```
and change url ``` .url("http://192.168.138.156:9901/api/accounts/createAccount") ``` change the IP ADDRESS OR PORT as required in the OpenAccount() method.



## To Set up and Run VNC Server with Android Emulator

### Pull the docker image
``` sudo docker pull budtmo/docker-android:emulator_13.0 ```

OR

**To directly download and run the docker image**

``` sudo sudo docker run -d -p 5900:5900 -p 6080:6080 -e EMULATOR_DEVICE="Samsung Galaxy S10" -e WEB_VNC=true --device /dev/kvm --name android-container-1 budtmo/docker-android:emulator_13.0 ``` 

**To view web browser**
``` http://<instance or host-ip>:6080 ```

**To connect**
Click on ``` Connect ```

### To view in Vnc-Client application 

**Download any vnc client**
``` 
Ref link 1 : https://www.cyberciti.biz/faq/install-and-configure-tigervnc-server-on-ubuntu-18-04/
Ref link 2 : https://adamtheautomator.com/remmina-on-ubuntu/
```

**To view in vnc client application**
``` Open vnc client and use ```
``` <host-ip>:5900 ``` 


Application Management
--
Back-end
--
1) Account-Service
2) User-Login-Inter-Com
3) Mysql DB

Front-end
--
1) Android application development

Streaming
--
1) VNC Server
2) VNC Client

Networking
--
1) Docker networks
2) Docker-compose files

Application Developed By
--
1) **_PAVAN KUMAR DASARI_** &nbsp; &nbsp; &nbsp;  (Back-end & Front-end)
2) **_ABHISHEK RAJ_**     &nbsp;  &nbsp; &nbsp;  (Networking)
3) **_PRAVEENA SAGI_**    &nbsp; &nbsp; &nbsp;  (Streaming)





