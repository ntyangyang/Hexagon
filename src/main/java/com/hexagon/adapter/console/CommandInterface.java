package com.hexagon.adapter.console;

import java.util.Scanner;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:49
 * @description
 */
public interface CommandInterface {

    public void list(Scanner scanner);

    public void register(Scanner scanner);

    public void update(Scanner scanner);

    public void info();

}
