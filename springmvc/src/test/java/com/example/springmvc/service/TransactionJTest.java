package com.example.springmvc.service;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.mapper.ScoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
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

	@AfterEach
	void tearDown() {
		score score11 = new score();
		score11.setSId("11");
		score11.setCId("11");
		score11.setSScore(100);
		score score22 = new score();
		score11.setSId("22");
		score11.setCId("22");
		score11.setSScore(100);
		System.out.println("scoreMapper.updateById(score11) = " + scoreMapper.updateById(score11));
		System.out.println("scoreMapper.updateById(score22) = " + scoreMapper.updateById(score22));

	}

	@Test
	void updateScore() {
		Map<String, Object> build = MapUtils.builder()
			.selectExclude(score::getCId)
			.field(score::getSId).sql("$1='11' or $1='22'")
			.build();
		List<score> scores = searcher.searchAll(score.class, build);
		log.info(scores.toString());

		log.info(String.valueOf(transactionJ.updateScore()));
	}
}