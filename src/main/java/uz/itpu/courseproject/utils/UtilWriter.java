package uz.itpu.courseproject.utils;

import java.util.Scanner;

public class UtilWriter {

    public static String writerInt() {
//        System.out.println("wanna continue \n yes\n2 no");
        Scanner scanner = new Scanner(System.in);
        //return scanner.nextInt();
        return scanner.next();
    }

    public static Boolean writerIsCordless(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }

    public static String writerText(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
    public static String writerText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Double writerDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public static Double writerDouble(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static Boolean writerBoolean(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }
}
