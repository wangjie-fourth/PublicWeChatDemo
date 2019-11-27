

create table message_record(
    id int primary key auto_increment comment '主键',
    user_open_id varchar(100) not null comment '用户openId',
    message_type varchar(20) not null comment '消息类型',
    message_content varchar(800) not null comment '消息内容',
    created_time datetime default current_timestamp comment '创建时间',
    updated_time datetime default current_timestamp on update current_timestamp comment '修改时间'
);

