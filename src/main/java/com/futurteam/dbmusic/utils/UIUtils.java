package com.futurteam.dbmusic.utils;

import com.futur.common.helpers.resources.FXMLHelper;
import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.AbstractController;
import com.futurteam.dbmusic.controllers.LoginController;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.entities.AppContext;
import com.futurteam.dbmusic.entities.rows.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UIUtils {

    @NotNull
    public static FXMLPair<LoginController, Stage> openLogin() {
        return openWindow(ResourcesUtils.LAYOUT_LOGIN_FXML, "Вход");
    }

    @NotNull
    public static FXMLPair<AbstractCreateController<AlbumRow>, Stage> openAlbumCreator() {
        return openWindow(ResourcesUtils.WINDOW_CREATE_ALBUM_FXML, "Альбом");
    }

    @NotNull
    public static FXMLPair<AbstractCreateController<ArtistRow>, Stage> openArtistCreator() {
        return openWindow(ResourcesUtils.WINDOW_CREATE_ARTIST_FXML, "Артист");
    }

    @NotNull
    public static FXMLPair<AbstractCreateController<DistributorRow>, Stage> openDistributorCreator() {
        return openWindow(ResourcesUtils.WINDOW_CREATE_DISTRIBUTOR_FXML, "Дистрибьютор");
    }

    @NotNull
    public static FXMLPair<AbstractCreateController<PartnerRow>, Stage> openPartnerCreator() {
        return openWindow(ResourcesUtils.WINDOW_CREATE_PARTNER_FXML, "Партнер");
    }

    @NotNull
    public static FXMLPair<AbstractCreateController<SongRow>, Stage> openSongCreate() {
        return openWindow(ResourcesUtils.WINDOW_CREATE_SONG_FXML, "Песня");
    }

    @NotNull
    private static <C extends AbstractController> FXMLPair<C, Stage> openWindow(@NotNull final URL url, @NotNull final String title) {
        @NotNull val pair = FXMLHelper.<C, Parent>loadFXML(url);

        @NotNull val stage = prepareStage(title);
        stage.setScene(new Scene(pair.getNode()));

        return new FXMLPair<>(pair.getController(), stage);
    }

    @NotNull
    private static Stage prepareStage(@NotNull final String title) {
        @NotNull val stage = new Stage();
        stage.initOwner(AppContext.getINSTANCE().getPrimaryStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image(ResourcesUtils.ICON.toString()));
        stage.setResizable(false);
        stage.setTitle(title);
        return stage;
    }

}