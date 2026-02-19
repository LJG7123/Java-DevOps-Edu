package com.ws07.view;

import java.util.List;

import com.ws07.exception.BalanceLackException;
import com.ws07.exception.UserAccountNotFoundException;
import com.ws07.dto.AccountDto;
import com.ws07.service.BankService;
import com.ws07.service.BankServiceImpl;

public class TestView03 {
	public static void main(String[] args) {

		BankService bankService = new BankServiceImpl();
		/*System.out.println("1. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());*/
		
		
		////////WS_ 추가된 문제///////////////////////////////////////
		/// UserAccountNotFoundException이 발생하는 경우
		try {
			int withdrawAmount = bankService.withdraw(111, 10, 10);
			System.out.println(withdrawAmount);
			
			System.out.println(bankService.getUserAccount(111, 90));
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		}
		
		/// BalanceLackException이 발생하는 경우
		try {
			int withdrawAmount = bankService.withdraw(100, 1, 10000000);
			System.out.println(withdrawAmount);
			
			System.out.println(bankService.getUserAccount(100, 1));
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		}
		
		/// 새로운 기능이 정상적으로 동작하는 경우
		try {
			int withdrawAmount = bankService.withdraw(100, 1, 100000);
			System.out.println(withdrawAmount);
			
			System.out.println(bankService.getUserAccount(100, 1));
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		}
		
		
	}
	

	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(List<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

}
