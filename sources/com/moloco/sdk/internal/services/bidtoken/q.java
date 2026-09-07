package com.moloco.sdk.internal.services.bidtoken;

import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes11.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6340a = a.f6341a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6341a = new a();

        public final q a() {
            return new r(com.moloco.sdk.service_locator.a.h.f6477a.f(), o.f6327a.a(), com.moloco.sdk.internal.services.encryption.a.f6369a.a(), com.moloco.sdk.internal.services.bidtoken.providers.l.f6335a.a());
        }
    }

    Object a(String str, f fVar, Continuation<? super Result<String>> continuation);
}
