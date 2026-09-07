package com.smaato.sdk.core.util.notifier;

/* JADX INFO: loaded from: classes12.dex */
public interface ChangeSender<T> extends ChangeNotifier<T> {
    T getValue();

    void newValue(T t);
}
