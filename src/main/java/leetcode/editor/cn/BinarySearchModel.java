package leetcode.editor.cn;

import java.util.List;

/**
 * @Date 2020/10/22
 * @Author zhangdianyang
 * @Description
 */
public class BinarySearchModel {

    /**
     * 单调递增有界
     *
     * @param array
     * @return
     */
    public int getMidOne(List<Integer> array, int target) {
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int getMidTwo(List<Integer> array, int target) {
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
