package com.futurteam.dbmusic.controllers.tables;

import com.futurteam.dbmusic.db.domains.Album;
import com.futurteam.dbmusic.db.domains.Artist;
import com.futurteam.dbmusic.db.repositories.ArtistsRepository;
import com.futurteam.dbmusic.entities.rows.AlbumRow;
import com.futurteam.dbmusic.entities.rows.ArtistRow;
import org.jetbrains.annotations.NotNull;

public final class ArtistsTableController extends AbstractTableController<Artist, ArtistRow> {

    @NotNull
    @Override
    protected ArtistsRepository getRepository() {
        return getDBContext().getArtistsRepository();
    }

    @NotNull
    @Override
    protected ArtistRow convert(@NotNull final Artist artist) {
        return new ArtistRow(artist);
    }

}
