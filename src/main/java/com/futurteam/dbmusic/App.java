package com.futurteam.dbmusic;

import com.futur.common.helpers.resources.FXMLHelper;
import com.futurteam.dbmusic.db.DBContext;
import com.futurteam.dbmusic.entities.AppContext;
import com.futurteam.dbmusic.utils.ResourcesUtils;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import static com.futurteam.dbmusic.utils.UIUtils.openLogin;

@Slf4j
public final class App extends Application {

    public static void main(@NotNull final String[] args) {
        launch(App.class, args);
    }

    @Override
    public void start(@NotNull final Stage primaryStage) {
        AppContext.getINSTANCE().setPrimaryStage(primaryStage);

        @NotNull val loginControllerParentFXMLPair = openLogin();
        @NotNull val loginController = loginControllerParentFXMLPair.getController();
        @NotNull val loginStage = loginControllerParentFXMLPair.getNode();

        loginController.setLoginer((username, password) -> {
            try {
                if (username.equals("admin") && password.equals("admin")) {
                    AppContext.getINSTANCE().setDbContext(new DBContext(username, password));

                    loginStage.close();
                }
            } catch (Throwable e) {
                log.error("Cannot create DB", e);
            }
        });

        loginStage.showAndWait();

        @NotNull val root = FXMLHelper.<Parent>loadNode(ResourcesUtils.LAYOUT_MAIN_FXML);
        primaryStage.getIcons().add(new Image(ResourcesUtils.ICON.toString()));
        primaryStage.setTitle("Музыка");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
