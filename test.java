public class test {
    public static void main(String[] args) {
        SimpleList<Integer> simleList = new SimpleList<>();
        System.out.println(simleList.size());
        System.out.println(simleList.toString());

        for (int i = 0; i < 100000; i++) 
            simleList.add(i);

        System.out.println(simleList.size());
        System.out.println(simleList.toString());
    }
}
