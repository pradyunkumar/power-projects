package pradyunjava;

//creation of a system that allows going forward and backward in the directory
public class Main {

    public static void main(String[] args) {
        ListItemList list = new ListItemList(null);
        list.transverse(list.getRoot());
        String stringData = " Darwin Brisbane Perth Melbourne Canberra" +
                 " Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }
        list.transverse(list.getRoot());
    }
}
