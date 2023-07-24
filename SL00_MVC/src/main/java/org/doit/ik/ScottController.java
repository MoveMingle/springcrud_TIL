package org.doit.ik;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/scott/*")
public class ScottController {
   //mvc로 따지면 ~~핸들러안에 있는 프로퍼티즈

   @Setter(onMethod=@__({@Autowired}))
   private DeptMapper deptMapper;
   
   @Setter(onMethod=@__({@Autowired}))
   private EmpMapper empMapper;
   
               //Controller Method 이다. properties파일이 따로 필요없게 됨
   @RequestMapping(value = "/dept", method = RequestMethod.GET) //기본값이 get방식이다.
   public void dept(Locale locale, Model model) {
      log.info(" /scott/dept get...");   
      //얘가 void이기 때문에 view페이지를 자동으로 찾아준다.
      List<DeptDTO> list = this.deptMapper.selectDept();
      //list.forEach(dto -> log.info(dto));
      model.addAttribute("list", list);
   }//dept
   
   
   //?deptno=10&deptno=20 -> req.getParam 하면 모든 자료형식은 String
   //@RequestMapping(value = "/scott/emp", method = RequestMethod.POST)
   //위와 아래의 코드는 같은 코딩이다.
   @PostMapping("/emp")
   //public void emp( String [] deptnos ) {
   public String emp( @RequestParam(value="deptno") 
   ArrayList<Integer> deptnos,Model model) {
      log.info(" /emp post...");
      List<EmpDTO> list = this.empMapper.selectEmp(deptnos);
      model.addAttribute("list", list);
      return "/scott/emp";
      
   }
}