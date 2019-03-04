package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Distributor;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class DistributorRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Distributor distributor;

    @NotNull
    private final SimpleStringProperty founder;

    public DistributorRow(@NotNull final Distributor distributor) {
        super(distributor);
        this.distributor = distributor;
        this.founder = new SimpleStringProperty(distributor.getFounder());
    }

    public String getFounder() {
        return founder.get();
    }

    public void setFounder(final String founder) {
        this.founder.set(founder);
    }

}
