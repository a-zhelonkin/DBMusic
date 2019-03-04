package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.Album;
import com.futurteam.dbmusic.db.repositories.AlbumsRepository;
import com.futurteam.dbmusic.entities.rows.AlbumRow;
import com.futurteam.dbmusic.utils.UIUtils;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public final class AlbumsTableController extends AbstractTableController<Album, AlbumRow> {

    @NotNull
    @Override
    protected AlbumsRepository getRepository() {
        return getDBContext().getAlbumsRepository();
    }

    @NotNull
    @Override
    protected FXMLPair<AbstractCreateController<AlbumRow>, Stage> getCreator() {
        return UIUtils.openAlbumCreator();
    }

    @NotNull
    @Override
    protected AlbumRow convert(@NotNull final Album album) {
        return new AlbumRow(album);
    }

}
