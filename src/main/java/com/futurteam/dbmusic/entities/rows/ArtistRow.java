package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Artist;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class ArtistRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Artist artist;

    @NotNull
    private final SimpleStringProperty genre;

    @NotNull
    private final SimpleStringProperty foundationDate;

    @NotNull
    private final SimpleStringProperty country;

    @NotNull
    private final SimpleStringProperty label;

    public ArtistRow(@NotNull final Artist artist) {
        super(artist);
        this.artist = artist;
        this.genre = new SimpleStringProperty(artist.getGenre());
        this.foundationDate = new SimpleStringProperty(artist.getFoundationDate().toString());
        this.country = new SimpleStringProperty(artist.getCountry());
        this.label = new SimpleStringProperty(artist.getLabel());
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(final String genre) {
        this.genre.set(genre);
    }

    public String getFoundationDate() {
        return foundationDate.get();
    }

    public void setFoundationDate(final String foundationDate) {
        this.foundationDate.set(foundationDate);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(final String country) {
        this.country.set(country);
    }

    public String getLabel() {
        return label.get();
    }

    public void setLabel(final String label) {
        this.label.set(label);
    }

}
