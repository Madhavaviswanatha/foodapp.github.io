package com.food.Dao;

import java.util.List;

import com.food.model.Users;

public interface UserDao {
	int addUser(Users user);
	Users getUser(int userId);
	int updateUser(Users user);
	int deleteUser(int userId);
	List<Users>getAllUser();
	

}
