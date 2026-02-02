package com.zhkgrocerystore.management;

import com.zhkgrocerystore.management.menu.MenuManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        new MenuManager().run();
    }
}
