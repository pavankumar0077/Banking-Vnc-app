package com.idrbt.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idrbt.entity.Account;
import com.idrbt.service.AccountService;

import lombok.AllArgsConstructor;


@RefreshScope
@RestController
@RequestMapping("api/accounts")
@AllArgsConstructor
public class AccountController {	
	
	@Autowired
	private AccountService accountService;
	
	
	@Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }
	
	@PostMapping(value = "/createAccount")
	public ResponseEntity<Account> saveAccount(@RequestBody Account account){
		Account savedAccount = accountService.saveAccount(account);
		return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") Long accountNum){
		Account account = accountService.getAccountByNum(accountNum);
		return ResponseEntity.ok(account);
	}
	
	
	@GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
	

}
