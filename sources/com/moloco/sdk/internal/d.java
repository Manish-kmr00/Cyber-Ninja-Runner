package com.moloco.sdk.internal;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.moloco.sdk.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6080a = LazyKt.lazy(a.f6081a);
    public static final long b = Color.INSTANCE.m1668getWhite0d7_KjU();
    public static final long c = u.a();
    public static final int d = 30;
    public static final long e;

    public static final class a extends Lambda implements Function0<com.moloco.sdk.internal.ortb.model.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6081a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.o invoke() {
            long j = d.c;
            int iM8001constructorimpl = UInt.m8001constructorimpl(30);
            com.moloco.sdk.internal.ortb.model.l lVar = com.moloco.sdk.internal.ortb.model.l.End;
            com.moloco.sdk.internal.ortb.model.u uVar = com.moloco.sdk.internal.ortb.model.u.Top;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 10;
            Color color = null;
            com.moloco.sdk.internal.ortb.model.s sVar = new com.moloco.sdk.internal.ortb.model.s(5, i, iM8001constructorimpl, lVar, uVar, j, color, 64, defaultConstructorMarker);
            int i2 = 0;
            boolean z = false;
            UInt uInt = null;
            boolean z2 = false;
            boolean z3 = false;
            String str = null;
            com.moloco.sdk.internal.ortb.model.i iVar = null;
            return new com.moloco.sdk.internal.ortb.model.o(sVar, sVar, new com.moloco.sdk.internal.ortb.model.p(i2, com.moloco.sdk.internal.ortb.model.l.Center, com.moloco.sdk.internal.ortb.model.u.Bottom, d.c, null), new com.moloco.sdk.internal.ortb.model.n(z, i, com.moloco.sdk.internal.ortb.model.l.Start, uVar, j, uInt, color, 96, defaultConstructorMarker), (com.moloco.sdk.internal.ortb.model.g) null, true, new com.moloco.sdk.internal.ortb.model.a(z2, z3, str, 6, (DefaultConstructorMarker) null), (com.moloco.sdk.internal.ortb.model.t) null, (com.moloco.sdk.internal.ortb.model.j) (0 == true ? 1 : 0), iVar, 384, (DefaultConstructorMarker) null);
        }
    }

    public static final class b extends Lambda implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.s f6082a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.ortb.model.s sVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(2);
            this.f6082a = sVar;
            this.b = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(113929444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113929444, i, -1, "com.moloco.sdk.internal.determineSkipCloseBehaviorFromDec.<anonymous> (AggregatedOptions.kt:181)");
            }
            float fM3843constructorimpl = Dp.m3843constructorimpl(this.f6082a.c());
            long jM3865DpSizeYgX7TsA = DpKt.m3865DpSizeYgX7TsA(fM3843constructorimpl, fM3843constructorimpl);
            Alignment alignmentA = d.a(this.f6082a.i(), this.f6082a.m());
            PaddingValues paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(this.f6082a.k()));
            long jG = this.f6082a.g();
            long sp = TextUnitKt.getSp(this.f6082a.c());
            TextUnitKt.m4037checkArithmeticR2X_6o(sp);
            long jPack = TextUnitKt.pack(TextUnit.m4022getRawTypeimpl(sp), TextUnit.m4024getValueimpl(sp) / 2);
            long jM3946timesGh9hcWk = DpSize.m3946timesGh9hcWk(jM3865DpSizeYgX7TsA, 0.4f);
            Color colorA = this.f6082a.a();
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(alignmentA, paddingValuesM416PaddingValues0680j_4, jG, jM3865DpSizeYgX7TsA, jPack, d.b(jM3946timesGh9hcWk, colorA != null ? colorA.m1641unboximpl() : d.b, composer, 0), null, this.b, composer, 0, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class c extends Lambda implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f6083a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.s b;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, com.moloco.sdk.internal.ortb.model.s sVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(2);
            this.f6083a = z;
            this.b = sVar;
            this.c = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A;
            composer.startReplaceableGroup(-1451072431);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451072431, i, -1, "com.moloco.sdk.internal.toCloseButton.<anonymous> (AggregatedOptions.kt:199)");
            }
            if (this.f6083a) {
                function10A = null;
            } else {
                float fM3843constructorimpl = Dp.m3843constructorimpl(this.b.c());
                long jM3865DpSizeYgX7TsA = DpKt.m3865DpSizeYgX7TsA(fM3843constructorimpl, fM3843constructorimpl);
                Alignment alignmentA = d.a(this.b.i(), this.b.m());
                PaddingValues paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(this.b.k()));
                long jG = this.b.g();
                long sp = TextUnitKt.getSp(this.b.c());
                TextUnitKt.m4037checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m4022getRawTypeimpl(sp), TextUnit.m4024getValueimpl(sp) / 2);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.moloco_close, composer, 0);
                long jM3946timesGh9hcWk = DpSize.m3946timesGh9hcWk(jM3865DpSizeYgX7TsA, 0.45f);
                Color colorA = this.b.a();
                function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(alignmentA, paddingValuesM416PaddingValues0680j_4, jG, jM3865DpSizeYgX7TsA, jPack, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(painterPainterResource, jM3946timesGh9hcWk, null, colorA != null ? colorA.m1641unboximpl() : d.b, composer, 8, 4), null, this.c, composer, 0, 64);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.d$d, reason: collision with other inner class name */
    public static final class C0532d extends Lambda implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f6084a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0532d(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f6084a = oVar;
        }

        public final Function7<BoxScope, Boolean, Boolean, Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            long jM3865DpSizeYgX7TsA;
            composer.startReplaceableGroup(-540184598);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-540184598, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:76)");
            }
            UInt uIntC = this.f6084a.k().c();
            if (uIntC != null) {
                float fM3843constructorimpl = Dp.m3843constructorimpl(uIntC.getData());
                jM3865DpSizeYgX7TsA = DpKt.m3865DpSizeYgX7TsA(fM3843constructorimpl, fM3843constructorimpl);
            } else {
                jM3865DpSizeYgX7TsA = d.e;
            }
            Alignment alignmentA = d.a(this.f6084a.k().g(), this.f6084a.k().m());
            PaddingValues paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(this.f6084a.k().k()));
            long jM3946timesGh9hcWk = DpSize.m3946timesGh9hcWk(jM3865DpSizeYgX7TsA, 0.6f);
            long jE = this.f6084a.k().e();
            Color colorA = this.f6084a.k().a();
            Function7<BoxScope, Boolean, Boolean, Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(jM3865DpSizeYgX7TsA, jM3946timesGh9hcWk, null, colorA != null ? colorA.m1641unboximpl() : d.b, alignmentA, paddingValuesM416PaddingValues0680j_4, jE, PainterResources_androidKt.painterResource(R.drawable.moloco_volume_off, composer, 0), PainterResources_androidKt.painterResource(R.drawable.moloco_volume_on, composer, 0), null, composer, 150994944, IronSourceConstants.SDK_INIT_SUCCESS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function7A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class e extends Lambda implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f6085a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f6085a = oVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A;
            composer.startReplaceableGroup(-1721735675);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1721735675, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:91)");
            }
            com.moloco.sdk.internal.ortb.model.s sVarO = this.f6085a.o();
            if (sVarO == null) {
                function10A = null;
            } else {
                com.moloco.sdk.internal.ortb.model.o oVar = this.f6085a;
                float fM3843constructorimpl = Dp.m3843constructorimpl(sVarO.c());
                long jM3865DpSizeYgX7TsA = DpKt.m3865DpSizeYgX7TsA(fM3843constructorimpl, fM3843constructorimpl);
                Alignment alignmentA = d.a(sVarO.i(), sVarO.m());
                PaddingValues paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(sVarO.k()));
                long jG = sVarO.g();
                long sp = TextUnitKt.getSp(sVarO.c());
                TextUnitKt.m4037checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m4022getRawTypeimpl(sp), TextUnit.m4024getValueimpl(sp) / 2);
                long jM3946timesGh9hcWk = DpSize.m3946timesGh9hcWk(jM3865DpSizeYgX7TsA, 0.4f);
                Color colorA = sVarO.a();
                function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(alignmentA, paddingValuesM416PaddingValues0680j_4, jG, jM3865DpSizeYgX7TsA, jPack, d.b(jM3946timesGh9hcWk, colorA != null ? colorA.m1641unboximpl() : d.b, composer, 0), null, oVar.e(), composer, 0, 64);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class f extends Lambda implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f6086a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f6086a = z;
            this.b = oVar;
        }

        public final Function7<BoxScope, Boolean, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            Function7<BoxScope, Boolean, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> function7A;
            com.moloco.sdk.internal.ortb.model.g gVarG;
            composer.startReplaceableGroup(-937155833);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-937155833, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:109)");
            }
            if (this.f6086a || (gVarG = this.b.g()) == null) {
                function7A = null;
            } else {
                Alignment alignmentA = d.a(gVarG.e(), gVarG.m());
                PaddingValues paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(gVarG.i()));
                String strK = gVarG.k();
                long jC = gVarG.c();
                Color colorA = gVarG.a();
                function7A = u.a(alignmentA, paddingValuesM416PaddingValues0680j_4, strK, jC, colorA != null ? colorA.m1641unboximpl() : u.a(), gVarG.g(), composer, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function7A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class g extends Lambda implements Function2<Composer, Integer, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f6087a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z, com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f6087a = z;
            this.b = oVar;
        }

        public final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Composer composer, int i) {
            com.moloco.sdk.internal.ortb.model.p pVarM;
            composer.startReplaceableGroup(-590534265);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-590534265, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:127)");
            }
            Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5A = (this.f6087a || (pVarM = this.b.m()) == null) ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(d.a(pVarM.c(), pVarM.g()), PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(pVarM.e())), pVarM.a(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function5A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class h extends Lambda implements Function2<Composer, Integer, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f6088a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f6088a = oVar;
        }

        public final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-1028492539);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1028492539, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:141)");
            }
            com.moloco.sdk.internal.ortb.model.t tVarQ = this.f6088a.q();
            composer.startReplaceableGroup(656099296);
            Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> function6A = tVarQ == null ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(d.a(tVarQ.a(), tVarQ.e()), PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(tVarQ.c())), composer, 0, 0);
            composer.endReplaceableGroup();
            if (function6A == null) {
                function6A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(null, null, composer, 0, 3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function6A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    static {
        float f2 = 30;
        e = DpKt.m3865DpSizeYgX7TsA(Dp.m3843constructorimpl(f2), Dp.m3843constructorimpl(f2));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g b(com.moloco.sdk.internal.ortb.model.o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVarA = a(oVar, false);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g(b(oVar, false), eVarA, eVarA);
    }

    public static final com.moloco.sdk.internal.ortb.model.o f() {
        return (com.moloco.sdk.internal.ortb.model.o) f6080a.getValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g a(com.moloco.sdk.internal.ortb.model.o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVarA = a(oVar, true);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g(b(oVar, true), eVarA, eVarA);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g b() {
        return b(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g a() {
        return a(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s b(com.moloco.sdk.internal.ortb.model.o oVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.k kVarE;
        UInt uIntA;
        boolean zI = oVar.k().i();
        Boolean bool = oVar.o() == null ? null : Boolean.TRUE;
        com.moloco.sdk.internal.ortb.model.s sVarO = oVar.o();
        int iE = sVarO != null ? sVarO.e() : 0;
        com.moloco.sdk.internal.ortb.model.a aVarA = oVar.a();
        boolean z2 = aVarA != null && aVarA.a() && oVar.a().e();
        com.moloco.sdk.internal.ortb.model.a aVarA2 = oVar.a();
        boolean z3 = aVarA2 != null && aVarA2.a();
        int iE2 = oVar.c().e();
        com.moloco.sdk.internal.ortb.model.j jVarI = oVar.i();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(zI, bool, iE, iE2, (jVarI == null || (kVarE = jVarI.e()) == null || (uIntA = kVarE.a()) == null) ? 0 : uIntA.getData(), z2, z3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a((1023 & 1) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : 0L, (1023 & 2) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.i.f7028a : new C0532d(oVar), (1023 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.j.f7029a : a(oVar.c(), z, oVar.e()), (1023 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.k.f7030a : new e(oVar), (1023 & 16) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.l.f7031a : new f(z, oVar), (1023 & 32) != 0 ? null : p.a(oVar.s()), (1023 & 64) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.m.f7032a : new g(z, oVar), (1023 & 128) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.C0675n.f7033a : new h(oVar), (1023 & 256) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.o.f7034a : null, (1023 & 512) != 0 ? com.moloco.sdk.service_locator.a.h.f6477a.h() : null));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e a(com.moloco.sdk.internal.ortb.model.o oVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.k kVarE;
        UInt uIntA;
        int iE = oVar.c().e();
        Function9 function9A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(0L, a(z, oVar.c(), oVar.i(), oVar.e()), 1, null);
        com.moloco.sdk.internal.ortb.model.j jVarI = oVar.i();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e(iE, function9A, (jVarI == null || (kVarE = jVarI.e()) == null || (uIntA = kVarE.a()) == null) ? 0 : uIntA.getData(), a(oVar.c(), z, null, 2, null));
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(boolean z, com.moloco.sdk.internal.ortb.model.s close, com.moloco.sdk.internal.ortb.model.j jVar, com.moloco.sdk.internal.ortb.model.i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        if (jVar == null) {
            return a(close, z, iVar);
        }
        return new b(close, iVar);
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(com.moloco.sdk.internal.ortb.model.s sVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar) {
        return new c(z, sVar, iVar);
    }

    public static /* synthetic */ Function2 a(com.moloco.sdk.internal.ortb.model.s sVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = null;
        }
        return a(sVar, z, iVar);
    }

    public static final Alignment a(com.moloco.sdk.internal.ortb.model.l horizontalAlignment, com.moloco.sdk.internal.ortb.model.u verticalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        com.moloco.sdk.internal.ortb.model.u uVar = com.moloco.sdk.internal.ortb.model.u.Top;
        if (verticalAlignment == uVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) {
            return Alignment.INSTANCE.getTopStart();
        }
        if (verticalAlignment == uVar && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) {
            return Alignment.INSTANCE.getTopCenter();
        }
        if (verticalAlignment == uVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) {
            return Alignment.INSTANCE.getTopEnd();
        }
        com.moloco.sdk.internal.ortb.model.u uVar2 = com.moloco.sdk.internal.ortb.model.u.Center;
        if (verticalAlignment == uVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) {
            return Alignment.INSTANCE.getCenterStart();
        }
        if (verticalAlignment == uVar2 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) {
            return Alignment.INSTANCE.getCenter();
        }
        if (verticalAlignment == uVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) {
            return Alignment.INSTANCE.getCenterEnd();
        }
        com.moloco.sdk.internal.ortb.model.u uVar3 = com.moloco.sdk.internal.ortb.model.u.Bottom;
        if (verticalAlignment == uVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) {
            return Alignment.INSTANCE.getBottomStart();
        }
        if (verticalAlignment == uVar3 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) {
            return Alignment.INSTANCE.getBottomCenter();
        }
        return (verticalAlignment == uVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) ? Alignment.INSTANCE.getBottomEnd() : Alignment.INSTANCE.getTopStart();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o b(long j, long j2, Composer composer, int i) {
        composer.startReplaceableGroup(-868162195);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868162195, i, -1, "com.moloco.sdk.internal.defaultMolocoSkipAfterCountdownButtonPart (AggregatedOptions.kt:156)");
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o oVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(PainterResources_androidKt.painterResource(R.drawable.moloco_skip, composer, 0), j, null, j2, composer, ((i << 3) & 112) | 8 | ((i << 6) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return oVarA;
    }
}
