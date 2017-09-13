package sample.ijoic.architlifecycle.ui;

import android.support.annotation.Nullable;

/**
 * Login ui.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface LoginUI {
  /**
   * Returns username.
   */
  @Nullable
  String getUsername();

  /**
   * Returns password.
   */
  @Nullable
  String getPassword();

  /**
   * Show message.
   *
   * @param msg message.
   *
   * @see sample.ijoic.architlifecycle.constants.LoginMessage
   */
  void showMessage(int msg);
}
