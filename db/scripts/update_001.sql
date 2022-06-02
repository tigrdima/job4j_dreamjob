CREATE TABLE post (
   id serial primary key,
   name text,
   description text,
   visible bool,
   city_id int,
   created text
);

CREATE TABLE canidate (
   id serial primary key,
   name text,
   description text,
   photo bytea,
   created text

);

