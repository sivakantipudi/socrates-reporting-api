package com.bec.socratesrpt.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('SUPER_ADMIN','DISTRICT_ADMIN','TECH_ADMIN','SCHOOL_ADMIN')")
public @interface IsAdmin {}
