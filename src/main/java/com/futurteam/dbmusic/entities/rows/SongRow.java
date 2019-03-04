package com.futurteam.dbmusic.entities.rows;

import com.futurteam.dbmusic.db.domains.Song;
import com.futurteam.dbmusic.entities.rows.base.NamedEntityRow;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class SongRow extends NamedEntityRow {

    @Getter
    @NotNull
    private final Song song;

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

    public SongRow(@NotNull final Song song) {
        super(song);
        this.song = song;
        this.albumId = new SimpleStringProperty(String.valueOf(song.getAlbumId()));
        this.artistId = new SimpleStringProperty(String.valueOf(song.getArtistId()));
        this.partnerId = new SimpleStringProperty(String.valueOf(song.getPartnerId()));
        this.distributorId = new SimpleStringProperty(String.valueOf(song.getDistributorId()));
        this.genre = new SimpleStringProperty(song.getGenre());
        this.releaseDate = new SimpleStringProperty(song.getReleaseDate().toString());
    }

    public String getAlbumId() {
        return albumId.get();
    }

    public void setAlbumId(final String albumId) {
        this.albumId.set(albumId);
    }

    public String getArtistId() {
        return artistId.get();
    }

    public void setArtistId(final String artistId) {
        this.artistId.set(artistId);
    }

    public String getPartnerId() {
        return partnerId.get();
    }

    public void setPartnerId(final String partnerId) {
        this.partnerId.set(partnerId);
    }

    public String getDistributorId() {
        return distributorId.get();
    }

    public void setDistributorId(final String distributorId) {
        this.distributorId.set(distributorId);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(final String genre) {
        this.genre.set(genre);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public void setReleaseDate(final String releaseDate) {
        this.releaseDate.set(releaseDate);
    }

}
