package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Distributor;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class DistributorRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Distributor entity;

    @NotNull
    private final SimpleStringProperty founder;

    public DistributorRow(@NotNull final Distributor entity) {
        super(entity);
        this.entity = entity;
        this.founder = new SimpleStringProperty(entity.getFounder());
    }

    public String getFounder() {
        return founder.get();
    }

    public void setFounder(final String founder) {
        this.entity.setFounder(founder);
        this.founder.set(founder);
    }

}
