package com.example.springmvc.service;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.entity.transaction.User1;
import com.example.springmvc.entity.transaction.User2;
import com.example.springmvc.mapper.ScoreMapper;
import com.example.springmvc.mapper.User1Mapper;
import com.example.springmvc.mapper.User2Mapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class TransactionJTest {
	@MockBean
	private BeanSearcher beanSearcher;

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

	@Test
	void name0() {
		int a=1;
		int b=2;
		int c= (a+b>3?a++:b++);

		System.out.println("c = " + c);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	/**
	 * REQUIRES_NEW
	 * 结论：在外围方法开启事务的情况下Propagation.REQUIRES_NEW修饰的内部方法依然会单独开启独立事务，且与外部方法事务也独立，内部方法之间、内部方法和外部方法事务均相互独立，互不干扰。
	 */
	/**
	 * 2.2 场景二
	 * 外围方法开启事务。
	 * 验证方法1：
	 * “张三”未插入，“李四”插入，“王五”插入。
	 * 外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中，外围方法抛出异常只回滚和外围方法同一事务的方法，故插入“张三”的方法回滚。
	 */
	@Test
	@Transactional
	void transaction_exception_required_requiresNew_requiresNew() {

		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addUser2RequiresNew(user2);

		User2 user3 = new User2();
		user3.setName("王五");
		transactionJ.addUser2RequiresNew(user3);
		throw new RuntimeException();
	}

	/**
	 * 验证方法2：
	 * “张三”未插入，“李四”插入，“王五”未插入。
	 * 外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中。插入“王五”方法抛出异常，首先插入 “王五”方法的事务被回滚，异常继续抛出被外围方法感知，外围方法事务亦被回滚，故插入“张三”方法也被回滚。
	 */
	@Test
	@Transactional
	void transaction_required_requiresNew_requiresNew_exception() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addUser2RequiresNew(user2);

		User2 user3 = new User2();
		user3.setName("王五");
		transactionJ.addUser2RequiresNewException(user3);
	}

	/**
	 * 验证方法3
	 * “张三”插入，“李四”插入，“王五”未插入。
	 * 外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中。插入“王五”方法抛出异常，首先插入“王五”方法的事务被回滚，异常被catch不会被外围方法感知，外围方法事务不回滚，故插入“张三”方法插入成功。
	 */
	@Test
	void transaction_required_requiresNew_requiresNew_exception_try() {
		transactionJ.transaction_required_requiresNew_requiresNew_exception_try();
//		User1 user1=new User1();
//		user1.setName("张三");
//		transactionJ.addUser1REQUIRED(user1);
//
//		User2 user2=new User2();
//		user2.setName("李四");
//		transactionJ.addUser2RequiresNew(user2);

//		User2 user3=new User2();
//		user3.setName("王五");
//		try {
////			transactionJ.addUser2RequiresNewException(user3);
//		} catch (Exception e) {
//			System.out.println("回滚");
//		}
	}

	/**
	 * 2.1 场景一
	 * 外围方法没有开启事务。
	 * 结论：通过这两个方法我们证明了在外围方法未开启事务的情况下Propagation.REQUIRES_NEW修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰。
	 * <p>
	 * 验证方法1：
	 * “张三”插入，“李四”插入。
	 * 外围方法没有事务，插入“张三”、“李四”方法都在自己的事务中独立运行,外围方法抛出异常回滚不会影响内部方法。
	 */
	@Test
	@Transactional
	void notransaction_exception_requiresNew_requiresNew() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRES_NEW(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addUser2RequiresNew(user2);
		throw new RuntimeException();
	}

	/**
	 * 验证方法2：
	 * “张三”插入，“李四”未插入
	 * 外围方法没有开启事务，插入“张三”方法和插入“李四”方法分别开启自己的事务，插入“李四”方法抛出异常回滚，其他事务不受影响。
	 */
	@Test
	@Transactional
	void notransaction_requiresNew_requiresNew_exception() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRES_NEW(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addUser2RequiresNewException(user2);
	}
	/**
	 * REQUIRED
	 * 结论：以上试验结果我们证明在外围方法开启事务的情况下Propagation.REQUIRED修饰的内部方法会加入到外围方法的事务中，所有Propagation.REQUIRED修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务均回滚。
	 */
	/**
	 * 1.2 场景二
	 * 外围方法开启事务，这个是使用率比较高的场景。
	 */
	/**
	 * 验证方法3
	 * “张三”、“李四”均未插入。
	 * 外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，即使方法被catch不被外围方法感知，整个事务依然回滚。
	 */
	@Test
	@Transactional
	void transaction_required_required_exception_try() {
		User1 user1 = new User1();
		user1.setName("张三transaction_required_required_exception_try");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四transaction_required_required_exception_try");
		try {
			transactionJ.addRequiredException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}

	/**
	 * 验证方法2：
	 * “张三”、“李四”均未插入。
	 * 外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，外围方法感知异常致使整体事务回滚
	 */
	@Test
	@Transactional
	void transaction_required_required_exception() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addRequiredException(user2);
	}

	/**
	 * 验证方法1：
	 * “张三”、“李四”均未插入。
	 * 外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚。
	 */
	@Test
	@Transactional
	void transaction_exception_required_required() {
		User1 user1 = new User1();
		user1.setName("张三 transaction_exception_required_required");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四 transaction_exception_required_required");
		transactionJ.addUser2REQUIRED(user2);
		throw new RuntimeException();
	}
	/**
	 * 1.1 场景一
	 * 此场景外围方法没有开启事务。
	 */
	/**
	 * 验证方法2：
	 * “张三”插入，“李四”未插入。
	 * 外围方法没有事务，插入“张三”、“李四”方法都在自己的事务中独立运行,所以插入“李四”方法抛出异常只会回滚插入“李四”方法，插入“张三”方法不受影响。
	 */
	@Test
	@Transactional
	void notransaction_required_required_exception() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addRequiredException(user2);
	}

	/**
	 * 验证方法1：
	 * “张三”、“李四”均插入。
	 * 外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，外围方法异常不影响内部插入“张三”、“李四”方法独立的事务。
	 */
	@Test
	@Transactional
	void notransaction_exception_required_required() {
		User1 user1 = new User1();
		user1.setName("张三");
		transactionJ.addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		transactionJ.addUser2REQUIRED(user2);
		throw new RuntimeException();
	}

	//	@BeforeEach
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
//		user1Mapper.delete(null);
//		user2Mapper.delete(null);
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