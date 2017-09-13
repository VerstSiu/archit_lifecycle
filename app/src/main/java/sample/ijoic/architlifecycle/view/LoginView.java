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
   * Bind resources.
   *
   * @param rootActivity root activity.
   */
  void bindRes(@NonNull Activity rootActivity);

  /**
   * Initialize.
   */
  void init();

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
