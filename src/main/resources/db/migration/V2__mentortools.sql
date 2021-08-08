create table registration
(
    id         bigint not null auto_increment,
    reg_status integer,
    student_id bigint,
    trainingclass_id  bigint,
    primary key (id)
) engine = InnoDB;