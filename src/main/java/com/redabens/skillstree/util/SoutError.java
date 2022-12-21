package com.redabens.skillstree.util;

public class SoutError {
    public static void print(String color, String error)
    {
        switch (color) {
            case "red":
                System.out.println("\u001B[31m" + error + "\u001B[0m");
                break;
            case "green":
                System.out.println("\u001B[32m" + error + "\u001B[0m");
                break;
            case "yellow":
                System.out.println("\u001B[33m" + error + "\u001B[0m");
                break;
            case "orange":
                System.out.println("\u001B[34m" + error + "\u001B[0m");
                break;
            default:
                System.out.println(error);
                break;
        }
    }
}