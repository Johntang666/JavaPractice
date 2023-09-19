package com.tang.test;

import com.tang.entity.Author;
import com.tang.entity.Book;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        test15();
    }
    public static void test15(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Integer integer = stream.parallel()
                .distinct()
                .peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer + Thread.currentThread().getName());
                    }
                })
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                .get();
        System.out.println(integer);

    }

    public static void test14(){
        Stream<Author> stream = getAuthors().stream();
        stream.distinct()
                .map(author -> author.getAge())
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer age) {
                        return String.valueOf(age);
                    }
                })
                .forEach(System.out::println);

    }

    public static void test13(){
        Stream<Author> stream = getAuthors().stream();
        stream.distinct()
                .filter(((Predicate<Author>) author -> author.getAge() > 18)
                        .and(author -> author.getName().length()>1))
                .forEach(author -> System.out.println(author.getName()));

    }

    public static void test12(){
        int[] arr={1,2,3,4,5,6};
        int sum=0;
        for(int i:arr){
            sum=sum+i;
        }
        System.out.println(sum);
        //求所有作者年龄之和
        List<Author> authors = getAuthors();
        Integer sumAge = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result + element;
                    }
                });
        System.out.println(sumAge);
        //reduce案例二：求年龄的最大值___>>>max,min内部封装了此方法
//        使用reduce求所有作者中年龄的最大值
        Integer max = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(max);
        //        使用reduce求所有作者中年龄的最小值
        Integer min = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(min);
        //一个参数的重载方式：
        //        使用reduce求所有作者中年龄的最小值
        Optional<Integer> minOptional = authors.stream()
                .map(author -> author.getAge())
                .reduce((result, element) -> result > element ? element : result);
        minOptional.ifPresent(age-> System.out.println(age));

    }


    public static void test11(){
        //判断是不是年龄都是小于100的
        Stream<Author> stream = getAuthors().stream();
        boolean b = stream.distinct()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
        //获取任意一个年龄大于18的，具有随机性，要结合filter来使用
        List<Author> authors = getAuthors();
        Optional<Author> optionalAuthor = authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 18;
                    }
                })
                .findAny();
        System.out.println(optionalAuthor);
        //要按照下面的方式输出；
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
        //findfirst获取第一个，要结合sorted来使用
        Optional<Author> first = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));

    }
    public static void test10(){
        //        判断是否有年龄在29以上的作家
        Stream<Author> stream = getAuthors().stream();
        boolean b = stream.distinct()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
        //        判断是否所有的作家都是成年人
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(flag);
    }
    public static void test09(){
//        //        获取一个存放所有作者名字的List集合。
//        List<Author> authors = getAuthors();
//        List<String> nameList = authors.stream()
//                .map(author -> author.getName())
//                .collect(Collectors.toList());
//        System.out.println(nameList);
//        //        获取一个所有书名的Set集合。
//        List<Author> authors = getAuthors();
//        Set<Book> books = authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .collect(Collectors.toSet());
//        System.out.println(books);
        //        获取一个Map集合，map的key为作者名，value为List<Book>
        List<Author> authors = getAuthors();
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }

    /**
     * minhe1max使用
     */
    public static void test08(){
        //        分别获取这些作家的所出书籍的最高分和最低分并打印。
        //Stream<Author>  -> Stream<Book> ->Stream<Integer>  ->求值
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        System.out.println(max.get());
        System.out.println(min.get());
    }
    /**
     * count的使用如何
     */
    public static void test07(){
        Stream<Author> stream = getAuthors().stream();
        long count = stream
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }
    /**
     * flatMap的使用
     */
    public static void test06(){
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category-> System.out.println(category));
    }
    /**
     * 打印所有书籍的名字。要求对重复的元素进行去重。
     */
    public static void test05(){
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(new Function<Author, Stream<Book>>() {
                    @Override
                    public Stream<Book> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .forEach(new Consumer<Book>() {
                    @Override
                    public void accept(Book book) {
                        System.out.println(book.getName());
                    }
                });
    }
    /**
     * 对于作家进行排序（升序），且去重
     */
    public static void test04(){
        Stream<Author> stream = getAuthors().stream();
        stream.distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        //升序就是前面减后面的，降序就是后面减前面的
                        return o1.getAge() - o2.getAge();
                    }
                })
                .forEach(author -> System.out.println(author.getName()));
    }

    /**
     * 打印所有作家的名字
     */
    private static void test03(){
        Stream<Author> stream = getAuthors().stream();
        stream.distinct()
                .map(author -> author.getName())
                .forEach(s -> System.out.println(s));
    }

    /**
     * filter的使用，只打印名字长度大于1的作家名字
     */
    private static void test02(){
        Stream<Author> stream = getAuthors().stream();
        stream.filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test01(){
        Stream<Author> authorStream = getAuthors().stream();
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(arr);
        stream.distinct()
                .filter(integer -> integer>2)
                .forEach(integer -> System.out.println(integer));
        Stream<Integer> stream2 = Stream.of(arr);
        System.out.println(stream);

        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()<18;
                    }
                })
                .forEach(new Consumer<Author>() {
                    @Override
                    public void accept(Author author) {
                        System.out.println(author.getName());
                    }
                });
        authors.stream()
                .distinct()
                .filter(author -> author.getAge()<18)
                .forEach(author -> System.out.println(author.getName()));
    }
    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }
}
