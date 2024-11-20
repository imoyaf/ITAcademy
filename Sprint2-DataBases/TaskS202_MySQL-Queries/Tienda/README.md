# Sprint 2: Databases - Task 2
# MySQL Queries

<br/>

### Description

<br/>

#### Database Tienda

We have the tables producto and fabricante, each with the following fields:

- producto (codigo, nombre, precio, codigo_fabricante)
- fabricante (codigo, nombre)

The field `codigo_fabricante` in the producto entity is related to the `codigo` field in the fabricante entity.

**Please perform the following queries:**

1.	    List the names and prices of all products in the producto table.

2.	    List all columns from the producto table.

3.	    List the name of the products, the price in euros, and the price in USD.

4.	    List the name of the products, the price in euros, and the price in USD. Use the following aliases for the columns: product name, euros, dollars.

5.	    List the names and prices of all products in the producto table, converting the names to uppercase.

6.	    List the names and prices of all products in the producto table, converting the names to lowercase.

7.	    List the name of all manufacturers in one column, and in another column, show in uppercase the first two characters of the manufacturer's name.

8.	    List the names and prices of all products in the producto table, rounding the price value.

9.	    List the names and prices of all products in the producto table, truncating the price value to show no decimal places.

10.	    List the codes of manufacturers who have products in the producto table.

11.	    List the codes of manufacturers who have products in the producto table, removing duplicate codes.

12.	    List the names of manufacturers in ascending order.

13.	    List the names of manufacturers in descending order.

14.	    List the names of products, sorted first by name in ascending order and then by price in descending order.

15.	    Return a list with the first 5 rows of the fabricante table.

16.	    Return a list with 2 rows starting from the fourth row of the fabricante table, including the fourth row.

17.	    List the name and price of the cheapest product (use only ORDER BY and LIMIT). NOTE: You cannot use MIN(precio); you would need GROUP BY.

18.	    List the name and price of the most expensive product (use only ORDER BY and LIMIT). NOTE: You cannot use MAX(precio); you would need GROUP BY.

19.	    List the name of all products whose manufacturer code equals 2.

20.	    Return a list with the product name, price, and manufacturer name for all products in the database.

21.	    Return a list with the product name, price, and manufacturer name for all products in the database. Order the result alphabetically by manufacturer name.

22.	    Return a list with the product code, product name, manufacturer code, and manufacturer name for all products in the database.

23.	    Return the product name, price, and manufacturer name for the cheapest product.

24.	    Return the product name, price, and manufacturer name for the most expensive product.

25.	    Return a list of all products from the manufacturer "Lenovo."

26.	    Return a list of all products from the manufacturer "Crucial" with a price greater than €200.

27.	    Return a list of all products from manufacturers "Asus," "Hewlett-Packard," and "Seagate" without using the IN operator.

28.	    Return a list of all products from manufacturers "Asus," "Hewlett-Packard," and "Seagate" using the IN operator.

29.	    Return a list with the name and price of all products from manufacturers whose names end with the vowel "e."

30.	    Return a list with the name and price of all products whose manufacturer names contain the letter "w."

31.	    Return a list with the product name, price, and manufacturer name for all products priced at €180 or more. Sort the results first by price (descending) and then by name (ascending).

32.	    Return a list with the code and manufacturer name of only those manufacturers who have associated products in the database.

33.	    Return a list of all manufacturers in the database along with the products they offer. The list should also show those manufacturers with no associated products.

34.	    Return a list showing only those manufacturers who have no associated products.

35.	    Return all products from the manufacturer "Lenovo" (without using INNER JOIN).

36.	    Return all data for products that have the same price as the most expensive product from the manufacturer "Lenovo" (without using INNER JOIN).

37.	    List the name of the most expensive product from the manufacturer "Lenovo."

38.	    List the name of the cheapest product from the manufacturer "Hewlett-Packard."

39.	    Return all products from the database priced greater than or equal to the most expensive product from the manufacturer "Lenovo."

40.	    List all products from the manufacturer "Asus" that are priced higher than the average price of all their products.