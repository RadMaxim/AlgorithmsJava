package org.example;

import org.example.QuickSort.QuickSort;
import org.example.RadixSort.RadixSort;
import org.example.ShellSort.ShellSort;

import java.util.Random;

public class MainCreateArray {
    static Random random = new Random();
    static int []arr1 = new int[(int) Math.pow(10, 8)];
    static int []arr2 = new int[(int) Math.pow(10, 8)];
    static int []arr3 = new int[(int) Math.pow(10, 8)];
    static {
        for (int i = 0; i < Math.pow(10, 8); i++) {
            int value = random.nextInt(0, 100000);
            arr1[i] = value;
            arr2[i] = value;
            arr3[i] = value;
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("QuickSort");
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        QuickSort.quickSort(arr1, 0, arr1.length - 1);
        long memoryAfter = (runtime.totalMemory() - runtime.freeMemory())/(1024);

        // Разница в памяти
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Использованная память: " + memoryUsed + "КБайт");
        long t2 = System.currentTimeMillis();
        System.out.println("QuickSort время: " + (t2 - t1) + " миллисекунд");

        long t3 = System.currentTimeMillis();
        System.out.println("ShellSort");
        long memoryBeforeShellSort = (runtime.totalMemory() - runtime.freeMemory())/(1024);
        ShellSort.shellSort(arr2);
        long memoryAfterShellSort = (runtime.totalMemory() - runtime.freeMemory())/(1024);

        long memoryUsedShellSort = memoryAfterShellSort - memoryBeforeShellSort;
        System.out.println("Использованная память: " + memoryUsedShellSort + "КБайт");
        long t4 = System.currentTimeMillis();
        System.out.println("ShellSort время: " + (t4 - t3) + " миллисекунд");

        long memoryBeforeRadixSort = (runtime.totalMemory() - runtime.freeMemory())/(1024*1024);

        RadixSort.radixSort(arr3);
        long t5 = System.currentTimeMillis();
        System.out.println("radixSort время: " + (t5 - t4) + " миллисекунд");
        long memoryAfterRadixSort = (runtime.totalMemory() - runtime.freeMemory())/(1024*1024);

        long memoryUsedRadixSort = memoryAfterRadixSort - memoryBeforeRadixSort;
        System.out.println("Использованная память: " + memoryUsedRadixSort + "МБайт");
    }
}
