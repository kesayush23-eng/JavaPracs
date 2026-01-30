public class Search {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

       
        System.out.println("Inorder traversal:");
        bst.inorder();

        
        System.out.println("\nSearch 40: " + bst.search(40));
        System.out.println("Search 25: " + bst.search(25));
    }
}
