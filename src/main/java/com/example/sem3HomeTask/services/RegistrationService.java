package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

   public User processRegistration(String name, int age, String email ){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        String message = "Пользователь " +  user.getName() +  " зарегистрирован";
        notificationService.sendNotification(message);
        return user;
   }

}
