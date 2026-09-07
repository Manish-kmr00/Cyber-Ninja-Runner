package com.google.firebase.remoteconfig;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes14.dex */
public interface ConfigUpdateListener {
    void onError(@Nonnull FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(ConfigUpdate configUpdate);
}
