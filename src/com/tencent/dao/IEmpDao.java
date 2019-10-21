package com.tencent.dao;

import com.tencent.pojo.Emp;

public interface IEmpDao {
	
	/**
	 * 查询
	 * @param empno
	 * @return
	 */
	public Emp selectEmpByEmpno(int empno);
	
	/**
	 * 新增
	 */
	public boolean insertEmp(Emp emp);
	
	/**
	 * 修改
	 */
	public boolean updateEmp(Emp emp);
	
	/**
	 * 删除
	 */
	public boolean deleteEmp(int empno);
	
}
