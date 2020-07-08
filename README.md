# Order-management

   
 ----------

# Build instructions

----------
please build `order-item-service` first to start h2 db

**Build**
    cd order-item-service
    `../gradlew clean build`

**Run** 
    `./gradlew bootRun`

 'order-service' 
**Build**
    cd order-service
    `../gradlew clean build`

**Run** 
    `./gradlew bootRun`

`order-item-service` will boot up with embedded tomcat at port `9090`
`order-service` will boot up with embedded tomcat at port `9050`

**Sample request paylod**

API[PoST] : http://localhost:9090/order-item-service/orderitems
Request payload :
[{"productCode":"ABC","productName":"Mobile","quantity":"100"},{"productCode":"DEF","productName":"TV","quantity":"50"}]

API[POST]: http://localhost:9050/order-service/orders
Request payload :
[{"orderId":"123","customerName":"Sudheer","orderDate":"07-07-2020","shippingAddress":"Hyderabad","total":"10000","productCodes":["ABC","DEF"]}] 
----------
