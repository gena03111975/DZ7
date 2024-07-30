package model.family.human;

import model.family.Builder;

import java.time.LocalDate;

public class HumanBuilder implements Builder<Human> {
    private int id;
    public HumanBuilder(){;
        id = 0;
    }

    public Human create(String name, LocalDate birthDate, Gender gender){
        return new Human(id++, name, birthDate, gender);
    }

    // Ýòîò êîíñòðóêòîð íå èñïîëüçóåòñÿ â ïðîåêòå
//    public  Human create(String name, LocalDate birthDate, Gender gender, Human mother, Human father){
//        return new Human(id++, name, birthDate, gender, mother, father);
//    }

}