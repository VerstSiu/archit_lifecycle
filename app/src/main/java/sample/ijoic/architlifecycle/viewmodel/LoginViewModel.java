package sample.ijoic.architlifecycle.viewmodel;

import android.support.annotation.NonNull;

import sample.ijoic.architlifecycle.ui.LoginUI;

/**
 * Login view model.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface LoginViewModel {

  /**
   * Login.
   *
   * @param loginUI login ui.
   */
  void login(@NonNull LoginUI loginUI);

}
