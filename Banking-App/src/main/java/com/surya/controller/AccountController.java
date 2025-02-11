package com.surya.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.dto.AccountDto;
import com.surya.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	//Add Account Rest Api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	//GetAccount rest api
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id)
	{
		AccountDto accountDto=accountService.getAccountById(id);
		return new ResponseEntity<>(accountDto,HttpStatus.OK);
	}
	
	//Deposit Rest Api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDto accountDto=accountService.deposit(id,amount);
		return new ResponseEntity<>(accountDto,HttpStatus.OK);
	}
	
	//Withdraw RestApi
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id,@RequestBody Map<String, Double> request)
	{
		Double ammount=request.get("amount");
		AccountDto accountDto=accountService.withdraw(id, ammount);
		return new ResponseEntity<>(accountDto,HttpStatus.OK);
	}
	
	//Get All Accounts RestApi
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts()
	{
		List<AccountDto> accounts=accountService.getAllAccounts();
		return new ResponseEntity<>(accounts,HttpStatus.OK);

	}
	
	//Delete Account Rest Api
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id)
	{
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Account is deleted successfully !",HttpStatus.OK);
		
	}
	
}
