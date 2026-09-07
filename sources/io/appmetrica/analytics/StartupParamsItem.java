package io.appmetrica.analytics;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class StartupParamsItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10924a;
    private final StartupParamsItemStatus b;
    private final String c;

    public StartupParamsItem(String str, StartupParamsItemStatus startupParamsItemStatus, String str2) {
        this.f10924a = str;
        this.b = startupParamsItemStatus;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StartupParamsItem.class != obj.getClass()) {
            return false;
        }
        StartupParamsItem startupParamsItem = (StartupParamsItem) obj;
        return Objects.equals(this.f10924a, startupParamsItem.f10924a) && this.b == startupParamsItem.b && Objects.equals(this.c, startupParamsItem.c);
    }

    public String getErrorDetails() {
        return this.c;
    }

    public String getId() {
        return this.f10924a;
    }

    public StartupParamsItemStatus getStatus() {
        return this.b;
    }

    public int hashCode() {
        return Objects.hash(this.f10924a, this.b, this.c);
    }

    public String toString() {
        return "StartupParamsItem{id='" + this.f10924a + "', status=" + this.b + ", errorDetails='" + this.c + "'}";
    }
}
