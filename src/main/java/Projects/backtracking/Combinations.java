package Projects.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int [] nums = {2,3,4,5,6};
        List<List<Integer>> result = combinations(nums,7);
        System.out.println(result);
    }
    private static List<List<Integer>>  combinations(int [] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        bactrack(nums, target,0,result, new ArrayList<>());
        return result;
    }
    private static void bactrack(int [] nums, int target, int index, List<List<Integer>> result,List<Integer> list){
        if(index == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[index] <= target){
            list.add(nums[index]);
            bactrack(nums, target - nums[index], index, result, list);
            list.remove(list.size() - 1);
        }
        bactrack(nums, target , index + 1, result, list);
    }
}
