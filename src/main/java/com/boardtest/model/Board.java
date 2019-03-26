package com.boardtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Table
@Entity
@Data
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "No boardTitle")
	@Column(nullable = false, length = 500)
	private String boardTitle;

	@NotBlank(message = "No boardCons")
	@Column(nullable = false, length = 2000)
	private String boardCons;

	@NotBlank(message = "No writer")
	@Column(nullable = false, length = 100)
	private String writer;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardCons() {
		return boardCons;
	}

	public void setBoardCons(String boardCons) {
		this.boardCons = boardCons;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	/*
	 * @Column(nullable=true, columnDefinition="date default sysdate")
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private Date boardDate = new Date();
	 * 
	 */

}
