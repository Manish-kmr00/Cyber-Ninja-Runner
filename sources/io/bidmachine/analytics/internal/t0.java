package io.bidmachine.analytics.internal;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class t0 implements Comparable {
    public static final a d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12176a;
    private final int b;
    private final int c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t0 a(String str) {
            Object objM7904constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (StringsKt.isBlank(str)) {
                    return null;
                }
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
                if (listSplit$default.isEmpty()) {
                    return null;
                }
                int size = listSplit$default.size();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i < size && i <= 6) {
                    if (i == 0) {
                        i2 = Integer.parseInt((String) listSplit$default.get(0));
                    } else if (i != 1) {
                        i4 = i != 2 ? (i4 * 100) + Integer.parseInt((String) listSplit$default.get(i)) : Integer.parseInt((String) listSplit$default.get(2));
                    } else {
                        i3 = Integer.parseInt((String) listSplit$default.get(1));
                    }
                    i++;
                }
                objM7904constructorimpl = Result.m7904constructorimpl(new t0(i2, i3, i4));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            return (t0) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
        }
    }

    public t0(int i, int i2, int i3) {
        this.f12176a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(t0 t0Var) {
        int iCompare = Intrinsics.compare(this.f12176a, t0Var.f12176a);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Intrinsics.compare(this.b, t0Var.b);
        return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(this.c, t0Var.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f12176a == t0Var.f12176a && this.b == t0Var.b && this.c == t0Var.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f12176a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return new StringBuilder().append(this.f12176a).append('.').append(this.b).append('.').append(this.c).toString();
    }
}
