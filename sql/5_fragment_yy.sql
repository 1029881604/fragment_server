
-- ----------------------------
-- Procedure structure for sp_all_attention
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_all_attention`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_all_attention`(IN `_id` int)
BEGIN

select id, name, email, sex, age, headimg, starnum, dealnum,  fansnum
	from v_person 
	where id !=_id;
	
END
;;
DELIMITER ;
