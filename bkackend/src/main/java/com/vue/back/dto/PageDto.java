package com.vue.back.dto;

import lombok.Setter;

@Setter
public class PageDto {
	private int page;
	private int qty;
	private String type;
	private int startPage;
	
	public PageDto() {
		this(1,10);
	}

	public PageDto(int pageNo, int qty) {
		this.page = pageNo;
		this.qty = qty;
	}
//	public int getStartPage() { //시작 번호 값 구하는 메서드
//		return (this.page - 1) * qty;  //DB에서 값을 limit 첫 시작이 (0,10), (10,10), (20,10)
//	}

	public int getPage() {
		return page;
	}

	public int getQty() {
		return qty;
	}

	public String getType() {
		return type;
	}

	public int getStartPage() {
		return (this.page - 1) * qty;
	}

	
	
}
