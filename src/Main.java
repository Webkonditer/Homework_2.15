import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringList stringList = new StringListImpl();
        stringList.add("0");
        stringList.add("90");
        stringList.add("2");
        stringList.add("3");
        stringList.add("54");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("88");
        stringList.add("9");
        stringList.add("10");
        stringList.add("11");
        stringList.add("12");
        System.out.println(stringList.contains("90"));
        System.out.println(stringList.contains("111"));

//        stringList.set(12, "22");
//        stringList.add("13");
//        stringList.remove("13");
//        System.out.println(stringList.indexOf("11"));
//        System.out.println(stringList.contains("3"));
//        stringList.add("3");
//        System.out.println(stringList.lastIndexOf("3"));
//        System.out.println(stringList.get(13));
//        System.out.println(Arrays.toString(stringList.toArray()));
//        stringList.clear();
//        System.out.println(stringList.isEmpty());
//        stringList.add("13");
//        System.out.println(stringList.isEmpty());

//        long start = System.currentTimeMillis();
//        stringList.sort();
//        System.out.println(System.currentTimeMillis() - start);


    }
}