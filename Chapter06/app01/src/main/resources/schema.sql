-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE Reader
(
  id       identity,
  username varchar(20),
  password varchar(20),
  fullname varchar(100),
  version  int
);


CREATE TABLE Book
(
  id          identity,
  isbn        varchar(15),
  title       varchar(200),
  author      varchar(20),
  description varchar(2000),
  version     int
);
