set serveroutput on;
drop table albums;
/
drop table artists;
/
create table artists(
    id int not null,
    name varchar(100),
    country varchar(100),
    primary key(id));
/
create table albums(
    id int not null,
    name varchar(100),
    artist_id int,
    release_year int,
    constraint asoc foreign key(artist_id) references artists(id)
    );
/
create table charts(id int not null, album_name varchar(100), artist_name varchar(100));