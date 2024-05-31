package sfu_spring;

import sfu_spring.materials.Material;
import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Briefcase {
    /**
     * Поле material (материал) представляет собой объект типа Material,
     * который определяет свойства конкретного материала.
     */
    private Material material;

    /**
     * Конструктор Briefcase принимает объект типа Material и устанавливает его в качестве значения поля material.
     * Проверяется, что переданный объект не равен null. Если объект равен null,
     * то выбрасывается исключение NullPointerException с сообщением "Material cannot be null".
     */
    public Briefcase(Material material) {
        this.material = material;
    }

    /**
     * Метод getMaterial() возвращает текущее значение поля material.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Метод setMaterial() устанавливает новое значение поля material.
     * Проверяется, что переданный объект не равен null. Если объект равен null,
     * то выбрасывается исключение NullPointerException с сообщением "Material cannot be null".
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Метод durability() возвращает значение прочности материала,
     * которое определяется методом getDurability() объекта material.
     */
    public float durability() {
        return this.material.getDurability();
    }

    /**
     * Метод equals() сравнивает текущий объект с переданным объектом o.
     * Если текущий объект равен переданному объекту, метод возвращает true.
     * В противном случае, если переданный объект равен null или имеет другой класс,
     * метод возвращает false. В противном случае, если значения полей material равны,
     * метод возвращает true. В противном случае, метод возвращает false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Briefcase briefcase = (Briefcase) o;
        return Objects.equals(material, briefcase.material);
    }

    /**
     * Метод hashCode() возвращает значение хэш-функции для текущего объекта.
     * Значение хэш-функции вычисляется на основе значения поля material.
     */
    @Override
    public int hashCode() {
        return Objects.hash(material);
    }

    /**
     * Метод toString() возвращает строковое представление текущего объекта.
     * Строковое представление содержит имя класса и значение поля material.
     */
    @Override
    public String toString() {
        return "Briefcase{" +
                "material=" + material +
                '}';
    }
}