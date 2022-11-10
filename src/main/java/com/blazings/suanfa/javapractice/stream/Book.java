package com.blazings.suanfa.javapractice.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	Long id;
	String name;
	String category;
	Integer score;
	String intro;
}
