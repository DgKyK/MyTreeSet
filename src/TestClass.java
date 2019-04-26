public class TestClass {
    public static void main(String[] args) {
        MyTreeSet<Integer> test = new MyTreeSet<>();
        test.add(5);
        test.add(10);
        test.add(4);
        test.add(1);
        test.add(8);
        test.add(7);
        test.add(9);
        System.out.println(test.size() + "\nAll elements : \n" + test.getAll());
        for(Integer k : test){
            System.out.print(k + "  ");
        }
    }
}
