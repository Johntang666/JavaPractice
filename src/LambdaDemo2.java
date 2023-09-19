import java.util.function.IntConsumer;

public class LambdaDemo2 {
    public static void main(String[] args) {
        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        foreachArr(value -> System.out.println(value));
        foreachArr((int value)->{
            System.out.println(value);
        });
    }

    public static void foreachArr(IntConsumer intConsumer){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        for(int i:arr){
//            System.out.println(i);
            intConsumer.accept(i);
        }
    }
}
