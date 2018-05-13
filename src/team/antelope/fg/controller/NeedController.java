package team.antelope.fg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.service.ISNearbyService;

/**
 * 需求Handler
 * @author 华文财
 * @time:2018年5月13日 下午7:40:19
 * @Description:TODO
 */
@Controller
@RequestMapping("/need")
public class NeedController {
	@Autowired
	private ISNearbyService nearbyService;
	
	@RequestMapping(value="/toNeedInfo", method=RequestMethod.GET)
	public ModelAndView toNeedInfo(@RequestParam(name="id") Long id){
		PersonInfo personInfo = nearbyService.getPersonInfo(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(SessionConst.NEARBY_PERSONINFO, personInfo);
		modelAndView.setViewName("nearby/personInfo");
		return modelAndView;
	}
	
}
