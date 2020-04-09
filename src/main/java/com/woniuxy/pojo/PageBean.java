package com.woniuxy.pojo;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
	private Integer nowPage = 1;
	private Integer pageRow = 5;
	private Integer countRow;
	private Integer countPage;
	private List<T> list;
	private Set<T> set;
	private String queryVal;
	private String queryName;
}
