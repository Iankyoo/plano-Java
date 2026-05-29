package com.Iankyo.jpa;

import com.Iankyo.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManager em = HibernateUtil.getEntityManager();

        //CREATE
        em.getTransaction().begin();
        Customer customer = new Customer();
        customer.setName("Pedro");
        customer.setEmail("Pedro@gmail.com");
        em.persist(customer);
        em.getTransaction().commit();


        em.getTransaction().begin();
        Customer customer2 = new Customer();
        customer2.setName("Tiago");
        customer2.setEmail("Tiago@email.com");
        em.persist(customer2);
        em.getTransaction().commit();

        //READ
        Customer found = em.find(Customer.class,1L);

        //UPDATE
        em.getTransaction().begin();
        found.setName("Pedro Silva");
        em.getTransaction().commit();

        //DELETE
        em.getTransaction().begin();
        em.remove(found);
        em.getTransaction().commit();

        //READ ALL
        List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList();

        customers.stream()
                .forEach(System.out::println);

    }
}
