package com.futurteam.dbmusic.controllers.tables;

import com.futurteam.dbmusic.db.domains.Song;
import com.futurteam.dbmusic.db.repositories.SongsRepository;
import com.futurteam.dbmusic.entities.rows.SongRow;
import org.jetbrains.annotations.NotNull;

public final class SongsTableController extends AbstractTableController<Song, SongRow> {

    @NotNull
    @Override
    protected SongsRepository getRepository() {
        return getDBContext().getSongsRepository();
    }

    @NotNull
    @Override
    protected SongRow convert(@NotNull final Song song) {
        return new SongRow(song);
    }

}
