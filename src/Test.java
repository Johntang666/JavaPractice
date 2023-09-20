import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private static final String PATTERN_NUMBER="\\d";
    public static void water() {
        int a, b, c;
        for (int i = 100; i < 1000; i++) {
            a = i / 100;
            b = i / 10 % 10;
            c = i % 10;
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i) {
                System.out.println(i);
            }
        }
    }

    // 从文本文件中提取数字并求和

    /**
     * 文本求和：
     * 2.文本文件求和第一行“2cdgz5”第二行“7edxcy”第三行“jrec69”从以上每行中取出数字并求和，不能用字符串截取方式做，取出的数字是2.5.7.6.9
     * @param filePath
     * @return
     */
    private static int getSumOfNumbers(String filePath) {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile(PATTERN_NUMBER);
            Matcher matcher;
            //取出的数字是
            ArrayList<Integer> integers = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    integers.add(number);
                    sum += number;
                }
            }
            integers.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public static void printAllFile(File path) {
        File[] files = path.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getAbsoluteFile());
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    // 遍历文件和子目录


    /**
     * 给定一个X盘路径，把X盘所有的文件路径输出来，包括所有子目录的。
     * @param path
     */
    private static void traverseFiles(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    traverseFiles(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        water();
        String path = "D:\\";
        //递归打印文件路劲
//        traverseFiles(path);

        //打印d盘文件夹
        /*File filePath = new File(path);
        printAllFile(filePath);*/

        //读取文件并求和
        String filePath = "D:/aaaa.txt"; // 替换为你的文件路径
        int sum = getSumOfNumbers(filePath);
        System.out.println("Sum of numbers: " + sum);
    }
}
