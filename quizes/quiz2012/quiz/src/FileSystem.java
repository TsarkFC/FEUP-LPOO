public class FileSystem {
    private String type;
    private Folder root;
    private NameFormatter os;
    public FileSystem(String type) {
        this.type = type;
        root = new Folder(this);
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter os) {
        this.os = os;
    }

    public NameFormatter getOs() {
        return os;
    }
}
