public class PriceTree {

    private static class Node {
        String partNumber;
        float price;
        Node left;
        Node right;

        Node(String partNumber, float price) {
            this.partNumber = partNumber;
            this.price = price;
        }
    }

    private Node root;

    public void insert(String partNumber, float price) {
        root = insert(root, partNumber, price);
    }

    private Node insert(Node node, String partNumber, float price) {
        if (node == null) {
            return new Node(partNumber, price);
        }

        int comparison = partNumber.compareTo(node.partNumber);

        if (comparison <= 0) {
            node.left = insert(node.left, partNumber, price);
        } else {
            node.right = insert(node.right, partNumber, price);
        }

        return node;
    }

    public Float findMinPrice(String partNumber) {
        Node current = root;
        Float minPrice = null;

        while (current != null) {
            int comparison = partNumber.compareTo(current.partNumber);

            if (comparison < 0) {
                current = current.left;

            } else if (comparison > 0) {
                current = current.right;

            } else {
                if (minPrice == null || current.price < minPrice) {
                    minPrice = current.price;
                }

                current = current.left;
            }
        }

        return minPrice;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        System.out.println(
                node.partNumber + " — " + node.price + " руб."
        );

        inOrderTraversal(node.right);
    }
}
