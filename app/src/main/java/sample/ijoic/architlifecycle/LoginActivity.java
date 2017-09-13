package sample.ijoic.architlifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.model.impl.LoginModelImpl;
import sample.ijoic.architlifecycle.presenter.StatePresenter;
import sample.ijoic.architlifecycle.presenter.impl.LoginPresenterImpl;
import sample.ijoic.architlifecycle.view.LoginView;
import sample.ijoic.architlifecycle.view.impl.LoginViewImpl;

/**
 * Login activity.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

  private final LoginModel loginModel = new LoginModelImpl();
  private final LoginView loginView = new LoginViewImpl();

  private final StatePresenter loginPresenter = new LoginPresenterImpl(loginView, loginModel);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    loginView.bindRes(this);
    loginPresenter.init();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    loginPresenter.destroy();
  }
}
