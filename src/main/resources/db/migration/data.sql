INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Jacket', 300.0000, 50.0000, 'Asos', 'Casual', 'Cloth', 1, NULL, 'Jackates & Coats', 'Men', 'UK 2', 'Tall', NULL);
INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'T-Shirt', 300.0000, 50.0000, 'All Saints', 'Casual', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 12', 'Petile', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Ethnic', 300.0000, 50.0000, 'Sabhyasachi', 'Ethnic', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 16', 'Maternity', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'cap', 200.0000, 50.0000, 'Gucci', 'Sports', 'Cloth', 1, NULL, 'Tops', 'Men', 'UK 8', 'Plus', '(-74.006,40.7128)'::point);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Shoes', 500.0000, 50.0000, 'Nike', 'Sports', 'Shoes', 1, NULL, 'Shoes', 'Women', 'UK 2 / EU 35 ', 'Plus', NULL);
INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Jacket', 300.0000, 50.0000, 'Asos', 'Casual', 'Cloth', 1, NULL, 'Jackates & Coats', 'Men', 'UK 2', 'Tall', NULL);
INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'T-Shirt', 300.0000, 50.0000, 'All Saints', 'Casual', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 12', 'Petile', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Ethnic', 300.0000, 50.0000, 'Sabhyasachi', 'Ethnic', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 16', 'Maternity', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'cap', 200.0000, 50.0000, 'Gucci', 'Sports', 'Cloth', 1, NULL, 'Tops', 'Men', 'UK 8', 'Plus', '(-74.006,40.7128)'::point);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Shoes', 500.0000, 50.0000, 'Nike', 'Sports', 'Shoes', 1, NULL, 'Shoes', 'Women', 'UK 2 / EU 35 ', 'Plus', NULL);
INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Jacket', 300.0000, 50.0000, 'Asos', 'Casual', 'Cloth', 1, NULL, 'Jackates & Coats', 'Men', 'UK 2', 'Tall', NULL);
INSERT INTO public.productlenders
(productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'T-Shirt', 300.0000, 50.0000, 'All Saints', 'Casual', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 12', 'Petile', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Ethnic', 300.0000, 50.0000, 'Sabhyasachi', 'Ethnic', 'Cloth', 1, NULL, 'Dresses', 'Women', 'UK 16', 'Maternity', NULL);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'cap', 200.0000, 50.0000, 'Gucci', 'Sports', 'Cloth', 1, NULL, 'Tops', 'Men', 'UK 8', 'Plus', '(-74.006,40.7128)'::point);
INSERT INTO public.productlenders
( productname, rrp, rentprice, brand, ocassion, category, lenderid, addedat, subcategory, gender, "size", fit, coordinates)
VALUES( 'Shoes', 500.0000, 50.0000, 'Nike', 'Sports', 'Shoes', 1, NULL, 'Shoes', 'Women', 'UK 2 / EU 35 ', 'Plus', NULL);

--Example of product image insertion
INSERT INTO public.productimageurl
(productid, imageurl, isthumbnail)
VALUES(9, 'https://fashionapp-bucket.s3.eu-north-1.amazonaws.com/sabyasachi.png', true);

-- Example of location insertion
UPDATE productlenders SET coordinates = POINT(-74.006, 40.7128) WHERE id = 1;

-- Insert rented product data
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(3,27,'2023-01-01', '2023-01-10');
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(3,27,'2023-11-01', '2023-11-10');
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(4,27,'2023-10-01', '2023-10-10');
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(5,27,'2023-12-01', '2023-12-10');
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(6,27,'2023-12-25', '2023-12-30');
insert into productrented (productlenderid,renteruserid,datefrom ,dateto) values(7,27,'2024-01-15', '2024-01-25');
