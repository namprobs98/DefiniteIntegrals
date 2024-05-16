/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.definiteintegrals;

import java.util.Scanner;

/**
 *
 * @author Nhat Anh
 */
public class DefiniteIntegrals {

    //Hàm tính diện tích
    public static String area(int[] a, int[] b, int L, int R) {
        //Kiểm tra b[] có chứa phần tử âm không
        boolean checkBNegative = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i] < 0) {
                checkBNegative = true;
                break;
            }
        }
        //Khi b[] có chứa phần tử âm thì điều kiện xác định là x khác 0 nên nếu L và R trái dấu hoặc L = 0 hoặc R = 0 thì không tồn tại tích phân
        if (checkBNegative) {
            if (L * R <= 0) {
                return null;
            }
        } else {
            double total = 0.0;
            int numSteps = 1000000; // điều chỉnh số bước tích phân
            double deltaX = (double) (R - L) / numSteps; //Tính delta x

            //lặp để tính từng giá trị x
            for (int i = 0; i < numSteps; i++) {
                double x = L + i * deltaX;
                double fx = 0.0;
                //lặp tính fx tại x ở trên
                for (int j = 0; j < a.length; j++) {
                    fx += a[j] * Math.pow(x, b[j]);
                }
                total += fx * deltaX;
            }
            return "" + total;

        }
        return null;
    }
    
    //Hàm tính thể tích
    public static String volume(int[] a, int[] b, int L, int R) {
        final double pi = 3.141592653589;
        //Kiểm tra b[] có chứa phần tử âm không
        boolean checkBNegative = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i] < 0) {
                checkBNegative = true;
                break;
            }
        }
        //Khi b[] có chứa phần tử âm thì điều kiện xác định là x khác 0 nên nếu L và R trái dấu hoặc L = 0 hoặc R = 0 thì không tồn tại tích phân
        if (checkBNegative) {
            if (L * R <= 0) {
                return null;
            }
        } else {
            double total = 0.0;
            int numSteps = 1000000; // điều chỉnh số bước tích phân
            double deltaX = (double) (R - L) / numSteps; //Tính delta x

            //lặp để tính từng giá trị x
            for (int i = 0; i < numSteps; i++) {
                double x = L + i * deltaX;
                double fx = 0.0;
                //lặp tính fx tại x ở trên
                for (int j = 0; j < a.length; j++) {
                    fx += a[j] * Math.pow(x, b[j]);
                }
                total += Math.pow(fx, 2) * deltaX;
            }
            return "" + total*pi;

        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //in ra màn hình yêu cầu nhập số a
        System.out.println("Nhập vào các hệ số a của hàm số:");
        //đọc dãy số từ input
        String inputA = sc.nextLine();
        // Tách các số từ input A bằng khoảng trắng và lưu vào mảng
        String[] StringA = inputA.split(" ");
        int[] numbersA = new int[StringA.length];
        // Chuyển đổi từng chuỗi số sang số nguyên và gán vào mảng
        for (int i = 0; i < StringA.length; i++) {
            numbersA[i] = Integer.parseInt(StringA[i]);
        }

        //in ra màn hình yêu cầu nhập số b
        System.out.println("Nhập vào các số mũ b tương ứng của hàm số:");
        //đọc dãy số từ input
        String inputB = sc.nextLine();
        // Tách các số từ input B bằng khoảng trắng và lưu vào mảng
        String[] StringB = inputB.split(" ");
        int[] numbersB = new int[numbersA.length];
        // Chuyển đổi từng chuỗi số sang số nguyên và gán vào mảng
        for (int i = 0; i < StringB.length; i++) {
            numbersB[i] = Integer.parseInt(StringB[i]);
        }

        //in ra màn hình yêu cầu nhập số L và R
        System.out.println("Nhập vào các cận L R:");
        //đọc input L và R
        int L = Integer.parseInt(sc.next());
        int R = sc.nextInt();

        //in ra màn hình đáp án
        String area = area(numbersA, numbersB, L, R);
        String volume = volume(numbersA, numbersB, L, R);
        System.out.println("area: "+ area);
        System.out.println("volume: "+ volume);
    }
}
