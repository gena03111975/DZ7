package model.family.human;

import model.family.Builder;
import model.family.tree.FamilyTree;
import model.rw.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public class HumanService extends model.family.Service<Human> {

    public HumanService(Writer rw) {
        super(new FamilyTree<Human>(), new HumanBuilder(), rw);
    }

    public int size() {
        return super.size();
    }

    //
//    // HUMAN
    public boolean setParent(int childId, int parentId) {
        return super.setParent(childId, parentId);
    }

    //
    public Human getById(int id) {
        return super.getById(id);
    }

    //
//    // TREE
    public boolean addHumanToTree(String name, LocalDate birthDate, Gender gender) {
//        Human human = builder.create(name, birthDate, gender);
//        return tree.add(human);
        return super.addHumanToTree(name, birthDate, gender);
    }

    //
    public String printTreeInfo() {
//        StringBuilder sb = new StringBuilder();
//        for (Human human : tree){
//            sb.append(human).append(System.lineSeparator());
//        }
//        return sb.toString();
        return super.printTreeInfo();
    }

    //
    public void setRelationships() {
        super.setRelationships();
    }

    //
    public Set<Human> getSiblings(int id) {
        return super.getSiblings(id);
    }

    //
    public Set<Human> getDescendants(int id, int generation) {
        return super.getDescendants(id, generation);
    }

    //
    public Set<Human> getAncestors(int id, int generation) {
        return super.getAncestors(id, generation);
    }

    //
//    //Sorts
    public void sortById() {
        super.sortById();
    }

    //
    public Set<Human> getChildren(int id) {
        return super.getChildren(id);
    }

    //
    public void sortByName() {
        super.sortByName();
    }

    //
    public void sortByAge() {
        super.sortByAge();
    }

    //
//    // FILEHANDLER

    public void setWriter(Writer writer){
        super.setWriter(writer);
    }
    //
    public void save() {
        try {
            super.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public void load() throws IOException, ClassNotFoundException {
        try {
            super.load();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }

    public String getPath(){
        return super.getPath();
    }
}