package dao;

import utils.JDBCUtils;

public class TbEmployeeDao {
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	public String[][] select(){
		String sql = "SELECT * FROM `personal`.`tb_employee`";
		String[][] data = JDBCUtils.select(sql, 5);
		return data;
	}
	
	/**
	 * 查询所有员工信息-模糊查询
	 * @return
	 */
	public String[][] select(String empName){
		String sql = "SELECT * FROM `personal`.`tb_employee` where empName like ?";
		String[][] data = JDBCUtils.select(sql, 5,"%"+empName+"%");
		return data;
	}
	
	/**
	 * 根据empId删除员工信息
	 * @param empId
	 */
	public void delete(String empId){
		String sql = "DELETE FROM `personal`.`tb_employee` WHERE `empId` = ?";
		JDBCUtils.addAndUpdate(sql, empId);
	}

}
