insert into users (id, firstname, secondname, username) values (1, 'Vlad', 'Brown', 'VladBrown');
insert into users (id, firstname, secondname, username) values (2, 'john', 'doe', 'johndoe');
insert into users (id, firstname, secondname, username) values (3, 'Sasha', 'Turban', 'Turban');
insert into users (id, firstname, secondname, username) values (4, 'Nariman', 'Ahmedoff', 'Narik');
insert into users (id, firstname, secondname, username) values (5, 'Ilya', 'Hontarau', 'Pattinson');

insert into artists (id, description, name) values (1, 'Fabulous art rock', 'Arcade Fire');
insert into artists (id, description, name) values (2, 'one of the foremost bands in the 21st century', 'Radiohead');
insert into artists (id, description, name) values (3, 'belarussian shiiiiiiiiiiiish', 'Lyapis Trubetskoy');
insert into artists (id, description, name) values (4, 'pure style from Belgium', 'Balthazar');
insert into artists (id, description, name) values (5, 'the best modern rock', 'Nothing But Thieves');

insert into albums (id, description, name, release_date, artist_id) values (1, 'perfect indie debut', 'Funeral', '2004', 1);
insert into albums (id, description, name, release_date, artist_id) values (2, 'masterpiece', 'The Suburbs', '2010', 1);
insert into albums (id, description, name, release_date, artist_id) values (3, 'one of the best ever made albums', 'OK Computer', '1997', 2);
insert into albums (id, description, name, release_date, artist_id) values (4, 'actually not funny at all', 'Funny pictures', '2004', 3);
insert into albums (id, description, name, release_date, artist_id) values (5, 'just listen', 'Fever', '2019', 4);
insert into albums (id, description, name, release_date, artist_id) values (6, 'creative and balanced alternative', 'Moral Panic', '2020', 5);

insert into tracks (id, is_single, name, album_id) VALUES (1, default, 'Tunnels', 1);
insert into tracks (id, is_single, name, album_id) VALUES (2, default, 'Laika', 1);
insert into tracks (id, is_single, name, album_id) VALUES (3, default, 'Une Annee Sans Lumiere', 1);
insert into tracks (id, is_single, name, album_id) VALUES (4, default, 'Power Out', 1);
insert into tracks (id, is_single, name, album_id) VALUES (5, default, '7 Kettles', 1);
insert into tracks (id, is_single, name, album_id) VALUES (6, default, 'Crown of Love', 1);
insert into tracks (id, is_single, name, album_id) VALUES (7, default, 'Wake Up', 1);
insert into tracks (id, is_single, name, album_id) VALUES (8, default, 'Haiti', 1);
insert into tracks (id, is_single, name, album_id) VALUES (9, default, 'Rebellion', 1);
insert into tracks (id, is_single, name, album_id) VALUES (10, default, 'In the Backseat', 1);

insert into tracks (id, is_single, name, album_id) VALUES (11, default, 'The Suburbs', 2);
insert into tracks (id, is_single, name, album_id) VALUES (12, default, 'Ready to Start', 2);
insert into tracks (id, is_single, name, album_id) VALUES (13, default, 'Modern Man', 2);
insert into tracks (id, is_single, name, album_id) VALUES (14, default, 'Rococo', 2);
insert into tracks (id, is_single, name, album_id) VALUES (15, default, 'Empty Room', 2);
insert into tracks (id, is_single, name, album_id) VALUES (16, default, 'City with No Children', 2);
insert into tracks (id, is_single, name, album_id) VALUES (17, default, 'Half Light I', 2);
insert into tracks (id, is_single, name, album_id) VALUES (18, default, 'Half Light II (No Celebration)', 2);
insert into tracks (id, is_single, name, album_id) VALUES (19, default, 'Suburban War', 2);
insert into tracks (id, is_single, name, album_id) VALUES (20, default, 'Month of May', 2);
insert into tracks (id, is_single, name, album_id) VALUES (21, default, 'Wasted Hours', 2);
insert into tracks (id, is_single, name, album_id) VALUES (22, default, 'Deep Blue', 2);
insert into tracks (id, is_single, name, album_id) VALUES (23, default, 'We Used to Wait', 2);
insert into tracks (id, is_single, name, album_id) VALUES (24, default, 'Sprawl I (Flatland)', 2);
insert into tracks (id, is_single, name, album_id) VALUES (25, default, 'Sprawl II (Mountains Beyond Mountains)', 2);
insert into tracks (id, is_single, name, album_id) VALUES (26, default, 'The Suburbs (Continued)', 2);

