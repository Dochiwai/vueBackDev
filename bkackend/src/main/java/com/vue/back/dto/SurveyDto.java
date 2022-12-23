package com.vue.back.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author INF
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {
    private String title;
    private String content;
    private int selectMin;
    private int selectMax;
    private String type;
    private List<Questions> questions;

}
