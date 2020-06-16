import java.util.ArrayList;
import java.util.List;

public class Folder extends Node{
    private Node[] child = new Node[2];
    private List<Node> children = new ArrayList<>();
    public Folder(FileSystem ostype){
        this.ostype = ostype;
    }
    public Folder(Folder root, String name) throws DuplicateNameException {
        super(root, name);
    }

    public void addChild(Node node){
        children.add(node);
        child = new Node[children.size()];
        for (int i = 0; i < children.size(); i++)
            child[i] = children.get(i);
    }

    public Node[] getChild() {
        child = new Node[children.size()];
        for (int i = 0; i < children.size(); i++)
            child[i] = children.get(i);
        return child;
    }

    public Node getChildByName(String name) {
        for (Node node : children)
            if (node.getName().equals(name)) return node;
        return null;
    }

    public boolean verifyChild(Node n){
        return getChildByName(n.getName()) != null;
    }

    public void incrementSize(int size){
        this.size += size;
    }

    public int getSize(){
        int total = 0;
        for (Node node : children)
            total += node.size;
        return total;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Folder clone(Folder root, String name) throws DuplicateNameException {
        Folder folder = new Folder(parent.ostype);
        folder.parent = root;
        folder.name = name;
        List<Node> c = new ArrayList<>();
        for (Node node : children){
            if (node instanceof Folder)
                c.add(((Folder) node).clone(folder, node.name));
            else
                c.add(new File(folder, node.name));
        }
        folder.setChildren(c);
        return folder;
    }

}
