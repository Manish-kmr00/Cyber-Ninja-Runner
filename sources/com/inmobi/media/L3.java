package com.inmobi.media;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class L3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3122a;
    public final String b;

    public L3(ArrayList eventIDs, String payload) {
        Intrinsics.checkNotNullParameter(eventIDs, "eventIDs");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.f3122a = eventIDs;
        this.b = payload;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L3)) {
            return false;
        }
        L3 l3 = (L3) obj;
        return Intrinsics.areEqual(this.f3122a, l3.f3122a) && Intrinsics.areEqual(this.b, l3.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() + (this.f3122a.hashCode() * 31)) * 31;
    }

    public final String toString() {
        return "EventPayload(eventIDs=" + this.f3122a + ", payload=" + this.b + ", shouldFlushOnFailure=false)";
    }
}
