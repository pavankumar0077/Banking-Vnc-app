# Banking Application in VNC

![image](https://github.com/5g-ucl-idrbt/Banking-Vnc-app/assets/131157072/b615618a-3828-45fc-b564-42a2f8b31bc2)


## Required services 
1) Account-Service docker image
2) User-Login-Inter-Com docker image
3) Config-Server 
4) Mysql docker image
5) Vnc server docker image
6) Android application

## To Set up Docker network for Fixed Ip

**Step 1: Create a User-Defined Bridge Network**
``` 
sudo docker network create --subnet=172.18.0.0/16 mynet
```

## To Set up and Run Mysql DB

### Pull the latest image of mysql from dockerhub
```
sudo docker pull mysql:latest 
```

### Run the docker image
<!-- ``` sudo docker run -e MYSQL_ROOT_PASSWORD=iDRBT@007 -d mysql ``` -->

```
sudo docker run -e MYSQL_ROOT_PASSWORD=iDRBT@007 -d --network=mynet --ip=172.18.0.2 --name=mysql-container mysql
```
### Install mysql cli
```
sudo apt install mysql-client-core-8.0
```

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
<!-- ``` sudo docker pull pavan0077/vnc-accounts:v1 ``` -->

```
docker pull pavan0077/vnc-accounts:V2
```

OR

**To directly download and run the docker image**
```
sudo docker run -d -p 9901:9901 --network=mynet --ip=172.18.0.3 --name=vnc-accounts-container pavan0077/vnc-accounts:V2
```

<!-- ``` sudo docker run -d -p 9901:9901 pavan0077/vnc-accounts:V2 ``` -->

### To check the container with rest end point use container docker ip


```
``` sudo docker ps ```
``` sudo docker inspect <container-ip> ```
``` sudo docker inspect c6c36ddb79f5 ```

And check for IPAddress
``` "IPAddress": "172.18.0.3" ``` 

```

## To Set up and Run User-Login-Inter-Com

### Pull the docker image
``` sudo docker pull pavan0077/vnc-login:V2 ```

OR

**To directly download and run the docker image**

<!-- ``` sudo docker run -d -p 9902:9902 pavan0077/vnc-login:v2 ```  -->
```
sudo docker run -d -p 9902:9902 --network=mynet --ip=172.18.0.4 --name=vnc-login-container pavan0077/vnc-login:V2
```

### To check the container with rest end point use container docker ip


```
``` sudo docker ps ```
``` sudo docker inspect <container-ip> ```
``` sudo docker inspect c6c36ddb79f5 ```

And check for IPAddress
``` "IPAddress": "172.18.0.4" ``` 

```

## Build and Run android application 

**In this repo we have three folders use ``` Bank-Mag``` folder to Build android application**

**To Build clone the repo and import Bank-Mag in Android studio and click on Run icon or Build the apk file using option Build --> Build Bundle --> Build APK**

**You can also find the apk file in the BankMag folder in this repo.**

### To change the rest endpoint in future like IP or Port then do some modification

**Step 1** : Change the config file with new properties
```
https://github.com/5gucl-idrbt/config-server
```
**Step 2** : Change the ip or port as per requirement
```
{
  "loginServiceUrl": "http://192.168.138.156:9902/api/login",
  "accountServiceUrl": "http://192.168.138.156:9901/api/accounts"
}
```

## To Set up and Run VNC Server with Android Emulator

REF LINK : https://github.com/budtmo/docker-android

### Pull the docker image
```
sudo docker pull budtmo/docker-android:emulator_13.0 

```

Step 1: Download the android application
```
https://github.com/5g-ucl-idrbt/Banking-Vnc-app/tree/main/BankMag
```

Step 2: Create a Directory for the APK
```
mkdir android-app
mv final.apk android-app/
```

Step 3: Mount the Directory into the Docker Container
```
sudo docker run -d -p 5901:5900 -p 6081:6080 -e EMULATOR_DEVICE="Samsung Galaxy S10" -e WEB_VNC=true --device /dev/kvm -v /home/idrbt/android-app:/app/android-app --name android-container-1 budtmo/docker-android:emulator_13.0
```

Step 4: Install the Application in the Emulator
```
sudo docker exec -it android-container-1 /bin/bash

cd /app/android-app/
adb install -r final.apk

```


<!-- ``` sudo sudo docker run -d -p 5900:5900 -p 6080:6080 -e EMULATOR_DEVICE="Samsung Galaxy S10" -e WEB_VNC=true --device /dev/kvm --name android-container-1 budtmo/docker-android:emulator_13.0 ``` -->

**To view web browser**
``` http://<instance or host-ip>:6081 ```

**To connect**
Click on ``` Connect ```

### To view in Vnc-Client application 

**Download any vnc client**
``` 
Ref link 1 : https://www.cyberciti.biz/faq/install-and-configure-tigervnc-server-on-ubuntu-18-04/
Ref link 2 : https://adamtheautomator.com/remmina-on-ubuntu/
```

**To view in vnc client application**
--
``` Open vnc client and use ```
``` <host-ip>:5901 ``` 

**To Capture DCP DUMP** 
--
``` sudo tcpdump -w packet_9nov.pcap -i docker0 port 5900 -B 100000 ```
``` Here -w is to write in the file packet_9nov.pcap - file name, port 5900 to get only port specific captures, -i is interface -B 10000 is used for buffer size ```


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
   
**Vulnerable-apks-
**
--

1.     Sieve.apk    
```
https://github.com/as0ler/Android-Examples/blob/master/sieve.apk
```

2.   Diva.apk

```
https://github.com/0xArab/diva-apk-file/blob/main/DivaApplication.apk
```
 
3.     FourGoats.apk

```
https://github.com/linkedin/qark/blob/master/tests/goatdroid.apk
```
4. InsecureBank.apk

```
https://github.com/dineshshetty/Android-InsecureBankv2/releases/tag/2.3.1
```
 
5.Herd-Financial.apk

```
https://sourceforge.net/projects/appiefiles/files/OWASP%20GoatDroid-%20Herd%20Financial%20Android%20App.apk/download
```
## For running the VNC client in a docker env
our vnc server ip goes here REMOTE_HOST, out port goes here REMOTE_PORT
```
sudo docker run -d -e REMOTE_HOST=192.168.138.123 -e REMOTE_PORT=5901 -p 8081:8081 dougw/novnc

```

Application Developed By
--
1) **_PAVAN KUMAR DASARI_** &nbsp; &nbsp; &nbsp;  (Back-end & Front-end)
2) **_ABHISHEK RAJ_**     &nbsp;  &nbsp; &nbsp;  (Networking)
3) **_PRAVEENA SAGI_**    &nbsp; &nbsp; &nbsp;  (Streaming)





