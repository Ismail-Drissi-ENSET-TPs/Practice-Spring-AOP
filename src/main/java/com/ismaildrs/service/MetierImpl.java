package com.ismaildrs.service;

import com.ismaildrs.aspects.Log;
import com.ismaildrs.aspects.SecuredByAspect;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier{

    @Override
    public void process() {
        System.out.println("Business process...");
    }

    @Override
    @SecuredByAspect(roles={"SUPERADMIN"})
    public double compute() {
        double data = 78;
        System.out.println("Business compute...");
        return data;
    }
}
