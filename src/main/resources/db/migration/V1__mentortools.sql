create table student
(
    id      bigint not null auto_increment,
    email   varchar(255),
    gituser varchar(255),
    memo    varchar(255),
    name    varchar(255),
    primary key (id)
) engine=InnoDB;

create table training_class
(
    id    bigint not null auto_increment,
    end   datetime(6),
    name  varchar(255),
    start datetime(6),
    primary key (id)
) engine=InnoDB;
