package com.blazings.suanfa.javapractice.stream;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class AuthorTest {

	List<Author> authorList;

	//输出所有作家的名字
	@Test
	void name6() {
		OptionalInt max = authorList.stream()
			.flatMap(author -> author.getBooks().stream())
			.mapToInt(book -> book.getScore())
			.max();
		System.out.println(max.getAsInt());
	}

	//打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式:哲学，爱情
	@Test
	void name5() {
		authorList.stream()
			.flatMap(author -> author.getBooks().stream())
			.flatMap(book -> StrUtil.split(book.getCategory(), ',').stream())
			.distinct()
			.forEach(category -> System.out.println(category));

	}

	@Test
	void name4() {
		authorList.stream()
			.flatMap(author -> author.getBooks().stream())
			.distinct()
			.forEach(book -> System.out.println(book));

		IntSummaryStatistics max = authorList.stream()
			.flatMapToInt(author -> IntStream.of(author.getAge()))
			.summaryStatistics();
		System.out.println(max);
	}

	//	对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
	@Test
	void name3() {
		authorList.stream()
			.distinct()
			.sorted()
			.limit(2)
			.forEach(author -> System.out.println(author));
	}

	//所有年龄小于18的作家的名字，并且要注意去重
	@Test
	void name() {
		authorList.parallelStream()
			.filter(author -> author.age < 18)
			.distinct()
			.collect(Collectors.toList())
			.forEach(author -> System.out.println(author.getName()));
	}

	//打印所有姓名长度大于1的作家的姓名
	@Test
	void name1() {
		authorList.stream()
			.map(author -> {
				author.setAge(author.getAge() + 10);
				return author;
			})
			.forEach(author -> System.out.println(author));
	}

	@BeforeEach
	void setUp() {
		//数据初始化
		Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
		Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
		Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
		Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
		//书籍列表
		List<Book> books1 = new ArrayList<>();
		List<Book> books2 = new ArrayList<>();
		List<Book> books3 = new ArrayList<>();
		books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
		books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

		books2.add(new Book(3L, " 那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
		books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
		books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, " :一个哲学家的恋爱观注定很难把他所在的时代理解"));

		books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象- 个武者能对他的伴侣这么的宽容"));
		books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢? "));
		books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢? "));

		author.setBooks(books1);
		author2.setBooks(books2);
		author3.setBooks(books3);
		author4.setBooks(books3);

		authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
	}
}