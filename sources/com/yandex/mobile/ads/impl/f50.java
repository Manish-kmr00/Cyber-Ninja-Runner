package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8867a;
    private final tj b;
    private final da c;
    private final hd1 d;

    @DebugMetadata(c = "com.monetization.ads.base.mediation.bidding.EncodedHeaderBiddingDataLoader", f = "EncodedHeaderBiddingDataLoader.kt", i = {0, 1}, l = {35, 44}, m = "loadEncodedBiddingData", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class a extends ContinuationImpl {
        f50 b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return f50.this.a(null, this);
        }
    }

    public f50(o3 adConfiguration, el biddingSettings, tj base64Encoder, da adUnitIdHeaderBiddingSettingsProvider, cy0 mediatedAdapterReporter, hd1 networksHeaderBiddingDataLoader) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(biddingSettings, "biddingSettings");
        Intrinsics.checkNotNullParameter(base64Encoder, "base64Encoder");
        Intrinsics.checkNotNullParameter(adUnitIdHeaderBiddingSettingsProvider, "adUnitIdHeaderBiddingSettingsProvider");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(networksHeaderBiddingDataLoader, "networksHeaderBiddingDataLoader");
        this.f8867a = adConfiguration;
        this.b = base64Encoder;
        this.c = adUnitIdHeaderBiddingSettingsProvider;
        this.d = networksHeaderBiddingDataLoader;
    }

    private final String a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("networks", jSONArray);
                tj tjVar = this.b;
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                tjVar.getClass();
                return tj.a(string);
            } catch (JSONException unused) {
                op0.c(new Object[0]);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, Continuation<? super String> continuation) throws Throwable {
        a aVar;
        f50 f50Var;
        f50 f50Var2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objWithContext = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 != 0) {
            if (i2 == 1) {
                f50Var2 = aVar.b;
                ResultKt.throwOnFailure(objWithContext);
                return f50Var2.a((JSONArray) objWithContext);
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f50Var = aVar.b;
            ResultKt.throwOnFailure(objWithContext);
            return f50Var.a((JSONArray) objWithContext);
        }
        ResultKt.throwOnFailure(objWithContext);
        ba baVarA = this.c.a(this.f8867a.c());
        if (baVarA == null) {
            return null;
        }
        List<hz0> listF = baVarA.f();
        if (this.f8867a.b() == qs.d) {
            zy1 zy1VarR = this.f8867a.r();
            if (zy1VarR != null) {
                hd1 hd1Var = this.d;
                aVar.b = this;
                aVar.e = 1;
                hd1Var.getClass();
                objWithContext = BuildersKt.withContext(nu.b(), new gd1(hd1Var, context, zy1VarR, listF, null), aVar);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                f50Var2 = this;
                return f50Var2.a((JSONArray) objWithContext);
            }
            op0.b(new Object[0]);
            return null;
        }
        hd1 hd1Var2 = this.d;
        aVar.b = this;
        aVar.e = 2;
        hd1Var2.getClass();
        objWithContext = BuildersKt.withContext(nu.b(), new gd1(hd1Var2, context, null, listF, null), aVar);
        if (objWithContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        f50Var = this;
        return f50Var.a((JSONArray) objWithContext);
    }
}
