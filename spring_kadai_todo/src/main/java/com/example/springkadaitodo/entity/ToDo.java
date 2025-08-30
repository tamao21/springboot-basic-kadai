package com.example.springkadaitodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer todoId;

	@Column(name = "title")
	private String todoTitle;

	@Column(name = "priority")
	private String todoPriority;

	@Column(name = "status")
	private Integer todoStatus;

}
