package com.futurteam.dbmusic.controllers.windows;

import com.futurteam.dbmusic.db.domains.Artist;
import com.futurteam.dbmusic.entities.rows.ArtistRow;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;

public final class CreateArtistController extends AbstractCreateController<ArtistRow> {

    @FXML
    private TextField name_TF;
    @FXML
    private TextField genre_TF;
    @FXML
    private DatePicker foundationDate_DP;
    @FXML
    private TextField country_TF;
    @FXML
    private TextField label_TF;

    @NotNull
    @Override
    protected ArtistRow newRow() {
        return new ArtistRow(new Artist());
    }

    @Override
    protected void apply(@NotNull final ArtistRow artistRow) {
        artistRow.setName(name_TF.getText());
        artistRow.setGenre(genre_TF.getText());
        artistRow.setFoundationDate(foundationDate_DP.getValue().format(DateTimeFormatter.ISO_DATE));
        artistRow.setCountry(country_TF.getText());
        artistRow.setLabel(label_TF.getText());
    }

}
