package sample.ijoic.architlifecycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.model.impl.LoginModelImpl;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);

    loginView.setOnLoginActionListener(new LoginView.OnLoginActionListener() {
      @Override
      public void onLoginAction(@NonNull String username, @NonNull String password) {
        loginModel.login(username, password, new LoginModel.OnLoginCompleteListener() {
          @Override
          public void onLoginComplete(boolean isSuccess, int msg) {
            loginView.showMessage(msg);
          }
        });
      }
    });
    loginView.init(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    loginView.destroy();
  }
}
