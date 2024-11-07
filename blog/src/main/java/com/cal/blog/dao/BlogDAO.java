package com.cal.blog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

}
