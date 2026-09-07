package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p40 {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9893a;
        private final et.a b;
        private final long c;

        public a(String adBreakType, et.a adBreakPositionType, long j) {
            Intrinsics.checkNotNullParameter(adBreakType, "adBreakType");
            Intrinsics.checkNotNullParameter(adBreakPositionType, "adBreakPositionType");
            this.f9893a = adBreakType;
            this.b = adBreakPositionType;
            this.c = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f9893a, aVar.f9893a) && this.b == aVar.b && this.c == aVar.c;
        }

        public final int hashCode() {
            return Long.hashCode(this.c) + ((this.b.hashCode() + (this.f9893a.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "AdBreakSignature(adBreakType=" + this.f9893a + ", adBreakPositionType=" + this.b + ", adBreakPositionValue=" + this.c + ")";
        }
    }

    public static ArrayList a(ArrayList adBreaks) {
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : adBreaks) {
            dt dtVar = (dt) obj;
            if (hashSet.add(new a(dtVar.e(), dtVar.b().a(), dtVar.b().b()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
