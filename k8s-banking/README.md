```
kubectl apply -f mysql-deployment.yaml
kubectl apply -f accounts-deployment.yaml
kubectl apply -f userlogin-deployment.yaml
```
for msql bash
```
kubectl exec -it mysql-0 -- mysql -u root -p
create database accounts_info;
create database users_info;
show databases;
```
