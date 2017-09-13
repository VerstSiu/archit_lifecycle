package sample.ijoic.architlifecycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.ijoic.architlifecycle.constants.LoginMessage;
import sample.ijoic.architlifecycle.model.LoginModel;
import sample.ijoic.architlifecycle.model.impl.LoginModelImpl;

/**
 * Login activity.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

  @BindView(R.id.username_title)
  TextView userName;

  @BindView(R.id.password_title)
  TextView password;

  private final LoginModel loginModel = new LoginModelImpl();

  @OnClick(R.id.login)
  void login() {
    String usernameText = userName.getText().toString();
    String passwordText = password.getText().toString();

    if (TextUtils.isEmpty(usernameText)) {
      showMessage(LoginMessage.MSG_USERNAME_EMPTY);
      return;
    }
    if (TextUtils.isEmpty(passwordText)) {
      showMessage(LoginMessage.MSG_PASSWORD_EMPTY);
      return;
    }
    login(usernameText, passwordText);
  }

  private void login(@NonNull final String username, @NonNull final String password) {
    loginModel.login(username, password, new LoginModel.OnLoginCompleteListener() {
      @Override
      public void onLoginComplete(boolean isSuccess, int msg) {
        showMessage(msg);
      }
    });
  }

  private void showMessage(int msg) {
    int msgRes = mapMsgRes(msg);

    if (msgRes != 0) {
      Toast.makeText(this, msgRes, Toast.LENGTH_SHORT).show();
    }
  }

  @StringRes
  private static int mapMsgRes(int msg) {
    switch (msg) {
      case LoginMessage.MSG_USERNAME_EMPTY:
        return R.string.login_msg_username_empty;

      case LoginMessage.MSG_PASSWORD_EMPTY:
        return R.string.login_msg_password_empty;

      case LoginMessage.MSG_USERNAME_ERROR:
        return R.string.login_msg_username_error;

      case LoginMessage.MSG_PASSWORD_ERROR:
        return R.string.login_msg_password_error;

      case LoginMessage.MSG_LOGIN_SUCCESS:
        return R.string.login_msg_login_success;
    }
    return 0;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    ButterKnife.bind(this);
  }
}
