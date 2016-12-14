package com.farguito.sarlanga.login;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.farguito.sarlanga.domain.User;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.menu.MenuScreen;
import com.farguito.sarlanga.ui.SimpleButton;
import com.farguito.sarlanga.ui.SimpleTextField;

import static com.farguito.sarlanga.login.LoginController.LoginState.LOGIN;
import static com.farguito.sarlanga.login.LoginController.LoginState.MENU;
import static com.farguito.sarlanga.login.LoginController.LoginState.REGISTER;


public class LoginController {

    private LoginConnector connection;
    private LoginRenderer renderer;

    private Stage stage;
    private LoginState currentState;
    private LoginScreen screen;


    private SimpleTextField username;
    private Label usernameLabel;

    private SimpleTextField password;
    private Label passwordLabel;

    private SimpleTextField confirmPassword;
    private Label confirmPasswordLabel;


    private SimpleTextField login;
    private SimpleTextField register;

    private SimpleButton backButton;
    private SimpleButton confirmButton;

    private SimpleTextField waitingText;

    private boolean waiting;
    private float timeWaiting;
    private float timeout = 3000;

    public SimpleTextField getWaitingText() {
        return waitingText;
    }

    public enum LoginState {
        MENU, LOGIN, REGISTER
    }

    public LoginController(LoginScreen screen, int midPointY) {
        currentState = MENU;
        waiting = false;
        this.screen = screen;
        connection = new LoginConnector();
        stage = new Stage();
        username = new SimpleTextField("", AssetLoader.textSkin , 100, 150);
        usernameLabel = new Label("Username:", AssetLoader.textSkin);

        password = new SimpleTextField("", AssetLoader.textSkin , 100, 100);
        password.setPasswordCharacter('*');
        password.setPasswordMode(true);
        passwordLabel = new Label("Password:", AssetLoader.textSkin);


        confirmPassword = new SimpleTextField("", AssetLoader.textSkin , 100, 50);
        confirmPassword.setPasswordCharacter('*');
        confirmPassword.setPasswordMode(true);
        confirmPasswordLabel = new Label("Confirm:", AssetLoader.textSkin);

        login = new SimpleTextField("LOGIN", AssetLoader.textSkin , 100, 100);
        login.setAlignment(1);

        register = new SimpleTextField("REGISTER", AssetLoader.textSkin , 100, 50);
        register.setAlignment(1);

        backButton = new SimpleButton(SimpleButton.Type.CIRCLE,
                300, 50, AssetLoader.backButtonUp.getRegionWidth(), AssetLoader.backButtonUp.getRegionHeight(),
                AssetLoader.backButtonUp, AssetLoader.backButtonDown);
        confirmButton = new SimpleButton(SimpleButton.Type.CIRCLE,
                300, 125, AssetLoader.confirmButtonUp.getRegionWidth(), AssetLoader.confirmButtonUp.getRegionHeight(),
                AssetLoader.confirmButtonUp, AssetLoader.confirmButtonDown);
    }



    public void goLogin() {
        username.setText("");
        username.setPosition(100, 150);
        usernameLabel.setPosition(username.getX()-usernameLabel.getWidth()-5, username.getY());

        password.setText("");
        password.setPosition(100, 100);
        passwordLabel.setPosition(password.getX()-passwordLabel.getWidth()-5, password.getY());

        currentState = LOGIN;
    }

    public void goRegister() {
        username.setText("");
        username.setPosition(100, 150);
        usernameLabel.setPosition(username.getX()-usernameLabel.getWidth()-5, username.getY());

        password.setText("");
        password.setPosition(100, 100);
        passwordLabel.setPosition(password.getX()-passwordLabel.getWidth()-5, password.getY());

        confirmPassword.setText("");
        confirmPassword.setPosition(100, 50);
        confirmPasswordLabel.setPosition(confirmPassword.getX()- confirmPasswordLabel.getWidth()-5, confirmPassword.getY());

        currentState = REGISTER;
    }

    public void goMenu() {
        currentState = MENU;
    }

    public void startRegister() {
        try {
            if(!password.getText().isEmpty()&& password.getText().contentEquals(confirmPassword.getText())){
                timeWaiting = 0;
                waiting = true;
                connection.register(username.getText(), password.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void finishRegister(){
        try {
            waiting = false;
            User user = connection.getRegisterResponse();
            this.screen.getGame().setUser(user);
            goMenuScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startLogin() {
        try {
            timeWaiting = 0;
            waiting = true;
            connection.login(username.getText(), password.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void finishLogin() {
        try {
            waiting = false;
            User user = connection.getLoginResponse();
            this.screen.getGame().setUser(user);
            goMenuScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void goMenuScreen() {
        renderer.stopMusic();
        screen.getGame().setScreen(new MenuScreen(screen.getGame()));
    }

    public void setRenderer(LoginRenderer renderer) {
        this.renderer = renderer;
    }

    public void update(float delta) {
        if(waiting){
            System.out.println(timeWaiting);
            if(!connection.isResponseError()
                    && connection.isWaiting()
                    && timeWaiting < timeout)
                timeWaiting += delta;
            else {
                switch (currentState) {
                    case LOGIN:
                        finishLogin();
                        break;
                    case REGISTER:
                        finishRegister();
                        break;
                }
            }
        }
    }
    public boolean isLogin(){ return currentState == LOGIN; }
    public boolean isMenu(){ return currentState == MENU; }
    public boolean isRegister(){ return currentState == REGISTER; }

    public LoginRenderer getRenderer() {
        return renderer;
    }

    public Stage getStage() {
        return stage;
    }

    public LoginState getCurrentState() {
        return currentState;
    }

    public SimpleTextField getUsername() {
        return username;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public SimpleTextField getPassword() {
        return password;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public SimpleTextField getConfirmPassword() {
        return confirmPassword;
    }

    public Label getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public SimpleTextField getLogin() {
        return login;
    }

    public SimpleTextField getRegister() {
        return register;
    }

    public SimpleButton getBackButton() {
        return backButton;
    }
    public SimpleButton getConfirmButton() {
        return confirmButton;
    }

    public boolean isWaiting(){
        return waiting;
    }
}
