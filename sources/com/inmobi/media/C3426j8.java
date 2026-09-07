package com.inmobi.media;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: renamed from: com.inmobi.media.j8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3426j8 extends C3455l7 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public int D;
    public int E;
    public HashMap F;
    public final boolean x;
    public final ArrayList y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3426j8(String assetId, String assetName, C3412i8 assetStyle, Rc rc, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ArrayList arrayList, boolean z6) {
        super(assetId, assetName, ShareConstants.VIDEO_URL, assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        this.x = z6;
        this.e = rc;
        Intrinsics.checkNotNullParameter("EXTERNAL", "<set-?>");
        this.g = "EXTERNAL";
        this.z = z;
        this.A = z2;
        this.B = z3;
        this.C = z4;
        this.y = new ArrayList();
        Map map = null;
        this.p = rc != null ? ((Qc) rc).k : null;
        ArrayList<C3328c8> trackers = rc != null ? ((Qc) rc).h : null;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C3328c8 c3328c8 = (C3328c8) it.next();
                if (Intrinsics.areEqual("OMID_VIEWABILITY", c3328c8.b)) {
                    map = c3328c8.c;
                    if (!TextUtils.isEmpty(c3328c8.d) && TypeIntrinsics.isMutableList(trackers)) {
                        trackers.add(c3328c8);
                    }
                } else if (TypeIntrinsics.isMutableList(trackers)) {
                    trackers.add(c3328c8);
                }
            }
        }
        if (trackers != null) {
            for (C3328c8 c3328c9 : trackers) {
                if (Intrinsics.areEqual("OMID_VIEWABILITY", c3328c9.b)) {
                    c3328c9.c = map;
                }
            }
        }
        if (trackers != null && !trackers.isEmpty()) {
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.s.addAll(trackers);
        }
        HashMap map2 = this.t;
        map2.put("placementType", (byte) 0);
        map2.put("lastVisibleTimestamp", Integer.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        map2.put(VastAttributes.VISIBLE, bool);
        map2.put("seekPosition", 0);
        map2.put("didStartPlaying", bool);
        map2.put("didPause", bool);
        map2.put("didCompleteQ1", bool);
        map2.put("didCompleteQ2", bool);
        map2.put("didCompleteQ3", bool);
        map2.put("didCompleteQ4", bool);
        map2.put("didRequestFullScreen", bool);
        map2.put("isFullScreen", bool);
        map2.put("didImpressionFire", bool);
        map2.put("mapViewabilityParams", new HashMap());
        map2.put("didSignalVideoCompleted", bool);
        map2.put("shouldAutoPlay", Boolean.valueOf(z5));
        map2.put("lastMediaVolume", 0);
        map2.put("currentMediaVolume", 0);
        map2.put("didQ4Fire", bool);
    }

    public final void a(HashMap map) {
        this.F = new HashMap(map);
    }

    public final int b() {
        return this.D;
    }

    public final boolean c() {
        if (this.x) {
            return this.z && !C3517pb.o();
        }
        return this.z;
    }

    public final void d(int i) {
        this.E = i;
    }

    public final void a(C3426j8 source) {
        HashMap map;
        Intrinsics.checkNotNullParameter(source, "source");
        this.t.putAll(source.t);
        HashMap map2 = source.F;
        if (map2 != null && (map = this.F) != null) {
            map.putAll(map2);
        }
        ArrayList trackers = source.s;
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.s.addAll(trackers);
    }

    public final Rc d() {
        Object obj = this.e;
        if (obj instanceof Rc) {
            return (Rc) obj;
        }
        return null;
    }

    public final void c(int i) {
        this.D = i;
    }
}
