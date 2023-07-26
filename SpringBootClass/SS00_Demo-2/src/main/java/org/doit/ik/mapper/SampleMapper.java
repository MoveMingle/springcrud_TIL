package org.doit.ik.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.doit.ik.domain.DeptVO;

@Mapper
public interface SampleMapper {
   
   public List<DeptVO> getDeptList() throws Exception;

}