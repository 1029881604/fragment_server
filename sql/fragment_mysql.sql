-- 创建数据库
drop database if exists fragment;
create database fragment;
use fragment;
-- ——————————表的构建  start
-- 收藏表，待写。。。。历史记录表。。。。。

-- nearbymodular 附近模块信息表
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
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_photography.jpg", 
 "最会拍的摄影师", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_photography.jpg", "photography", now(), now()),
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_accompany.jpg", 
 "最有趣的陪玩", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_accompany.jpg", "accompany", now(), now()),
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_errand.jpeg", 
 "最速度的跑腿", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_errand.jpeg", "errand", now(), now()),
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_manual.jpg", 
 "最尽力的苦力", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_manual.jpg", "manual", now(), now()),
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_guide.jpg", 
 "最专业的指导", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_guide.jpg", "guide", now(), now()),
("needtitle", "巴拉巴拉balabalabala, we have the bast py in the world, balabala...., now you should...",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/need_other.jpg", 
 "最专业的啥", "不知道说啥，这里是内容，巴拉巴拉巴拉巴拉，，balabalabala...巴拉巴拉巴拉巴拉.",
 "http://192.168.191.1:8080/fragment_server/images/nearby_modular_img/skill_other.png", "other", now(), now());


-- person表 other or firends
drop table if exists person;
create table person(			--  服务器端的person应该需要password or phone num?  add at 17/12/28
	id int primary key auto_increment,  
	name varchar(60) not null unique,		-- 昵称，独一无二
	password varchar(60) not null,  
	sex varchar(10),
	email varchar(30),			-- add at 17/12/28
	phonenum varchar(20),		-- add at 17/12/29  server had and client didn't had  
	age smallint,
	headimg varchar(300),		-- 头像
	starnum double,		-- 星级评分
	dealnum int,		-- 完成交易数量
	fansnum int		-- 粉丝数量  关注者数
-- constraint chk_sex check (sex in ("男", "女"))			mysql当前版本约束无效
-- constraint chk_age check (age >0 and age < 130)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--  后面可以加上身份证号之类的
insert into person values
(100, "张三", "zhangsan", "男", "1923e343@qq.com",
"10000000000", 22, "http://192.168.191.1:8080/fragment_server/images/person_head_img/100.jpg",
3.5, 30, 200),
(101, "annie", "annie", "女", "annie@163.com",
"10000000001", 18, "http://192.168.191.1:8080/fragment_server/images/person_head_img/101.jpeg",
6.5, 600, 3000),
(102, "galun", "galun", "男", "galun@qq.com",
"10000000002", 25, "http://192.168.191.1:8080/fragment_server/images/person_head_img/102.jpg",
5.5, 100, 300),
(103, "bob", "bob", "男", "bob@qq.com",
"10000000003", 22, "http://192.168.191.1:8080/fragment_server/images/person_head_img/103.jpg",
3.5, 30, 200),
(104, "tony", "tony", "男", "tony@qq.com",
"10000000004", 22, "http://192.168.191.1:8080/fragment_server/images/person_head_img/104.jpg",
1.5, 30, 100),
(105, "sweet", "sweet", "女", "sweet@qq.com",
"10000000005", 19, "http://192.168.191.1:8080/fragment_server/images/person_head_img/105.jpg",
5.5, 200, 1000),
(106, "alice", "alice", "女", "alice@qq.com",
"10000000006", 19, "http://192.168.191.1:8080/fragment_server/images/person_head_img/106.jpg",
5.5, 400, 1000),
(107, "michelle", "michelle", "女", "michelle@qq.com",
"10000000007", 19, "http://192.168.191.1:8080/fragment_server/images/person_head_img/107.jpg",
7.5, 600, 3000);

-- attention表  
drop table if exists attention;
create table attention(
	uid int not null,
	attentionuserid int not null,		-- 被关注的人的id
	primary key (uid, attentionuserid),
	foreign key (uid) references person(id),		--  add	at 17/12/29		添加外键约束
	foreign key (attentionuserid) references person(id)		--  add	at 17/12/29	添加外键约束
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


-- publishskill表
drop table if exists publishskill;
create table publishskill(
	id int primary key auto_increment,
	uid int not null,		-- 发布技能者的id
	title varchar(60),		-- 发布标题	add	at 17/12/28
	content text,				-- 发布内容
	publishdate datetime,			-- 发布时间 now()
	stopdate datetime,			-- 停止服务时间
	img varchar(300),					-- 图片预览
	skilltype varchar(50),				-- 技能类型
	iscomplete boolean,			-- 是否是被预定 alter at 17/12/30
	isonline boolean,				-- 是否是线上	add	at 17/12/28  alter at 17/12/30
	addressdesc text,			-- 位置描述	add	at 17/12/28
	longitude double,			-- 经度		add	at 17/12/28
	latitude double,				-- 纬度		add	at 17/12/28
	foreign key (uid) references person(id)		--  add	at 17/12/29	添加外键约束
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publishskill values
(null, 100, "一个....的ppt", "我的ppt....", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/100ppt.jpg",
"ppt", false, true, null, null, null),											-- 线上 位置和描述为null
(null, 101, "一个....的ppt", "我的ppt....", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/101ppt.jpg",
"ppt", false, true, null, null, null),											-- 线上 位置和描述为null
(null, 102, "帮忙拍全家福", "18年2月14,15,16号专门帮人拍全家福照片，有需要的请叫我", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/102quanjiafu.jpeg",
"photography", false, false, "江西师范大学", 116.0393384141, 28.6880130001),
(null, 103, "帮拍写真", "这几天比较闲，有需要拍写真的可以找我", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/103xiezheng.jpg",
"photography", true, false, "江西师范大学", 116.0321930092, 28.6888601125),
(null, 104, "帮拍毕业照", "专业拍毕业照，价格公正，童叟无欺....", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/104biyezhao.jpg",
"photography", false, false, "江西师范大学", 116.0371926468, 28.6842291481),
(null, 105, "帮拍记录短片", "想要记录你人生中重要的一刻，可以来找我帮忙...", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/105jilupian.jpg",
"photography", false, false, "江西师范大学", 116.0332015198, 28.6894436747),
(null, 106, "拍拍拍", "想要拍，可以找我.....", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/106pai.jpg",
"photography", false, false, "江西师范大学", 116.0393697686, 28.6927591132),
(null, 107, "一个让您满意的拍照助理", "本人专业拍照多年......", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/null.jpg",
"photography", false, false, "江西师范大学", 116.0308460373, 28.6967061686),
(null, 102, "陪玩吃鸡", "有人需要吃鸡队友吗，我搜房速度一流，98k能量饮料枪支配件全上交，有药先分你，倍镜不私藏，意识超群，不强人头，有多次0杀吃鸡经验，主动冲锋，送命探路，枪下舔包，血拼空投，所有物品全部上交，有需要的请叫我",
now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"accompany", false, false, "江西师范大学", 116.0393384141, 28.6880130001),
(null, 103, "陪聊天~", "这几天比无聊，有需要找聊天的可以找我，~~", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"accompany", true, false, "江西师范大学", 116.0311330092, 28.6888601125),
(null, 105, "陪吃东西呦~", "本人吃货一枚，爱吃好吃的东西，有人想要一起吃东西的吗，价钱55分...", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"accompany", false, false, "江西师范大学", 116.0341926468, 28.6842291481),
(null, 101, "陪看各类电影", "好久没看电影了，有想看看电影的不，有的话可以找我，我自付影票呦...", now(), date_add(now(), interval 2 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"accompany", false, false, "江西师范大学", 116.0335015198, 28.6834436747),
(null, 104, "陪逛街", "有女生想要逛街的吗，本人提供免费的帮提东西服务，有的话可以来找我帮忙...", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"accompany", false, false, "江西师范大学", 116.0336015198, 28.6844436747),
(null, 106, "陪玩lol", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"accompany", false, false, "江西师范大学", 116.0391697686, 28.6927591132),
(null, 107, "当跑腿", "跑腿跑腿跑腿......", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"errand", false, false, "江西师范大学", 116.0302460373, 28.6967061686),
(null, 106, "当跑腿1", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/106pai.jpg",
"errand", false, false, "江西师范大学", 116.0391697686, 28.6927591132),

(null, 103, "当跑腿5", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "江西师范大学", 116.0391697606, 28.6927590132),
(null, 104, "当跑腿6", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://192.168.191.1:8080/fragment_server/images/skill_pre_img/104biyezhao.jpg",
"errand", false, false, "江西师范大学", 116.0331697606, 28.6927591032),
 (null, 102, "当跑腿7", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "江西师范大学", 116.0341697606, 28.6927591032),
 (null, 101, "当跑腿8", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"errand", false, false, "江西师范大学", 116.0351697606, 28.6927591032),
 (null, 103, "当跑腿9", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "江西师范大学", 116.0361697606, 28.6923491032),
(null, 105, "当跑腿2", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg",
"errand", false, false, "江西师范大学", 116.0371607686, 28.6927391032),
(null, 102, "当跑腿3", "本人钻石段位，想找人带的可以call我，..", now(), date_add(now(), interval 3 day),
 "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg",
"errand", false, false, "江西师范大学", 116.0391497686, 28.6927501132),

(null, 107, "当跑腿4", "我一口气能喝10瓶......", now(), date_add(now(), interval 3 day),
 "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
"errand", false, false, "江西师范大学", 116.0302460373, 28.6967061686);


-- publishneed表
drop table if exists publishneed;
create table publishneed(
	id int primary key auto_increment,	
	uid int not null,
	title varchar(60),		-- 发布标题	add	at 17/12/28
	content text,				-- 需求内容
	needtype varchar(60),				--				add	at 17/12/30   alter in the android studio
	customdate datetime,			-- 发布时间
	requestdate datetime,			-- 截止日期
	iscomplete boolean,			-- 是否完成		 alter at 17/12/30
	isonline boolean,				-- 是否是线上	add	at 17/12/28		 alter at 17/12/30
	addressdesc text,			-- 位置描述	add	at 17/12/28
	longitude double,			-- 经度		add	at 17/12/28
	latitude double,				-- 纬度		add	at 17/12/28
	foreign key (uid) references person(id)		--  add	at 17/12/29	添加外键约束
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publishneed values
(null, 100, "我急需一份ppt", "我现在由于...想要...", "ppt", now(), date_add(now(), interval 2 day),
false, false, "江西师范大学", 116.0415056453, 28.6885548192),
(null, 100, "求帮拍全家福", "快过年的了，想要和家人照个相，....", "photography", now(), date_add(now(), interval 2 day),
false, false, "江西师范大学", 116.0460332141, 28.6872182561),
(null, 101, "求帮拍写真", "我现在由于...想要找人帮忙拍一张写真。。最好在室内", "photography", now(), date_add(now(), interval 2 day),
false, false, "江西师范大学", 116.0339096230, 28.6847939108),
(null, 102, "求帮拍记录短片", "我过年前要结婚，想找个人帮我拍视频...", "photography", now(), date_add(now(), interval 4 day),
false, false, "江西师范大学", 116.0357978982, 28.6821206738),
(null, 103, "我急需...", "我现在由于...想要...", "photography", now(), date_add(now(), interval 3 day),
false, false, "江西师范大学", 116.0269949630, 28.6830559397),
(null, 104, "找人帮忙", "我现在由于...想要...", "photography",  now(), date_add(now(), interval 2 day),
false, false, "江西师范大学", 116.0367519326, 28.6927779371),

(null, 103, "我急需...", "我现在由于...想要...", "accompany", now(), date_add(now(), interval 3 day),
false, false, "江西师范大学", 116.0269949630, 28.6830559397),

(null, 102, "求跑腿...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0469949630, 28.6830559397),
(null, 103, "求跑腿1...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0369949630, 28.6830559397),
 (null, 101, "求跑腿2...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0269949630, 28.6830559397),
 (null, 104, "求跑腿3...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0429949630, 28.6830559397),
 (null, 105, "求跑腿4...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0365949630, 28.6830559397),
 (null, 106, "求跑腿5...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0439949630, 28.6830559397),
 (null, 103, "求跑腿6...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0379949630, 28.6830559397),
 (null, 102, "求跑腿7...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0449949630, 28.6830559397),
 (null, 101, "求跑腿8...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0359949630, 28.6830559397),
 (null, 105, "求跑腿9...", "我现在由于...想要...", "errand", now(), date_add(now(), interval 3 day),
 false, false, "江西师范大学", 116.0269949630, 28.6830559397),

(null, 102, "找人陪玩..", "我现在由于...想要...", "accompany", now(), date_add(now(), interval 3 day),
false, false, "江西师范大学", 116.0269949630, 28.6830559397);



-- completecustom表
-- drop table if exists completecustom;
-- create table completecustom(
-- 	id int primary key auto_increment,
-- 	uid int not null,		-- 发布技能者的id
-- 	title varchar(60),			--  发布标题    add	at 17/12/28
-- 	content text,				-- 发布内容
-- 	customdate datetime,			-- 发布时间	
-- 	img varchar(300),				-- 图片预览
-- 	skilltype varchar(50),				-- 技能类型
-- 	isopen tinyint,				-- 是否公开
-- 	foreign key (uid) references person(id)		--  add	at 17/12/29	添加外键约束
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert into completecustom values
-- (null, 100, ),


-- privatemessage表
drop table if exists privatemessage;  
create table privatemessage(
	id int  primary key auto_increment,
	senderid int not null,	-- 发送者id
	sendername varchar(12) not null,		-- 发送者姓名
	receiverid int not null,	-- 接受者 id
	receivername varchar(12) not null,	-- 接受者姓名
	sendtime datetime not null,	-- 发送时间
	content text,				-- 发送内容
	isread boolean,					-- 是否读取，默认没有false 0   alter at 17/12/30
	foreign key (senderid) references person(id),		--  add	at 17/12/29	添加外键约束
	foreign key (receiverid) references person(id)		--  add	at 17/12/29	添加外键约束
--	由于不像attention表，消息可以同一个人对另一个人发多条，所以不能用两个外键作为主键

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into privatemessage values
(null, 100, "张三", 101, "annie", now(), "hello, annie, I'm zs", false),
(null, 100, "张三", 102, "galun", now(), "hello, galun, I'm张三 ", false),
(null, 100, "张三", 103, "bob", now(), "hello, bob, I'm 张三", false),
(null, 101, "annie", 102, "galun", now(), "hello, galun, I'm annie ", false),
(null, 101, "annie", 103, "bob", now(), "hello, bob, I'm annie", false),
(null, 102, "galun", 104, "tony", now(), "hello, tony, I'm galun", false),
(null, 103, "bob", 105, "sweet", now(), "hello, sweet, I'm bob", false);

-- PublicMessage表
drop table if exists publicmessage;
create table publicmessage(
	id int  primary key auto_increment,
	receiverid int not null,					-- add at 17/12/29
	sendtime datetime not null,
	title varchar(60),
	content text,
	isread boolean,	 -- alter at 17/12/30
	foreign key (receiverid) references person(id)		--  add	at 17/12/29	添加外键约束
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into publicmessage values
(null, 100, now(), "系统消息", "尊敬的用户0..", false ),
(null, 100, now(), "系统消息", "尊敬的用户1..", false ),
(null, 101, now(), "系统消息", "尊敬的用户2..", false ),
(null, 102, now(), "系统消息", "尊敬的用户3..", false ),
(null, 103, now(), "系统消息", "尊敬的用户4..", false ),
(null, 104, now(), "系统消息", "尊敬的用户5..", false ),
(null, 105, now(), "系统消息", "尊敬的用户6..", false );



--         ——————————————视图 start


-- 返回user view  过滤不需要的信息
drop view if exists v_user;
create view v_user (id, name, password, email)
	as
	select id, name, password, email
	from person;

-- view person 隐藏一些信息
drop view if exists v_person;
create view v_person(id, name, email, sex, age, headimg, starnum, dealnum,  fansnum)
	as 
	select id, name, email, sex, age, headimg, starnum, dealnum, fansnum
	from person;

-- 线下所有need预览 
drop view if exists v_need_prehead;
create view v_need_prehead  (id, uid, name, headimg, longitude, latitude, title, addressdesc )
	as 
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title,b.addressdesc
	from person a, publishneed b
	where a.id = b.uid and b.isonline = false;

-- 线下所有skill预览
drop view if exists v_skill_prehead;
create view v_skill_prehead  (id, uid, name, headimg, longitude, latitude, title, addressdesc )
	as 
	select b.id, b.uid, a.name, a.headimg, b.longitude, b.latitude, b.title,b.addressdesc
	from person a, publishskill b
	where a.id = b.uid and b.isonline = false;
-- ——————————————————————————————alter at 1/4

-- ————————————存储过程(stored procedure) start  
--  ————————————减少连接数据传输次数和数据库连接
drop procedure if exists sp_find_attention;
delimiter //  
create procedure sp_find_attention (
	in _id int			 -- 定义输入参数
)	 --   查询关注的人   有括号
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
-- call sp_find_attention(100);	-- 有括号
--       ——————————分割线————————
--    —————自定义函数—————————
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
--       ——————————分割线————————
drop procedure if exists sp_nearbyneed_infos;
delimiter //  
create procedure sp_nearbyneed_infos (
	in _type varchar(50),			 -- 定义输入参数
	in _latitude double,
	in _longitude double
)	 --   查询附近的need_infos   有括号
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
	in _type varchar(50),			 -- 定义输入参数
	in _latitude double,
	in _longitude double
)	 --   查询附近的need_infos   有括号
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

-- ———— 交易 过程 事务，
--   ------------------------------------------------------------
-- sp_nearbyneed_infos
-- sp_nearbyskill_infos