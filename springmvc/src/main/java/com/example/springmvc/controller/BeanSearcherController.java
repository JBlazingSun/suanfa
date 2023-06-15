package com.example.springmvc.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.ResultData;
import com.example.springmvc.entity.User;
import com.example.springmvc.entity.beansearcher.Q1;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
@Tag(name = "user_beanSearcher")
public class BeanSearcherController {
	@Resource
	private BeanSearcher searcher;

	@GetMapping("index")
	public SearchResult<User> index(HttpServletRequest request) {
		// 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）, 默认分页15个
		return searcher.search(User.class, MapUtils.flat(request.getParameterMap()));
	}

	@GetMapping("getQ1")
	public ResultData GetQ1() {
		List<Q1> q1s = searcher.searchList(Q1.class, null);
		return ResultData.success(q1s);
	}
}
