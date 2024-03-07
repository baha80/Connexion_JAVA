package TestSingleton;

public class Test {
    public static void main(String[] args) {
       
       
        B b = new B();
        System.out.println(b);

        A a = A.getInstance();
        System.out.println(a);


        a.setX(5);
        System.out.println(a.getX());
        
    }
    
}
