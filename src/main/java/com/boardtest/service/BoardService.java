package com.boardtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardtest.dao.BoardDao;
import com.boardtest.model.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//board object 저장
	public Board createBoard(Board board) {
		
		System.out.println(board);
		return boardDao.save(board);
	}

	//모든 로우를 다 가져옴
	public Iterable<Board> findAll(){
		return boardDao.findAll();
	}
	
	
	//아이디로 해당 게시물 객체를 찾음
	public Board getById(Long id) {
		return boardDao.getById(id);
	}
	
	//해당 객체가 있으면 삭제한다. 
	public void deleteBoard(Long id) {
		Board board = getById(id);
		boardDao.delete(board);
	}
	
	
}
