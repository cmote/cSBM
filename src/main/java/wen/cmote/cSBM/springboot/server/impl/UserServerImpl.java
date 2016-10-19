package wen.cmote.cSBM.springboot.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import wen.cmote.cSBM.springboot.model.User;
import wen.cmote.cSBM.springboot.model.mapper.UserMapper;
import wen.cmote.cSBM.springboot.server.UserServer;

public class UserServerImpl implements UserServer {
	@Autowired
	private UserMapper mapper;

	public boolean add(User user) {
		return mapper.insert(user) > 0;
	}

	public List<User> findAll() {
		return mapper.selectByExample(null);
	}
}
