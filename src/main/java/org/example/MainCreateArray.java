package org.example;

import org.example.QuickSort.QuickSort;
import org.example.ShellSort.ShellSort;

import java.util.Random;

public class MainCreateArray {
    static Random random = new Random();
    static int []arr1 = new int[(int) Math.pow(10, 7)];
    static int []arr2 = new int[(int) Math.pow(10, 7)];

    static {
        for (int i = 0; i < Math.pow(10, 7); i++) {
            int value = random.nextInt(0, 100000);
            arr1[i] = value;
            arr2[i] = value;
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("QuickSort");
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        System.out.println("Память до выполнения метода: " + memoryBefore + " КБайт");
        QuickSort.quickSort(arr1, 0, arr1.length - 1);
        long memoryAfter = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        System.out.println("Память после выполнения метода: " + memoryAfter + "КБайт");

        // Разница в памяти
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Использованная память: " + memoryUsed + "КБайт");
        long t2 = System.currentTimeMillis();
        System.out.println("QuickSort время: " + (t2 - t1) + " миллисекунд");

        long t3 = System.currentTimeMillis();
        System.out.println("ShellSort");
        long memoryBeforeShellSort = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        System.out.println("Память до выполнения метода: " + memoryBeforeShellSort + " КБайт");
        ShellSort.shellSort(arr2);
        long memoryAfterShellSort = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        System.out.println("Память после выполнения метода: " + memoryAfterShellSort + "КБайт");
        long memoryUsedShellSort = memoryAfterShellSort - memoryBeforeShellSort;
        System.out.println("Использованная память: " + memoryUsedShellSort + "КБайт");
        long t4 = System.currentTimeMillis();
        System.out.println("ShellSort время: " + (t4 - t3) + " миллисекунд");
    }
}
