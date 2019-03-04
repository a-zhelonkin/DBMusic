package com.futurteam.dbmusic.controllers.tables;

import com.futur.common.models.FXMLPair;
import com.futurteam.dbmusic.controllers.windows.AbstractCreateController;
import com.futurteam.dbmusic.db.domains.Partner;
import com.futurteam.dbmusic.db.repositories.PartnersRepository;
import com.futurteam.dbmusic.entities.rows.PartnerRow;
import com.futurteam.dbmusic.utils.UIUtils;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public final class PartnersTableController extends AbstractTableController<Partner, PartnerRow> {

    @NotNull
    @Override
    protected PartnersRepository getRepository() {
        return getDBContext().getPartnersRepository();
    }

    @NotNull
    @Override
    protected FXMLPair<AbstractCreateController<PartnerRow>, Stage> getCreator() {
        return UIUtils.openPartnerCreator();
    }

    @NotNull
    @Override
    protected PartnerRow convert(@NotNull final Partner partner) {
        return new PartnerRow(partner);
    }

}
