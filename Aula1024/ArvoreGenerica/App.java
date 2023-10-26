import java.util.List;

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

        System.out.println("=-=-=-=-=-=-=");
        List<Integer> resultado = ag.positionPos();
        for(Integer val: resultado)
            System.out.print(val+", ");
        System.out.println();

        System.out.println("=-=-=-=-=-=-=");
        resultado = ag.positionPre();
        for(Integer val: resultado)
            System.out.print(val+", ");
        System.out.println();

        System.out.println("=-=-=-=-=-=-=");
        resultado = ag.positionWidth();
        for(Integer val: resultado)
            System.out.print(val+", ");
        System.out.println();

        System.out.println("=-=-=-=-=-=-=");
        System.out.println(ag);

        ag.add(10,1);
        ag.add(11,10);
        ag.add(12,11);
        ag.add(13,11);
        ag.add(14,11);
        ag.add(15,11);
        ag.add(16,11);
        System.out.println("=-=-=-=-=-=-=");
        System.out.println("NElements="+ag.size());
        System.out.println(ag);

        System.out.println("=-=-=-=-=-=-=");
        ag.removeBranch(15);
        System.out.println("NElements="+ag.size());
        System.out.println(ag);
        System.out.println("=-=-=-=-=-=-=");
        ag.removeBranch(1);
        System.out.println("NElements="+ag.size());
        System.out.println(ag);

    }
}