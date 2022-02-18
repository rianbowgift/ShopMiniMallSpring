package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.OrderDTO;

@Repository
public class CartDAO {

	@Autowired
	SqlSessionTemplate session;

	public int orderAllDone(List<OrderDTO> x) {
		int n = session.insert("CartMapper.orderAllDone", x);
		return n;
	}
	
	public List<CartDTO> orderAllConfirm(List<String> list) {
		List<CartDTO> n = session.selectList("CartMapper.orderAllConfirm", list);
		return n;
	}
	
	public int orderDone(OrderDTO dto) {
		int n = session.insert("CartMapper.orderDone", dto);
		return n;
	}
	
	public CartDTO cartbyNum(String num) {
		CartDTO list = session.selectOne("CartMapper.cartbyNum", num);
		return list;
	}
	
	public int cartAllDel(List<String> list) {
		int n = session.delete("CartMapper.cartAllDel", list);
		return n;
	}
	
	public int cartDel( int num) {
		int n = session.delete("CartMapper.cartDel", num);
		return n;
	}
	
	public int cartUpdate( Map<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}
	public int cartAdd(CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return list;
	}
}
