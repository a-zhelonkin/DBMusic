package com.futurteam.dbmusic.entities.rows.base;

import com.futurteam.dbmusic.db.domains.base.NamedEntity;
import javafx.beans.property.SimpleStringProperty;
import org.jetbrains.annotations.NotNull;

public abstract class NamedEntityRow extends EntityRow {

    @NotNull
    private final SimpleStringProperty name;

    protected NamedEntityRow(@NotNull final NamedEntity namedEntity) {
        super(namedEntity);
        this.name = new SimpleStringProperty(String.valueOf(namedEntity.getName()));
    }

    public String getName() {
        return name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

}
