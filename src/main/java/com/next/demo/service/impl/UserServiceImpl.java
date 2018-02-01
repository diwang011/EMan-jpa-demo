package com.next.demo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.demo.bean.User;
import com.next.demo.repository.UserRepository;
import com.next.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(User user) {
		String loginId = user.getLoginId();
		String loginPassword = user.getLoginPassword();
		if (StringUtils.isEmpty(loginId) || StringUtils.isEmpty(loginPassword)) {
			return null;
		}
		User probe = new User();
		probe.setLoginId(loginId);
		probe.setLoginPassword(loginPassword);
		Example<User> example = Example.of(probe);
		User res = userRepository.findOne(example);
		return res;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
