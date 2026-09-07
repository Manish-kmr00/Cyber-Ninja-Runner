package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i f6572a;
    public final com.moloco.sdk.internal.error.b b;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.DECLoaderImpl", f = "DECLoader.kt", i = {0, 0, 0, 0}, l = {31}, m = "load", n = {"this", "decToLoad", "mtid", "appIconUri"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6573a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return k.this.a(null, null, this);
        }
    }

    public k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.internal.error.b errorReportingService) {
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        this.f6572a = mediaCacheRepository;
        this.b = errorReportingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j
    public Object a(i iVar, String str, Continuation<? super i> continuation) throws Throwable {
        a aVar;
        String strH;
        Object objA;
        k kVar;
        i iVarA;
        i iVar2 = iVar;
        String str2 = str;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.g = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            strH = iVar.h();
            if (strH == null) {
                this.b.a(l.b, str2 != null ? new com.moloco.sdk.internal.error.a(str2) : new com.moloco.sdk.internal.error.a("UNKNOWN_MTID"));
                l.b("can't precache DEC: appIconUri is null");
                return iVar2;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar3 = this.f6572a;
            aVar.f6573a = this;
            aVar.b = iVar2;
            aVar.c = str2;
            aVar.d = strH;
            aVar.g = 1;
            objA = iVar3.a(strH, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            kVar = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = (String) aVar.d;
            str2 = (String) aVar.c;
            i iVar4 = (i) aVar.b;
            k kVar2 = (k) aVar.f6573a;
            ResultKt.throwOnFailure(obj);
            strH = str3;
            iVar2 = iVar4;
            kVar = kVar2;
            objA = obj;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a) objA;
        if (aVar2 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) {
            iVarA = i.a(iVar2, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) aVar2).a().getAbsolutePath(), null, null, null, null, null, null, 126, null);
        } else {
            kVar.b.a(l.f6575a, str2 != null ? new com.moloco.sdk.internal.error.a(str2) : new com.moloco.sdk.internal.error.a("UNKNOWN_MTID"));
            l.b("dec loading error: " + aVar2 + ": `Not found` for " + strH);
            iVarA = null;
        }
        return iVarA == null ? iVar2 : iVarA;
    }
}
