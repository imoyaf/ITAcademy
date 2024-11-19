USE pizzeria;

INSERT INTO `pizzeria`.`pizzas_categories` (`pizzas_categories_name`) VALUES
('Vegetarian'),
('Meat Lovers'),
('Seafood'),
('Cheese Lovers'),
('Classic');

INSERT INTO `pizzeria`.`products` (`products_name`, `products_type`, `products_description`, `products_image`, `products_price`) VALUES
('Classic Burger', 'burgers', 'A delicious classic beef burger', 'image1.jpg', 5.99),
('Cheese Burger', 'burgers', 'Classic beef burger with cheese', 'image2.jpg', 6.99),
('Chicken Burger', 'burgers', 'Grilled chicken burger', 'image3.jpg', 6.49),
('Veggie Burger', 'burgers', 'Healthy vegetarian burger', 'image4.jpg', 5.49),
('BBQ Burger', 'burgers', 'Beef burger with BBQ sauce', 'image5.jpg', 7.99),
('Coke', 'drinks', 'Refreshing cola drink', 'coke.jpg', 1.99),
('Pepsi', 'drinks', 'Refreshing pepsi drink', 'pepsi.jpg', 1.99),
('Sprite', 'drinks', 'Refreshing lemon-lime drink', 'sprite.jpg', 1.99),
('Fanta', 'drinks', 'Refreshing orange drink', 'fanta.jpg', 1.99),
('Water', 'drinks', 'Pure bottled water', 'water.jpg', 1.50);

INSERT INTO `pizzeria`.`products` (`products_name`, `products_type`, `products_description`, `products_image`, `products_price`, `pizzas_categories_id`) VALUES
('Margherita', 'pizzas', 'Classic cheese and tomato pizza', 'margherita.jpg', 7.99, 1),
('Pepperoni', 'pizzas', 'Pepperoni pizza', 'pepperoni.jpg', 8.99, 2),
('Seafood Delight', 'pizzas', 'Pizza with assorted seafood', 'seafood.jpg', 12.99, 3),
('Four Cheese', 'pizzas', 'Pizza with four types of cheese', 'fourcheese.jpg', 9.99, 4),
('BBQ Chicken', 'pizzas', 'BBQ chicken pizza', 'bbqchicken.jpg', 10.99, 5);

INSERT INTO `pizzeria`.`provinces` (`provinces_name`) VALUES
('Barcelona'),
('Tarragona'),
('Girona'),
('Lleida');

INSERT INTO `pizzeria`.`towns` (`towns_name`) VALUES
('Barcelona'),
("L'Hospitalet de Llobregat"),
('Reus'),
('Salt'),
('Lleida');

INSERT INTO `pizzeria`.`customers` (`customers_fname`, `customers_lname`, `customers_address`, `customers_postcode`, `towns_id`, `provinces_id`, `customers_tel`) VALUES
('John', 'Doe', '123 Avinguda Diagonal', '08080', 1, 1, '1234567890'),
('Jane', 'Doe', '456 Avinguda Horitzontal', '08025', 2, 1, '0987654321'),
('Johnny', 'Donny', '789 Avinguda Vertical', '08120', 3, 2, '1122334455'),
('Janey', 'Daney', '101 Avinguda Transversal', '08850', 4, 3, '5566778899'),
('Jamal', 'Danal', '202 Avinguda Paral·lela', '08008', 5, 4, '6677889900');

INSERT INTO `pizzeria`.`restaurants` (`restaurants_address`, `restaurants_postcode`, `towns_id`, `provinces_id`) VALUES
('123 Carrer Gran', '08080', 1, 1),
('456 Carrer Petit', '08250', 2, 1),
('789 Carrer Major', '08456', 3, 2),
('101 Avinguda Horitzontal', '08745', 4, 3),
('202 Avinguda Vertical', '08123', 5, 4);

INSERT INTO `pizzeria`.`staff` (`staff_fname`, `staff_lname`, `staff_nif`, `staff_tel`, `staff_position`, `restaurants_id`) VALUES
('Joan', 'Petit', '12345678R', '1112223333', 'cook', 1),
('Joana', 'Petita', 'R8765432T', '4445556666', 'delivery', 2),
('Joan', 'Mitjà', '45612378F', '7778889999', 'cook', 3),
('Joan', 'Gran', '78945612T', '0001112222', 'delivery', 4),
('Joana', 'Gran', 'E2165498G', '3334445555', 'cook', 5);

INSERT INTO `pizzeria`.`deliveries` (`orders_id`, `staff_id`, `deliveries_date_time`) VALUES
(1, 2, NOW()),
(3, 4, NOW()),
(5, 1, NOW()),
(2, 3, NOW()),
(4, 5, NOW());

INSERT INTO `pizzeria`.`orders` (`orders_date_time`, `orders_delivery`, `orders_total_price`, `customers_id`, `restaurants_id`) VALUES
(NOW(), 'delivery', 25.97, 1, 1),
(NOW(), 'takeaway', 28.87, 2, 2),
(NOW(), 'delivery', 30.87, 3, 3),
(NOW(), 'takeaway', 35.87, 4, 4),
(NOW(), 'delivery', 22.97, 5, 5);

INSERT INTO `pizzeria`.`orders_has_products` (`orders_id`, `customers_id`, `restaurants_id`, `products_id`, `orders_has_products_quantity`) VALUES
(1, 1, 1, 3, 2),
(2, 2, 2, 2, 1),
(3, 3, 3, 8, 3),
(4, 4, 4, 10, 4),
(5, 5, 5, 12, 2);