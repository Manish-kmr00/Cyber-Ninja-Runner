package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.j5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3423j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3345a;
    public final JSONArray b;
    public final C3368f6 c;

    public C3423j5(JSONObject vitals, JSONArray logs, C3368f6 data) {
        Intrinsics.checkNotNullParameter(vitals, "vitals");
        Intrinsics.checkNotNullParameter(logs, "logs");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f3345a = vitals;
        this.b = logs;
        this.c = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3423j5)) {
            return false;
        }
        C3423j5 c3423j5 = (C3423j5) obj;
        return Intrinsics.areEqual(this.f3345a, c3423j5.f3345a) && Intrinsics.areEqual(this.b, c3423j5.b) && Intrinsics.areEqual(this.c, c3423j5.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f3345a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "IncompleteLogData(vitals=" + this.f3345a + ", logs=" + this.b + ", data=" + this.c + ')';
    }
}
