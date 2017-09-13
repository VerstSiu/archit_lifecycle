package sample.ijoic.architlifecycle.presenter.impl;

import android.support.annotation.NonNull;

import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.view.LoginView;

/**
 * Login presenter impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginPresenterImpl extends BaseStatePresenterImpl<LoginView, LoginModel> implements
    LoginView.OnLoginActionListener,
    LoginModel.OnLoginCompleteListener {

  /**
   * Constructor.
   *
   * @param view  view.
   * @param model model.
   */
  public LoginPresenterImpl(@NonNull LoginView view, @NonNull LoginModel model) {
    super(view, model);
  }

  @Override
  public void init() {
    getView().setOnLoginActionListener(this);
    getView().init();
  }

  @Override
  public void destroy() {
    getView().setOnLoginActionListener(null);
    getView().destroy();
  }

  @Override
  public void onLoginAction(@NonNull String username, @NonNull String password) {
    getModel().login(username, password, this);
  }

  @Override
  public void onLoginComplete(boolean isSuccess, int msg) {
    getView().showMessage(msg);
  }
}
