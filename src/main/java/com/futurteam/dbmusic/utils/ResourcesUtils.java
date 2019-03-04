package com.futurteam.dbmusic.utils;

import com.futur.common.annotations.PrepareURL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.URL;

import static com.futur.common.helpers.resources.ResourcesHelper.checkURL;
import static com.futur.common.helpers.resources.ResourcesHelper.getInternalUrl;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourcesUtils {

    @PrepareURL
    public static final URL ICON = getInternalUrl("icon.png");
    @PrepareURL
    public static final URL LAYOUT_MAIN_FXML = getInternalUrl("fxml/layout_main.fxml");
    @PrepareURL
    public static final URL LAYOUT_LOGIN_FXML = getInternalUrl("fxml/layout_login.fxml");
    @PrepareURL
    public static final URL WINDOW_CREATE_ARTIST_FXML = getInternalUrl("fxml/windows/window_create_artist.fxml");

    static {
        checkURL(ResourcesUtils.class);
    }

}
