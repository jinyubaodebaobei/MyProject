package com.dao;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBUtil {
	private   static   SqlSessionFactory    sqlSessionFactory;
	private   static   String resource="mybatis.config.xml";
	static
	{
		try {
			InputStream  inputStream=Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  SqlSession   getSqlSession()
	{
		return sqlSessionFactory.openSession();
		
	}

}
