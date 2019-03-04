package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.AbstractController;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.base.Entity;
import com.futurteam.dbmusic.db.repositories.base.AbstractRepository;
import com.futurteam.dbmusic.entities.rows.base.EntityRow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public abstract class AbstractTableController<TEntity extends Entity, TRow extends EntityRow> extends AbstractController {

    @FXML
    protected TableView<TRow> table;

    @FXML
    public void initialize() {
        table.getItems().setAll(getRepository().get().stream().map(this::convert).collect(Collectors.toList()));
    }

    @NotNull
    protected abstract AbstractRepository<TEntity> getRepository();

    @NotNull
    protected abstract FXMLPair<AbstractCreateController<TRow>, Stage> getCreator();

    @NotNull
    protected abstract TRow convert(@NotNull final TEntity entity);

    @SuppressWarnings("unchecked")
    public void add() {
        @NotNull val creator = getCreator();
        @NotNull val stage = creator.getNode();
        @NotNull val controller = creator.getController();
        controller.setStage(stage);
        controller.setConsumer(row -> {
            @NotNull val entity = (TEntity) row.getEntity();
            getRepository().add(entity);

            row.setId(String.valueOf(entity.getId()));
            table.getItems().add(row);
        });

        stage.showAndWait();
    }

    public void remove() {
        @NotNull val selectionModel = table.getSelectionModel();
        @NotNull val row = selectionModel.getSelectedItem();
        val selectedIndex = selectionModel.getSelectedIndex();
        table.getItems().remove(selectedIndex);

        getRepository().remove(Integer.valueOf(row.getId()));
    }

}
