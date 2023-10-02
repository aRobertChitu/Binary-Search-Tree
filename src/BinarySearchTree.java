import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearchTree {

    private static final Logger logger = Logger.getLogger( Main.class.getName() );


    private final Node root;

    public boolean contains(Integer itemToSearch){
        return search(this.root, itemToSearch);
    }

    private boolean search(Node root, Integer itemToSearch){
        try {
            if (itemToSearch.equals(root.getValue())) {
                return true;
            } else if (itemToSearch < root.getValue()) {
                return search(root.getLeftNode(), itemToSearch);
            } else {
                return search(root.getRightNode(), itemToSearch);
            }
        }catch(NullPointerException e){
            return false;
        }
    }

    public void insert(Node root, int itemToInsert){
        if(itemToInsert < root.getValue()){
            if(root.getLeftNode() == null){
                root.setLeftNode(new Node(itemToInsert));
                logger.log(Level.INFO, "Inserted value {0} as the left child of {1}", new Object[]{itemToInsert, root.getValue()});
            }
            else{
                insert(root.getLeftNode(), itemToInsert);
            }

        }
        else {
            if(root.getRightNode() == null){
                root.setRightNode(new Node(itemToInsert));
                logger.log(Level.INFO, "Inserted value {0} as the right child of {1}", new Object[]{itemToInsert, root.getValue()});
            }
            else{
                insert(root.getRightNode(), itemToInsert);
            }
        }
    }

    public BinarySearchTree(List<Integer> items) {
        root = new Node(items.get(0));
        items.remove(0);
        items.forEach(integer ->  insert(root, integer));
    }
}
