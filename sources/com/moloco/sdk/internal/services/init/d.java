package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes8.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6395a = a.f6396a;
    public static final long b = 3000;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6396a = new a();
        public static final long b = 3000;
    }

    Object a(String str, MediationInfo mediationInfo, Continuation<? super v<Init.SDKInitResponse, j>> continuation);
}
