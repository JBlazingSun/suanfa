package com.blazings.suanfa.javapractice.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	Long id;
	String name;
	Integer age;
	String intro;
	List<Book> books;
}
