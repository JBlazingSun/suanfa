package com.blazings.suanfa.sql.sqlintroduction.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.sql.sqlintroduction.entity.QuestionPracticeDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (QuestionPracticeDetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-15 16:57:22
 */
public interface QuestionPracticeDetailDao extends BaseMapper<QuestionPracticeDetail> {

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<QuestionPracticeDetail> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<QuestionPracticeDetail> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<QuestionPracticeDetail> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<QuestionPracticeDetail> entities);

}

