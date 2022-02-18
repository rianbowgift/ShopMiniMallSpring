package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	

	public GoodsDTO goodsRetrieve( String gCode) {
		// GoodsMapper.xml 접근은  namespace.id 값 형식으로 접근
		GoodsDTO list = 
				   session.selectOne("com.GoodsMapper.goodsRetrieve", gCode);
		   return list;
	   }
   public List<GoodsDTO> goodsList(String gCategory) {
	   List<GoodsDTO> list = 
			   session.selectList("com.GoodsMapper.goodsList", gCategory);
	   return list;
   }
}
