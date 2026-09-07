package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public interface InterfaceC4632h {

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.h$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReaderConfig.Rule f12088a;
        private final String b;
        private final q0 c;

        public a(ReaderConfig.Rule rule, String str, q0 q0Var) {
            this.f12088a = rule;
            this.b = str;
            this.c = q0Var;
        }

        public final String a() {
            return this.b;
        }

        public final q0 b() {
            return this.c;
        }

        public final ReaderConfig.Rule c() {
            return this.f12088a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f12088a, aVar.f12088a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            int iHashCode = this.f12088a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            q0 q0Var = this.c;
            return iHashCode2 + (q0Var != null ? q0Var.hashCode() : 0);
        }

        public String toString() {
            return "Data(rule=" + this.f12088a + ", dataHash=" + this.b + ", error=" + this.c + ')';
        }

        public /* synthetic */ a(ReaderConfig.Rule rule, String str, q0 q0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rule, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : q0Var);
        }
    }

    void a(List list);
}
