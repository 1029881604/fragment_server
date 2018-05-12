use fragment;
drop table if exists collection_skill ;
-- �����ղر�
create table collection_skill(	
	id int  primary key AUTO_INCREMENT,
	user_id int not null,				--  �û�id
	skill_id int not null,				--  ����id
	collect_date datetime not null,			--  �ղ�����
	CONSTRAINT collection_ibfk_1 FOREIGN KEY (user_id) REFERENCES person (id),
	CONSTRAINT collection_ibfk_2 FOREIGN KEY (skill_id) REFERENCES publishskill (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '�����ղر�';

insert into collection_skill values
(null, 100, 2, now()),
(null, 101, 1, now()),
(null, 101, 3, now()),
(null, 101, 4, now()),
(null, 101, 5, now()) ;


--  ���۱�
drop table if exists t_comment ;
CREATE TABLE t_comment (
	  id int(10)  NOT NULL AUTO_INCREMENT,
	  topic_id int(10)  DEFAULT NULL ,  --   '����id'
	  topic_type smallint(2)   NOT NULL DEFAULT '1' ,  --   '1Ϊuser��2Ϊskill��3Ϊneed'
	  content text ,  --   '��������'
	  user_id int(10)  DEFAULT NULL ,  --   '������id��һ��Ϊ��Ա���id'
	  nickname varchar(60) DEFAULT NULL ,  --   '�����û��ǳ�'
	  user_img varchar(255) DEFAULT NULL ,  --   '�����û�ͷ��'
	  is_top boolean  NOT NULL DEFAULT '0' ,  --   '�Ƿ��ö����ۣ�trueΪ�ö���falseΪ���ö�'
	  is_hot boolean  NOT NULL DEFAULT '0' ,  --   '�Ƿ�Ϊ������trueΪ����'
	  like_num int(5)  DEFAULT '0' ,  --   '���۱����޵Ĵ���',
	  reply_num int(5)  DEFAULT '0' ,  --   '���۱��ظ��Ĵ���',
	  is_reply boolean  DEFAULT '0' ,  --   '�Ƿ�ظ�',
	  comment_status smallint(2)  NOT NULL DEFAULT '1'  ,  --   '����״̬��-1Ϊɾ����0Ϊ����ˣ�1Ϊ�ѷ���',
	  create_time datetime  DEFAULT NULL ,  --   '����ʱ��',
	  PRIMARY KEY (id),
	  CONSTRAINT comment_ibfk_1 FOREIGN KEY (user_id) REFERENCES person (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '���۱�';


insert into t_comment (id, topic_id, topic_type, content, user_id ) values
(null, 1, 2, 'aaaaaaabbbbb',101),
(null, 2, 2, 'ccccdddd',102),
(null, 101, 1, '������',100),
(null, 1, 1, '������',101),
(null, 2, 3, '������',101);


--  ���ۻظ���
drop table if exists comment_reply ;
CREATE TABLE comment_reply (
	  id int(10)  NOT NULL AUTO_INCREMENT,
	  comment_id int(10)  DEFAULT NULL ,  --   '����id',
	  reply_type smallint(2)  DEFAULT '1' ,  --   '1Ϊ�ظ����ۣ�2Ϊ�ظ����˵Ļظ�',
	  reply_id int(10)  DEFAULT NULL ,  --   '�ظ�Ŀ��id��reply_typeΪ1ʱ����comment_id��reply_typeΪ2ʱΪ�ظ����id',
	  content text  ,					 --   '�ظ�����',
	  to_uid int(10)  DEFAULT NULL ,  --   '�ظ�Ŀ��id',
	  from_uid int(10)  DEFAULT NULL ,  --   '�ظ��û�id',
	  from_user_headimg varchar(255) DEFAULT NULL ,  --   '�ظ��ߵ�ͷ��',
	  from_nickname varchar(50) DEFAULT NULL ,  --   '�ظ��ߵ��ǳ�',
	  create_time datetime  DEFAULT NULL ,  --   '����ʱ��',
	  to_nickname varchar(50)  DEFAULT NULL ,  --   '����ظ�������ǳ�',
	  is_author boolean  DEFAULT NULL ,  --   '0Ϊ��ͨ�ظ���1Ϊ��̨����Ա�ظ�',
	  PRIMARY KEY (id),
	  CONSTRAINT comment_reply_ibfk_1 FOREIGN KEY (from_uid) REFERENCES person (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '�ظ���';

-- ���ű�����Ȳ�������