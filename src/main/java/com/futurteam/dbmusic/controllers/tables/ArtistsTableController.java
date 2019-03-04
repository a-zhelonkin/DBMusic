package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.Artist;
import com.futurteam.dbmusic.db.repositories.ArtistsRepository;
import com.futurteam.dbmusic.entities.rows.ArtistRow;
import com.futurteam.dbmusic.utils.UIUtils;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public final class ArtistsTableController extends AbstractTableController<Artist, ArtistRow> {

    @NotNull
    @Override
    protected ArtistsRepository getRepository() {
        return getDBContext().getArtistsRepository();
    }

    @NotNull
    @Override
    protected FXMLPair<AbstractCreateController<ArtistRow>, Stage> getCreator() {
        return UIUtils.openArtistCreator();
    }

    @NotNull
    @Override
    protected ArtistRow convert(@NotNull final Artist artist) {
        return new ArtistRow(artist);
    }

}
