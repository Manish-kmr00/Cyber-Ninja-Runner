package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class r52 implements jm {
    public static final jm.a<r52> g = new jm.a() { // from class: com.yandex.mobile.ads.impl.r52$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return r52.a(bundle);
        }
    };
    public final int b;
    public final String c;
    public final int d;
    private final gc0[] e;
    private int f;

    public r52(String str, gc0... gc0VarArr) {
        hg.a(gc0VarArr.length > 0);
        this.c = str;
        this.e = gc0VarArr;
        this.b = gc0VarArr.length;
        int iC = s01.c(gc0VarArr[0].m);
        this.d = iC == -1 ? s01.c(gc0VarArr[0].l) : iC;
        a();
    }

    public final gc0 a(int i) {
        return this.e[i];
    }

    public final int hashCode() {
        if (this.f == 0) {
            this.f = v3.a(this.c, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31) + Arrays.hashCode(this.e);
        }
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r52.class != obj.getClass()) {
            return false;
        }
        r52 r52Var = (r52) obj;
        return this.c.equals(r52Var.c) && Arrays.equals(this.e, r52Var.e);
    }

    public final int a(gc0 gc0Var) {
        int i = 0;
        while (true) {
            gc0[] gc0VarArr = this.e;
            if (i >= gc0VarArr.length) {
                return -1;
            }
            if (gc0Var == gc0VarArr[i]) {
                return i;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r52 a(Bundle bundle) {
        hk0 hk0VarA;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        if (parcelableArrayList == null) {
            hk0VarA = hk0.h();
        } else {
            hk0VarA = km.a(gc0.I, parcelableArrayList);
        }
        return new r52(bundle.getString(Integer.toString(1, 36), ""), (gc0[]) hk0VarA.toArray(new gc0[0]));
    }

    private void a() {
        String str = this.e[0].d;
        if (str == null || str.equals("und")) {
            str = "";
        }
        int i = this.e[0].f | 16384;
        int i2 = 1;
        while (true) {
            gc0[] gc0VarArr = this.e;
            if (i2 >= gc0VarArr.length) {
                return;
            }
            String str2 = gc0VarArr[i2].d;
            if (str2 == null || str2.equals("und")) {
                str2 = "";
            }
            if (!str.equals(str2)) {
                gc0[] gc0VarArr2 = this.e;
                at0.a("TrackGroup", "", new IllegalStateException("Different languages combined in one TrackGroup: '" + gc0VarArr2[0].d + "' (track 0) and '" + gc0VarArr2[i2].d + "' (track " + i2 + ")"));
                return;
            }
            gc0[] gc0VarArr3 = this.e;
            if (i != (gc0VarArr3[i2].f | 16384)) {
                at0.a("TrackGroup", "", new IllegalStateException("Different role flags combined in one TrackGroup: '" + Integer.toBinaryString(gc0VarArr3[0].f) + "' (track 0) and '" + Integer.toBinaryString(this.e[i2].f) + "' (track " + i2 + ")"));
                return;
            }
            i2++;
        }
    }
}
