package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.Distributor;
import com.futurteam.dbmusic.db.repositories.DistributorsRepository;
import com.futurteam.dbmusic.entities.rows.DistributorRow;
import com.futurteam.dbmusic.utils.UIUtils;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public final class DistributorsTableController extends AbstractTableController<Distributor, DistributorRow> {

    @NotNull
    @Override
    protected DistributorsRepository getRepository() {
        return getDBContext().getDistributorsRepository();
    }

    @NotNull
    @Override
    protected FXMLPair<AbstractCreateController<DistributorRow>, Stage> getCreator() {
        return UIUtils.openDistributorCreator();
    }

    @NotNull
    @Override
    protected DistributorRow convert(@NotNull final Distributor distributor) {
        return new DistributorRow(distributor);
    }

}
