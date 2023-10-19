/**
 * App
 */
public class App {

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();
        System.out.println(ag);

        ag.setRoot(3);
        ag.print();

        ag.add(4, 3);
        ag.print();
        ag.add(5, 3);
        ag.print();

        ag.add(7, 4);
        ag.print();
        ag.add(2, 5);
        ag.print();
        ag.add(1, 5);
        ag.print();
        ag.add(9, 4);
        ag.print();
    }
}