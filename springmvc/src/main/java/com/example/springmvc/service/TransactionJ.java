package com.example.springmvc.service;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.mapper.ScoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class TransactionJ {
	@Resource
	ScoreMapper scoreMapper;
	@Resource
	BeanSearcher searcher;

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
				System.out.println(1 / 0);
			} else {
				score.setSScore(score.getSScore() + 10);
				scoreMapper.updateById(score);

			}
		});
	}
}
