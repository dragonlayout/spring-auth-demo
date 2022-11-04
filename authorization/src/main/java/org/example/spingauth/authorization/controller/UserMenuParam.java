package org.example.spingauth.authorization.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserMenuParam {

    private Long id;
    private Set<String> menus;
}
