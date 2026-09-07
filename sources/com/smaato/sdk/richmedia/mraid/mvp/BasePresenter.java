package com.smaato.sdk.richmedia.mraid.mvp;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.mraid.mvp.BaseView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public abstract class BasePresenter<T extends BaseView> implements Presenter<T> {
    private WeakReference weakView = new WeakReference(null);

    @Override // com.smaato.sdk.richmedia.mraid.mvp.Presenter
    public void attachView(T t) {
        Threads.ensureMainThread();
        this.weakView = new WeakReference(t);
    }

    @Override // com.smaato.sdk.richmedia.mraid.mvp.Presenter
    public void detachView() {
        Threads.ensureMainThread();
        this.weakView.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void ifViewAttached(Consumer<T> consumer) {
        Objects.requireNonNull(consumer);
        Threads.ensureMainThread();
        BaseView baseView = (BaseView) this.weakView.get();
        if (baseView != null) {
            consumer.accept(baseView);
        }
    }
}
