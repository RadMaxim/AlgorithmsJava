package org.example.CombimationOfSumm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7, 1};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Комбинации с суммой " + target + ": " + result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return; // Если сумма больше, чем требуется
        else if (remain == 0) result.add(new ArrayList<>(tempList)); // Если сумма равна целевому значению
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i); // Не i + 1, потому что можно использовать одно и то же число повторно
                tempList.removeLast(); // Удаление последнего элемента
            }
        }
    }
}
