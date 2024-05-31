package sfu_spring.materials;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;


@Component
@PropertySources({
	@PropertySource("classpath:materials.properties"),
	@PropertySource("classpath:leather_technologies.properties")
})
public class MatFactory {
	
	public Material getMat(String matType) {
		
        if ("leather".equalsIgnoreCase(matType)) {
            return new Leather();
        } else if ("cloth".equalsIgnoreCase(matType)) {
            return new Cloth();
        }
        return null;
    }

}
