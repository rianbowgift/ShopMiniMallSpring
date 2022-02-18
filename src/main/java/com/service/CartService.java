package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

@Service
public class CartService {

	@Autowired
	CartDAO dao;

	public int orderAllDone(List<OrderDTO> x,List<String> nums) {
		int n = 0;
			n = dao.orderAllDone( x);
			n= dao.cartAllDel( nums);
		return n;
	}// end cartAdd
	
	public List<CartDTO> orderAllConfirm(List<String> x) {
		List<CartDTO> list = null;
			 list = dao.orderAllConfirm(x);
		return list;
	}//end idCheck
	
	public int orderDone(OrderDTO dto,String orderNum) {
		 int n = dao.orderDone(dto); // Order에 주문정보 저장
			 n= dao.cartDel(Integer.parseInt(orderNum)); //Cart테이블에서 삭제
		return n;
	}// end cartAdd
	
	public CartDTO cartbyNum( String num) {
		CartDTO dto = dao.cartbyNum(num);
		return dto;
	}//end idCheck
	
	public int cartAllDel(List<String> list) {
		int n = dao.cartAllDel(list);
		return n;
	}// end cartAdd

	public int cartDel(int num) {
		int n = dao.cartDel(num);
		return n;
	}// end cartDel

	public int cartUpdate(Map<String, Integer> map) {
		int n = dao.cartUpdate(map);
		return n;
	}// end cartAdd

	public int cartAdd(CartDTO dto) {
		int n = dao.cartAdd(dto);
		return n;
	}// end cartAdd

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = dao.cartList(userid);
		return list;
	}// end idCheck
}// end class
