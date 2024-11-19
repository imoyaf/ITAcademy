# Sprint 2: Databases. Data Structure - MySQL

<br/>

We will model several Entity-Relationship diagrams.

<br/>

### Exercise 1 - Optical Shop:

An optical shop, named "Cul d'Ampolla," wants to make the management of clients and eyewear sales digital.

First, the optical shop wants to know who the supplier is for each pair of glasses. Specifically, it wants to know the following details about each supplier:

	Name
	Address (street, number, floor, door, town, postcode, and country)
	Phone number
	Fax
	VAT number (NIF).

The shop's purchasing policy is based on buying glasses from a single supplier for each brand (this way, they can get better prices), but they can buy glasses from different brands from the same supplier. For each pair of glasses, the following information should be stored:
 
 	Brand
	Prescription for each lens
	Frame type (floating, plastic, or metal)
	Frame color
	Lens color
	Price

 For customers, the following information should be stored:
 
	Name
	Postal address
	Phone number
	Email address
	Registration date
	When a new client arrives, store the name of the client who recommended the store (if anyone recommended it).
	The system should indicate which employee made the sale for each pair of glasses.
 


---

<br/>

### Resources

To verify that your design is correct, perform the following queries and check that they return the correct results:

**Optical Shop:**

- List the total number of invoices for a client within a specific period.
- List the different models of glasses sold by an employee during a year.
- List the different suppliers that have supplied glasses successfully sold by the optical shop.