public class Main {

    static class Node {
        int article;
        double price;
        Node left;
        Node right;

        Node(int article, double price) {
            this.article = article;
            this.price = price;
        }
    }

    static class BinarySearchTree {
        Node root;

        int comparisons;

        void insert(int article, double price) {

            Node newNode = new Node(article, price);

            if (root == null) {
                root = newNode;
                return;
            }

            Node current = root;

            while (true) {

                if (article < current.article) {

                    if (current.left == null) {
                        current.left = newNode;
                        return;
                    }

                    current = current.left;

                } else {

                    if (current.right == null) {
                        current.right = newNode;
                        return;
                    }

                    current = current.right;
                }
            }
        }

        Double findPrice(int article) {

            Node current = root;
            comparisons = 0;

            while (current != null) {

                comparisons++;

                if (article == current.article) {
                    return current.price;
                }

                if (article < current.article) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            return null;
        }

        int getDepth() {

            int depth = 0;
            Node current = root;

            while (current != null) {
                depth++;
                current = current.right;
            }

            return depth;
        }
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        int[] articles = {
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20
        };

        double[] prices = {
                100, 250, 180, 320, 150,
                90, 450, 210, 175, 500,
                130, 280, 350, 120, 600,
                220, 310, 400, 270, 550
        };

        for (int i = 0; i < articles.length; i++) {
            tree.insert(articles[i], prices[i]);
        }

        System.out.println("Количество позиций: " + articles.length);
        System.out.println("Глубина дерева: " + tree.getDepth());

        int searchArticle = 20;

        long start = System.nanoTime();

        Double price = tree.findPrice(searchArticle);

        long end = System.nanoTime();

        long searchTime = end - start;

        System.out.println("Искомый артикул: " + searchArticle);
        System.out.println("Цена: " + price);
        System.out.println("Количество сравнений: " + tree.comparisons);
        System.out.println("Время поиска: " + searchTime + " нс");

        System.out.println("Сложность поиска: O(n) так как дерево выродилось в список.");
    }
}