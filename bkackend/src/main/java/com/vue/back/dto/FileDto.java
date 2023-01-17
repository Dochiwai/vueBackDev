package com.vue.back.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FileDto {
	private String uuid;
	private String file_name;
	private int file_type;
	private long uid;
	private long file_size;
	private Date reg_at;
	
	public FileDto() {}
	
	public FileDto(String uuid, String file_name, int file_type) {
		this.uuid = uuid;
		this.file_name = file_name;
		this.file_type = file_type;
		
	}
}	
