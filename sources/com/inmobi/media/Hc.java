package com.inmobi.media;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class Hc {
    public static final List h = CollectionsKt.listOf((Object[]) new String[]{"image/jpeg", "image/png", "image/jpg"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3091a;
    public final int b;
    public final String d;
    public boolean g;
    public String c = null;
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();

    public Hc(int i, int i2, String str) {
        this.f3091a = i;
        this.b = i2;
        this.d = str;
    }

    public final ArrayList a(int i) {
        ArrayList arrayList = new ArrayList();
        for (Gc gc : this.e) {
            if (gc.f3084a == i) {
                arrayList.add(gc);
            }
        }
        return arrayList;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.d;
            if (str != null) {
                jSONObject.put("id", str);
            }
            jSONObject.put("width", this.f3091a);
            jSONObject.put("height", this.b);
            jSONObject.put("clickThroughUrl", this.c);
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Gc) it.next()).toString());
            }
            jSONObject.put("resources", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((C3328c8) it2.next()).toString());
            }
            jSONObject.put(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, jSONArray2);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("Hc", "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return "";
        }
    }

    public final ArrayList a(String trackerEventType) {
        Intrinsics.checkNotNullParameter(trackerEventType, "trackerEventType");
        ArrayList arrayList = new ArrayList();
        for (C3328c8 c3328c8 : this.f) {
            if (Intrinsics.areEqual(c3328c8.b, trackerEventType)) {
                arrayList.add(c3328c8);
            }
        }
        return arrayList;
    }
}
