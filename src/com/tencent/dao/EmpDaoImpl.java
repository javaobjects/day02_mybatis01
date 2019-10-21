package com.tencent.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tencent.pojo.Emp;

public class EmpDaoImpl implements IEmpDao {
	
	private SqlSessionFactory factory;
	
	public EmpDaoImpl(SqlSessionFactory factory)
	{
		this.factory = factory;
	}
	
	@Override
	public Emp selectEmpByEmpno(int empno) {
		//1.获取SqlSessionFactory接口
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		
		//2.获取SqlSession接口
		SqlSession session = factory.openSession();
		
		//3.执行查询     参数一：SQL语句的id属性值    参数二：查询语句需要的参数parameterType
		Emp emp = (Emp)session.selectOne("selectEmpByEmpno", empno);
	
		//4.关闭连接
		session.close();
		
		return emp;
	}

	@Override
	public boolean insertEmp(Emp emp) {
		//1.获取SqlSessionFactory接口
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		
		//2.获取SqlSession接口
		SqlSession session = factory.openSession();
		
		//3.执行新增     参数一：SQL语句的id属性值    参数二：查询语句需要的参数parameterType
		int result = session.insert("insertEmp", emp);
	
		//3.1 提交事务----------------------------
		session.commit();
		
		//4.关闭连接
		session.close();
		
		//5.处理结果
		if(result > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateEmp(Emp emp) {
		//1.获取SqlSessionFactory接口
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		
		//2.获取SqlSession接口
		SqlSession session = factory.openSession();
		
		//3.执行修改     参数一：SQL语句的id属性值    参数二：查询语句需要的参数parameterType
		int result = session.update("updateEmp", emp);
	
		//3.1 提交事务----------------------------
		session.commit();
		
		//4.关闭连接
		session.close();
		
		//5.处理结果
		if(result > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteEmp(int empno) {
		//1.获取SqlSessionFactory接口
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		
		//2.获取SqlSession接口
		SqlSession session = factory.openSession();
		
		//3.执行删除     参数一：SQL语句的id属性值    参数二：查询语句需要的参数parameterType
		int result = session.delete("deleteEmp", empno);
	
		//3.1 提交事务----------------------------
		session.commit();
		
		//4.关闭连接
		session.close();
		
		//5.处理结果
		if(result > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
