import java.util.ArrayList;
import java.util.List;

public class Conpoment implements Cloneable{
    private String name;
    private List<Integer> number;

    public Conpoment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public Conpoment(String name, List<Integer> number) {
        this.name = name;
        this.number = number;
    }

    /**
     * 实现了深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Conpoment conpoment = new Conpoment();
        conpoment=(Conpoment)  super.clone();
        conpoment.number=new ArrayList<>(number);
        return conpoment;
    }

    @Override
    public String toString() {
        return "Conpoment{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Conpoment conpoment = new Conpoment();
        conpoment.name="唐";
        conpoment.setNumber(new ArrayList<>());
        conpoment.number.add(1);
        conpoment.number.add(2);
        conpoment.number.add(3);
        conpoment.number.add(78);
        Object conpoment1 = new Object();
        conpoment1= (Conpoment) conpoment.clone();
        System.out.println(conpoment1.toString());

    }
}
