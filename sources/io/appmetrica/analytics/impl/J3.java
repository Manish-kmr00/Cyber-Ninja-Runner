package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class J3 implements L5 {
    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap mapC = AbstractC4288mb.c(asString);
        if (AbstractC4199im.a(mapC)) {
            return mapC;
        }
        Vi.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
