/* Inserting three franchises */
INSERT INTO franchise (name, description) VALUES ('The Marvel Cinematic Universe', 'The Marvel Cinematic Universe (MCU) is an American media franchise and shared universe centered on a series of superhero films produced by Marvel Studios.');
INSERT INTO franchise (name, description) VALUES ('The DC Extended Universe', 'The DC Extended Universe (DCEU) is an American media franchise and shared universe centered on a series of superhero films and television series produced by DC Films and distributed by Warner Bros. Pictures.');
INSERT INTO franchise (name, description) VALUES ('The Lord of the Rings', 'The Lord of the Rings is a series of three epic fantasy adventure films directed by Peter Jackson, based on the novel written by J. R. R. Tolkien.');

/* Inserting 4 movies */
INSERT INTO movie (title, genre, year, director, picture, trailer, franchise_id) VALUES ('Iron Man', 'Action,Adventure', 2008, 'Jon Favreau', 'https://upload.wikimedia.org/wikipedia/fi/7/70/Ironmanposter.JPG', 'https://www.youtube.com/watch?v=eOrNdBpGMv8', 1);
INSERT INTO movie (title, genre, year, director, picture, trailer, franchise_id) VALUES ('The Batman', 'Action,Adventure', 2022, 'Matt Reeves', 'https://media.finnkino.fi/1012/Event_13273/portrait_medium/TheBatman_1080c.jpg?width=412', 'https://www.youtube.com/watch?v=mqqft2x_Aa4', 2);
INSERT INTO movie (title, genre, year, director, picture, trailer, franchise_id) VALUES ('The Lord of the Rings: The Fellowship of the Ring', 'Fantasy,Adventure', 2001, 'Peter Jackson', 'https://upload.wikimedia.org/wikipedia/fi/thumb/0/0c/The_Fellowship_Of_The_Ring.jpg/250px-The_Fellowship_Of_The_Ring.jpg', 'https://www.youtube.com/watch?v=V75dMMIW2B4', 3);
INSERT INTO movie (title, genre, year, director, picture, trailer, franchise_id) VALUES ('The Hobbit: An Unexpected Journey', 'Fantasy,Adventure', 2012, 'Peter Jackson', 'https://en.wikipedia.org/wiki/The_Hobbit:_An_Unexpected_Journey#/media/File:The_Hobbit-_An_Unexpected_Journey.jpeg', 'https://www.youtube.com/watch?v=9PSXjr1gbjc', 3);

/* Inserting 5 characters */
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Bruce Wayne', 'Batman', 'Male', 'https://1.bp.blogspot.com/-biwd6AbmK64/YKko_rIVVgI/AAAAAAAAAdw/Gfrjh4LKQeMd-X6Yu-Fq_ITDeXYGZe3MgCLcBGAsYHQ/w1480/The-Batman-2022-statue-shows-Robert-Pattinson-costume.jpg');
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Tony Stark', 'Iron Man', 'Male', 'https://cdn.europosters.eu/image/750/julisteet/avengers-endgame-i-am-iron-man-i76482.jpg');
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Pepper Potts', '', 'Female', 'https://preview.redd.it/paaxdxfdx8j11.jpg?auto=webp&s=5bd18d28f47ebcc62e24c76b25821cdb7afd68cf');
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Gandalf the Grey', '', 'Male', 'https://static.wikia.nocookie.net/lotr/images/e/e7/Gandalf_the_Grey.jpg/revision/latest?cb=20121110131754');
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Legolas Gteanleaf', '', 'Male', 'https://static.wikia.nocookie.net/lotr/images/3/33/Legolas_-_in_Two_Towers.PNG/revision/latest?cb=20120916035151');
INSERT INTO character (full_name, alias, gender, picture) VALUES ('Thorin Oakenshield', '', 'Male', 'https://img.ilcdn.fi/7YfWJSNOz5xnMhRvMaeIOKxXs6Q=/full-fit-in/612x0/img-s3.ilcdn.fi/5476c479c5a65d847ec2249a796d2256e497b5e50798f2046485974e109d8d7f.jpg');

/* Connecting characters to movies */
INSERT INTO movie_character (movie_id, character_id) VALUES (1, 2);
INSERT INTO movie_character (movie_id, character_id) VALUES (1, 3);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 1);
INSERT INTO movie_character (movie_id, character_id) VALUES (3, 4);
INSERT INTO movie_character (movie_id, character_id) VALUES (3, 5);
INSERT INTO movie_character (movie_id, character_id) VALUES (4, 4);
INSERT INTO movie_character (movie_id, character_id) VALUES (4, 5);
INSERT INTO movie_character (movie_id, character_id) VALUES (4, 6);