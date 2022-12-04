package com.example.springmvc.entity.beansearcher;

import lombok.Data;

import java.util.HashMap;

@Data
public class Q35 {
	String s_id;
	String s_name;
	HashMap<String, Double> scoreMap = new HashMap<>();
	Double sumScore;
}
