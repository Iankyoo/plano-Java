package com.Iankyo.jpa;

import com.Iankyo.entity.Account;
import com.Iankyo.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();
        Customer customer1 = new Customer();
        customer1.setName("Suzy");
        customer1.setEmail("Suzy@gmail.com");
        em.persist(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Anna");
        customer2.setEmail("Anna@gmail.com");
        em.persist(customer2);
        em.getTransaction().commit();

        em.getTransaction().begin();

        Account account1 = new Account();
        account1.setAccountType("savings");
        account1.setCustomer(customer1);
        customer1.getAccounts().add(account1);
        account1.setBalance(3000);
        em.persist(account1);

        Account account2 = new Account();
        account2.setAccountType("checking");
        account2.setCustomer(customer1);// Suzy possui duas contas agora
        customer1.getAccounts().add(account2);
        account2.setBalance(4800);
        em.persist(account2);

        em.getTransaction().commit();


        // N + 1 problem
        List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();

        for (Customer c : customers) {
            System.out.println(c.getName() + " tem " + c.getAccounts().size() + " contas");
        }

        // Resolvido com JOIN FETCH
        List<Customer> customersResolved = em.createQuery("SELECT DISTINCT c FROM Customer c LEFT JOIN FETCH c.accounts", Customer.class).getResultList();


        for (Customer c : customersResolved) {
            System.out.println(c.getName() + " tem " + c.getAccounts().size() + " contas");
        }
    }
}
