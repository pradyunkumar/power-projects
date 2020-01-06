package pradyunjava;


public class ListItemList implements NodeList {
    private ListItem root = null;

    public ListItemList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null){
            //List was empty, so item becomes head of list
            this.root = item;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){
                //new Item is greater than current
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    //there is no next, so insert at end of list
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            } else if(comparison > 0){
                //new Item is less, insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                } else {
                    //the node with a previous is the root
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }
            } else {
                // equal
                System.out.println(item.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            this.root = null;
            return true;
        }
        return false;
    }

    @Override
    public void transverse(ListItem root) {
        if(root == null){
            System.out.println("List is empty.");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
