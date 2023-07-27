-- Create the brand table
create table brand (
    id_brand integer auto_increment,
    brand_name varchar(50),
    primary key (id_brand)
);

-- Create the skin table
create table skin (
    id integer auto_increment,
    id_brand integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id)
);

create table eye
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

create table beauty_lounge (
    id integer auto_increment,
    name varchar(255),
    hq_address varchar(255),
    year_of_establishment integer not null,
    primary key (id)
);