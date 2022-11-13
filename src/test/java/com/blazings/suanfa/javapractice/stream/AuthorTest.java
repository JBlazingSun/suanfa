package com.blazings.suanfa.javapractice.stream;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class AuthorTest {

	List<Author> authorList;

	@Test
	void name16() {
		print(value -> value < 3, value2 -> value2 < 7);
		Table<String, String, List<Object>> tables = HashBasedTable.create();
		tables.put("财务部", "总监", Lists.newArrayList());
		tables.put("财务部", "职员", Lists.newArrayList());
		tables.put("法务部", "助理", Lists.newArrayList());
		System.out.println(tables);
	}

	void print(IntPredicate predicate, IntPredicate predicate2) {
		ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		integers.forEach(integer -> {
			if (predicate.or(predicate2).and(predicate2).test(integer)) {
				System.out.println("integer = " + integer);
			}
		});
	}

	@Test
	void name15() {
		Optional<List<Author>> authorList1 = Optional.ofNullable(authorList);
		authorList1.ifPresent(authors -> authors.stream().flatMap(author -> author.getBooks().stream()).forEach(book -> {
			Optional<Book> optionalBook = Optional.ofNullable(book);
			if (optionalBook.isPresent()) {
				System.out.println("optionalBook.get().getName() = " + optionalBook.get().getName());
			}
			;
		}));
	}

	@Test
	void name14() {
		authorList.stream()
			.map(author -> {
				author.setAge(author.getAge() + 100);
				return author.getAge();
			})
			.forEach(integer -> System.out.println("integer = " + integer));
	}

	@Test
	void name13() {
		int reduce = authorList.stream()
			.distinct()
			.mapToInt(value -> value.getAge())
			.reduce(0, (left, right) -> left + right);
		System.out.println("reduce = " + reduce);

	}

	@Test
	void name12() {
		List<Integer> integers = Arrays.asList(1, 2, 3);
		Optional<Integer> reduce = Optional.of(integers.stream()
			.reduce(100, (integer, integer2) -> integer + integer2));
		reduce.ifPresent(integer -> System.out.println(integer));
	}

	//获取任意一个大于18的作家,如果存在就输出他的名字
	@Test
	void name11() {
		Optional<Author> author1 = authorList.stream()
			.filter(author -> author.getAge() > 18)
			.findAny();
		author1.ifPresent(author -> System.out.println(author.name));
	}

	//判断是否所有的作家都是成年人
	@Test
	void name10() {
		Assertions.assertTrue(authorList.stream()
			.allMatch(author -> author.getAge() > 18));
	}

	//判断是否有年龄在29以上的作家
	@Test
	void name9() {
		Assertions.assertTrue(authorList.stream()
			.anyMatch(author -> author.getAge() > 29));
	}

	//获取一个map集合, map的key为作者名, value为List<Book>
	@Test
	void name8() {
		Map<String, List<Book>> collect = authorList.stream()
			.distinct()
			.collect(Collectors.toMap(Author::getName, Author::getBooks));
		System.out.println(collect);
	}

	//获取一个所有书名的Set集合。
	@Test
	void name7() {
		authorList.stream()
			.flatMap(author -> author.getBooks().stream())
			.map(book -> book.getName())
			.collect(Collectors.toSet())
			.forEach(s -> System.out.println(s));
	}

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

		books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
		books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
		books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, " :一个哲学家的恋爱观注定很难把他所在的时代理解"));

		books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象- 个武者能对他的伴侣这么的宽容"));
		books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢? "));
		books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢? "));
		books3.add(null);

		author.setBooks(books1);
		author2.setBooks(books2);
		author3.setBooks(books3);
		author4.setBooks(books3);

		authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
	}
}