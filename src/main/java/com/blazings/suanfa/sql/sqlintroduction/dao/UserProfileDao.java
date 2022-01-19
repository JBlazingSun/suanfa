package com.blazings.suanfa.sql.sqlintroduction.dao;

import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (UserProfile)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-15 16:57:51
 */
public interface UserProfileDao extends MPJBaseMapper<UserProfile> {

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserProfile> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<UserProfile> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserProfile> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<UserProfile> entities);

	@Select("${sqlStr}")
	List<UserProfile> dynamicSql(@Param("sqlStr")String sql);
}