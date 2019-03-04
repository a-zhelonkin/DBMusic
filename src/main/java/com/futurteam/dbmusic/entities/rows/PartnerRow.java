package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Partner;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class PartnerRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Partner partner;

    @NotNull
    private final SimpleStringProperty price;

    public PartnerRow(@NotNull final Partner partner) {
        super(partner);
        this.partner = partner;
        this.price = new SimpleStringProperty(String.valueOf(partner.getPrice()));
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

}
