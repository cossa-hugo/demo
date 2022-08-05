drop table if exists CITY;

create table CITY(
    id INTEGER auto_increment primary key,
    name varchar(255) not null,
    country varbinary(255) not null,
    populationNumber INTEGER not null
)