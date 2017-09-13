package sample.ijoic.architlifecycle.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sample.ijoic.architlifecycle.constants.LoginMessage;
import sample.ijoic.architlifecycle.model.LoginModel;

/**
 * Login model impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public class LoginModelImpl implements LoginModel {

  private final Handler handler = new Handler();

  private static final String DST_USERNAME = "ijoic";
  private static final String DST_PASSWORD = "1234567";

  @Override
  public void login(@NonNull final String username, @NonNull final String password, @Nullable final OnLoginCompleteListener callback) {
    if (callback == null) {
      return;
    }

    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        handler.post(new Runnable() {
          @Override
          public void run() {
            if (!username.equals(DST_USERNAME)) {
              callback.onLoginComplete(false, LoginMessage.MSG_USERNAME_ERROR);
            } else if (!password.equals(DST_PASSWORD)) {
              callback.onLoginComplete(false, LoginMessage.MSG_PASSWORD_ERROR);
            } else {
              callback.onLoginComplete(true, LoginMessage.MSG_LOGIN_SUCCESS);
            }
          }
        });
      }
    }.start();
  }
}
