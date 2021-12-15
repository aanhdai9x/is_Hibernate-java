CREATE DATABASE TestHibernate
GO

USE TestHibernate
GO

CREATE TABLE Orders(
	orderId			INT IDENTITY(1,1) PRIMARY KEY,
	customerId		VARCHAR(5) ,
	orderDate		DATE ,
	requiredDate	DATE ,
	shippedDate		DATE ,
	shipAddress		VARCHAR(100) ,
)

CREATE TABLE OrderDetails(
	orderDetailId	INT IDENTITY(1,1) PRIMARY KEY,
	orderId			INT	,
	productId		VARCHAR(10) ,
	unitPrice		MONEY ,
	quantity		TINYINT ,
	discount		FLOAT ,
	FOREIGN KEY (orderId) REFERENCES Orders (orderId) ,
)

--insert into Orders values('11111', '2021-12-12', '2021-12-15', '2021-12-14', '20');
select * from Orders;

