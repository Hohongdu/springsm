package edu.sm.app;

import edu.sm.cust.service.CustService;
import edu.sm.dto.Cust;
import edu.sm.frame.SMService;

public class Main {
    public static void main(String[] args) {
        SMService<String, Cust> service = null;
        service = new CustService();
        service.remove("id01");
    }
}