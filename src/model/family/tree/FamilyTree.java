package model.family.tree;

import java.io.Serializable;
import java.util.*;

import model.family.Alivable;
import model.family.human.comparators.ByAgeComparator;
import model.family.human.comparators.ByNameComparator;
import model.family.AlivableIterator;


public class FamilyTree<U extends Alivable<U>> implements Serializable, Iterable<U> {
    private List<U> tree;

    public FamilyTree(List<U> list){
        tree = new ArrayList<>(list);
    }

    public FamilyTree() {
        tree = new ArrayList<>();
    }

    public int size(){
        return tree.size();
    }

    public boolean add(U alivable) {
        if (!tree.contains(alivable))
            return tree.add(alivable);
        return false;
    }

    private List<U> getTree() {
        return tree;
    }

    public boolean setParentRelationship(U alivable) {
        if (!alivable.getParents().isEmpty()) {
            for (U parent : alivable.getParents()) {
                if (!parent.getChildren().contains(alivable)) {
                    return parent.addChild(alivable);
                }
            }
        }
        return false;
    }

    //
    public void setAllRelationships(){
        for (U alivable : tree){
            setParentRelationship(alivable);
        }
    }

    public U getByName(String name){
        for (U alivable : tree){
            if (alivable.getName().equals(name)){
                return alivable;
            }
        }
        return null;
    }

    public U getById(int id){
        for (U alivable : tree){
            if (alivable.getId() == id){
                return alivable;
            }
        }
        return null;
    }

    public Set<U> getSiblings(U alivable) {
        Set<U> siblings = new HashSet<>();
        for (U parent : alivable.getParents()) {
            for (U el : parent.getChildren()) {
                if (!el.equals(alivable)) {
                    siblings.add(el);
                }
            }
        }
        return siblings;
    }

    public HashSet<U> getDescendants(U alivable, int generation) {
        HashSet<U> hs = new HashSet<>();
        if (generation == 0) {
            hs.addAll(this.getSiblings(alivable));
            hs.add(alivable);
        }
        for (U child : alivable.getChildren()) {
            hs.addAll(getDescendants(child, generation - 1));
        }
        return hs;
    }

    public HashSet<U> getAncestors(U alivable, int generation){
        HashSet<U> hs = new HashSet<>();
        if (generation == 0){
            if (alivable != null){
                hs.add(alivable);
            }
        }
        for (U parent : alivable.getParents()){
            if (parent != null){
                hs.addAll(getAncestors(parent, generation - 1));
            }
        }
        return hs;
    }

    public void sortById(){
        tree.sort(null);
    }

    public void sortByName(){
        tree.sort(new ByNameComparator());
    }

    public void sortByAge(){
        tree.sort(new ByAgeComparator());
    }
    @Override
    public Iterator<U> iterator() {
        return new AlivableIterator(tree);
    }
}