package sample.ijoic.architlifecycle.view;

import android.support.annotation.NonNull;

/**
 * State view.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface StateView<ROOT> {
  /**
   * Bind res.
   *
   * @param root root.
   */
  void bindRes(@NonNull ROOT root);

  /**
   * Initialize.
   */
  void init();

  /**
   * Destroy.
   */
  void destroy();

}
