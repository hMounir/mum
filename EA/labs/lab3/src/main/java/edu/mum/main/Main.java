package edu.mum.main;


import java.util.Date;
import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
  public static void main(String[] args) {
      try {
          // open/read the application context file
          ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

          UserService userService = ctx.getBean(UserService.class);

          User user = new User(true,"test@test.com","Test",new Date(),"Last",10,1);
          userService.save(user);
          System.out.println("New User Added: " + user);

          System.out.println("=========================== User ==============================");
          User lookupUser = userService.findByEmail(user.getEmail());
          System.out.println("\nUser found: " + lookupUser);

          lookupUser.setFirstName("Updated Test");
          userService.update(user);
          System.out.println("\nUser Updated: " + lookupUser);

          System.out.println("Now trying to save new user with flush");
          User flushedUser = new User(true,"test2@test2.com","Test2",new Date(),"NewLast",10,2);
          userService.saveFlush(flushedUser);

          System.out.println("Now trying to return user using refresh");
          userService.refreshFind("test2@test2.com");

          System.out.println("Now trying to update the version unmanaged");
          lookupUser.setVersion(0);
          userService.update(user);

      }catch (Exception ex){
          if(ex.getCause() instanceof StaleObjectStateException){
              System.err.println("The user version couldn't be updated because " + ex.getMessage());
              return;
          }
          ex.printStackTrace();
      }
  }  
  
 }