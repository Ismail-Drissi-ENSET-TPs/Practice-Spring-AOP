package com.ismaildrs;

import com.ismaildrs.service.IMetier;
import com.ismaildrs.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.ismaildrs"})
public class Main {
    public static void main(String[] args) {
        new SecurityContext().authenticate("root", "root", new String[]{"SUPERADMIN"});
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println(metier.compute());
    }
}