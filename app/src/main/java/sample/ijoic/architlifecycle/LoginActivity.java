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

  private static final int MSG_USERNAME_EMPTY = 0x01;
  private static final int MSG_PASSWORD_EMPTY = 0x02;
  private static final int MSG_USERNAME_ERROR = 0x03;
  private static final int MSG_PASSWORD_ERROR = 0x04;
  private static final int MSG_LOGIN_SUCCESS = 0x05;

  private static final String DST_USERNAME = "ijoic";
  private static final String DST_PASSWORD = "1234567";

  @OnClick(R.id.login)
  void login() {
    String usernameText = userName.getText().toString();
    String passwordText = password.getText().toString();

    if (TextUtils.isEmpty(usernameText)) {
      showMessage(MSG_USERNAME_EMPTY);
      return;
    }
    if (TextUtils.isEmpty(passwordText)) {
      showMessage(MSG_PASSWORD_EMPTY);
      return;
    }
    login(usernameText, passwordText);
  }

  private void login(@NonNull final String username, @NonNull final String password) {
    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            if (!username.equals(DST_USERNAME)) {
              showMessage(MSG_USERNAME_ERROR);
            } else if (!password.equals(DST_PASSWORD)) {
              showMessage(MSG_PASSWORD_ERROR);
            } else {
              showMessage(MSG_LOGIN_SUCCESS);
            }
          }
        });
      }
    }.start();
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
      case MSG_USERNAME_EMPTY:
        return R.string.login_msg_username_empty;

      case MSG_PASSWORD_EMPTY:
        return R.string.login_msg_password_empty;

      case MSG_USERNAME_ERROR:
        return R.string.login_msg_username_error;

      case MSG_PASSWORD_ERROR:
        return R.string.login_msg_password_error;

      case MSG_LOGIN_SUCCESS:
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
