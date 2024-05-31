package sfu_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBriefcases {
    public static void main(String[] args) {
        // Создаем контекст приложения, который будет использоваться для получения экземпляров классов
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigSpring.class);
        // Получаем экземпляр класса Briefcase с именем "briefcaseClothBean" из контекста приложения
        Briefcase briefcaseCloth = context.getBean("leatherBriefcase", Briefcase.class);
        // Выводим свойства материала портфеля из ткани
        briefcaseCloth.getMaterial().echoPropertiesMaterial();
        // Выводим прочность портфеля из ткани
        System.out.println("Cloth briefcase durability is " + briefcaseCloth.durability());
 
        // Закрываем контекст приложения
        context.close();
    }
}
