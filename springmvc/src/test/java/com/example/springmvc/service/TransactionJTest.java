package com.example.springmvc.service;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.mapper.ScoreMapper;
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