package sample.ijoic.architlifecycle.presenter.impl;

import android.support.annotation.NonNull;

import sample.ijoic.architlifecycle.presenter.StatePresenter;

/**
 * Base state presenter impl.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public abstract class BaseStatePresenterImpl<V, M> implements StatePresenter {

  private final V view;
  private final M model;

  /**
   * Constructor.
   *
   * @param view view.
   * @param model model.
   */
  public BaseStatePresenterImpl(@NonNull V view, @NonNull M model) {
    this.view = view;
    this.model = model;
  }

  /**
   * Returns view.
   */
  @NonNull
  public final V getView() {
    return view;
  }

  /**
   * Returns model.
   */
  @NonNull
  public final M getModel() {
    return model;
  }

}
