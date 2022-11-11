package com.blazings.suanfa.javapractice.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Comparable<Author> {
	Long id;
	String name;
	Integer age;
	String intro;
	List<Book> books;

	@Override
	public int compareTo(@NotNull Author o) {
		return this.getAge() - o.getAge();
	}
}
