package com.opencode.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Person.class.equals(arg0);
	}


	public void validate(Object object, Errors errors) {
		Person person = (Person)object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "person.firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "person.lastName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "person.age.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departement", "person.departement.empty");
		
		if(person.getAge() < 18 || person.getAge() > 120){
			errors.rejectValue("age", "person.age.notValid");
		}
	}

}
