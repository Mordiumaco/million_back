package com.boardtest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boardtest.model.Board;

@Repository
public interface BoardDao extends CrudRepository<Board, Long>{

	Board getById(Long id);
	
}
