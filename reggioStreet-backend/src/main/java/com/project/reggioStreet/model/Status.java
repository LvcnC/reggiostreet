package com.project.reggioStreet.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public enum Status{
    // actually those are final static properties, with Status as the type
    FINISHED,
    FINISHING,
    AVAILABLE
}
