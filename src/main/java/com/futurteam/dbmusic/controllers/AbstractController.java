package com.futurteam.dbmusic.controllers;

import com.futurteam.dbmusic.db.DBContext;
import com.futurteam.dbmusic.entities.AppContext;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractController {

    @NotNull
    protected final DBContext getDBContext() {
        return AppContext.getINSTANCE().getDBContext();
    }

}
