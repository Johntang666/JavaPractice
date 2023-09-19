import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void water(){
        int a,b,c;
        for(int i=100;i<1000;i++){
           a=i/100;
            b=i/10%10;
            c=i%10;
            if(Math.pow(a,3)*Math.pow(b,3)*Math.pow(c,3)==i){
                System.out.printf("i="+i);
            }
        }
    }

    /**
     * 注意是文本文件求和，看了几次
     * @param arr
     */
    public static void textmerge(String[] arr) throws FileNotFoundException {
        Pattern pattern=Pattern.compile("\\d");
//        for(int i=0;i<arr.length;i++ ){
//            Matcher matcher= pattern.matcher(arr[i]);
//        }
//        Matcher matcher= pattern.matcher(arr);
        String fileName="aaa.txt";
        double sum=0;
        BufferedReader reader=new BufferedReader(new FileReader(fileName));
        String line;
//        Matcher matcher= pattern.matcher(reader);
    }

    public static void printAllFile(File path){
        File[] files=path.listFiles();
        for(File f:files){
            if(f.isFile())
                System.out.println(f.getAbsoluteFile());
            else if (f.isDirectory())
                System.out.println(f.getAbsolutePath());
        }
    }
    public static void main(String[] args) {
        water();
        String path="D:\\";
        File filePath=new File(path);
        printAllFile(filePath);
    }
}
