# Sprint 2: Databases. Data Structure - MySQL

<br/>

We will model several Entity-Relationship diagrams.

<br/>

### Exercise 2 - Pizzeria

You have been hired to design a website that allows food orders for home delivery via the Internet.

Keep in mind the following guidelines to model the database for the project.

For each client, store a unique identifier:

	Name
	Surname	
	Address
	Postcode
	Town
	Province
	Phone number

The town and province data will be stored in separate tables. We know that a town belongs to a single province, and a province can have many towns.
For each town, store a unique identifier and a name. For each province, store a unique identifier and a name.

A person can make many orders, but a single order can only be made by one person. For each order, store a unique identifier:
 
 	Date/time
	Whether the order is for home delivery or for pick-up in the store
	The quantity of products selected of each type
	Total price

 An order can consist of one or more products.
 
 The products can be pizzas, burgers, and drinks. For each product, store a unique identifier:
 
	Name
	Description
	Image
	Price
 
In the case of pizzas, there are various categories that may change names throughout the year. A pizza can only belong to one category, but a category can have many pizzas.

For each category, store a unique identifier and a name. An order is managed by a single store, and a store can manage many orders. For each store, store a unique identifier:

	Address
	Postcode
	Town
	Province

A store can have many employees, and an employee can only work at one store. For each employee, store a unique identifier:

	Name
	Last name
	Tax ID (NIF)
	Phone number
	Whether they work as a cook or a delivery person. For home delivery orders, store the name of the delivery person who makes the delivery and the date/time of the delivery.

---

<br/>

### Resources

To verify that your design is correct, perform the following queries and check that they return the correct results:

**Pizzeria:**

- List how many products from the 'Drinks' category have been sold in a specific locality.
- List how many orders a specific employee has completed.