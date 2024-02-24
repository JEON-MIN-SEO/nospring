package nospring.core.beanfind;

import nospring.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AplicationTest  {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findBean() {
        String[] beanName = ac.getBeanDefinitionNames();
       //iter + tap
        for (String s : beanName) {
            Object bean = ac.getBean(s);
        } 
    }
}
