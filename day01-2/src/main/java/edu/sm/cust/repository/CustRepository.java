package edu.sm.cust.repository;

import edu.sm.dto.Cust;
import edu.sm.frame.SMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustRepository implements SMRepository<String, Cust> {
    @Autowired
    SMRepository<String, Cust> repository;

    @Override
    public void insert(Cust cust) {
        repository.insert(cust);
    }

    @Override
    public void update(Cust cust) {
        System.out.println("Update : "+ cust);
    }

    @Override
    public void delete(String s) {
        System.out.println("Delete : " +s);
    }
}
