package io.appmetrica.analytics.gpllibrary.internal;

/* JADX INFO: loaded from: classes9.dex */
public interface IGplLibraryWrapper {
    void startLocationUpdates(GplLibraryWrapper.Priority priority) throws Throwable;

    void stopLocationUpdates() throws Throwable;

    void updateLastKnownLocation() throws Throwable;
}
