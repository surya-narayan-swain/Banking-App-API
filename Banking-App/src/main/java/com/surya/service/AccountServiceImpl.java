package com.surya.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	@Override
	public AccountDto deposit(long id, double amount) {
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not Exists.."));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not Exists.."));
if(account.getBalance()<amount)
{
	throw new RuntimeException("insufficient account");
	
}
double total=account.getBalance()-amount;
account.setBalance(total);
Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		
		List<Account> accounts =accountRepository.findAll();
		
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not Exists.."));
accountRepository.deleteById(id);
		
	}
}
