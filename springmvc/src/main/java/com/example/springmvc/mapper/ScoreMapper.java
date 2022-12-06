package com.example.springmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springmvc.entity.beansearcher.entity.score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreMapper extends BaseMapper<score> {
}
