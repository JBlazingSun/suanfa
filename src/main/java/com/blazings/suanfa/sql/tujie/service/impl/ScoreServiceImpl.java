package com.blazings.suanfa.sql.tujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.dao.ScoreDao;
import com.blazings.suanfa.sql.tujie.entity.Score;
import com.blazings.suanfa.sql.tujie.service.ScoreService;
import org.springframework.stereotype.Service;

/**
 * (Score)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, Score> implements ScoreService {

}

