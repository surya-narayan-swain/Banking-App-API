package com.surya.service;

import com.surya.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountdto);
	AccountDto getAccountById(long id);
}
