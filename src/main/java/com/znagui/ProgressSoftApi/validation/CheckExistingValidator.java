package com.znagui.ProgressSoftApi.validation;

import com.znagui.ProgressSoftApi.exception.ResourceAlreadyExistsException;
import com.znagui.ProgressSoftApi.validation.api.CheckExistion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckExistingValidator  implements ConstraintValidator<CheckExistion, String> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entityC;

    public void initialize(CheckExistion constraintAnnotation) {
        this.entityC = constraintAnnotation.entityC();
    }
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null){
            log.warn("Validation failed: ID is null for ");
            return false;
        }
        Long count = (Long) entityManager.createQuery("SELECT COUNT(*) FROM " + entityC.getSimpleName() + " e WHERE e.id = :id ").setParameter("id",id).getSingleResult();

        if(count != 0){
            log.warn("Duplicate resource detected: {} with id {}", entityC.getSimpleName(), id);
            throw new ResourceAlreadyExistsException(entityC.getSimpleName(),id);
        }
        log.debug("Validation passed: no existing {} with id {}", entityC.getSimpleName(), id);
        return true;
    }

}
