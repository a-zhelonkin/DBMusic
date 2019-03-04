package com.futurteam.dbmusic.controllers.windows;

import com.futurteam.dbmusic.controllers.AbstractController;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractCreateController<TRow> extends AbstractController {

    @Setter
    @Nullable
    protected Stage stage;

    @Setter
    @Nullable
    protected Consumer<TRow> consumer;

    @NotNull
    protected abstract TRow newRow();

    protected abstract void apply(@NotNull final TRow row);

    @FXML
    private void apply_B_action() {
        Objects.requireNonNull(stage);
        Objects.requireNonNull(consumer);

        @NotNull val newRow = newRow();
        apply(newRow);
        consumer.accept(newRow);

        stage.close();
    }

    @FXML
    protected void cancel_B_action() {
        Objects.requireNonNull(stage).close();
    }

}
