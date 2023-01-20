package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDto {
	private long uid;
	private long mother_uid;
	private String comment;
	private String created_user;
	private Date created_at;
	private Date updated_at;
}
