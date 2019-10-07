package com.yaolong.validator;

import com.yaolong.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yaoLong
 * @date 2019/10/6  13:38
 */
public class MyConstraintValidatedBy implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService service;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        service.getInfo("s");
        System.out.println(value);

        return false;
    }
}
