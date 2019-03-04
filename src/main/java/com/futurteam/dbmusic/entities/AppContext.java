package com.futurteam.dbmusic.entities;

import com.futurteam.dbmusic.db.DBContext;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppContext {

    @Getter
    @NotNull
    private static final AppContext INSTANCE = new AppContext();

    @Setter
    @Nullable
    private Stage primaryStage;

    @Setter
    @Nullable
    private DBContext dbContext;

    @NotNull
    public Stage getPrimaryStage() {
        return Objects.requireNonNull(primaryStage);
    }

    @NotNull
    public DBContext getDBContext() {
        return Objects.requireNonNull(dbContext);
    }

}
