package io.appmetrica.analytics.networktasks.internal;

/* JADX INFO: loaded from: classes13.dex */
public interface HostRetryInfoProvider {
    long getLastAttemptTimeSeconds();

    int getNextSendAttemptNumber();

    void saveLastAttemptTimeSeconds(long j);

    void saveNextSendAttemptNumber(int i);
}
