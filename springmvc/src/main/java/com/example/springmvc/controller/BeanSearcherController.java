package com.example.springmvc.controller;

import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("user")
@Slf4j
@Tag(name = "user_beanSearcher")
public class BeanSearcherController {
	@Resource
	private MapSearcher mapSearcher;

	@GetMapping("index")
	public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
		// 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）, 默认分页15个
		return mapSearcher.search(User.class, MapUtils.flat(request.getParameterMap()));
	}
}
