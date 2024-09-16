insert into books
(name,price,page_count,author) values
('Java 23',44,344,'Nicat'),
('CSS 3',12,544,'James'),
('Html 5',56,232,'Aysu');



insert into products
(name,price) values
('Corek',0.8),
('Duyu',1.5),
('Yag',5);

insert into customers
(name,phone) values
('Nicat','0989'),
('Aysu','0919'),
('Zerda','0389');

insert into orders
(price,customer_id) values
(123,1),
(123,3),
(123,2),
(123,1),
(123,2);


insert into order_details
(product_id,quantity,order_id) values

(1,2,1),
(2,2.5,1),
(3,1,1),

(1,2,2),
(2,2.5,2),
 
(1,2,3),
(3,3,3),
 
(1,5,4),
(3,7,4),
 
(2,8,5),
(3,32,5);



