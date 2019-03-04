package com.futurteam.dbmusic.controllers.windows;

import com.futur.ui.FormatterHelper;
import com.futurteam.dbmusic.db.domains.Partner;
import com.futurteam.dbmusic.entities.rows.PartnerRow;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public final class CreatePartnerController extends AbstractCreateController<PartnerRow> {

    @FXML
    private TextField name_TF;
    @FXML
    private TextField price_TF;

    @FXML
    public void initialize() {
        FormatterHelper.applyDoubleFormat(price_TF);
    }

    @NotNull
    @Override
    protected PartnerRow newRow() {
        return new PartnerRow(new Partner());
    }

    @Override
    protected void apply(@NotNull final PartnerRow partnerRow) {
        partnerRow.setName(name_TF.getText());
        partnerRow.setPrice(price_TF.getText());
    }

}
