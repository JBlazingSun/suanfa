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
import org.checkerframework.checker.units.qual.Temperature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TransactionJ {
	@Resource
	ScoreMapper scoreMapper;
	@Resource
	BeanSearcher searcher;
	@Resource
	User1Mapper user1Mapper;
	@Resource
	User2Mapper user2Mapper;

	//https://segmentfault.com/a/1190000013341344
	//REQUIRES_NEW

	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try() {
		User1 user1 = new User1();
		user1.setName("张三");
		addUser1REQUIRED(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		addUser2RequiresNew(user2);

		User2 user3 = new User2();
		user3.setName("王五");
//		addUser2RequiresNewException(user3);
		try {
			addUser2RequiresNewException(user3);
		} catch (Exception e) {
			log.info("回滚");
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addUser2RequiresNew(User2 user) {
		user2Mapper.insert(user);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addUser2RequiresNewException(User2 user) {
		user2Mapper.insert(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addUser1REQUIRES_NEW(User1 user1) {
		user1Mapper.insert(user1);
	}

	//PROPAGATION_REQUIRED
	@Transactional
	public void addUser1REQUIRED(User1 user1) {
		user1Mapper.insert(user1);
	}

	@Transactional
	public void addUser2REQUIRED(User2 user2) {
		user2Mapper.insert(user2);
	}

	@Transactional
	public void addRequiredException(User2 user2) {
		user2Mapper.insert(user2);
		throw new RuntimeException();
	}

	//自测
	@Transactional
	public void updateScore() {
		Map<String, Object> build = MapUtils.builder()
			.field(score::getSId).sql("$1='11' or $1='22' or $1='33'")
			.build();
		List<score> scores = searcher.searchAll(score.class, build);
		scores.forEach(score -> {
			if (score.getSId().equals("11")) {
				score.setSScore(score.getSScore() - 20);
				scoreMapper.updateById(score);
			} else if (score.getSId().equals("22")) {
				score.setSScore(score.getSScore() + 10);
				scoreMapper.updateById(score);
			} else {
				score.setSScore(score.getSScore() + 10);
				scoreMapper.updateById(score);
				throw new RuntimeException();
			}
		});
	}
}
