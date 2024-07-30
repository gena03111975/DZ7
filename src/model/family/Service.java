package model.family;

import model.family.human.Gender;
import model.family.human.Human;
import model.family.human.HumanBuilder;
import model.family.tree.FamilyTree;
import model.rw.FileHandler;
import model.rw.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public abstract class Service<T extends Alivable<T>> {
    protected FamilyTree<T> tree;
    protected Builder<T> builder;
    protected Writer rw;
    protected String path;

}
