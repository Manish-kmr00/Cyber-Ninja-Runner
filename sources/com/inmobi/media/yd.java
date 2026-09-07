package com.inmobi.media;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3489a;
    public final int b;
    public final int c;
    public final int d;

    public yd(int i, int i2, int i3, int i4) {
        this.f3489a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("left", AbstractC3420j2.a(this.f3489a));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, AbstractC3420j2.a(this.b));
            jSONObject.put("right", AbstractC3420j2.a(this.c));
            jSONObject.put("bottom", AbstractC3420j2.a(this.d));
            return jSONObject;
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return new JSONObject();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yd)) {
            return false;
        }
        yd ydVar = (yd) obj;
        return this.f3489a == ydVar.f3489a && this.b == ydVar.b && this.c == ydVar.c && this.d == ydVar.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f3489a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Insets(left=" + this.f3489a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
    }
}
