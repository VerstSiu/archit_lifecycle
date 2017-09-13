package sample.ijoic.architlifecycle.view.impl;

import android.support.annotation.NonNull;

import sample.ijoic.architlifecycle.view.StateView;

/**
 * Base state view impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public abstract class BaseStateViewImpl<VM> implements StateView {

  private final VM viewModel;

  /**
   * Constructor.
   *
   * @param viewModel view model.
   */
  public BaseStateViewImpl(@NonNull VM viewModel) {
    this.viewModel = viewModel;
  }

  /**
   * Returns view model.
   */
  @NonNull
  public VM getViewModel() {
    return viewModel;
  }

}
