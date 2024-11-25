# caixa-installments-management
This is my personal project to manage my installments

## Built With
- Java 17
- Kotlin/Spring
- MongoDB Atlas
- Angular

## Prerequisites
 - Java+8

## Running

```java -jar file.jar -Dusername=my_username -Dpassword=my_password -Dcluster=my_cluster.xpto.mongodb.net -Ddatabase=my_database```


## Endpoints
### POST api/installments/create
- Response: Code 200
```
{
  "nroContrato": "01",
  "dueDate": "2023-09-20T00:00:00.000Z",
  "paid": true,
  "amount": 1598.1,
  "interest": 931.22,
  "insurance": 44.02,
  "fees": 25,
  "outstandingBalance": 837152135.3,
  "monetaryCorrection": 1212.25,
  "amortization": 312355.86,
  "isContribution": false
}

```
