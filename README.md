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
``` docker pull pavan0077/vnc-accounts:v1 ```

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
``` docker pull pavan0077/vnc-login:v2 ```

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




