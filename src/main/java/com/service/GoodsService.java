package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

@Service
public class GoodsService {
	 
	@Autowired
	 GoodsDAO dao;
	  
	 public GoodsDTO goodsRetrieve(String gCode) {
		 	return dao.goodsRetrieve(gCode);
		}//end idCheck
	
	  public List<GoodsDTO> goodsList(String gCategory) {
			return dao.goodsList(gCategory);
		}//end idCheck
}//end class
