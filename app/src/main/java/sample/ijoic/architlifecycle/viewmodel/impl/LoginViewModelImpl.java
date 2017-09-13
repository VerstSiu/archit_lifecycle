package sample.ijoic.architlifecycle.viewmodel.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import sample.ijoic.architlifecycle.constants.LoginMessage;
import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.ui.LoginUI;
import sample.ijoic.architlifecycle.viewmodel.LoginViewModel;

/**
 * Login view model impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginViewModelImpl implements LoginViewModel {

  private final LoginModel loginModel;

  public LoginViewModelImpl(@NonNull LoginModel loginModel) {
    this.loginModel = loginModel;
  }

  @Override
  public void login(@NonNull final LoginUI loginUI) {
    String username = loginUI.getUsername();
    String password = loginUI.getPassword();

    if (TextUtils.isEmpty(username)) {
      loginUI.showMessage(LoginMessage.MSG_USERNAME_EMPTY);
      return;
    }
    if (TextUtils.isEmpty(password)) {
      loginUI.showMessage(LoginMessage.MSG_PASSWORD_EMPTY);
      return;
    }
    loginModel.login(username, password, new LoginModel.OnLoginCompleteListener() {
      @Override
      public void onLoginComplete(boolean isSuccess, int msg) {
        loginUI.showMessage(msg);
      }
    });
  }

}
