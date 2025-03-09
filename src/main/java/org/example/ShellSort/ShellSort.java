package org.example.ShellSort;

public class ShellSort {

    public static void shellSort(int[] array) {
        int n = array.length;

        // Начальный интервал h
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Выполняем сортировку вставками для текущего интервала
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 34, 54, 2, 3};
        System.out.println("Исходный массив:");
        printArray(array);

        shellSort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }

    // Вспомогательный метод для вывода массива
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
