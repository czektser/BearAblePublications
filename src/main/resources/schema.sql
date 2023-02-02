create table if not exists Account (
    id identity,
    email varchar(250) not null,
    title varchar(5),
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    role_type varchar(10) not null,
    is_enabled boolean not null
);

create table if not exists Department (
    id identity,
    name varchar(100) not null,
    is_enabled boolean not null
);

create table if not exists Token (
    id UUID,
    creation_time TIMESTAMP,
    expiration_time TIMESTAMP
);

create table if not exists Audit_Record(
    id UUID,
    creation_time TIMESTAMP,
    record CHARACTER LARGE OBJECT

);
