package pradyunjava;

//interface defines how a list works
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void transverse(ListItem root);
}
