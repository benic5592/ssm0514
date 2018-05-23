package cn.com.zhirun.ssm0514.controller;

import cn.com.zhirun.ssm0514.model.MemberModel;
import cn.com.zhirun.ssm0514.service.IMemberService;
import cn.com.zhirun.ssm0514.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@RequestMapping("/member")
@Controller
public class MemberController {


    @Autowired
    IMemberService memberService;


    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/selectById")
    public ModelAndView selectByPrimaryKey(Integer id, Locale locale){



        // 国际化测试 start
        String select = applicationContext.getMessage("se", null, locale);

        // 国际化测试 end

        MemberModel memberModel = memberService.selectByPrimaryKey(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("member",memberModel);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/selectByMember")
    public ModelAndView selectByPrimaryKey(MemberModel member){


        MemberModel memberModel = memberService.selectByPrimaryKey(member.getId());

        ModelAndView mv = new ModelAndView();
        mv.addObject("member",memberModel);
        mv.setViewName("result");

        return mv;
    }


    @RequestMapping("/toResult")
    public String toResult(){
        return "forward:/index.jsp";
    }

    @ResponseBody
    @RequestMapping("/selectByAjax")
    public MemberModel selectByAjax(Integer id){

        MemberModel memberModel = memberService.selectByPrimaryKey(id);

        return memberModel;

    }

    @ResponseBody
    @RequestMapping("/selectByAjaxBetter")
    public ModelMap selectByAjaxBetter(Integer id){

        ModelMap modelMap = new ModelMap();
        MemberModel memberModel = memberService.selectByPrimaryKey(id);

        // 放到modelMap里
        modelMap.put("member",memberModel);

        return modelMap;

    }

    @RequestMapping("/selectMembers")
    public ModelAndView selectMembers(MemberModel memberModel){

        ModelAndView mv = new ModelAndView();

        List<MemberModel> list =
                memberService.selectMembers(memberModel);

        mv.addObject("members",list);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/selectByIds")
    public ModelAndView selectByIds(String[] id) {

        ModelAndView mv = new ModelAndView();
        List<MemberModel> list =
                memberService.selectByIds(id);

        mv.addObject("members",list);

        mv.setViewName("result");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/selectByIdsAjax")
    public ModelMap selectByIdsAjax(@RequestParam("id[]") String[] id) {
        ModelMap mm = new ModelMap();
        List<MemberModel> list =
                memberService.selectByIds(id);

        mm.put("members",list);

        return mm;
    }


    @ResponseBody
    @RequestMapping("/selectByMemberAjax")
    public ModelMap selectByMemberAjax(MemberModel member){


        MemberModel memberModel = memberService.selectByPrimaryKey(member.getId());

        ModelMap mv = new ModelMap();
        mv.put("member",memberModel);

        return mv;
    }


    @RequestMapping("/testLanguage")
    public ModelAndView testLanguage(String username,Locale locale){

        Object[] objects = new Object[1];
        objects[0] = username;
        String result =
                applicationContext.getMessage("login",objects,locale);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",result);
        modelAndView.setViewName("result");

        return modelAndView;
    }


    @RequestMapping("/changeLanguage")
    public String changeLanguage(){
        return "forward:/testLanguage.jsp";
    }
}
