package sfu_spring.materials;
import java.util.Objects;


import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;



/**
 * Класс Cloth представляет материал ткань.
 */
@Component
@PropertySources({
	@PropertySource("classpath:materials.properties"),
	@PropertySource("classpath:leather_technologies.properties")
})
public class Cloth implements Material {
    //Имя ткани.
    private String name;
    //Состав ткани.
    private String fiberContent;
    //Устойчивость ткани.
    private float durability;

    /**
     * Конструктор с параметрами.
     *
     * @param name           имя ткани
     * @param fiberContent   состав ткани
     * @param durability     устойчивость ткани
     */
    @Autowired
    public Cloth(@Value("${cloth.description}") String name, 
    		@Value("${cloth.fiberContent}") String fiberContent, 
    		@Value("${cloth.durability}") float durability) {
    	this.name = name;
        this.fiberContent = fiberContent;
        this.durability = durability;
	}
    
    public Cloth() {
    	this("", "", 0);
    }

    
    /**
     * Метод для вывода свойств материала.
     */
    @Override
    public void echoPropertiesMaterial() {
        System.out.println("Class: \n" + this.getClass().getName());
        System.out.println("Name: \n" + name);
        System.out.println("Fiber's content: \n" + fiberContent);
        System.out.println("Durability: \n" + durability); // Добавлено вывод устойчивости
    }

    /**
     * Метод для получения устойчивости.
     *
     * @return устойчивость
     */
    @Override
    public float getDurability() {
        return durability;
    }

    /**
     * Метод для установки устойчивости.
     *
     * @param durability устойчивость
     */
    public void setDurability(float durability) {
        this.durability = durability;
    }

    /**
     * Метод для получения состава ткани.
     *
     * @return состав ткани
     */
    public String getFiberContent() {
        return fiberContent;
    }

    /**
     * Метод для установки состава ткани.
     *
     * @param fiberContent состав ткани
     */
    public void setFiberContent(String fiberContent) {
        this.fiberContent = fiberContent;
    }

    /**
     * Метод для получения имени ткани.
     *
     * @return имя ткани
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для установки имени ткани.
     *
     * @param name имя ткани
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
        Cloth cloth = (Cloth) o;
        return Objects.equals(name, cloth.name) && Objects.equals(fiberContent, cloth.fiberContent);
    }

    /**
     * Метод для вычисления хэш-кода.
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, fiberContent);
    }

    /**
     * Метод для получения строкового представления объекта.
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + name + '\'' +
                ", fiberContent='" + fiberContent + '\'' +
                ", durability=" + durability +
                '}';
    }
}