package com.Iankyo.jdbc;

public class jdbcMain {
    public static void main(String[] args){
        CustomerRepository customerRepo = new CustomerRepository();
        AccountRepository accountRepo = new AccountRepository();

        customerRepo.saveAccount("Tony", "contato.tony@gmail.com");
        customerRepo.saveAccount("Judah", "Judahmori27@gmail.com");
        customerRepo.saveAccount("Isis", "isis.mieko@gmail.com");

        customerRepo.findAll();
        customerRepo.findById(1);
        customerRepo.deleteAccount(2);

        accountRepo.findCustomerById(1);

        accountRepo.transfer(1,2,400);
    }
}
