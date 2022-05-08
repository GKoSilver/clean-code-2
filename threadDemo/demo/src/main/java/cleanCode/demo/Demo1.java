package cleanCode.demo;

public class Demo1 {
    public static void main(String[] args) {

        int[]a={100,101,102};

        OUTER:
        while (true) {
            for (int i = 0; i < a.length; ++i) {
                if(i==1){
                    break OUTER;
                }else{
                    System.out.println("A");
                }
            }
            System.out.println("B");
            
        }

        System.out.println("C");
    }

}
