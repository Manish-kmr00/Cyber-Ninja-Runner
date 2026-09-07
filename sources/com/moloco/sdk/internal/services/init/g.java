package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6401a = a.f6402a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6402a = new a();

        public final g a(SharedPreferences sharedPreferences) {
            Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
            return new h(sharedPreferences, com.moloco.sdk.internal.scheduling.b.a().getIo(), AndroidClientMetrics.INSTANCE);
        }
    }

    Object a(com.moloco.sdk.internal.services.init.a aVar, Init.SDKInitResponse sDKInitResponse, Continuation<? super Unit> continuation);

    Object a(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super Init.SDKInitResponse> continuation);

    Object a(Continuation<? super Unit> continuation);

    Object b(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super Unit> continuation);
}
