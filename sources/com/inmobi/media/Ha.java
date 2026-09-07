package com.inmobi.media;

/* JADX INFO: loaded from: classes6.dex */
public final class Ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3090a;

    public Ha(int i) {
        this.f3090a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ha) && this.f3090a == ((Ha) obj).f3090a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3090a);
    }

    public final String toString() {
        return "RenderViewTelemetryData(maxTemplateEvents=" + this.f3090a + ')';
    }
}
