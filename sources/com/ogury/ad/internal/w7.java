package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class w7 {
    public static final Boolean a(String name, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            return null;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(name));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Integer b(String name, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            return null;
        }
        try {
            return Integer.valueOf(jSONObject.getInt(name));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Long c(String name, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            return null;
        }
        try {
            return Long.valueOf(jSONObject.getLong(name));
        } catch (Exception unused) {
            return null;
        }
    }
}
