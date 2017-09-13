package sample.ijoic.architlifecycle.view.impl;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sample.ijoic.architlifecycle.view.ActivityStateView;

/**
 * Base activity state view impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public abstract class BaseActivityStateViewImpl<VM> extends BaseStateViewImpl<VM> implements ActivityStateView {

  private Activity rootActivity;
  private boolean viewReady;

  /**
   * Constructor.
   *
   * @param viewModel view model.
   */
  public BaseActivityStateViewImpl(@NonNull VM viewModel) {
    super(viewModel);
  }

  @Override
  public final void bindRes(@NonNull Activity rootActivity) {
    this.rootActivity = rootActivity;
  }

  @Nullable
  public final Activity getRootActivity() {
    return rootActivity;
  }

  @Override
  public final void init() {
    Activity rootActivity = this.rootActivity;
    viewReady = false;

    if (rootActivity == null) {
      return;
    }
    onInit(rootActivity);
    viewReady = true;
  }

  /**
   * Init callback.
   *
   * @param rootActivity root activity.
   */
  protected abstract void onInit(@NonNull Activity rootActivity);

  @Override
  public final void destroy() {
    rootActivity = null;
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
