package sfu_spring;

import org.springframework.context.annotation.*;
import sfu_spring.materials.MatFactory;
import sfu_spring.materials.Material;

@Configuration
@ComponentScan("sfu_spring")
public class ConfigSpring {

	@Bean
	public MatFactory mat() {
		return new MatFactory();
	}
	
	@Bean
	public Material leatherMat() {
		return mat().getMat("leather");
	}
		
	@Bean
	public Material clothMat() {
		return mat().getMat("cloth");
	}
	
	@Bean
	public Briefcase leatherBriefcase() {
		return new Briefcase(leatherMat());
	}
	
	@Bean
	public Briefcase clothBriefcase() {
		return new Briefcase(clothMat());
	}
	
}


