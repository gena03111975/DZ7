package presenter;

import model.family.Alivable;
import model.family.Service;
import model.family.human.Gender;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter<U extends Alivable<U>> {
    private View view;
    private Service<U> service;
    //    String answer;
    String errMessage;
    public Presenter(View view, Service<U> service) {
        // Можно менять вью и менять вид животного, указывая конкретный сервис.

        this.view = view;
        this.service = service;

//        answer = "";
        errMessage = "Что-то пошло не так";
    }


    public void addHuman(String name, LocalDate birthDate, Gender gender){
        String answer;
        if (service.addHumanToTree(name, birthDate, gender)){
            answer = "человек добавлен";
        } else answer = errMessage;
        view.answer(answer);
    }

    public void printTree(){
        String answer;
        answer = service.printTreeInfo();
        view.answer(answer);

    }

    public void getHuman(int id){
        String answer;
        if (isValid(id)) {
            answer = service.getById(id).toString();

        } else answer = errMessage;
        view.answer(answer);
    }

    public void setParent(int childId, int parentId){
        String answer;
        StringBuilder sb = new StringBuilder();
        if (childId >=0
                && childId < service.size()
                && parentId >= 0
                && parentId < service.size()
                && service.setParent(childId, parentId)){
            sb.append("Родитель для ");
            sb.append(service.getById(childId));
            sb.append(" добавлен!");
            answer = sb.toString();
        } else answer = errMessage;
        view.answer(answer);
    }

    public void getChildren(int id){
        String answer;
        if (isValid(id)){
            answer = service.getChildren(id).toString();
        } else answer = errMessage;
        view.answer(answer);
    }

    public void getSiblings(int id){
        String answer;
        if (isValid(id))
            answer = service.getSiblings(id).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void getAncestors(int id, int gen){
        String answer;
        if (isValid(id))
            answer = service.getAncestors(id, gen).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void getDescendants(int id, int gen){
        String answer;
        if (isValid(id))
            answer = service.getDescendants(id, gen).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void sortByName(){
        service.sortByName();
        printTree();
    }

    public void sortByAge(){
        service.sortByAge();
        printTree();
    }

    public void save(){
        String answer = "";
        try {
            service.save();
            answer = String.format("Файл сохранен в %s", service.getPath());
        } catch (IOException e){
            e.printStackTrace();
            answer = errMessage;
        } finally {
            view.answer(answer);
        }

    }

    public void load(){
        try {
            service.load();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
    }

    private boolean isValid(int id){
        return (id >= 0 && id < service.size());
    }

}