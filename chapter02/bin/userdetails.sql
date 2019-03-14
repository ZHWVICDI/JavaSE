create table userdetails(
id int primary key comment'主键id',
username varchar(50) not null comment'用户名',
password varchar(50) not null comment'密码',
sex char(1) not null comment'性别，1：男，0：女',
hobby varchar(200) comment'爱好',
address varchar(100) comment'地址',
degree varchar(50) comment'学历',
remark varchar(500) comment'备注'
);
#添加测试数据
insert into userdetails(id,username,password,sex) values(1,'zhansan','zs123',1);
insert into userdetails(id,username,password,sex) values(2,'lisi','lisi123',1);
insert into userdetails(id,username,password,sex) values(3,'wangwu','ww123',1);
insert into userdetails(id,username,password,sex) values(4,'maliu','ml123',1);
insert into userdetails(id,username,password,sex) values(5,'linghc','lhc123',1);
insert into userdetails(id,username,password,sex) values(6,'zhaokl','zkl123',1);
