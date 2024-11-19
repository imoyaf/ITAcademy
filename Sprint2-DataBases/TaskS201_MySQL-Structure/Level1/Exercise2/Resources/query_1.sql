USE pizzeria;

SELECT t.towns_name, COUNT(op.products_id) AS number_of_drinks_sold
FROM orders o
JOIN orders_has_products op ON o.orders_id = op.orders_id
JOIN products p ON op.products_id = p.products_id
JOIN customers c ON o.customers_id = c.customers_id
JOIN towns t ON c.towns_id = t.towns_id
WHERE p.products_type = 'drinks' AND t.towns_name = 'Reus' -- Choose town here and substitute for Reus
GROUP BY t.towns_name;
