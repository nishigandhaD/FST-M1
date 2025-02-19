SELECT * FROM orders;
SELECT SUM(PURCHASE_AMOUNT) AS "Total Purchase amount" FROM orders;
SELECT AVG(PURCHASE_AMOUNT) AS "Average Purchase amount" FROM orders;
SELECT MAX(PURCHASE_AMOUNT) AS "Highest Purchase amount" FROM orders;
SELECT MIN(PURCHASE_AMOUNT) AS "Lowest Purchase amount" FROM orders;
SELECT COUNT(DISTINCT SALESMAN_ID) AS "No.of salesman" FROM orders;
