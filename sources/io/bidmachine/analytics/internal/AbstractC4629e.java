package io.bidmachine.analytics.internal;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC4629e extends AbstractC4631g implements InterfaceC4630f {
    private InterfaceC4630f d;
    private final Object e = new Object();
    private final Map f = new LinkedHashMap();
    private b g;

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.e$a */
    public enum a {
        UNSPECIFIED,
        BANNER,
        INTERSTITIAL,
        REWARDED,
        NATIVE
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.e$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12084a;
        private final float b;
        private final String c;
        private final float d;

        public b(int i, float f, String str) {
            this.f12084a = i;
            this.b = f;
            this.c = str;
            this.d = f * 1000;
        }

        public final b a(int i, float f, String str) {
            return new b(i, f, str);
        }

        public final float b() {
            return this.d;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12084a == bVar.f12084a && Float.compare(this.b, bVar.b) == 0 && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f12084a) * 31) + Float.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return super.toString();
        }

        public /* synthetic */ b(int i, float f, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, f, str);
        }

        public static /* synthetic */ b a(b bVar, int i, float f, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = bVar.f12084a;
            }
            if ((i2 & 2) != 0) {
                f = bVar.b;
            }
            if ((i2 & 4) != 0) {
                str = bVar.c;
            }
            return bVar.a(i, f, str);
        }

        public final int a() {
            return this.f12084a;
        }
    }

    public final b a(a aVar) {
        b bVar;
        synchronized (this.e) {
            bVar = (b) this.f.get(aVar);
        }
        return bVar;
    }

    public final b b() {
        b bVar;
        synchronized (this.e) {
            bVar = this.g;
        }
        return bVar;
    }

    public abstract b b(Map map);

    public abstract a c(Map map);

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        synchronized (this.e) {
            this.f.clear();
            this.g = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a(AbstractC4631g.a aVar) {
        this.d = aVar.a();
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC4630f
    public void a(Map map) {
        b bVarB;
        InterfaceC4630f interfaceC4630f = this.d;
        if (interfaceC4630f != null) {
            interfaceC4630f.a(map);
        }
        a aVarC = c(map);
        if (aVarC == null || (bVarB = b(map)) == null) {
            return;
        }
        synchronized (this.e) {
            b bVar = this.g;
            this.g = b.a(bVarB, (bVar != null ? bVar.a() : 0) + 1, 0.0f, null, 6, null);
            b bVar2 = (b) this.f.get(aVarC);
            this.f.put(aVarC, bVar2 == null ? b.a(bVarB, 1, 0.0f, null, 6, null) : b.a(bVarB, bVar2.a() + 1, 0.0f, null, 6, null));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC4630f
    public void a(q0 q0Var) {
        InterfaceC4630f interfaceC4630f = this.d;
        if (interfaceC4630f != null) {
            interfaceC4630f.a(q0Var);
        }
    }
}
