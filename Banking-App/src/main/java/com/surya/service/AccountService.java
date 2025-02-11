package com.surya.service;

import java.util.List;

import com.surya.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountdto);
	AccountDto getAccountById(long id);
	AccountDto deposit(long id,double amount);
	AccountDto withdraw(long id,double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(long id);
}