insert into tracks (id, is_single, name, album_id) VALUES (27, default, 'Airbag', 3);
insert into tracks (id, is_single, name, album_id) VALUES (28, default, 'Paranoid Android', 3);
insert into tracks (id, is_single, name, album_id) VALUES (29, default, 'Subterranean Homesick Alien', 3);
insert into tracks (id, is_single, name, album_id) VALUES (30, default, 'Exit Music (For a Film)', 3);
insert into tracks (id, is_single, name, album_id) VALUES (31, default, 'Let Down', 3);
insert into tracks (id, is_single, name, album_id) VALUES (32, default, 'Karma Police', 3);
insert into tracks (id, is_single, name, album_id) VALUES (33, default, 'Fitter Happier', 3);
insert into tracks (id, is_single, name, album_id) VALUES (34, default, 'Electioneering', 3);
insert into tracks (id, is_single, name, album_id) VALUES (35, default, 'Climbing Up the Walls', 3);
insert into tracks (id, is_single, name, album_id) VALUES (36, default, 'No Surprises', 3);
insert into tracks (id, is_single, name, album_id) VALUES (37, default, 'Lucky', 3);
insert into tracks (id, is_single, name, album_id) VALUES (38, default, 'The Tourist', 3);

insert into tracks (id, is_single, name, album_id) VALUES (39, default, 'Africa', 4);

insert into tracks (id, is_single, name, album_id) VALUES (40, default, 'Roller Coaster', 5);

insert into user2artist (user_id, artist_id) VALUES (1, 1);
insert into user2artist (user_id, artist_id) VALUES (1, 2);
insert into user2artist (user_id, artist_id) VALUES (1, 3);
insert into user2artist (user_id, artist_id) VALUES (1, 4);
insert into user2artist (user_id, artist_id) VALUES (1, 5);

insert into user2artist (user_id, artist_id) VALUES (3, 5);
insert into user2artist (user_id, artist_id) VALUES (4, 4);
insert into user2artist (user_id, artist_id) VALUES (5, 3);

insert into user2album (user_id, album_id) VALUES (1, 1);
insert into user2album (user_id, album_id) VALUES (1, 2);
insert into user2album (user_id, album_id) VALUES (1, 3);
insert into user2album (user_id, album_id) VALUES (1, 4);
insert into user2album (user_id, album_id) VALUES (1, 5);
insert into user2album (user_id, album_id) VALUES (1, 6);

insert into user2album (user_id, album_id) VALUES (3, 1);
insert into user2album (user_id, album_id) VALUES (4, 2);
insert into user2album (user_id, album_id) VALUES (5, 3);
insert into user2album (user_id, album_id) VALUES (3, 4);
insert into user2album (user_id, album_id) VALUES (4, 5);
insert into user2album (user_id, album_id) VALUES (5, 6);

insert into user2track (user_id, track_id) VALUES (1, 3);
insert into user2track (user_id, track_id) VALUES (1, 6);
insert into user2track (user_id, track_id) VALUES (1, 11);
insert into user2track (user_id, track_id) VALUES (1, 16);
insert into user2track (user_id, track_id) VALUES (1, 22);
insert into user2track (user_id, track_id) VALUES (1, 31);
insert into user2track (user_id, track_id) VALUES (1, 14);
insert into user2track (user_id, track_id) VALUES (1, 27);

