-- List the total number of invoices for a client within a specific period.

SELECT sales.sales_invoice_number, sales.sales_date, sales.glasses_id
FROM sales
JOIN customers ON sales.customers_id = customers.customers_id
WHERE customers.customers_id = 1
  AND sales.sales_date BETWEEN '2024-01-01' AND '2024-12-31';
