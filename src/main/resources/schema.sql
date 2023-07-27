-- Create the brand table
create table brand (
    brand_id integer,
    brand_name varchar(50),
    primary key (brand_id)
);

-- Create the skin table
create table skin (
    id integer auto_increment,
    brand_id integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id),
    foreign key (brand_id) references brand (brand_id)
);

-- Create the eye table
create table eye
(
    id integer auto_increment,
    brand_id integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id),
    foreign key (brand_id) references brand (brand_id)
);

-- Create the lips table
create table lips
(
    id integer auto_increment,
    brand_id integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id),
    foreign key (brand_id) references brand (brand_id)
);

-- Create the eyebrows table
create table eyebrows
(
    id integer auto_increment,
    brand_id integer,
    name varchar(50),
    category varchar(50),
    texture varchar(50),
    quantity integer,
    price integer,
    primary key (id),
    foreign key (brand_id) references brand (brand_id)
);

-- Create the Beauty Lounge table
create table beauty_lounge (
    id integer auto_increment,
    name varchar(255),
    hq_address varchar(255),
    year_of_establishment integer not null,
    primary key (id)
);