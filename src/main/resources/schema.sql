create table brand
(
    id_brand integer auto_increment,
    brand_name varchar(50),
    primary key (id_brand)
)

create table ten
(
    id integer auto_increment,
    id_brand integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id)
);

create table ochi
(
    id integer auto_increment,
    id_brand integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id)
);

create table lips
(
    id integer auto_increment,
    id_brand integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id)
);

create table eyebrows
(
    id integer auto_increment,
    id_brand integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id)
);