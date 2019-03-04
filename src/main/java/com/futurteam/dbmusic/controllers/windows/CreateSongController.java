package com.futurteam.dbmusic.controllers.windows;

import com.futurteam.dbmusic.db.domains.Song;
import com.futurteam.dbmusic.db.domains.base.Entity;
import com.futurteam.dbmusic.entities.rows.SongRow;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public final class CreateSongController extends AbstractCreateController<SongRow> {

    @FXML
    private TextField name_TF;
    @FXML
    private TextField genre_TF;
    @FXML
    private DatePicker releaseDate_DP;
    @FXML
    private ComboBox albumId_CB;
    @FXML
    private ComboBox artistId_CB;
    @FXML
    private ComboBox partnerId_CB;
    @FXML
    private ComboBox distributorId_CB;

    @FXML
    public void initialize() {
        @NotNull val dbContext = getDBContext();

        albumId_CB.getItems().setAll(dbContext.getAlbumsRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));

        artistId_CB.getItems().setAll(dbContext.getArtistsRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));

        partnerId_CB.getItems().setAll(dbContext.getPartnersRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));

        distributorId_CB.getItems().setAll(dbContext.getDistributorsRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));
    }

    @NotNull
    @Override
    protected SongRow newRow() {
        return new SongRow(new Song());
    }

    @Override
    protected void apply(@NotNull final SongRow songRow) {
        songRow.setName(name_TF.getText());
        songRow.setGenre(genre_TF.getText());
        songRow.setReleaseDate(releaseDate_DP.getValue().format(DateTimeFormatter.ISO_DATE));
        songRow.setAlbumId(albumId_CB.getValue().toString());
        songRow.setArtistId(artistId_CB.getValue().toString());
        songRow.setPartnerId(partnerId_CB.getValue().toString());
        songRow.setDistributorId(distributorId_CB.getValue().toString());
    }

}
