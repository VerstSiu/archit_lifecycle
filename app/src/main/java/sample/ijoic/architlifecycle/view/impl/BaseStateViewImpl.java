package sample.ijoic.architlifecycle.view.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sample.ijoic.architlifecycle.view.StateView;

/**
 * Base state view impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public abstract class BaseStateViewImpl<VM, ROOT> implements StateView<ROOT> {

  private final VM viewModel;

  private ROOT root;
  private boolean viewReady;

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

  @Override
  public final void bindRes(@NonNull ROOT root) {
    this.root = root;
  }

  @Nullable
  public final ROOT getRoot() {
    return root;
  }

  @Override
  public final void init() {
    ROOT root = this.root;
    viewReady = false;

    if (root == null) {
      return;
    }
    onInit(root);
    viewReady = true;
  }

  /**
   * Init callback.
   *
   * @param root root.
   */
  protected abstract void onInit(@NonNull ROOT root);

  @Override
  public final void destroy() {
    root = null;
    viewReady = false;
  }

  /**
   * Destroy callback.
   */
  protected void onDestroy() {
  }

  /**
   * Returns view ready status.
   */
  protected boolean isViewReady() {
    return viewReady;
  }

}
