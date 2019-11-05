create table message(
    to_user_name varchar(100),
    from_user_name varchar(100),
    create_time long,
    msg_type varchar(100),
    content text,
    msg_id long
);


create table message_record(
    id int primary key auto_increment,
    user_open_id varchar(100) not null,
    message_type varchar(20) not null,
    message_content varchar(800) not null,
    is_did tinyint not null default 0,
    notify_time datetime,
    created_time datetime default current_timestamp,
    updated_time datetime default current_timestamp on update current_timestamp
);

