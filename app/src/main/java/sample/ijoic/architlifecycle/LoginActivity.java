package sample.ijoic.architlifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.model.impl.LoginModelImpl;
import sample.ijoic.architlifecycle.view.ActivityStateView;
import sample.ijoic.architlifecycle.view.impl.LoginViewImpl;
import sample.ijoic.architlifecycle.viewmodel.LoginViewModel;
import sample.ijoic.architlifecycle.viewmodel.impl.LoginViewModelImpl;

/**
 * Login activity.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

  private final LoginModel loginModel = new LoginModelImpl();
  private final LoginViewModel loginViewModel = new LoginViewModelImpl(loginModel);

  private final ActivityStateView loginView = new LoginViewImpl(loginViewModel);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    loginView.bindRes(this);
    loginView.init();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    loginView.destroy();
  }
}
