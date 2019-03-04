package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Song;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Objects;

public final class SongRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Song entity;

    @NotNull
    private final SimpleStringProperty albumId;

    @NotNull
    private final SimpleStringProperty artistId;

    @NotNull
    private final SimpleStringProperty partnerId;

    @NotNull
    private final SimpleStringProperty distributorId;

    @NotNull
    private final SimpleStringProperty genre;

    @NotNull
    private final SimpleStringProperty releaseDate;

    public SongRow(@NotNull final Song entity) {
        super(entity);
        this.entity = entity;
        this.albumId = new SimpleStringProperty(String.valueOf(entity.getAlbumId()));
        this.artistId = new SimpleStringProperty(String.valueOf(entity.getArtistId()));
        this.partnerId = new SimpleStringProperty(String.valueOf(entity.getPartnerId()));
        this.distributorId = new SimpleStringProperty(String.valueOf(entity.getDistributorId()));
        this.genre = new SimpleStringProperty(entity.getGenre());
        this.releaseDate = new SimpleStringProperty(Objects.toString(entity.getReleaseDate()));
    }

    public String getAlbumId() {
        return albumId.get();
    }

    public void setAlbumId(final String albumId) {
        this.entity.setAlbumId(Integer.valueOf(albumId));
        this.albumId.set(albumId);
    }

    public String getArtistId() {
        return artistId.get();
    }

    public void setArtistId(final String artistId) {
        this.entity.setArtistId(Integer.valueOf(artistId));
        this.artistId.set(artistId);
    }

    public String getPartnerId() {
        return partnerId.get();
    }

    public void setPartnerId(final String partnerId) {
        this.entity.setPartnerId(Integer.valueOf(partnerId));
        this.partnerId.set(partnerId);
    }

    public String getDistributorId() {
        return distributorId.get();
    }

    public void setDistributorId(final String distributorId) {
        this.entity.setDistributorId(Integer.valueOf(distributorId));
        this.distributorId.set(distributorId);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(final String genre) {
        this.entity.setGenre(genre);
        this.genre.set(genre);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public void setReleaseDate(final String releaseDate) {
        this.entity.setReleaseDate(Date.valueOf(releaseDate));
        this.releaseDate.set(releaseDate);
    }

}
