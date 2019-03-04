package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.Song;
import com.futurteam.dbmusic.db.repositories.SongsRepository;
import com.futurteam.dbmusic.entities.rows.SongRow;
import com.futurteam.dbmusic.utils.UIUtils;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public final class SongsTableController extends AbstractTableController<Song, SongRow> {

    @NotNull
    @Override
    protected SongsRepository getRepository() {
        return getDBContext().getSongsRepository();
    }

    @NotNull
    @Override
    protected FXMLPair<AbstractCreateController<SongRow>, Stage> getCreator() {
        return UIUtils.openSongCreate();
    }

    @NotNull
    @Override
    protected SongRow convert(@NotNull final Song song) {
        return new SongRow(song);
    }

}
