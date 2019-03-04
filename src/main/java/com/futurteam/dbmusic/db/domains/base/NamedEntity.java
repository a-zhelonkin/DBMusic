package com.futurteam.dbmusic.db.domains.base;

import lombok.Getter;
import lombok.Setter;

public abstract class NamedEntity extends Entity {

    @Getter
    @Setter
    private String name;

}
