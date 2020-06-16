import java.util.Arrays;
import java.util.List;

public class Node{
    protected Folder parent;
    protected String name;
    public static int num = 0;
    protected int number;
    protected int size;
    protected FileSystem ostype;

    public Node(){
        Node.num++;
        number = Node.num;
    }

    public Node(Folder root, String name) throws DuplicateNameException {
        parent = root;
        ostype = root.ostype;
        this.name = name;
        if (parent.verifyChild(this))
            throw new DuplicateNameException();
        parent.addChild(this);
        Node.num++;
        number = Node.num;
    }

    public static void resetNumbering(int num) {
        Node.num = num;
    }

    public Node getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o){
        if (!(o instanceof Node)) return false;
        Node n = (Node) o;
        return name == n.name;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public String getPath(){
        String output = "";
        Node p = parent;
        while(p != null){
            if (p.name == null) break;
            output = ostype.getOs().getSeparator() + p.name + output;
            p = p.getParent();
        }
        return output + ostype.getOs().getSeparator() + name;
    }

    public void move(Folder to, String name) throws CycleException{
        if (to.equals(parent))
            throw new CycleException();
        if (this instanceof Folder){
            Folder f = (Folder) this;
            for (Node node : f.getChildren())
                if (to.equals(node))
                    throw new CycleException();
        }
        parent.getChildren().remove(this);
        to.getChildren().add(this);
        parent = to;
        this.name = name;
    }
}
