SELECT a.salesman_name,b.customer_name, b.city FROM salesman a INNER JOIN customers b ON a.salesman_id=b.salesman_id;

SELECT a.grade,a.salesman_id,a.customer_id,a.customer_name,a.city,b.salesman_id,b.salesman_name FROM customers a LEFT JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 ORDER BY a.customer_id ASC;

SELECT  a.customer_name,a.city,b.salesman_name,b.commission  FROM customers a INNER JOIN salesman b ON a.salesman_id = b.salesman_id WHERE b.commission>12;

SELECT a.order_no,a.purchase_amount,a.order_date,b.customer_name,c.salesman_name,c.commission FROM orders a INNER JOIN customers b ON a.customer_id=b.customer_id INNER JOIN salesman c ON b.salesman_id=c.salesman_id;
