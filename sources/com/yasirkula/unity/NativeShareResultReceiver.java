package com.yasirkula.unity;

/* JADX INFO: loaded from: classes12.dex */
public interface NativeShareResultReceiver {
    boolean HasManagedCallback();

    void OnShareCompleted(int result, String shareTarget);
}
