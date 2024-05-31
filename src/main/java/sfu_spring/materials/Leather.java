package sfu_spring.materials;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import sfu_spring.Props;

/**
 * Класс Leather представляет материал кожа.
 */
@Component
@PropertySources({
	@PropertySource("classpath:materials.properties"),
	@PropertySource("classpath:leather_technologies.properties")
})
public class Leather implements Material {
    //Название кожанного материала.
    private String name;
    //Технологии создания данного типа кожи.
    private String[] technologiesCreateLeather;
    //Стабильность материала кожи.
    private float stability;
    //Прочность кожи.
    private float toughness;

    /**
     * Конструктор с параметрами.
     *
     * @param name                 имя кожи
     * @param technologiesCreateLeather технологии создания кожи
     * @param stability             устойчивость кожи
     * @param toughness             прочность кожи
     */
    @Autowired
    public Leather(@Value("${leather.description}") String name, 
    		@Value("#{'${leather.techs}'.split('\\@')}") String[] technologiesCreateLeather, 
    		@Value("${leather.stability}") float stability, 
    		@Value("${leather.toughness}") float toughness) {
        this.name = name;
        this.technologiesCreateLeather = technologiesCreateLeather;
        this.stability = stability;
        this.toughness = toughness;
    }
    
    public Leather() {
    	this("j", new String[] {""}, 0, 0);
	}

	/**
     * Метод для вывода свойств материала.
     */
    @Override
    public void echoPropertiesMaterial() {
        System.out.println("Class: \n" + this.getClass().getName());
        System.out.println("Name: \n" + name);
        System.out.println("Technologies: ");
        for (String s : technologiesCreateLeather) {
            System.out.println(s);
        }
    }

    /**
     * Метод для получения прочности.
     *
     * @return durability
     */
    @Override
    public float getDurability() {
        return stability * toughness;
    }

    /**
     * Метод для получения технологий создания кожи.
     *
     * @return technologiesCreateLeather технологии создания кожи
     */
    public String[] getTechnologiesCreateLeather() {
        return technologiesCreateLeather;
    }

    /**
     * Метод для установки технологий создания кожи.
     *
     * @param technologiesCreateLeather технологии создания кожи
     */
    public void setTechnologiesCreateLeather(String[] technologiesCreateLeather) {
        this.technologiesCreateLeather = technologiesCreateLeather;
    }

    /**
     * Метод для получения имени кожи.
     *
     * @return name название материала кожи
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для установки имени кожи.
     *
     * @param name название материала кожи
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для сравнения объектов.
     *
     * @param o объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leather leather = (Leather) o;
        return Objects.equals(name, leather.name) &&
                Objects.equals(technologiesCreateLeather, leather.technologiesCreateLeather);
    }

    /**
     * Метод для вычисления хэш-кода.
     *
     * @return int hash хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, technologiesCreateLeather);
    }

    /**
     * Метод для получения строкового представления объекта.
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "Leather{" +
                "name='" + name + '\'' +
                ",\ntechnologiesCreateLeather=\n" + technologiesCreateLeather +
                "\n}";
    }
   
}