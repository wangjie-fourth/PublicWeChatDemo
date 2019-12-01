CREATE TABLE history_expenses(
                                 id int PRIMARY KEY auto_increment COMMENT '自增主键',
                                 type VARCHAR(30) COMMENT '收入or花费',
                                 content VARCHAR(400) COMMENT '收入or花费记录',
                                 use_day DATETIME COMMENT '使用时间',
                                 created_time DATETIME DEFAULT current_timestamp COMMENT '该记录创建时间',
                                 updated_time DATETIME DEFAULT current_timestamp on UPDATE current_timestamp COMMENT '该记录上次修改时间'
) COMMENT='历史花销表';