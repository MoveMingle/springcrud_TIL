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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// Ajax 처리를 하는 컨트롤러
@RestController
@RequestMapping("/scott/*")
@Log4j
public class ScottRestController {
   
   // @Setter(onMethod=@__({@Autowired}))
	
   @Autowired
   private DeptMapper deptMapper;
   
   //            /scott/dept/new
   @PostMapping("/dept/new")
   public ResponseEntity<String> insertDept( @RequestBody DeptDTO dto ){
      
      
      log.info("> /scott/dept/now POST ...");
      int insertResult = this.deptMapper.insertDept(dto);   // 1, 0
      return insertResult==1? 
            new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
            : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   //            /scott/dept/10
// /scott/dept/50
   //get,post

   @DeleteMapping(value ="/dept/{deptno}")
   public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno) {
       log.info("> /scott/dept/now DELETE ...");
       int deleteResult = this.deptMapper.deleteDept(deptno); // 1, 0
       return deleteResult == 1 ? 
           new ResponseEntity<String>("SUCCESS", HttpStatus.OK) :
           new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
  
   
   
   //////////////
   
   
}   //class