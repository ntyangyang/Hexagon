package com.hexagon.adapter.console;

import com.google.inject.Inject;
import com.hexagon.core.domain.User;
import com.hexagon.core.exception.UserNotFoundException;
import com.hexagon.core.service.UserService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:50
 * @description
 */
public class CommandInterfaceImpl implements CommandInterface {
    private UserService userService;

    @Inject
    public CommandInterfaceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void list(Scanner scanner) {
        System.out.println("All users registered so far");

        List<User> users = userService.getAllUsers();

        if (!CollectionUtils.isEmpty(users)) {
            users.forEach(u -> {
                CommandConsoleUtils.printUser(u);
                System.out.println("------------------------------------");
            });
        } else {
            System.out.println("Registed user is empty");
        }
    }

    @Override
    public void register(Scanner scanner) {
        System.out.println("What is the username ? ");
        String username = CommandConsoleUtils.readString(scanner);

        System.out.println("What is the age ? ");
        String age = CommandConsoleUtils.readString(scanner);

        User unregistered = new User();
        unregistered.setUsername(username);
        unregistered.setAge(age);
        User registered = userService.registerUser(unregistered);

        System.out.println("User registered successfully with the following : ");
        CommandConsoleUtils.printUser(registered);
    }

    @Override
    public void update(Scanner scanner) {
        System.out.println("What is the user Id you want to update? ");
        String userId = CommandConsoleUtils.readString(scanner);
        Optional<User> userOptional = userService.findUserById(Integer.valueOf(userId));

        if (userOptional.isPresent()) {
            System.out.println("The User you want to update is as following");
            CommandConsoleUtils.printUser(userOptional.get());
            System.out.println("Do you want to proceed ? Y(es)/N(o)");
            String confirm = CommandConsoleUtils.readString(scanner);

            if ("yes".equalsIgnoreCase(confirm) || "y".equalsIgnoreCase(confirm)) {
                try {
                    User oldUser = userOptional.get();
                    System.out.println("What is the username ? ");
                    String newUsername = CommandConsoleUtils.readString(scanner);
                    oldUser.setUsername(newUsername);

                    System.out.println("What is the age ? ");
                    String newAge = CommandConsoleUtils.readString(scanner);
                    oldUser.setAge(newAge);


                    User newUser = userService.updateUser(oldUser);
                    System.out.println("User update successful with the following : ");
                    CommandConsoleUtils.printUser(newUser);
                } catch (UserNotFoundException e) {
                    System.out.println("User update failed");
                }
            }
        } else {
            System.out.println("Can't find the user with supplied Id. Please try again ");
        }
    }

    @Override
    public void info() {
        CommandConsoleUtils.printMainmenu();
    }
}
