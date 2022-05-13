package org.example.springboot.common.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


//중복검사등을 위한 클래스
public abstract class AbstractValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {

        try {
            doValidate( (T) target , errors);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected abstract void doValidate(final T dto, final Errors errors);

}
