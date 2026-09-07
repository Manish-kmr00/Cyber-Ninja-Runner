package io.appmetrica.analytics.impl;

import android.location.Location;

/* JADX INFO: loaded from: classes2.dex */
public interface Nc {
    void a(Location location);

    void a(String str, String str2);

    void a(boolean z);

    void b(boolean z);

    void clearAppEnvironment();

    void putAppEnvironmentValue(String str, String str2);

    void setDataSendingEnabled(boolean z);

    void setUserProfileID(String str);
}
