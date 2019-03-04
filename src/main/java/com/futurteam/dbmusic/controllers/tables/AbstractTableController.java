package com.futurteam.dbmusic.controllers.tables;

import com.futurteam.dbmusic.controllers.AbstractController;
import com.futurteam.dbmusic.db.domains.base.Entity;
import com.futurteam.dbmusic.db.repositories.base.AbstractRepository;
import com.futurteam.dbmusic.entities.rows.base.EntityRow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
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
    protected abstract TRow convert(@NotNull final TEntity entity);

}
