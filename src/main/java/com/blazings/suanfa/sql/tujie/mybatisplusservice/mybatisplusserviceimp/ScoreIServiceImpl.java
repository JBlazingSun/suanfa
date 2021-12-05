package com.blazings.suanfa.sql.tujie.mybatisplusservice.mybatisplusserviceimp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.mapper.ScoreMapper;
import com.blazings.suanfa.sql.tujie.mybatisplusservice.ScoreIService;
import com.blazings.suanfa.sql.tujie.vo.Score;
import org.springframework.stereotype.Service;

@Service
public class ScoreIServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreIService {
    @Override
    public float GetCourseideq2TotalScore() {
        QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<>();
        return 0;
    }
}
