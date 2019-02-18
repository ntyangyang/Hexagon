package com.hexagon.adapter.console;

import com.hexagon.core.domain.User;

import java.util.Scanner;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:51
 * @description
 */
public class CommandConsoleUtils {

    public static String readString(Scanner scanner) {
        System.out.print( "> " );
        return scanner.next();
    }

    public static void printUser(User user) {
        System.out.println("User Id: " + user.getId());
        System.out.println("User Username: " + user.getUsername());
        System.out.println("User Age: " + user.getAge());
    }

    public static void printMainmenu() {
        System.out.println("LS : list all users");
        System.out.println("REG : register a user");
        System.out.println("UD : update a user");
        System.out.println("INFO : show main menu command");
        System.out.println("EXIT : exit application");
    }
}
