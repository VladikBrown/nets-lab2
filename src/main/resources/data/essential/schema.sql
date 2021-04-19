drop table if exists user2album;
drop table if exists user2artist;
drop table if exists user2track;
drop table if exists tracks;
drop table if exists albums;
drop table if exists users;
drop table if exists artists;

CREATE TABLE artists
(
    id          BIGINT PRIMARY KEY NOT NULL,
    name        varchar(100)       NOT NULL UNIQUE,
    description text
);

CREATE TABLE albums
(
    id           BIGINT PRIMARY KEY NOT NULL,
    name         varchar(100)       NOT NULL UNIQUE,
    description  text,
    release_date varchar(100),
    artist_id    BIGINT             NOT NULL,
    CONSTRAINT artist_id_ref FOREIGN KEY (artist_id) REFERENCES artists (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tracks
(
    id        BIGINT PRIMARY KEY NOT NULL,
    name      varchar(100)       NOT NULL UNIQUE,
    is_single boolean default false,
    album_id  BIGINT,
    CONSTRAINT album_id_ref FOREIGN KEY (album_id) REFERENCES albums (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE users
(
    id         BIGINT PRIMARY KEY NOT NULL,
    firstName  varchar(100)       NOT NULL,
    secondName varchar(100)       NOT NULL,
    username   varchar(100)       NOT NULL UNIQUE
);

CREATE TABLE user2album
(
    user_id  BIGINT,
    album_id BIGINT,
    CONSTRAINT FK_user2album_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_user2album_album_id FOREIGN KEY (album_id) REFERENCES albums (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE user2track
(
    user_id  BIGINT,
    track_id BIGINT,
    CONSTRAINT FK_user2track_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_user2track_track_id FOREIGN KEY (track_id) REFERENCES tracks (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE user2artist
(
    user_id   BIGINT,
    artist_id BIGINT,
    CONSTRAINT FK_user2artist_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_user2artist_artist_id FOREIGN KEY (artist_id) REFERENCES artists (id) ON DELETE CASCADE ON UPDATE CASCADE
);
