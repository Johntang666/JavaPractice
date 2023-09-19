import java.util.function.Function;

public class LambdaDemo1 {

    public static void main(String[] args) {
        String s = typeConver(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "唐";
            }
        });
        System.out.println(s);
        String s2 = typeConver((String str) -> {
            return str + "蒋";
        });
        System.out.println(s2);;
    }
    public static <R> R typeConver(Function<String,R> function){
        String str="123";
        R apply = function.apply(str);
        return apply;
    }
}
