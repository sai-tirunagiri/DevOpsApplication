package org.quinnox.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.quinnox.factory.MySqlConnectionFactory;
import org.quinnox.model.Employee;


public class DashBoardDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;
	private List<Employee> employeeList;
	
	public List<Employee> getFileList() throws ClassNotFoundException{
	try {
		connection = MySqlConnectionFactory.getConnection();
		sql = "select * from Employee";
        preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		employeeList = new ArrayList<Employee>();
		
		while(resultSet.next()){
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setAddress(resultSet.getString(3));
				employeeList.add(employee);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
	return employeeList;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		DashBoardDAO boardDAO = new DashBoardDAO();
		
		System.out.println(boardDAO.getFileList());
	}
}
