package org.example.springboot.common.validator;


import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CommonValid.Validator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonValid {



    String message() default "";
    ValidCode value() ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};



    @RequiredArgsConstructor
    class Validator implements ConstraintValidator<CommonValid, String> {



        private final ApplicationContext context;

        @Override
        public void initialize(CommonValid constraintAnnotation) {
            
            //reflection 주입을 위한 클래스
/*

            String beanName = commonCode.getAClass().getSimpleName();
            String remainString = beanName.substring(1);
            String firstStr = beanName.substring(0,1).toLowerCase();
            beanName = firstStr + remainString;
            System.out.println("빈이름:::" +  beanName);

            String method = context.getBean(beanName).getClass().getMethod(commonCode.getMethodName()).getName();

            res = (ArrayList<String>) context.getBean(beanName).getClass().getMethod(commonCode.getMethodName()).invoke(context.getBean(beanName));
*/



        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {



            return true;
        }
    }
}
