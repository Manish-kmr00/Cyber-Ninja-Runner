package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes11.dex */
public interface i extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g {

    public static abstract class a {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6939a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a, reason: collision with other inner class name */
        public static final class C0652a extends a {
            public static final int e = 8;
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h c;
            public final boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0652a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h viewModel, boolean z) {
                super(z, null);
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                this.c = viewModel;
                this.d = z;
            }

            public final C0652a a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h viewModel, boolean z) {
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                return new C0652a(viewModel, z);
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h b() {
                return this.c;
            }

            public final boolean c() {
                return this.d;
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h d() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0652a)) {
                    return false;
                }
                C0652a c0652a = (C0652a) obj;
                return Intrinsics.areEqual(this.c, c0652a.c) && this.d == c0652a.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.c.hashCode() * 31;
                boolean z = this.d;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "Companion(viewModel=" + this.c + ", isLastAdPart=" + this.d + ')';
            }

            public static /* synthetic */ C0652a a(C0652a c0652a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h hVar, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    hVar = c0652a.c;
                }
                if ((i & 2) != 0) {
                    z = c0652a.d;
                }
                return c0652a.a(hVar, z);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.d;
            }
        }

        public static final class b extends a {
            public static final int e = 8;
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e c;
            public final boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e viewModel, boolean z) {
                super(z, null);
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                this.c = viewModel;
                this.d = z;
            }

            public final b a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e viewModel, boolean z) {
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                return new b(viewModel, z);
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e b() {
                return this.c;
            }

            public final boolean c() {
                return this.d;
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e d() {
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
                return Intrinsics.areEqual(this.c, bVar.c) && this.d == bVar.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.c.hashCode() * 31;
                boolean z = this.d;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "DEC(viewModel=" + this.c + ", isLastAdPart=" + this.d + ')';
            }

            public static /* synthetic */ b a(b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    eVar = bVar.c;
                }
                if ((i & 2) != 0) {
                    z = bVar.d;
                }
                return bVar.a(eVar, z);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.d;
            }
        }

        public static final class c extends a {
            public static final int e = 8;
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k c;
            public final boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k viewModel, boolean z) {
                super(z, null);
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                this.c = viewModel;
                this.d = z;
            }

            public final c a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k viewModel, boolean z) {
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                return new c(viewModel, z);
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k b() {
                return this.c;
            }

            public final boolean c() {
                return this.d;
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k d() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.c.hashCode() * 31;
                boolean z = this.d;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "Linear(viewModel=" + this.c + ", isLastAdPart=" + this.d + ')';
            }

            public static /* synthetic */ c a(c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    kVar = cVar.c;
                }
                if ((i & 2) != 0) {
                    z = cVar.d;
                }
                return cVar.a(kVar, z);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.d;
            }
        }

        public static final class d extends a {
            public static final int e = 8;
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i c;
            public final boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i viewModel, boolean z) {
                super(z, null);
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                this.c = viewModel;
                this.d = z;
            }

            public final d a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i viewModel, boolean z) {
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                return new d(viewModel, z);
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i b() {
                return this.c;
            }

            public final boolean c() {
                return this.d;
            }

            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i d() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return Intrinsics.areEqual(this.c, dVar.c) && this.d == dVar.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.c.hashCode() * 31;
                boolean z = this.d;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "Mraid(viewModel=" + this.c + ", isLastAdPart=" + this.d + ')';
            }

            public static /* synthetic */ d a(d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i iVar, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    iVar = dVar.c;
                }
                if ((i & 2) != 0) {
                    z = dVar.d;
                }
                return dVar.a(iVar, z);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.d;
            }
        }

        public /* synthetic */ a(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        public boolean a() {
            return this.f6939a;
        }

        public a(boolean z) {
            this.f6939a = z;
        }
    }

    void A();

    void B();

    StateFlow<Boolean> O();

    StateFlow<a> j();

    StateFlow<Boolean> n();

    void y();
}
