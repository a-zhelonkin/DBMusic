package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Partner;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class PartnerRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Partner entity;

    @NotNull
    private final SimpleStringProperty price;

    public PartnerRow(@NotNull final Partner entity) {
        super(entity);
        this.entity = entity;
        this.price = new SimpleStringProperty(String.valueOf(entity.getPrice()));
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(final String price) {
        this.entity.setPrice(Double.valueOf(price));
        this.price.set(price);
    }

}
