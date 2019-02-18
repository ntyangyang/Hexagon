package com.hexagon.adapter.console;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:47
 * @description
 */
public class CommandClient {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new CommandConsoleModule());
        CommandInterface commandConsole = injector.getInstance(CommandInterface.class);
        CommandClient.start(commandConsole);

    }

    public static void start(CommandInterface commandConsole) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            String cmd = CommandConsoleUtils.readString(scanner);
            if ("LS".equalsIgnoreCase(cmd)) {
                commandConsole.list(scanner);
            } else if ("REG".equalsIgnoreCase(cmd)) {
                commandConsole.register(scanner);
            } else if ("UD".equalsIgnoreCase(cmd)) {
                commandConsole.update(scanner);
            } else if ("INFO".equalsIgnoreCase(cmd)) {
                commandConsole.info();
            } else if ("EXIT".equalsIgnoreCase(cmd)) {
                exit = true;
            } else {
                commandConsole.info();
            }
        }

    }
}
