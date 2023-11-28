package com.idrbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idrbt.dto.ResponseDto;
import com.idrbt.entity.Login;
import com.idrbt.service.LoginService;

import lombok.AllArgsConstructor;

@RefreshScope
@RestController
@RequestMapping("api/login")
@AllArgsConstructor
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/createLogin")
	public ResponseEntity<Login> saveLogin(@RequestBody Login login) {
		Login savedLogin = loginService.saveLoginDetails(login);
		return new ResponseEntity<>(savedLogin, HttpStatus.CREATED);

	}

	@GetMapping(value = "/account/{accountNum}")
	public ResponseEntity<ResponseDto> getLoginAccountDetails(@PathVariable("accountNum") Long accountNum) {
		ResponseDto responseDto = loginService.getLoginAccountDetails(accountNum);
		return ResponseEntity.ok(responseDto);
	}

}
