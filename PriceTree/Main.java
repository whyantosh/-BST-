public class Main {

    public static void main(String[] args) {

        PriceTree tree = new PriceTree();
        
        tree.insert("A100", 500);
        tree.insert("A100", 450);
        tree.insert("A100", 520);

        tree.insert("A200", 300);
        tree.insert("A200", 250);
        tree.insert("A200", 280);

        tree.insert("A300", 700);
        tree.insert("A300", 650);

        tree.insert("A400", 150);
        tree.insert("A400", 120);

        tree.insert("A500", 900);
        tree.insert("A500", 850);

        tree.insert("A600", 430);
        tree.insert("A600", 410);

        tree.insert("A700", 1000);
        tree.insert("A700", 950);

        tree.insert("A800", 340);
        tree.insert("A800", 320);

        tree.insert("A900", 600);
        tree.insert("A900", 550);

        tree.inOrderTraversal();

        System.out.println();

        String searchArticle = "A100";

        long start = System.nanoTime();

        Float minPrice = tree.findMinPrice(searchArticle);

        long end = System.nanoTime();

        System.out.println("Артикул: " + searchArticle);

        if (minPrice != null) {
            System.out.println("Минимальная цена: " + minPrice + " руб.");
        } else {
            System.out.println("Артикул не найден.");
        }

        System.out.println("Время поиска: " + (end - start) + " нс");

        System.out.println();
        System.out.println("Сложность поиска: O(n)");
    }
}
