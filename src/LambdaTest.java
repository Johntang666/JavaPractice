import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class LambdaTest {
    public static void main(String[] args) {
        String[] arr=new String[] {"apple","orange","watermelon","banana"};
        Arrays.sort(arr,(s1,s2)->{
            return s1.compareTo(s2);
        });
        System.out.println(String.join("----",arr));

        new Thread(()->{
            System.out.println("线程测试");
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        int calculateNum = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        //lambda表达式
        int num = calculateNum((int left, int right) -> {
            return left - right;
        });
        System.out.println(calculateNum);
        System.out.println(num);

    }


    public static int calculateNum(IntBinaryOperator intBinaryOperator){
        int a=10;
        int b=2;
        return intBinaryOperator.applyAsInt(a,b);
    }
}
