package sample.ijoic.architlifecycle.view.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.ijoic.architlifecycle.R;
import sample.ijoic.architlifecycle.constants.LoginMessage;
import sample.ijoic.architlifecycle.ui.LoginUI;
import sample.ijoic.architlifecycle.viewmodel.LoginViewModel;

/**
 * Login view impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginViewImpl extends BaseStateViewImpl<LoginViewModel, Activity> implements LoginUI {

  @BindView(R.id.username_title)
  TextView userName;

  @BindView(R.id.password_title)
  TextView password;

  /**
   * Constructor.
   *
   * @param viewModel view model.
   */
  public LoginViewImpl(@NonNull LoginViewModel viewModel) {
    super(viewModel);
  }

  @OnClick(R.id.login)
  void login() {
    getViewModel().login(this);
  }

  @Override
  protected void onInit(@NonNull Activity root) {
    ButterKnife.bind(this, root);
  }

  @Nullable
  @Override
  public String getUsername() {
    return userName.getText().toString();
  }

  @Nullable
  @Override
  public String getPassword() {
    return password.getText().toString();
  }

  @Override
  public void showMessage(int msg) {
    if (!isViewReady()) {
      return;
    }
    Context context = getRoot();
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

}
