package com.yandex.mobile.ads.impl;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ce1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<de1, be1> f8593a = new ConcurrentHashMap<>();
    private static final c72 b = new c72();
    public static final /* synthetic */ int c = 0;

    public static be1 a(int i, int i2, SSLSocketFactory sSLSocketFactory) throws NoSuchAlgorithmException, KeyStoreException {
        b.getClass();
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        SSLSocketFactory sSLSocketFactory2 = null;
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        ArrayList arrayList = new ArrayList();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                arrayList.add(trustManager);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) CollectionsKt.firstOrNull((List) arrayList);
        if (sSLSocketFactory != null && x509TrustManager != null) {
            sSLSocketFactory2 = sSLSocketFactory;
        }
        de1 de1Var = new de1(i, i2, sSLSocketFactory2);
        ConcurrentHashMap<de1, be1> concurrentHashMap = f8593a;
        if (!concurrentHashMap.containsKey(de1Var)) {
            be1.a aVar = new be1.a();
            long j = i;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            be1.a aVarA = aVar.a(j, timeUnit).b(i2, timeUnit).a();
            if (sSLSocketFactory != null && x509TrustManager != null) {
                aVarA = aVarA.a(sSLSocketFactory, x509TrustManager);
            }
            concurrentHashMap.put(de1Var, new be1(aVarA));
        }
        be1 be1Var = concurrentHashMap.get(de1Var);
        if (be1Var != null) {
            return be1Var;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
