package com.futurteam.dbmusic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.util.Objects;
import java.util.function.BiConsumer;

public final class LoginController extends AbstractController {

    @FXML
    private TextField username_TF;
    @FXML
    private PasswordField password_PF;

    @Setter
    private BiConsumer<String, String> loginer;

    @FXML
    private void login_B_action() {
        Objects.requireNonNull(loginer);

        loginer.accept(username_TF.getText(), password_PF.getText());
    }

}
