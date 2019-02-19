package com.example.allen.allenbasemvp.base;

/**
 * Created by allen on 2018/12/25.
 */
public class Contract<V,P,VH,M> {
    private V view;
    private P presenter;
    private VH viewHolder;
    private M model;

    public Contract(V view, P presenter, VH viewHolder, M model) {
        this.view = view;
        this.presenter = presenter;
        this.viewHolder = viewHolder;
        this.model = model;
    }

    public V getView() {
        return view;
    }

    public P getPresenter() {
        return presenter;
    }

    public VH getViewHolder() {
        return viewHolder;
    }

    public M getModel() {
        return model;
    }
}
