package com.smaato.sdk.core.util.notifier;

/* JADX INFO: loaded from: classes9.dex */
public interface ChangeNotifier<T> {

    public interface Listener<T> {
        void onNextValue(T t);
    }

    void addListener(Listener<T> listener);

    void removeListener(Listener<T> listener);
}
