package com.futurteam.dbmusic.entities.rows.base;

import com.futurteam.dbmusic.db.domains.base.Entity;
import javafx.beans.property.SimpleStringProperty;
import org.jetbrains.annotations.NotNull;

public abstract class EntityRow {

    @NotNull
    private final SimpleStringProperty id;

    protected EntityRow(@NotNull final Entity entity) {
        this.id = new SimpleStringProperty(String.valueOf(entity.getId()));
    }

    public abstract Entity getEntity();

    public String getId() {
        return id.get();
    }

    public void setId(final String id) {
        this.id.set(id);
    }

}
