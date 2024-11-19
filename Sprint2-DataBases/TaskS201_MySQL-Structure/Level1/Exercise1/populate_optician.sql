USE Optician;

INSERT INTO addresses (addresses_street, addresses_street_number, addresses_floor, addresses_door, addresses_town, addresses_postcode, addresses_country) VALUES
('Avinguda Diagonal', 10, 'Àtic', '1', 'Barcelona', 08025, 'Spain'),
('Avinguda Transversal', 20, '6è', 'B', 'Reus', 08014, 'Spain'),
('Avinguda Tangent', 30, '4rt', 'D', 'Girona', 03598, 'Spain'),
('Avinguda Secant', 40, '1er', '3a', 'Lleida', 08445, 'Spain'),
('Avinguda Concèntrica', 50, '5è', '2a', "L'Hospitalet", 08747, 'Spain');

INSERT INTO vendors (vendors_name, vendors_tel, vendors_fax, vendors_nif, addresses_id) VALUES
('Supplier Inc.', '123-456-7890', '123-456-7891', 'B25814796', 1),
('Sub Supplies Ltd.', '234-567-8901', '234-567-8902', 'A85496587', 2),
('Vendor Ltd.', '345-678-9012', '345-678-9013', 'C12345678', 3),
('Super Vendor Inc.', '456-789-0123', '456-789-0124', 'B85274196', 4),
('Company LLC', '567-890-1234', '567-890-1235', 'A96385247', 5);

INSERT INTO brands (brands_name, brands_model, vendors_id) VALUES
('Ray-Ban', 'Model A1', 1),
('Ray-Ban', 'Model A1', 2),
('Oakley', 'Model B1', 3),
('Oakley', 'Model B1', 4),
('Specs', 'Model S1', 5);

INSERT INTO glasses (glasses_prescription_left_eye, glasses_prescritpion_right_eye, glasses_frame_type, glasses_frame_colour, glasses_left_glass_colour, glasses_right_glass_colour, glasses_price, brands_id) VALUES
('1.00', '2.50', 'rimless', 'blue', 'clear', 'clear', 100.00, 1),
('0', '0', 'rimmed', 'black', 'dark', 'dark', 150.00, 2),
('0', '0.75', 'wire-frame', 'green', 'clear', 'clear', 200.00, 3),
('1.50', '1.75', 'rimless', 'red', 'clear', 'clear', 250.00, 4),
('6.00', '5.25', 'rimmed', 'yellow', 'clear', 'clear', 300.00, 5);

INSERT INTO customers (customers_name, customers_tel, customers_email, customers_reg_date, addresses_id, customers_referrer_customers_id) VALUES
('Joan Petit', '111-111-1111', 'jpetit@example.com', NOW(), 1, NULL),
('Joana Petita', '222-222-2222', 'jpetita@example.com', '2024-06-02 12:00:00', 2, 1),
('John Doe', '333-333-3333', 'jdoe@example.com', '2024-06-03 12:00:00', 3, 2),
('Jane Doe', '444-444-4444', 'jane_doe@example.com', NOW(), 4, NULL),
('John Small', '555-555-5555', 'jsmall@example.com', '2024-06-05 12:00:00', 5, 4);

INSERT INTO staff (staff_name, staff_position) VALUES
('Pepa', 'Optician'),
('Pau', 'Sales Manager'),
('Paula', 'Sales Assistant'),
('Pol D', 'Sales Assistant'),
('Pia E', 'Sales Assistant');

INSERT INTO sales (sales_date, sales_invoice_number, glasses_id, customers_id, staff_id) VALUES
('2024-06-06 12:00:00', 101, 1, 1, 1),
('2024-06-07 12:00:00', 102, 2, 2, 2),
('2024-06-08 12:00:00', 103, 3, 3, 3),
('2024-06-09 12:00:00', 104, 4, 4, 4),
('2024-06-10 12:00:00', 105, 5, 5, 5);
