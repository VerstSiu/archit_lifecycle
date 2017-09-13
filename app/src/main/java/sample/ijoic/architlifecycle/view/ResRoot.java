package sample.ijoic.architlifecycle.view;

import android.support.annotation.NonNull;

/**
 * Res root.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface ResRoot<T> {
  /**
   * Bind res.
   *
   * @param root root.
   */
  void bindRes(@NonNull T root);
}
