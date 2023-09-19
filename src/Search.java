public class Search {
    /*
    * 第33题-搜索旋转排序数组
    *
    *
    * */
    public static int index(int[] nums, int target){
        int left =0;
        int right = nums.length - 1;
        while (left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {//说明是正好是目标值
                return mid;
            } else if(nums[mid] < nums[right]) {//说明旋转点不在右边，这边是有序的
                if(target>nums[mid] && target<=nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else {//说明旋转点在右边，这是我们根据左边来判断
                if(target>=nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array={4,5,6,7,0,1,2};
        int a=0;
        System.out.println(index(array,a));
        System.out.println(a);
    }
}
