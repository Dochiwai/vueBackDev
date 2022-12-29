package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	private long uid;
	private String category;
	private String title;
	private String content;
	private String created_user;
	private Date created_at;
	private Date updated_at;
	private int is_del;
	private int view_cnt;
	private int good_cnt;
	private int not_good_cnt;
}
