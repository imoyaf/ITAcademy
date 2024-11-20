# Sprint 2: Databases. Data Structure - MongoDB

<br/>

**Desctiption**

We will create different databases in MongoDB.

<br/>

### Level 2

You have been hired to design a website that allows online food orders for home delivery.

Keep the following guidelines in mind to model the database for the project:

For each client, store a unique identifier: Name, surname, address, postal code, locality, province, phone number.

A person can place many orders, but a single order can only be placed by one person. For each order, store a unique identifier: Date/time of the order, whether the order is for home delivery or store pickup, the quantity of products selected for each type, the total price, as well as a note with additional information.

An order may consist of one or multiple products.

Products can be pizzas, burgers, or drinks. For each product, store a unique identifier: Name, description, image, price. In the case of pizzas, there are various categories that may change names throughout the year.

An order is managed by a single store, and a store can manage many orders. For each store, store a unique identifier: Address, postal code, locality, province.

A store may have many employees, but an employee can only work at one store. For each employee, store a unique identifier: Name, surname, tax ID (NIF), phone number, whether they work as a cook or a delivery person. For home delivery orders, record the delivery person who fulfills the order and the date/time of delivery.