create table userdetails(
id int primary key comment'����id',
username varchar(50) not null comment'�û���',
password varchar(50) not null comment'����',
sex char(1) not null comment'�Ա�1���У�0��Ů',
hobby varchar(200) comment'����',
address varchar(100) comment'��ַ',
degree varchar(50) comment'ѧ��',
remark varchar(500) comment'��ע'
);
#��Ӳ�������
insert into userdetails(id,username,password,sex) values(1,'zhansan','zs123',1);
insert into userdetails(id,username,password,sex) values(2,'lisi','lisi123',1);
insert into userdetails(id,username,password,sex) values(3,'wangwu','ww123',1);
insert into userdetails(id,username,password,sex) values(4,'maliu','ml123',1);
insert into userdetails(id,username,password,sex) values(5,'linghc','lhc123',1);
insert into userdetails(id,username,password,sex) values(6,'zhaokl','zkl123',1);
