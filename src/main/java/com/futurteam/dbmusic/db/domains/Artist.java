package com.futurteam.dbmusic.db.domains;

import com.futurteam.dbmusic.db.domains.base.NamedEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public final class Artist extends NamedEntity {

    @Getter
    @Setter
    private String genre;

    @Getter
    @Setter
    private Date foundationDate;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private String label;

}
