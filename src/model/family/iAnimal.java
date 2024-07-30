package model.family;

import model.family.animals.Achievement;

import java.util.List;

public interface iAnimal<T extends iAnimal> extends Alivable<T> {
    public boolean setAchievement();
    public List<Achievement> getAchievements();
}