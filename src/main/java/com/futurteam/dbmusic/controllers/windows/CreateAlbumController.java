package com.futurteam.dbmusic.controllers.windows;

import com.futur.ui.FormatterHelper;
import com.futurteam.dbmusic.db.domains.Album;
import com.futurteam.dbmusic.db.domains.base.Entity;
import com.futurteam.dbmusic.entities.rows.AlbumRow;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public final class CreateAlbumController extends AbstractCreateController<AlbumRow> {

    @FXML
    private TextField name_TF;
    @FXML
    private TextField genre_TF;
    @FXML
    private DatePicker releaseDate_DP;
    @FXML
    private TextField songsCount_TF;
    @FXML
    private ComboBox<Integer> partnerId_CB;
    @FXML
    private ComboBox<Integer> distributorId_CB;

    @FXML
    public void initialize() {
        FormatterHelper.applyIntegerFormat(songsCount_TF);

        @NotNull val dbContext = getDBContext();

        partnerId_CB.getItems().setAll(dbContext.getPartnersRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));

        distributorId_CB.getItems().setAll(dbContext.getDistributorsRepository().get().stream()
                .map(Entity::getId)
                .collect(Collectors.toList()));
    }

    @NotNull
    @Override
    protected AlbumRow newRow() {
        return new AlbumRow(new Album());
    }

    @Override
    protected void apply(@NotNull final AlbumRow albumRow) {
        albumRow.setName(name_TF.getText());
        albumRow.setGenre(genre_TF.getText());
        albumRow.setReleaseDate(releaseDate_DP.getValue().format(DateTimeFormatter.ISO_DATE));
        albumRow.setSongsCount(songsCount_TF.getText());
        albumRow.setPartnerId(partnerId_CB.getValue().toString());
        albumRow.setDistributorId(distributorId_CB.getValue().toString());
    }

}
