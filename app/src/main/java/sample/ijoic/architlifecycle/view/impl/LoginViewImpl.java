package sample.ijoic.architlifecycle.view.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.ijoic.architlifecycle.R;
import sample.ijoic.architlifecycle.constants.LoginMessage;
import sample.ijoic.architlifecycle.view.LoginView;

/**
 * Login view impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginViewImpl implements LoginView {

  @BindView(R.id.username_title)
  TextView userName;

  @BindView(R.id.password_title)
  TextView password;

  private Activity rootActivity;
  private boolean viewReady;

  private OnLoginActionListener loginActionListener;

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
    OnLoginActionListener listener = loginActionListener;

    if (listener != null) {
      listener.onLoginAction(username, password);
    }
  }

  @Override
  public void setOnLoginActionListener(OnLoginActionListener listener) {
    loginActionListener = listener;
  }

  @Override
  public void bindRes(@NonNull Activity rootActivity) {
    this.rootActivity = rootActivity;
  }

  @Override
  public void init() {
    Activity rootActivity = this.rootActivity;

    if (rootActivity == null) {
      return;
    }
    ButterKnife.bind(this, rootActivity);
    viewReady = true;
  }

  @Override
  public void showMessage(int msg) {
    if (!viewReady) {
      return;
    }
    Context context = rootActivity;
    int msgRes = mapMsgRes(msg);

    if (context != null && msgRes != 0) {
      Toast.makeText(context, msgRes, Toast.LENGTH_SHORT).show();
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
  public void destroy() {
    viewReady = false;
    rootActivity = null;
  }

}
