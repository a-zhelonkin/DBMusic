package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Artist;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Objects;

public final class ArtistRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Artist entity;

    @NotNull
    private final SimpleStringProperty genre;

    @NotNull
    private final SimpleStringProperty foundationDate;

    @NotNull
    private final SimpleStringProperty country;

    @NotNull
    private final SimpleStringProperty label;

    public ArtistRow(@NotNull final Artist entity) {
        super(entity);
        this.entity = entity;
        this.genre = new SimpleStringProperty(entity.getGenre());
        this.foundationDate = new SimpleStringProperty(Objects.toString(entity.getFoundationDate()));
        this.country = new SimpleStringProperty(entity.getCountry());
        this.label = new SimpleStringProperty(entity.getLabel());
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(final String genre) {
        this.entity.setGenre(genre);
        this.genre.set(genre);
    }

    public String getFoundationDate() {
        return foundationDate.get();
    }

    public void setFoundationDate(final String foundationDate) {
        this.entity.setFoundationDate(Date.valueOf(foundationDate));
        this.foundationDate.set(foundationDate);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(final String country) {
        this.entity.setCountry(country);
        this.country.set(country);
    }

    public String getLabel() {
        return label.get();
    }

    public void setLabel(final String label) {
        this.entity.setLabel(label);
        this.label.set(label);
    }

}
