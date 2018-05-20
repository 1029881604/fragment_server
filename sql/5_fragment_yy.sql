
-- ----------------------------
-- Procedure structure for sp_all_attention
-- ----------------------------
----�ҳ��Լ������person  start---
DROP PROCEDURE IF EXISTS `sp_all_attention`;
DELIMITER ;;
CREATE  PROCEDURE `sp_all_attention`(IN `_id` int)
BEGIN

select id, name, email, sex, age, headimg, starnum, dealnum,  fansnum
	from v_person 
	where id !=_id;
	
END
;;
DELIMITER ;
----�ҳ��Լ������person  end---

----�ҹ�ע����  start---
drop procedure if exists sp_find_following;
delimiter //  
create procedure sp_find_following (
	in _id int			
)	 
begin 
select id, name, email, sex, age, headimg, starnum, dealnum,  fansnum
	from v_person 
	where exists (
	select 1 from (
		select attentionuserid fid from attention where uid= _id 
		) friend
	where friend.fid = v_person.id
	);
end;
//
delimiter ;
----�ҹ�ע����  end---