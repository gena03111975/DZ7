package model.rw;

import java.io.*;
import model.family.tree.FamilyTree;

public class FileHandler implements Writer {
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void write(FamilyTree tree) throws IOException {
        objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(this.path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public FamilyTree read() throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(
                new FileInputStream(this.path));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }

}