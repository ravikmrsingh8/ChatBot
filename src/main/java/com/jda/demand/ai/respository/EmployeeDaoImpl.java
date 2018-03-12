package com.jda.demand.ai.respository;


import com.jda.demand.ai.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements  EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Employee> findAll() {
        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return employees;
    }

    @Override
    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findByName(String firstName) {
        return entityManager.createQuery("FROM Employee e WHERE e.firstName = :firstName", Employee.class)
                .setParameter("firstName", firstName)
                .getResultList();
    }

    @Override
    public void save(Employee e) {
        entityManager.persist(e);
    }

    @Override
    public Employee remove(long id) {
        Employee e = entityManager.find(Employee.class, id);
        if(entityManager.contains(e)) entityManager.remove(e);
        return e;
    }

    @Override
    public Employee update( Employee e) {
        return entityManager.merge(e);
    }
}
