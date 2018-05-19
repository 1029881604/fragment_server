use fragment;
drop table if exists collection_skill ;
-- 技能收藏表
create table collection_skill(	
	id int  primary key AUTO_INCREMENT,
	user_id int not null,				--  用户id
	skill_id int not null,				--  技能id
	collect_date datetime not null,			--  收藏日期
	CONSTRAINT collection_ibfk_1 FOREIGN KEY (user_id) REFERENCES person (id),
	CONSTRAINT collection_ibfk_2 FOREIGN KEY (skill_id) REFERENCES publishskill (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '技能收藏表';

insert into collection_skill values
(null, 100, 2, now()),
(null, 101, 1, now()),
(null, 101, 3, now()),
(null, 101, 4, now()),
(null, 101, 5, now()) ;


--  评论表
drop table if exists t_comment ;
CREATE TABLE t_comment (
	  id int(10)  NOT NULL AUTO_INCREMENT,
	  topic_id int(10)  DEFAULT NULL ,  --   '主题id'
	  topic_type smallint(2)   NOT NULL DEFAULT '1' ,  --   '1为user，2为skill，3为need'   根据此类型关联表或为user或为skill/need，所以没有外键
	  content text ,  --   '评论内容'
	  user_id int(10)  DEFAULT NULL ,  --   '评论者id，一般为会员表的id'
	  nickname varchar(60) DEFAULT NULL ,  --   '冗余用户昵称'
	  user_img varchar(255) DEFAULT NULL ,  --   '冗余用户头像'
	  is_top boolean  NOT NULL DEFAULT '0' ,  --   '是否置顶评论，true为置顶，false为不置顶'
	  is_hot boolean  NOT NULL DEFAULT '0' ,  --   '是否为热评，true为热评'
	  like_num int(5)  DEFAULT '0' ,  --   '评论被点赞的次数',
	  reply_num int(5)  DEFAULT '0' ,  --   '评论被回复的次数',
	  is_reply boolean  DEFAULT '0' ,  --   '是否回复',
	  comment_status smallint(2)  NOT NULL DEFAULT '1'  ,  --   '评论状态，-1为删除，0为待审核，1为已发布',
	  create_time datetime  DEFAULT NULL ,  --   '创建时间',
	  PRIMARY KEY (id),
	  CONSTRAINT comment_ibfk_1 FOREIGN KEY (user_id) REFERENCES person (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '评论表';


insert into t_comment (id, topic_id, topic_type, content, user_id ) values
(null, 1, 2, 'aaaaaaabbbbb',101),
(null, 2, 2, 'ccccdddd',102),
(null, 101, 1, '哈哈哈',100),
(null, 1, 1, '啊啊啊',101),
(null, 2, 3, '嘻嘻嘻',101),
(null, 2, 3, '你的需求要求太高了， 我是实习不了',103),
(null, 2, 3, '太难实习了，兄弟',102);


--  评论回复表
drop table if exists comment_reply ;
CREATE TABLE comment_reply (
	  id int(10)  NOT NULL AUTO_INCREMENT,
	  comment_id int(10)  DEFAULT NULL ,  --   '评论id',
	  reply_type smallint(2)  DEFAULT '1' ,  --   '1为回复评论，2为回复别人的回复',
	  reply_id int(10)  DEFAULT NULL ,  --   '回复目标id，reply_type为1时，是comment_id，reply_type为2时为回复表的id',
	  content text  ,					 --   '回复内容',
	  to_uid int(10)  DEFAULT NULL ,  --   '回复目标id',
	  from_uid int(10)  DEFAULT NULL ,  --   '回复用户id',
	  from_user_headimg varchar(255) DEFAULT NULL ,  --   '回复者的头像',
	  from_nickname varchar(50) DEFAULT NULL ,  --   '回复者的昵称',
	  create_time datetime  DEFAULT NULL ,  --   '评论时间',
	  to_nickname varchar(50)  DEFAULT NULL ,  --   '冗余回复对象的昵称',
	  is_author boolean  DEFAULT NULL ,  --   '0为普通回复，1为后台管理员回复',
	  PRIMARY KEY (id),
	  CONSTRAINT comment_reply_ibfk_1 FOREIGN KEY (from_uid) REFERENCES person (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '回复表';

-- 这张表可以先不用数据