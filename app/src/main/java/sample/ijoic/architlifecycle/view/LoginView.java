package sample.ijoic.architlifecycle.view;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Login view.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface LoginView {

  /**
   * Login action listener.
   */
  interface OnLoginActionListener {
    /**
     * Login action.
     *
     * @param username username.
     * @param password password.
     */
    void onLoginAction(@NonNull String username, @NonNull String password);
  }

  /**
   * Set login action listener.
   *
   * @param listener listener.
   */
  void setOnLoginActionListener(OnLoginActionListener listener);

  /**
   * Initialize.
   */
  void init(@NonNull Activity rootActivity);

  /**
   * Show message.
   *
   * @param msg message.
   *
   * @see sample.ijoic.architlifecycle.constants.LoginMessage
   */
  void showMessage(int msg);

  /**
   * Destroy.
   */
  void destroy();
}
