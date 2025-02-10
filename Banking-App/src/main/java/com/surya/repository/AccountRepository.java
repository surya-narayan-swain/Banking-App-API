package com.surya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
