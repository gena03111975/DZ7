package model.rw;

import java.io.IOException;
import model.family.tree.FamilyTree;

public interface Writer {
    FamilyTree read() throws IOException, ClassNotFoundException;
    void write(FamilyTree tree) throws IOException ;

    String getPath();
}