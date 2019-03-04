package com.futurteam.dbmusic.db.domains;

import com.futurteam.dbmusic.db.domains.base.NamedEntity;
import lombok.Getter;
import lombok.Setter;

public final class Distributor extends NamedEntity {

    @Getter
    @Setter
    private String founder;

}
