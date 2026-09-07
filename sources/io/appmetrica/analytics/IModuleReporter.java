package io.appmetrica.analytics;

/* JADX INFO: loaded from: classes12.dex */
public interface IModuleReporter {
    void reportAdRevenue(AdRevenue adRevenue, boolean z);

    void reportEvent(ModuleEvent moduleEvent);

    void sendEventsBuffer();

    void setSessionExtra(String str, byte[] bArr);
}
