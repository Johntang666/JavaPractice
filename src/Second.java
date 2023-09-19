public class Second {
    public static void main(String[] args) {
        int[] array = {1, 34, 12, 32,11,8,3};
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++) {
            if (array[i] > max) {
                second = max;
                max = array[i];
            } else if (array[i] > second && array[i] < max) {
                second = array[i];
            }
        }
        System.out.println(second);
    }
}
