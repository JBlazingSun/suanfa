package com.example.springmvc.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;

@Service
//@Transactional
public class TransactionJ {
	@Resource
	ScoreMapper scoreMapper;
	@Resource
	BeanSearcher searcher;

	public Long updateScore() {
		LongAccumulator longAccumulator = new LongAccumulator(null, 0);
		Map<String, Object> build = MapUtils.builder()
			.selectExclude(score::getCId)
			.field(score::getSId).sql("$1='11' or $1='22'")
			.build();
		List<score> scores = searcher.searchAll(score.class, build);
		scores.forEach(score -> {
			if (score.getSId().equals("11")) {
				score.setSScore(score.getSScore() - 10);
				UpdateWrapper updateWrapper = new UpdateWrapper();
				longAccumulator.accumulate(scoreMapper.updateById(score));
			}
			if (score.getSId().equals("22")) {
				score.setSScore(score.getSScore() + 10);
				longAccumulator.accumulate(scoreMapper.updateById(score));
			}
		});
		return longAccumulator.get();
	}
}
