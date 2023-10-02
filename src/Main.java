import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {

        logger.info("Startup");

        List<Integer> itemList = new LinkedList<>();

        itemList.add(8);
        itemList.add(19);
        itemList.add(33);
        itemList.add(9);
        itemList.add(1);
        itemList.add(2);
        itemList.add(7);
        itemList.add(4);
        itemList.add(14);
        itemList.add(11);

        logger.log(Level.INFO, "List: {0}", itemList);

        BinarySearchTree tree = new BinarySearchTree(itemList);

        System.out.println(tree.contains(14));
        System.out.println(tree.contains(80));


    }
}