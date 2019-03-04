package com.futurteam.dbmusic.controllers.tables;

import com.futurteam.dbmusic.db.domains.Album;
import com.futurteam.dbmusic.db.repositories.AlbumsRepository;
import com.futurteam.dbmusic.entities.rows.AlbumRow;
import org.jetbrains.annotations.NotNull;

public final class AlbumsTableController extends AbstractTableController<Album, AlbumRow> {

    @NotNull
    @Override
    protected AlbumsRepository getRepository() {
        return getDBContext().getAlbumsRepository();
    }

    @NotNull
    @Override
    protected AlbumRow convert(@NotNull final Album album) {
        return new AlbumRow(album);
    }

}
