package sample.ijoic.architlifecycle.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Login model.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface LoginModel {

  /**
   * Login complete listener.
   */
  interface OnLoginCompleteListener {
    /**
     * Login complete.
     *
     * @param isSuccess is success.
     * @param msg msg.
     *
     * @see sample.ijoic.architlifecycle.constants.LoginMessage
     */
    void onLoginComplete(boolean isSuccess, int msg);
  }

  /**
   * Login.
   *
   * @param username username.
   * @param password password.
   * @param callback callback.
   */
  void login(@NonNull String username, @NonNull String password, @Nullable OnLoginCompleteListener callback);
}
