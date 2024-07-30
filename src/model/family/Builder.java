package model.family;

import model.family.human.Gender;

import java.time.LocalDate;

public interface Builder<T extends Alivable<T>> {
    public T create(String name, LocalDate birthDate, Gender gender);
}