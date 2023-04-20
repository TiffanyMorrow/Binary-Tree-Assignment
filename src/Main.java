//Tiffany Morrow
//Sri Vaishnavi Singari
//Consultation by Dan Chovanes
//CPSC 374 Whitfield
//Binary Tree Assignment - Dailey's Numbers
import java.util.*;
public class Main {
    public static void main(String[] args){
        int depth = 0, traversal = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please set the depth as an integer between 2 - 26: ");
        depth = sc.nextInt();

        if (depth < 2){
            depth = 2;
            System.out.println("Invalid depth entered, value set to 2.");
        }
        if (depth > 26){
            depth = 26;
            System.out.println("Invalid depth entered, value set to 26.");
        }

        DaileyTree tree = new DaileyTree(depth);

        while (true) {
            System.out.println("\n\nChoose the number of the type of Traversal: \nPre-order: 1 \nIn-Order: 2 \nPost-Order: 3 \nExit: 0");
            System.out.print("Please make a selection -> ");
            traversal = sc.nextInt();

            if (traversal == 1){
                tree.preOrderTraversal(tree.root);
                continue;
            }
            if (traversal == 2){
                tree.inOrderTraversal(tree.root);
                continue;
            }
            if (traversal == 3){
                tree.postOrderTraversal(tree.root);
                continue;
            }
            if (traversal == 0){
                System.out.println();
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        sc.close();

        tree.findOccurrences();
    }
}
