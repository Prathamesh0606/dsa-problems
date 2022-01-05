package general;

public class Example {
    private int g = 10;

    public int getG() {
        return  g;
    }



}

class E extends Example {
    private int e = 11;

    @Override
    public int getG() {
//        return super.getG();
        return e;
    }
    public static void main(String[] args) {
       Example e = new Example();
       E eg = new E();

       System.out.println(e.getG());
    }
}
