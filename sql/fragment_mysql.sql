-- �������ݿ�
drop database if exists fragment;
create database fragment;
use fragment;
-- ����������������������Ĺ���  start
-- �ղر���д����������ʷ��¼����������

-- nearbymodular ����ģ����Ϣ��
drop table if exists nearbymodular;
create table nearbymodular(			
	needtitle varchar(120) not null,
	needbody text not null,
	needimg varchar(200) not null,
	skilltitle varchar(120) not null,
	skillbody text not null,
	skillimg varchar(200) not null,
	type varchar(50) not null primary key,
	needupdatetime datetime,
	skillupdatetime datetime
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into nearbymodular values 
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_photography.jpg", 
 "����ĵ���Ӱʦ", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_photography.jpg", "photography", now(), now()),
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_accompany.jpg", 
 "����Ȥ������", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_accompany.jpg", "accompany", now(), now()),
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_errand.jpeg", 
 "���ٶȵ�����", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_errand.jpeg", "errand", now(), now()),
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_manual.jpg", 
 "����Ŀ���", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_manual.jpg", "manual", now(), now()),
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_guide.jpg", 
 "��רҵ��ָ��", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_guide.jpg", "guide", now(), now()),
("needtitle", "��������balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/need_other.jpg", 
 "��רҵ��ɶ", "��֪��˵ɶ�����������ݣ���������������������balabalabala...����������������.",
 "http://192.168.1.110:8080/fragment_server/images/nearby_modular_img/skill_other.png", "other", now(), now());


-- person�� other or firends
drop table if exists person;
create table person(			--  �������˵�personӦ����Ҫpassword or phone num?  add at 17/12/28
	id int primary key auto_increment,  
	name varchar(60) not null unique,		-- �ǳƣ���һ�޶�
	password varchar(60) not null,  
	sex varchar(10),
	email varchar(30),			-- add at 17/12/28
	phonenum varchar(20),		-- add at 17/12/29  server had and client didn't had  
	age smallint,
	headimg varchar(300),		-- ͷ��
	starnum double,		-- �Ǽ�����
	dealnum int,		-- ��ɽ�������
	fansnum int		-- ��˿����  ��ע����
-- constraint chk_sex check (sex in ("��", "Ů"))			mysql��ǰ�汾Լ����Ч
-- constraint chk_age check (age >0 and age < 130)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--  ������Լ������֤��֮���
insert into person values
(100, "����", "zhangsan", "��", "1923e343@qq.com",
"10000000000", 22, "http://192.168.1.110:8080/fragment_server/images/person_head_img/100.jpg",
3.5, 30, 200),
(101, "annie", "annie", "Ů", "annie@163.com",
"10000000001", 18, "http://192.168.1.110:8080/fragment_server/images/person_head_img/101.jpeg",
6.5, 600, 3000),
(102, "galun", "galun", "��", "galun@qq.com",
"10000000002", 25, "http://192.168.1.110:8080/fragment_server/images/person_head_img/102.jpg",
5.5, 100, 300),
(103, "bob", "bob", "��", "bob@qq.com",
"10000000003", 22, "http://192.168.1.110:8080/fragment_server/images/person_head_img/103.jpg",
3.5, 30, 200),
(104, "tony", "tony", "��", "tony@qq.com",
"10000000004", 22, "http://192.168.1.110:8080/fragment_server/images/person_head_img/104.jpg",
1.5, 30, 100),
(105, "sweet", "sweet", "Ů", "sweet@qq.com",
"10000000005", 19, "http://192.168.1.110:8080/fragment_server/images/person_head_img/105.jpg",
5.5, 200, 1000),
(106, "alice", "alice", "Ů", "alice@qq.com",
"10000000006", 19, "http://192.168.1.110:8080/fragment_server/images/person_head_img/106.jpg",
5.5, 400, 1000),
(107, "michelle", "michelle", "Ů", "michelle@qq.com",
"10000000007", 19, "http://192.168.1.110:8080/fragment_server/images/person_head_img/107.jpg",
7.5, 600, 3000);

-- attention��  
drop table if exists attention;
create table attention(
	uid int not null,
	attentionuserid int not null,		-- ����ע���˵�id
	primary key (uid, attentionuserid),
	foreign key (uid) references person(id),		--  add	at 17/12/29		������Լ��
	foreign key (attentionuserid) references person(id)		--  add	at 17/12/29	������Լ��
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into attention values
(100, 102),
(100, 103),
(100, 104),
(102, 103),
(103, 104),
(102, 104),
(101, 105),
(103, 105),
(104, 105),
(104, 106),
(104, 107),
(101, 106),
(101, 107),
(102, 106),
(102, 105);


-- publishskill��
drop table if exists publishskill;
create table publishskill(
	id int primary key auto_increment,
	uid int not null,		-- ���������ߵ�id
	title varchar(60),		-- ��������	add	at 17/12/28
	content text,				-- ��������
	publishdate datetime,			-- ����ʱ�� now()
	stopdate datetime,			-- ֹͣ����ʱ��
	img varchar(300),					-- ͼƬԤ��
	skilltype varchar(50),				-- ��������
	iscomplete boolean,			-- �Ƿ��Ǳ�Ԥ�� alter at 17/12/30
	isonline boolean,				-- �Ƿ�������	add	at 17/12/28  alter at 17/12/30
	addressdesc text,			-- λ������	add	at 17/12/28
	longitude double,			-- ����		add	at 17/12/28
	latitude double,				-- γ��		add	at 17/12/28
	foreign key (uid) references person(id)		--  add	at 17/12/29	������Լ��
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publishskill values
(null, 100, "һ��....��ppt", "�ҵ�ppt....", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/100ppt.jpg",
"ppt", false, true, null, null, null),											-- ���� λ�ú�����Ϊnull
(null, 101, "һ��....��ppt", "�ҵ�ppt....", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/101ppt.jpg",
"ppt", false, true, null, null, null),											-- ���� λ�ú�����Ϊnull
(null, 102, "��æ��ȫ�Ҹ�", "18��2��14,15,16��ר�Ű�����ȫ�Ҹ���Ƭ������Ҫ�������", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/102quanjiafu.jpeg",
"photography", false, false, "����ʦ����ѧ", 116.0393384141, 28.6880130001),
(null, 103, "����д��", "�⼸��Ƚ��У�����Ҫ��д��Ŀ�������", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/103xiezheng.jpg",
"photography", true, false, "����ʦ����ѧ", 116.0321930092, 28.6888601125),
(null, 104, "���ı�ҵ��", "רҵ�ı�ҵ�գ��۸�����ͯ������....", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/104biyezhao.jpg",
"photography", false, false, "����ʦ����ѧ", 116.0371926468, 28.6842291481),
(null, 105, "���ļ�¼��Ƭ", "��Ҫ��¼����������Ҫ��һ�̣����������Ұ�æ...", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/105jilupian.jpg",
"photography", false, false, "����ʦ����ѧ", 116.0332015198, 28.6894436747),
(null, 106, "������", "��Ҫ�ģ���������.....", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/106pai.jpg",
"photography", false, false, "����ʦ����ѧ", 116.0393697686, 28.6927591132),
(null, 107, "һ�������������������", "����רҵ���ն���......", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/null.jpg",
"photography", false, false, "����ʦ����ѧ", 116.0308460373, 28.6967061686),
(null, 102, "����Լ�", "������Ҫ�Լ����������ѷ��ٶ�һ����98k��������ǹ֧���ȫ�Ͻ�����ҩ�ȷ��㣬������˽�أ���ʶ��Ⱥ����ǿ��ͷ���ж��0ɱ�Լ����飬������棬����̽·��ǹ�������Ѫƴ��Ͷ��������Ʒȫ���Ͻ�������Ҫ�������",
now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"accompany", false, false, "����ʦ����ѧ", 116.0393384141, 28.6880130001),
(null, 103, "������~", "�⼸������ģ�����Ҫ������Ŀ������ң�~~", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"accompany", true, false, "����ʦ����ѧ", 116.0311330092, 28.6888601125),
(null, 105, "��Զ�����~", "���˳Ի�һö�����ԺóԵĶ�����������Ҫһ��Զ������𣬼�Ǯ55��...", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"accompany", false, false, "����ʦ����ѧ", 116.0341926468, 28.6842291481),
(null, 101, "�㿴�����Ӱ", "�þ�û����Ӱ�ˣ����뿴����Ӱ�Ĳ����еĻ��������ң����Ը�ӰƱ��...", now(), date_add(now(), interval 2 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"accompany", false, false, "����ʦ����ѧ", 116.0335015198, 28.6834436747),
(null, 104, "����", "��Ů����Ҫ��ֵ��𣬱����ṩ��ѵİ��ᶫ�������еĻ����������Ұ�æ...", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"accompany", false, false, "����ʦ����ѧ", 116.0336015198, 28.6844436747),
(null, 106, "����lol", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"accompany", false, false, "����ʦ����ѧ", 116.0391697686, 28.6927591132),
(null, 107, "������", "������������......", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"errand", false, false, "����ʦ����ѧ", 116.0302460373, 28.6967061686),
(null, 106, "������1", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/106pai.jpg",
"errand", false, false, "����ʦ����ѧ", 116.0391697686, 28.6927591132),

(null, 103, "������5", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0391697606, 28.6927590132),
(null, 104, "������6", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://192.168.1.110:8080/fragment_server/images/skill_pre_img/104biyezhao.jpg",
"errand", false, false, "����ʦ����ѧ", 116.0331697606, 28.6927591032),
 (null, 102, "������7", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0341697606, 28.6927591032),
 (null, 101, "������8", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0351697606, 28.6927591032),
 (null, 103, "������9", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0361697606, 28.6923491032),
(null, 105, "������2", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0371607686, 28.6927391032),
(null, 102, "������3", "������ʯ��λ�������˴��Ŀ���call�ң�..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "����ʦ����ѧ", 116.0391497686, 28.6927501132),

(null, 107, "������4", "��һ�����ܺ�10ƿ......", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"errand", false, false, "����ʦ����ѧ", 116.0302460373, 28.6967061686);


-- publishneed��
drop table if exists publishneed;
create table publishneed(
	id int primary key auto_increment,	
	uid int not null,
	title varchar(60),		-- ��������	add	at 17/12/28
	content text,				-- ��������
	needtype varchar(60),				--				add	at 17/12/30   alter in the android studio
	customdate datetime,			-- ����ʱ��
	requestdate datetime,			-- ��ֹ����
	iscomplete boolean,			-- �Ƿ����		 alter at 17/12/30
	isonline boolean,				-- �Ƿ�������	add	at 17/12/28		 alter at 17/12/30
	addressdesc text,			-- λ������	add	at 17/12/28
	longitude double,			-- ����		add	at 17/12/28
	latitude double,				-- γ��		add	at 17/12/28
	foreign key (uid) references person(id)		--  add	at 17/12/29	������Լ��
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publishneed values
(null, 100, "�Ҽ���һ��ppt", "����������...��Ҫ...", "ppt", now(), date_add(now(), interval 2 day),
false, false, "����ʦ����ѧ", 116.0415056453, 28.6885548192),
(null, 100, "�����ȫ�Ҹ�", "�������ˣ���Ҫ�ͼ����ո��࣬....", "photography", now(), date_add(now(), interval 2 day),
false, false, "����ʦ����ѧ", 116.0460332141, 28.6872182561),
(null, 101, "�����д��", "����������...��Ҫ���˰�æ��һ��д�档�����������", "photography", now(), date_add(now(), interval 2 day),
false, false, "����ʦ����ѧ", 116.0339096230, 28.6847939108),
(null, 102, "����ļ�¼��Ƭ", "�ҹ���ǰҪ��飬���Ҹ��˰�������Ƶ...", "photography", now(), date_add(now(), interval 4 day),
false, false, "����ʦ����ѧ", 116.0357978982, 28.6821206738),
(null, 103, "�Ҽ���...", "����������...��Ҫ...", "photography", now(), date_add(now(), interval 3 day),
false, false, "����ʦ����ѧ", 116.0269949630, 28.6830559397),
(null, 104, "���˰�æ", "����������...��Ҫ...", "photography",  now(), date_add(now(), interval 2 day),
false, false, "����ʦ����ѧ", 116.0367519326, 28.6927779371),

(null, 103, "�Ҽ���...", "����������...��Ҫ...", "accompany", now(), date_add(now(), interval 3 day),
false, false, "����ʦ����ѧ", 116.0269949630, 28.6830559397),

(null, 102, "������...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0469949630, 28.6830559397),
(null, 103, "������1...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0369949630, 28.6830559397),
 (null, 101, "������2...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0269949630, 28.6830559397),
 (null, 104, "������3...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0429949630, 28.6830559397),
 (null, 105, "������4...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0365949630, 28.6830559397),
 (null, 106, "������5...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0439949630, 28.6830559397),
 (null, 103, "������6...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0379949630, 28.6830559397),
 (null, 102, "������7...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0449949630, 28.6830559397),
 (null, 101, "������8...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0359949630, 28.6830559397),
 (null, 105, "������9...", "����������...��Ҫ...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "����ʦ����ѧ", 116.0269949630, 28.6830559397),

(null, 102, "��������..", "����������...��Ҫ...", "accompany", now(), date_add(now(), interval 3 day),
false, false, "����ʦ����ѧ", 116.0269949630, 28.6830559397);



-- completecustom��
-- drop table if exists completecustom;
-- create table completecustom(
-- 	id int primary key auto_increment,
-- 	uid int not null,		-- ���������ߵ�id
-- 	title varchar(60),			--  ��������    add	at 17/12/28
-- 	content text,				-- ��������
-- 	customdate datetime,			-- ����ʱ��	
-- 	img varchar(300),				-- ͼƬԤ��
-- 	skilltype varchar(50),				-- ��������
-- 	isopen tinyint,				-- �Ƿ񹫿�
-- 	foreign key (uid) references person(id)		--  add	at 17/12/29	������Լ��
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert into completecustom values
-- (null, 100, ),


-- privatemessage��
drop table if exists privatemessage;  
create table privatemessage(
	id int  primary key auto_increment,
	senderid int not null,	-- ������id
	sendername varchar(12) not null,		-- ����������
	receiverid int not null,	-- ������ id
	receivername varchar(12) not null,	-- ����������
	sendtime datetime not null,	-- ����ʱ��
	content text,				-- ��������
	isread boolean,					-- �Ƿ��ȡ��Ĭ��û��false 0   alter at 17/12/30
	foreign key (senderid) references person(id),		--  add	at 17/12/29	������Լ��
	foreign key (receiverid) references person(id)		--  add	at 17/12/29	������Լ��
--	���ڲ���attention����Ϣ����ͬһ���˶���һ���˷����������Բ��������������Ϊ����

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into privatemessage values
(null, 100, "����", 101, "annie", now(), "hello, annie, I'm zs", false),
(null, 100, "����", 102, "galun", now(), "hello, galun, I'm���� ", false),
(null, 100, "����", 103, "bob", now(), "hello, bob, I'm ����", false),
(null, 101, "annie", 102, "galun", now(), "hello, galun, I'm annie ", false),
(null, 101, "annie", 103, "bob", now(), "hello, bob, I'm annie", false),
(null, 102, "galun", 104, "tony", now(), "hello, tony, I'm galun", false),
(null, 103, "bob", 105, "sweet", now(), "hello, sweet, I'm bob", false);

-- PublicMessage��
drop table if exists publicmessage;
create table publicmessage(
	id int  primary key auto_increment,
	receiverid int not null,					-- add at 17/12/29
	sendtime datetime not null,
	title varchar(60),
	content text,
	isread boolean,	 -- alter at 17/12/30
	foreign key (receiverid) references person(id)		--  add	at 17/12/29	������Լ��
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publicmessage values
(null, 100, now(), "ϵͳ��Ϣ", "�𾴵��û�0..", false ),
(null, 100, now(), "ϵͳ��Ϣ", "�𾴵��û�1..", false ),
(null, 101, now(), "ϵͳ��Ϣ", "�𾴵��û�2..", false ),
(null, 102, now(), "ϵͳ��Ϣ", "�𾴵��û�3..", false ),
(null, 103, now(), "ϵͳ��Ϣ", "�𾴵��û�4..", false ),
(null, 104, now(), "ϵͳ��Ϣ", "�𾴵��û�5..", false ),
(null, 105, now(), "ϵͳ��Ϣ", "�𾴵��û�6..", false );



--         ������������������������������ͼ start


-- ����user view  ���˲���Ҫ����Ϣ
drop view if exists v_user;
create view v_user (id, name, password, email)
	as
	select id, name, password, email
	from person;

-- view person ����һЩ��Ϣ
drop view if exists v_person;
create view v_person(id, name, email, sex, age, headimg, starnum, dealnum,  fansnum)
	as 
	select id, name, email, sex, age, headimg, starnum, dealnum, fansnum
	from person;

-- ��������needԤ�� 
drop view if exists v_need_prehead;
create view v_need_prehead  (id, uid, name, headimg, longitude, latitude, title, addressdesc )
	as 
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title,b.addressdesc
	from person a, publishneed b
	where a.id = b.uid and b.isonline = false;

-- ��������skillԤ��
drop view if exists v_skill_prehead;
create view v_skill_prehead  (id, uid, name, headimg, longitude, latitude, title, addressdesc )
	as 
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title,b.addressdesc
	from person a, publishskill b
	where a.id = b.uid and b.isonline = false;
-- ������������������������������������������������������������alter at 1/4

-- �������������������������洢����(stored procedure) start  
--  �����������������������������������ݴ�����������ݿ�����
drop procedure if exists sp_find_attention;
delimiter //  
create procedure sp_find_attention (
	in _id int			 -- �����������
)	 --   ��ѯ��ע����   ������
begin 
select id, name, email, sex, age, headimg, starnum, dealnum,  fansnum
	from v_person 
	where exists (
	select 1 from (
		select attentionuserid fid from attention where uid= _id 
		union 
		select uid fid from attention where attentionuserid = _id 
		) friend
	where friend.fid = v_person.id
	);
end;
//
delimiter ;
-- call sp_find_attention(100);	-- ������
--       ���������������������ָ��ߡ���������������
--    �����������Զ��庯��������������������
drop function if exists func_getDistance;
delimiter //  
create function func_getDistance (
	LatBegin double,
	LngBegin double,	
	LatEnd double,
	LngEnd double	
)	returns double 
begin 
	declare Distance double;  
	declare EARTH_RADIUS double;  
	declare RadLatBegin double;
	declare RadLatEnd double;
	declare RadLatDiff double;
	declare RadLngDiff double; 
	SET EARTH_RADIUS = 6378137;     
	SET RadLatBegin = LatBegin * PI() / 180.0;  
	SET RadLatEnd = LatEnd * PI() / 180.0;  
	SET RadLatDiff = RadLatBegin - RadLatEnd;  
	SET RadLngDiff = LngBegin * PI() / 180.0 - LngEnd * PI() / 180.0;  
	SET Distance = 2 * ASIN(SQRT(POWER(Sin(RadLatDiff / 2), 2) +COS(RadLatBegin) * COS(RadLatEnd) * POWER(SIN(RadLngDiff/2),2)));  
	SET Distance = Distance * EARTH_RADIUS ;  
	return Distance;
end;
//
delimiter ;
--       ���������������������ָ��ߡ���������������
drop procedure if exists sp_nearbyneed_infos;
delimiter //  
create procedure sp_nearbyneed_infos (
	in _type varchar(50),			 -- �����������
	in _latitude double,
	in _longitude double
)	 --   ��ѯ������need_infos   ������
begin 
	declare maxDistance double; 
	declare distance double; 
	SET maxDistance = 2500.0;
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title, b.addressdesc
		from person a, publishneed b
	where a.id = b.uid and b.isonline = false and b.needtype = _type and 
		func_getDistance(_latitude, _longitude, b.latitude, b.longitude) < maxDistance;
end;
//
delimiter ;

drop procedure if exists sp_nearbyskill_infos;
delimiter //  
create procedure sp_nearbyskill_infos (
	in _type varchar(50),			 -- �����������
	in _latitude double,
	in _longitude double
)	 --   ��ѯ������need_infos   ������
begin 
	declare maxDistance double; 
	declare distance double; 
	SET maxDistance = 2500.0;
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title, b.addressdesc
		from person a, publishskill b
	where a.id = b.uid and b.isonline = false and b.skilltype = _type and
		func_getDistance(_latitude, _longitude, b.latitude, b.longitude) < maxDistance;
end;
//
delimiter ;

-- �������� ���� ���� ����
--   ------------------------------------------------------------
-- sp_nearbyneed_infos
-- sp_nearbyskill_infos