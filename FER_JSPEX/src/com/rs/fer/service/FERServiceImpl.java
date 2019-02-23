
package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	Logger logger = Logger.getLogger(FERServiceImpl.class);
	
	@Override
	public int login(String userName, String password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		try {
			connection = DBUtil.getConnection();
			String query = "select * from user where userName=? and password=?";
			prst = connection.prepareStatement(query);
			prst.setString(1, userName);
			prst.setString(2, password);
			ResultSet resultSet = prst.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt("userId");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return 0;
	}

	@Override
	public boolean registration(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		boolean registrationFlag=false;	
		
		logger.info("registration:: user: "+user);
		logger.debug("registration:: password: "+user.getPassword());
		try {
			connection = DBUtil.getConnection();
			String query = "insert into user(firstName,middleName,lastName,email,userName,password,mobile)values(?,?,?,?,?,?,?)";
			prst = connection.prepareStatement(query);

			prst.setString(1, user.getFirstName());
			prst.setString(2, user.getMiddleName());
			prst.setString(3, user.getLastName());
			prst.setString(4, user.getEmail());
			prst.setString(5, user.getUserName());
			prst.setString(6, user.getPassword());
			prst.setInt(7, user.getMobile());

			int numberOfRecordsInserted = prst.executeUpdate();
			System.out.println("Number of records inserted" + numberOfRecordsInserted);
			
			registrationFlag=numberOfRecordsInserted>0;
			

		} catch (Exception e) {
			logger.error("registration:: Exception: "+e);
			e.printStackTrace();
		} finally {
			
			DBUtil.closeConnection(connection);
		}

		logger.info("registration:: registrationFlag: "+registrationFlag);
		
		return registrationFlag;
	}

	@Override
	public boolean addExpense(Expense expense) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		boolean expenseFlag=false;
		try {
			connection = DBUtil.getConnection();
			String query = "insert into expense(expenseType,date,price,numberOfItems,total,byWhom,userId)values(?,?,?,?,?,?,?)";
			prst = connection.prepareStatement(query);
			prst.setString(1, expense.getExpenseType());
			prst.setString(2, expense.getDate());
			prst.setFloat(3,expense.getPrice());
			prst.setInt(4, expense.getNumberOfItems());
			prst.setFloat(5,expense.getTotal());
			prst.setString(6,expense.getByWhom());
			prst.setInt(7,expense.getUserId());
			
			int i = prst.executeUpdate();
			System.out.println("Number of records effected" + i);
			expenseFlag=i>0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenseFlag;
	}

	@Override
	
	public boolean deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		boolean deleteExpenseFlag = false;
		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("delete from expense where expenseId=?");
			prst.setInt(1, expenseId);
			int deletedId = prst.executeUpdate();
			System.out.println("Number of records deleted"+deletedId);
			
			deleteExpenseFlag = deletedId>0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return deleteExpenseFlag;
	}

	@Override
	public boolean editExpense(Expense expense) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		boolean editExpenseFlag = false;
		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("update expense set expenseType=?,byWhom=? where expenseId=?");
			prst.setString(1, expense.getExpenseType());
			prst.setString(2, expense.getByWhom());
			prst.setInt(3, expense.getExpenseId());
			int updatedItems = prst.executeUpdate();
			System.out.println("Number of  items updated are"+updatedItems);
			editExpenseFlag = updatedItems>0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return editExpenseFlag;
	}

	@Override
	public Expense getExpense(int expenseId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		Expense expenseObject = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("select * from expense where expenseId=?");
			prst.setInt(1, expenseId);
			resultSet = prst.executeQuery();
			//expenseObject = new Expense();
			while (resultSet.next()) {
				expenseObject = new Expense();
				expenseObject.setExpenseId(resultSet.getInt("expenseId"));
				expenseObject.setExpenseType(resultSet.getString("expenseType"));
				expenseObject.setPrice(resultSet.getInt("price"));
				expenseObject.setNumberOfItems(resultSet.getInt("numberOfItems"));
				expenseObject.setTotal(resultSet.getInt("total"));
				expenseObject.setByWhom(resultSet.getString("byWhom"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenseObject;
	}

	@Override
	public List<Expense> getExpenseReport(String expenseType, String fromDate, String toDate,int userId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		List<Expense> expenses = new ArrayList<Expense>();
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("select * from expense where expenseType=? and userId=? and date between ? and ?");
			prst.setString(1, expenseType);
			prst.setInt(2, userId);
			prst.setString(3, fromDate);
			prst.setString(4, toDate);
			
			resultSet = prst.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpenseId(resultSet.getInt("expenseId"));
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNumberOfItems(resultSet.getInt("numberOfItems"));
				expense.setTotal(resultSet.getInt("total"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setUserId(resultSet.getInt("userId"));

				expenses.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("select * from expense where userId=?");
			prst.setInt(1, userId);
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpenseId(resultSet.getInt("expenseId"));
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNumberOfItems(resultSet.getInt("numberOfItems"));
				expense.setTotal(resultSet.getInt("total"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setUserId(resultSet.getInt("userId"));
				
				expenses.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public boolean resetPassword(int userId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement prst = null;
		boolean resetPasswordFlag = false;

		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement("update user set password=? where userId=? and password=?");
			prst.setString(1, newPassword);
			prst.setInt(2, userId);
			prst.setString(3, oldPassword);

			int resetPasswordrecord = prst.executeUpdate();
			System.out.println("Number of records updated"+resetPasswordrecord);
			resetPasswordFlag =resetPasswordrecord>0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return resetPasswordFlag;
	}

	@Override
	public PersonalInfo getPersonalInfo(int userId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		PersonalInfo info = new PersonalInfo();
		try {
			connection = DBUtil.getConnection();
			prst = connection.prepareStatement(
					"SELECT u.*,a.* From user u LEFT JOIN address a ON u.userId=a.userId where u.userId");
			resultSet = prst.executeQuery();
			while (resultSet.next()) {

				User user = new User();
				user.setUserId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setMiddleName(resultSet.getString(3));
				user.setLastName(resultSet.getString(4));
				user.setEmail(resultSet.getString(5));
				user.setUserName(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setMobile(resultSet.getInt(8));

				Address address = new Address();

				//address.setAddressId(resultSet.getInt("addressId"));
				address.setAddressLine1(resultSet.getString("addressLine1"));
				address.setAddressLine2(resultSet.getString("addressLine2"));
				address.setStreet(resultSet.getString("street"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("state"));
				address.setZip(resultSet.getInt("Zip"));
				address.setUserId(resultSet.getInt("userId"));

				info.setAddress(address);
				info.setUser(user);
				if (userId == (user.getUserId())) {
					return info;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return null;
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		boolean isUpdated = false;

		try
		{
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			String query="Update user set firstName=?,middleName=?,lastName=?,email=?,mobile=? where userId=?";
			prst=connection.prepareStatement(query);
			
			prst.setString(1,user.getFirstName());
			prst.setString(2,user.getMiddleName());
			prst.setString(3,user.getLastName());
			prst.setString(4,user.getEmail());
			prst.setInt(5,user.getMobile());
			prst.setInt(6,user.getUserId());
			
			int updatePersonal=prst.executeUpdate();
			System.out.println(updatePersonal);
			
			if(updatePersonal>0) {
				int numberOfAddOrEditAddress=0;
				if(address.getUserId()!=0)
				{
					String query1="update address set addressLine1=?,addressLine2=?,street=?,city=?,state=?,zip=? where userId=?";
					prst=connection.prepareStatement(query1);
					prst.setString(1,address.getAddressLine1());
					prst.setString(2,address.getAddressLine2());
					prst.setString(3,address.getStreet());
					prst.setString(4,address.getCity());
					prst.setString(5,address.getState());
					prst.setInt(6,address.getZip());
					prst.setInt(7,address.getUserId());
				}
				else {
					String query2="insert into address(addressLine1,addressLine2,city,state,zip,country,userId)values(?,?,?,?,?,?,?)";
					prst.setString(1,address.getAddressLine1());
					prst.setString(2,address.getAddressLine2());
					prst.setString(3,address.getStreet());
					prst.setString(4,address.getCity());
					prst.setString(5,address.getState());
					prst.setInt(6,address.getZip());
					prst.setInt(7,address.getUserId());
				
				}
				numberOfAddOrEditAddress=prst.executeUpdate();
				System.out.println("Updated item = "+numberOfAddOrEditAddress);
				if(numberOfAddOrEditAddress>0)
				{
					isUpdated=true;
				}
				if(isUpdated) {
					connection.commit();
				}else {
					connection.rollback();
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return isUpdated;
	}

	
}
