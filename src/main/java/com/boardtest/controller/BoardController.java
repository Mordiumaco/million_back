package com.boardtest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardtest.model.Board;
import com.boardtest.service.BoardService;

@RestController
@RequestMapping
@CrossOrigin
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시물 만들기
	@PostMapping("")
	public ResponseEntity<?> addBoard(@Valid @RequestBody Board board, BindingResult result){
		
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		Board newBoard = boardService.createBoard(board);
		
		return new ResponseEntity<Board>(newBoard, HttpStatus.CREATED);
	}
	
	//게시물 전체 조회
	@GetMapping("/all")
	public Iterable<Board> getAllBoards(){
		return boardService.findAll();
	}
	
	//해당 번호 게시물 조회 
	@GetMapping("/{id}")
	public ResponseEntity<?> getBoardById(@PathVariable Long id){
		Board board = boardService.getById(id);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//해당 번호 게시물 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id){
		boardService.deleteBoard(id);
		return new ResponseEntity<String>("Board deleted", HttpStatus.OK);
	}
	
	
}
