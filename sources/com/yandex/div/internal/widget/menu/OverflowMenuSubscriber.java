package com.yandex.div.internal.widget.menu;

/* JADX INFO: loaded from: classes5.dex */
public interface OverflowMenuSubscriber {

    public interface Listener {
        void dismiss();
    }

    void subscribe(Listener listener);
}
