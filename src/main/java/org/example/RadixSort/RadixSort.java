package org.example.RadixSort;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] array) {
        // Нахождение максимального числа для определения количества разрядов
        int max = Arrays.stream(array).max().getAsInt();

        // Выполнение сортировки для каждого разряда
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private static void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Заполнение массива count
        Arrays.fill(count, 0);

        // Подсчет количества вхождений чисел
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Изменение count[i] так, чтобы он содержал фактические позиции цифр в output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Сборка отсортированного массива
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Копирование отсортированных элементов обратно в оригинальный массив
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        radixSort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}
