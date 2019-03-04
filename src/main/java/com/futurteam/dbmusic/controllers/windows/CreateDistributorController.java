package com.futurteam.dbmusic.controllers.windows;

import com.futurteam.dbmusic.db.domains.Distributor;
import com.futurteam.dbmusic.entities.rows.DistributorRow;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public final class CreateDistributorController extends AbstractCreateController<DistributorRow> {

    @FXML
    private TextField name_TF;
    @FXML
    private TextField founder_TF;

    @NotNull
    @Override
    protected DistributorRow newRow() {
        return new DistributorRow(new Distributor());
    }

    @Override
    protected void apply(@NotNull final DistributorRow distributorRow) {
        distributorRow.setName(name_TF.getText());
        distributorRow.setFounder(founder_TF.getText());
    }

}
