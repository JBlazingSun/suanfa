package com.example.springmvc.service;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.entity.transaction.User1;
import com.example.springmvc.entity.transaction.User2;
import com.example.springmvc.mapper.ScoreMapper;
import com.example.springmvc.mapper.User1Mapper;
import com.example.springmvc.mapper.User2Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class TransactionJTest {
	@Resource
	ScoreMapper scoreMapper;
	@Resource
	BeanSearcher searcher;
	@Resource
	TransactionJ transactionJ;
	@Resource
	User1Mapper user1Mapper;
	@Resource
	User2Mapper user2Mapper;

	/**
	 * 1.2 场景二
	 * 外围方法开启事务，这个是使用率比较高的场景。
	 */
	/**
	 * 验证方法1：
	 */
	@Test
	void transaction_exception_required_required() {
		User1 user1=new User1();
		user1.setName("张三");
		transactionJ.addUser1(user1);

		User2 user2=new User2();
		user2.setName("李四");
		transactionJ.addUser2(user2);
		throw new RuntimeException();
	}
	/**
	 * 1.1 场景一
	 * 此场景外围方法没有开启事务。
	 * REQUIRED
	 */
	/**
	 * 验证方法2：
	 * “张三”插入，“李四”未插入。
	 * 外围方法没有事务，插入“张三”、“李四”方法都在自己的事务中独立运行,所以插入“李四”方法抛出异常只会回滚插入“李四”方法，插入“张三”方法不受影响。
	 */
	@Test
	void notransaction_required_required_exception() {
		User1 user1=new User1();
		user1.setName("张三");
		transactionJ.addUser1(user1);

		User2 user2=new User2();
		user2.setName("李四");
		transactionJ.addRequiredException(user2);
	}
	/**
	 * 验证方法1：
	 * “张三”、“李四”均插入。
	 * 外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，外围方法异常不影响内部插入“张三”、“李四”方法独立的事务。
	 */
	@Test
	void notransaction_exception_required_required() {
		User1 user1=new User1();
		user1.setName("张三");
		transactionJ.addUser1(user1);

		User2 user2=new User2();
		user2.setName("李四");
		transactionJ.addUser2(user2);
		throw new RuntimeException();
	}

	@BeforeEach
	void setUp() {
		score score11 = new score();
		score11.setSId("11");
		score11.setCId("11");
		score11.setSScore(100);
		score score22 = new score();
		score22.setSId("22");
		score22.setCId("22");
		score22.setSScore(100);
		score score33 = new score();
		score33.setSId("33");
		score33.setCId("33");
		score33.setSScore(100);
		System.out.println("scoreMapper.updateById(score11) = " + scoreMapper.updateById(score11));
		System.out.println("scoreMapper.updateById(score22) = " + scoreMapper.updateById(score22));
		System.out.println("scoreMapper.updateById(score33) = " + scoreMapper.updateById(score33));

		user1Mapper.delete(null);
		user2Mapper.delete(null);

	}

	@Test
	void name() {
		Map<String, Object> build = MapUtils.builder()
			.selectExclude(score::getCId)
			.field(score::getSId).sql("$1='11' or $1='22' or $1='33'")
			.build();
		List<score> scores = searcher.searchAll(score.class, build);
		log.info(scores.toString());

		transactionJ.updateScore();

		List<score> scores1 = searcher.searchAll(score.class, build);
		log.info(scores1.toString());
	}
}