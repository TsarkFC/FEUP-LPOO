public class File extends Node{;
    public File(Folder root, String name) throws DuplicateNameException {
        super(root, name);
    }

    public File(Folder root, String name, int size) throws DuplicateNameException {
        super(root, name);
        this.size = size;
        parent.incrementSize(size);
    }
}
