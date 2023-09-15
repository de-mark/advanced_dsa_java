package deque;

public class Test {
    public static void main(String[] args) {
        Deque d = new Deque(4);

        d.insertLeft(1);
        d.insertRight(2);
        d.insertLeft(3);
        d.insertRight(4);
        d.insertLeft(10);
        d.TEMPDISPLAY();
        d.deleteLeft();
        d.TEMPDISPLAY();
        d.deleteRight();
        d.TEMPDISPLAY();
        d.deleteLeft();
        d.TEMPDISPLAY();
        d.deleteRight();
        d.TEMPDISPLAY();
        d.deleteLeft();
        d.insertLeft(200);
        d.insertRight(300);
        d.insertLeft(500);
        d.insertRight(600);
        d.TEMPDISPLAY();
    }

}
