package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.DeptVO;
import org.doit.ik.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{
   
   @Autowired
   private SampleMapper sampleMapper;



@Override
public List<DeptVO> getDeptList() throws Exception {
	// TODO Auto-generated method stub
	  return this.sampleMapper.getDeptList();
}

}