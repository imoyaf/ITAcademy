-- List the different suppliers that have supplied glasses successfully sold by the optical shop.

SELECT DISTINCT vendors.vendors_name
FROM sales
JOIN glasses ON sales.glasses_id = glasses.glasses_id
JOIN brands ON glasses.brands_id = brands.brands_id
JOIN vendors ON brands.vendors_id = vendors.vendors_id;
