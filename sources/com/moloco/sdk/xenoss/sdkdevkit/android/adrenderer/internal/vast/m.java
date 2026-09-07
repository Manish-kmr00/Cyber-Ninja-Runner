package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f6883a;
    public final CoroutineScope b;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastTrackerImpl$track$1", f = "VastTracker.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6884a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public final /* synthetic */ List<String> j;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a k;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f l;
        public final /* synthetic */ m m;
        public final /* synthetic */ List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> n;
        public final /* synthetic */ x o;
        public final /* synthetic */ Integer p;
        public final /* synthetic */ String q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar, m mVar, List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> list2, x xVar, Integer num, String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.j = list;
            this.k = aVar;
            this.l = fVar;
            this.m = mVar;
            this.n = list2;
            this.o = xVar;
            this.p = num;
            this.q = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0062  */
        /* JADX WARN: Code duplicated, block: B:13:0x006b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:19:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:21:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:22:0x00c3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0098 -> B:18:0x00a2). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 215
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public m(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f6883a = persistentHttpRequest;
        this.b = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault());
    }

    public final void b(List<String> list, x xVar, Integer num, String str, List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar) {
        if (list.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(list, aVar, fVar, this, list2, xVar, num, str, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l
    public void a(List<String> urls, x xVar, Integer num, String str, List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> renderedButtons, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f lastClickPosition) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(renderedButtons, "renderedButtons");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(lastClickPosition, "lastClickPosition");
        b(urls, xVar, num, str, renderedButtons, customUserEventBuilderService, lastClickPosition);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l
    public void a(List<String> urls, x xVar, Integer num, String str) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        b(urls, xVar, num, str, CollectionsKt.emptyList(), null, null);
    }

    public final Object a(String str, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar, long j, List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> list, Continuation<? super String> continuation) {
        return aVar.a(j, new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d(fVar, null, null, list, 6, null), str, continuation);
    }
}
