package io.bidmachine.analytics.internal;

import java.text.ParseException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class F {
    public static final a c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Regex f12044a = new Regex("^(\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) ([A-Z])\\/(\\S+)\\(\\s*(\\d+)\\): (.*)$");
    private final N b = new N();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12045a;
        private final String b;
        private final String c;
        private final String d;

        public b(long j, String str, String str2, String str3) {
            this.f12045a = j;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public final String a() {
            return this.c;
        }

        public final String b() {
            return this.d;
        }

        public final String c() {
            return this.b;
        }

        public final long d() {
            return this.f12045a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12045a == bVar.f12045a && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f12045a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return super.toString();
        }
    }

    public final b a(String str) throws ParseException {
        MatchResult matchResultFind$default = Regex.find$default(this.f12044a, str, 0, 2, null);
        if (matchResultFind$default == null) {
            return null;
        }
        MatchResult.Destructured destructured = matchResultFind$default.getDestructured();
        String str2 = destructured.getMatch().getGroupValues().get(1);
        String str3 = destructured.getMatch().getGroupValues().get(2);
        String str4 = destructured.getMatch().getGroupValues().get(3);
        String str5 = destructured.getMatch().getGroupValues().get(5);
        Long lA = this.b.a(str2);
        return new b(lA != null ? lA.longValue() : 0L, str4, str3, str5);
    }
}
