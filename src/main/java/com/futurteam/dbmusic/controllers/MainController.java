package com.futurteam.dbmusic.controllers;

import com.futurteam.dbmusic.controllers.tables.*;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class MainController extends AbstractController {

    @FXML
    private TabPane tabs_TP;
    @FXML
    private DistributorsTableController distributorsTableController;
    @FXML
    private PartnersTableController partnersTableController;
    @FXML
    private ArtistsTableController artistsTableController;
    @FXML
    private AlbumsTableController albumsTableController;
    @FXML
    private SongsTableController songsTableController;

    @Nullable
    private AbstractTableController<?, ?> selectedTableController;

    @FXML
    public void initialize() {
        this.selectedTableController = distributorsTableController;

        tabs_TP.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()) {
                case 0:
                    this.selectedTableController = distributorsTableController;
                    break;
                case 1:
                    this.selectedTableController = partnersTableController;
                    break;
                case 2:
                    this.selectedTableController = artistsTableController;
                    break;
                case 3:
                    this.selectedTableController = albumsTableController;
                    break;
                case 4:
                    this.selectedTableController = songsTableController;
                    break;
            }
        });
    }

    @FXML
    private void add_B_action() {
        Objects.requireNonNull(selectedTableController).add();
    }

    @FXML
    private void remove_B_action() {
        Objects.requireNonNull(selectedTableController).remove();
    }

}
