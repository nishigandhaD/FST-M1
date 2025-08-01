--Activity1 :create a salesman table

create table salesman (
    salesman_id int,
    salesman_name varchar2(20),
    salesman_city varchar2(20),
    commission int
    
);

DESC salesman;
--Activity2 : insert data into salesman table
INSERT INTO salesman VALUES(5002,'Nail Knite','Paris',13);
Insert ALL 
    INTO salesman VALUES(5001 ,'James Hoog','New York', 15)
	INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

--Activity3 : Display data from salesman table
-- Show data from the salesman_id and city columns
SELECT salesman_id, salesman_city FROM salesman;

-- Show data of salesman from Paris
SELECT * FROM salesman WHERE salesman_city='Paris';

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';


--Activiy4 :To add a new column to salesman table
ALTER TABLE salesman ADD (grade int);
DESC salesman;
UPDATE salesman SET grade=100;


--Activity5: To modify values in the salesman table
-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

-- Display modified data
SELECT * FROM salesman;

