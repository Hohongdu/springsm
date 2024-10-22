package edu.sm.cust.service;

import edu.sm.cust.repository.CustRepository;
import edu.sm.dto.Cust;
import edu.sm.frame.SMRepository;
import edu.sm.frame.SMService;

public class CustService implements SMService<String, Cust> {

    SMRepository<String, Cust> repository;

    @Override
    public void register(Cust cust) {
        repository.insert(cust);
    }

    @Override
    public void modify(Cust cust) {
        repository.update(cust);
    }

    @Override
    public void remove(String s) {
        repository.delete(s);
    }
}
