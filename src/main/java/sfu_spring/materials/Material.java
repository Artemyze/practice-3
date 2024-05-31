package sfu_spring.materials;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Интерфейс Material (Материал) определяет контракт для всех классов, которые будут представлять различные материалы.
 * Этот интерфейс содержит два метода: echoPropertiesMaterial() и getDurability().
 */
public interface Material {
    /**
     * Метод echoPropertiesMaterial() должен выводить на консоль свойства конкретного материала.
     */
    void echoPropertiesMaterial();

    /**
     * Метод getDurability() должен возвращать прочность конкретного материала в виде числового значения с плавающей запятой.
     */
    float getDurability();
    
    @PostConstruct
    static void init() {
    	System.out.println("Material is initialized");
    }
    @PreDestroy
    static void destroy() {
    	System.out.println("Material is destroying..");
    }
    
}
