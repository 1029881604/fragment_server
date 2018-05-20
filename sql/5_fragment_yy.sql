
-- ----------------------------
-- Procedure structure for sp_all_attention
-- ----------------------------
----找除自己本身的person  start---
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
----找除自己本身的person  end---

----找关注的人  start---
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
----找关注的人  end---