

##创建数据库
create database seckill;

use seckill;

##秒杀库存表
create table seckill(
  seckill_id bigint not null auto_increment comment '商品库存id',
  name varchar(120) not null comment '商品名称',
  number int not null comment '库存数量',
  start_time timestamp not null comment '秒杀开始时间',
  end_time timestamp not null comment '秒杀结束时间',
  create_time timestamp not null  comment '创建时间',
  primary key (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)engine = InnoDB auto_increment=1000 default charset = utf8 comment '秒杀库存表';

insert into seckill(name, number, start_time, end_time,create_time)
values
  ('1000元秒杀iphone',100,'2018-05-18 00:00:00','2018-05-19 00:00:00',now()),
  ('500元秒杀iphone',200,'2018-05-18 00:00:00','2018-05-19 00:00:00',now()),
  ('600元秒杀iphone',300,'2018-05-18 00:00:00','2018-05-19 00:00:00',now()),
  ('700元秒杀iphone',400,'2018-05-18 00:00:00','2018-05-19 00:00:00',now());

##秒杀成功明细表
##用户登陆认证相关的信息
create table success_killed(
  seckill_id bigint not null comment '秒杀商品ID',
  user_phone bigint not null comment '用户电话',
  state tinyint not null default -1 comment '状态标识:-1 无效 0 成功 1 已付款 2已发货',
  create_time timestamp not null  comment '创建时间',
  primary key (seckill_id,user_phone), /*联合主键*/
  key idx_create_time(create_time)

)engine = InnoDB default charset = utf8 comment '秒杀成功明细表';


##链接数据库控制台
##mysql -uroot -p