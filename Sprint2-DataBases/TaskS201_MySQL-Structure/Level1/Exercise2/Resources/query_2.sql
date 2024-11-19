USE pizzeria;

SELECT s.staff_fname, s.staff_lname, COUNT(o.orders_id) AS number_of_orders
FROM staff s
JOIN deliveries d ON s.staff_id = d.staff_id
JOIN orders o ON d.orders_id = o.orders_id
WHERE s.staff_id = 5 -- Choose staff id and substitute here
GROUP BY s.staff_fname, s.staff_lname;