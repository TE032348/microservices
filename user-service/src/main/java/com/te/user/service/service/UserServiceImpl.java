package com.te.user.service.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.te.user.service.entity.User;
import com.te.user.service.repository.UserRepository;
import com.te.user.service.value_object.DepartmentResposne;
import com.te.user.service.wrapper.UserDepartmentWrapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public UserDepartmentWrapper getUserr(Long id) throws RestClientException {
		UserDepartmentWrapper wrapper = new UserDepartmentWrapper();
		User user = userRepository.findById(id).orElse(null);
		wrapper.setUser(user);

		
		String uri = "http://DEPARTMENT-SERVICE/departments/get-department/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>("Department", headers);
		ResponseEntity<DepartmentResposne> department = restTemplate.exchange(uri, HttpMethod.GET, entity, DepartmentResposne.class, user.getDepartmentId());
		wrapper.setDepartment(department.getBody().getData().get(0));
		return wrapper;
	}

	@Override
	public UserDepartmentWrapper getUser(Long userId) throws RestClientException, URISyntaxException {
		
		return null;
	}

}
