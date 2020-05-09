DROP TABLE IF EXISTS POICategory;
 
CREATE TABLE POICategory (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  UNIQUE(category)
);
 
INSERT INTO POICategory (category) VALUES
  ('Restaurant'),
  ('Hospital'),
  ('School'),
  ('Cinema');
  
DROP TABLE IF EXISTS POIRestaurant;
 
CREATE TABLE POIRestaurant (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(100) NOT NULL,
  name VARCHAR(150) NOT NULL,
  address VARCHAR(250) NOT NULL,
  latitude DECIMAL (9,6) NOT NULL,
  longitude DECIMAL (9,6) NOT NULL,
  pricepoint VARCHAR(150) NOT NULL,
  cuisine VARCHAR(150) NOT NULL,
  delivery VARCHAR(1) NOT NULL
);

ALTER TABLE POIRestaurant
ADD FOREIGN KEY (category) REFERENCES POICategory (category);

INSERT INTO POIRestaurant (category, name, address, latitude, longitude, pricepoint, cuisine, delivery) VALUES
  ('Restaurant','Restaurant 1', 'Restaurant 1 Address', 40.741895, -73.989308, 'High', 'French', 'Y'),
  ('Restaurant','Restaurant 2', 'Restaurant 2 Address', 45.741895, -71.989308, 'High', 'Continental', 'Y'),
  ('Restaurant','Restaurant 3', 'Restaurant 3 Address', 50.741895, -69.989308, 'High', 'Italian', 'Y'),
  ('Restaurant','Restaurant 4', 'Restaurant 4 Address', 46.741895, -70.989308, 'High', 'Asian', 'Y'),
  ('Restaurant','Restaurant 5', 'Restaurant 5 Address', 52.741895, -68.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 6', 'Restaurant 6 Address', 56.741895, -65.989308, 'High', 'Asian', 'N'),
  ('Restaurant','Restaurant 7', 'Restaurant 7 Address', 60.741895, -52.989308, 'High', 'Oriental', 'N'),
  ('Restaurant','Restaurant 8', 'Restaurant 8 Address', 40.741895, -73.989308, 'High', 'French', 'Y'),
  ('Restaurant','Restaurant 9', 'Restaurant 9 Address', 45.741895, -71.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 10', 'Restaurant 10 Address', 50.741895, -69.989308, 'High', 'French', 'Y'),
  ('Restaurant','Restaurant 11', 'Restaurant 11 Address', 46.741895, -70.989308, 'High', 'Continental', 'Y'),
  ('Restaurant','Restaurant 12', 'Restaurant 12 Address', 52.741895, -68.989308, 'High', 'Italian', 'Y'),
  ('Restaurant','Restaurant 13', 'Restaurant 13 Address', 56.741895, -65.989308, 'High', 'Continental', 'Y'),
  ('Restaurant','Restaurant 14', 'Restaurant 14 Address', 60.741895, -52.989308, 'High', 'Continental', 'Y'),
  ('Restaurant','Restaurant 15', 'Restaurant 15 Address', 72.741895, 17.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 16', 'Restaurant 16 Address', 69.741895, 20.989308, 'High', 'Asian', 'N'),
  ('Restaurant','Restaurant 17', 'Restaurant 17 Address', 70.741895, 21.989308, 'High', 'French', 'N'),
  ('Restaurant','Restaurant 18', 'Restaurant 18 Address', 73.741895, 20.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 19', 'Restaurant 19 Address', 72.741895, 21.989308, 'High', 'Caribbean', 'Y'),
  ('Restaurant','Restaurant 20', 'Restaurant 20 Address', 75.741895, 18.989308, 'High', 'French', 'Y'),
  ('Restaurant','Restaurant 21', 'Restaurant 21 Address', 71.741895, 17.989308, 'High', 'Continental', 'Y'),
  ('Restaurant','Restaurant 22', 'Restaurant 22 Address', 70.741895, 21.989308, 'High', 'Caribbean', 'N'),
  ('Restaurant','Restaurant 23', 'Restaurant 23 Address', 69.741895, 16.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 24', 'Restaurant 24 Address', 72.741895, 19.989308, 'High', 'Oriental', 'Y'),
  ('Restaurant','Restaurant 25', 'Restaurant 25 Address', 73.741895, 18.989308, 'High', 'Italian', 'Y'),
  ('Restaurant','Restaurant 26', 'Restaurant 26 Address', 74.741895, 17.989308, 'High', 'Continental', 'N'),
  ('Restaurant','Restaurant 27', 'Restaurant 27 Address', 73.741895, 15.989308, 'High', 'Oriental', 'Y'),
  ('Restaurant','Restaurant 28', 'Restaurant 28 Address', 72.741895, 17.989308, 'High', 'Continental', 'Y');
  
  
DROP TABLE IF EXISTS POIHospital;
 
CREATE TABLE POIHospital (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(100) NOT NULL,
  name VARCHAR(150) NOT NULL,
  address VARCHAR(250) NOT NULL,
  latitude DECIMAL (9,6) NOT NULL,
  longitude DECIMAL (9,6) NOT NULL,
  speciality VARCHAR(150) NOT NULL
);

ALTER TABLE POIHospital
ADD FOREIGN KEY (category) REFERENCES POICategory (category);

INSERT INTO POIHospital (category, name, address, latitude, longitude, speciality) VALUES
  ('Hospital','Hospital 1', 'Hospital 1 Address', 46.741895, 18.989308, 'Cardiac Care');
  
  
DROP TABLE IF EXISTS POISchool;
 
CREATE TABLE POISchool (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(100) NOT NULL,
  name VARCHAR(150) NOT NULL,
  address VARCHAR(250) NOT NULL,
  latitude DECIMAL (9,6) NOT NULL,
  longitude DECIMAL (9,6) NOT NULL,
  curriculum VARCHAR(150) NOT NULL
);

ALTER TABLE POISchool
ADD FOREIGN KEY (category) REFERENCES POICategory (category);

INSERT INTO POISchool (category, name, address, latitude, longitude, curriculum) VALUES
  ('School','School 1', 'School 1 Address', 46.741895, -70.989308, 'CBSE');
  
  
DROP TABLE IF EXISTS POICinema;
 
CREATE TABLE POICinema (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(100) NOT NULL,
  name VARCHAR(150) NOT NULL,
  address VARCHAR(250) NOT NULL,
  latitude DECIMAL (9,6) NOT NULL,
  longitude DECIMAL (9,6) NOT NULL,
  genre VARCHAR(150) NOT NULL,
  movieRating DECIMAL(3,2)
);

ALTER TABLE POICinema
ADD FOREIGN KEY (category) REFERENCES POICategory (category);

INSERT INTO POICinema (category, name, address, latitude, longitude, genre, movieRating) VALUES
  ('Cinema','Cinema 1', 'Cinema 1 Address', 46.741895, -70.989308, 'Comedy', 4.2);
  
  
  