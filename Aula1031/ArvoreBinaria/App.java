public class App {
    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        ab.addRoot(3);
        ab.addLeft(5,3);
        ab.addLeft(4, 5);
        ab.addRight(2, 5);
        ab.addRight(7, 3);
        ab.addRight(9,7);

        System.out.println(ab.positionsCentral());

        System.out.println(ab);
        System.out.println("Arvore é completa? "+ab.isComplete());

        ab.addLeft(1,7);
        System.out.println(ab);
        System.out.println("Arvore é completa? "+ab.isComplete());
    }
}
