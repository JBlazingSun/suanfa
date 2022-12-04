package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;
import lombok.Data;

@Data
@SearchBean(tables = "student s")
public class Q46 extends student {
}
