/**
 * App
 */
public class App {

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();
        System.out.println(ag);

        ag.setRoot(1);
        System.out.println(ag);

        ag.add(2, null);
        System.out.println(ag);

        ag.add(3, 1);
        System.out.println(ag);

        ag.add(4, 3);
        System.out.println(ag);

        ag.add(5, 1);
        System.out.println(ag);
    }
}