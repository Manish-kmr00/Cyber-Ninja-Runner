package com.pubmatic.sdk.crashanalytics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashStorage;", "", "<init>", "()V", "", "clear", "Lorg/json/JSONArray;", "a", "Lorg/json/JSONArray;", "getCrashJsonArray", "()Lorg/json/JSONArray;", "setCrashJsonArray", "(Lorg/json/JSONArray;)V", "crashJsonArray", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBCrashStorage {
    public static final POBCrashStorage INSTANCE = new POBCrashStorage();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static JSONArray crashJsonArray = new JSONArray();

    private POBCrashStorage() {
    }

    public final void clear() {
        crashJsonArray = new JSONArray();
    }

    public final JSONArray getCrashJsonArray() {
        return crashJsonArray;
    }

    public final void setCrashJsonArray(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
        crashJsonArray = jSONArray;
    }
}
