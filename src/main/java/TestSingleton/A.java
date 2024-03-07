package TestSingleton;
public class A {
    private static A a;
    private int x ; 
    private A() {
        System.out.println("je suis le constructeur de A");
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    //methode de class 
    public static A getInstance() {
        if (a == null) {
            a = new A();
        }return a;
    }
    
    

}
