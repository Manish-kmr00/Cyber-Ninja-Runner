package com.inmobi.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.l7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public class C3455l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3369a;
    public final String b;
    public final String c;
    public final C3471m7 d;
    public Object e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public int n;
    public int o;
    public String p;
    public String q;
    public C3513p7 r;
    public final ArrayList s;
    public final HashMap t;
    public Object u;
    public int v;
    public C3455l7 w;

    public C3455l7(String assetId, String assetName, String assetType, C3471m7 assetStyle, List trackers) {
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.f3369a = assetId;
        this.b = assetName;
        this.c = assetType;
        this.d = assetStyle;
        this.g = "NO_ACTION";
        this.h = "";
        this.m = (byte) 2;
        this.n = -1;
        this.p = "";
        this.q = "";
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        this.t = new HashMap();
        arrayList.addAll(trackers);
    }

    public static void a(C3328c8 tracker, HashMap map, T6 t6, L4 l4) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        String str = tracker.d;
        boolean z = W8.f3228a;
        C3364f2.f3308a.a(W8.a(str, map), tracker.c, true, t6, B9.b, l4);
    }

    public static void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final void b(byte b) {
        this.m = b;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void b(String str) {
        String string;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            string = str.subSequence(i, length + 1).toString();
        } else {
            string = null;
        }
        this.p = string;
    }

    public final void a(byte b) {
        this.j = b;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(C3513p7 c3513p7) {
        this.r = c3513p7;
    }

    public final HashMap a() {
        return this.t;
    }

    public final void a(String eventType, HashMap map, T6 t6, L4 l4) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        for (C3328c8 c3328c8 : this.s) {
            if (Intrinsics.areEqual(eventType, c3328c8.b)) {
                a(c3328c8, map, t6, l4);
            }
        }
    }

    public final void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) value.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        this.q = value.subSequence(i, length + 1).toString();
    }

    public /* synthetic */ C3455l7(String str, String str2, String str3, C3471m7 c3471m7, int i) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "root" : str2, (i & 4) != 0 ? "CONTAINER" : str3, (i & 8) != 0 ? new C3471m7() : c3471m7, new LinkedList());
    }
}
