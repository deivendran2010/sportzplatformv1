package com.skiya.sportzplatform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.skiya.sportzplatform.beanmapper.UserBeanMapper;
import com.skiya.sportzplatform.common.ApplicationConstants;
import com.skiya.sportzplatform.common.EmailUtil;
import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.mapper.UserMapper;


@Service
public class UserService implements UserDetailsService {
	
	private final Logger log = LoggerFactory.getLogger(UserService.class);
	
	String ROLE_PREFIX = "ROLE_";
	
	@Autowired 
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private UserBeanMapper userBeanMapper;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.selectByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), 
				user.getUserPassword(), getAuthority(user.getUserId()));
	}
	
	private List<SimpleGrantedAuthority> getAuthority(long userId) {
		List<SimpleGrantedAuthority> rolesList = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ROLE_PREFIX + ApplicationConstants.ROLE_USER);
		rolesList.add(grantedAuthority);
		return rolesList;
	}
	
	public User getUserByToken(String resetToken) {
		return(userMapper.selectByResetToken(Objects.requireNonNull(resetToken, "Reset Token is mandatory")));
	}
	
	public List<User> getAll() {
		return userMapper.selectAll();
    }

	public User getUser(Integer id) {
		return userMapper.selectByPrimaryKey(Objects.requireNonNull(id, "User Id is mandatory"));
	}

	public User getUserByEmail(String userEmail) {
		return userMapper.selectByEmail(Objects.requireNonNull(userEmail, "User Email is mandatory"));
	}
	
	public void sendPasswordEmail(User user,String appURL) {
		
		user.setResetToken(UUID.randomUUID().toString());
		userMapper.updateByPrimaryKey(user);
		log.debug("User Updated successfully with token...");
		StringBuffer sb = new StringBuffer();
		sb.append("To reset your password, click the link below:\n");
		sb.append(appURL);
		sb.append("/reset-password?token=");
		sb.append(user.getResetToken());
		
		emailUtil.sendSimpleEmail(user.getUserEmail(), "Reset your Password", sb.toString());
	}
	
	public void sendActivationEmail(User user,String appURL) {
		
		user.setResetToken(UUID.randomUUID().toString());
		userMapper.updateByPrimaryKey(user);
		log.debug("User Created successfully with token...");
		StringBuffer sb = new StringBuffer();
		sb.append("To activate your account, click the link below:\n");
		sb.append(appURL);
		sb.append("/activate-account?token=");
		sb.append(user.getResetToken());
		
		emailUtil.sendSimpleEmail(user.getUserEmail(), "Activate your Account", sb.toString());
	}
	
	@Transactional
	public int addUser(User user) {
		String encryptPwd = bCryptPasswordEncoder.encode(user.getUserPassword());
		user.setUserPassword(encryptPwd);
		user.setUserStatus("IN");
		return userMapper.insert(user);
	}
	
	@Transactional
	public int updateToken(User userDTO) {
		Objects.requireNonNull(userDTO, "User object is empty");
		log.debug("UserDTO...." + userDTO.toString());
		User user = userMapper.selectByPrimaryKey(userDTO.getUserId());
		Objects.requireNonNull(user, "User is not found");
		if(!StringUtils.isEmpty(userDTO.getUserPassword())) {
			String encryptPwd = bCryptPasswordEncoder.encode(userDTO.getUserPassword());
			userDTO.setUserPassword(encryptPwd);
		}
		if(user.getResetToken() !=null)
			user.setResetToken(null);
		userBeanMapper.forEntityUpdate(userDTO, user);
		int userId = userMapper.updateByPrimaryKey(user);
		return userId;
	}
	
	@Transactional
	public int updateUser(User userDTO) {
		Objects.requireNonNull(userDTO, "User object is empty");
		log.debug("UserDTO...." + userDTO.toString());
		User user = userMapper.selectByPrimaryKey(userDTO.getUserId());
		Objects.requireNonNull(user, "User is not found");
		if(!StringUtils.isEmpty(userDTO.getUserPassword())) {
			String encryptPwd = bCryptPasswordEncoder.encode(userDTO.getUserPassword());
			userDTO.setUserPassword(encryptPwd);
		}
		userBeanMapper.forEntityUpdate(userDTO, user);
		int userId = userMapper.updateByPrimaryKey(user);
		return userId;
	}
	
	@Transactional
	public int deleteUser(Integer id) {
		Objects.requireNonNull(id, "User id is empty");
		User user = userMapper.selectByPrimaryKey(id);
		Objects.requireNonNull(user, "User not found");
		return userMapper.deleteByPrimaryKey(id);
	}
}
