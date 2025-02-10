package com.surya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.dto.AccountDto;
import com.surya.entity.Account;
import com.surya.mapper.AccountMapper;
import com.surya.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	@Override
	public AccountDto getAccountById(long id) {
		
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not Exists.."));
		
		return AccountMapper.mapToAccountDto(account);
	}
}
