package com.example.springmvc.entity;

import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

@Data
@SearchBean
public class User {
	private Long id;            // 默认映射到 id 字段
	private String name;        // 默认映射到 name 字段
	private int age;            // 默认映射到 age 字段
}
