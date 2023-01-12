package com.vue.back.dto;

import lombok.Data;

@Data
public class PageDto {
	private int page;
	private int qty;
	
	public PageDto() {
		this(1,10);
	}

	public PageDto(int pageNo, int qty) {
		this.page = pageNo;
		this.qty = qty;
	}
	public int getPageStart() { //시작 번호 값 구하는 메서드
		return (this.page - 1) * qty;  //DB에서 값을 limit 첫 시작이 (0,10), (10,10), (20,10)
	}

}
