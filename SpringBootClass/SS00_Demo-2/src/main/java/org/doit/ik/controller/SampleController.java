package org.doit.ik.controller;

import java.util.List;

import javax.annotation.Resource;

import org.doit.ik.domain.DeptVO;
import org.doit.ik.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
   
   @Resource
   private SampleService sampleService;
   
   @GetMapping( value = "/dept/list" )
   public ModelAndView deptList() throws Exception{
      
      ModelAndView mv = new ModelAndView();
      List<DeptVO> list = this.sampleService.getDeptList();
      mv.addObject("list",list);
      mv.setViewName("/dept/list");
      return mv;
      
   }

}