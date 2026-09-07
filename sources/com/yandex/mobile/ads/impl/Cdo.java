package com.yandex.mobile.ads.impl;

import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yandex.mobile.ads.impl.do, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Cdo {

    /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.do$a */
    public static final class a {
        public static Cdo a(X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            return nh1.f9731a.a(trustManager);
        }
    }

    public abstract List a(String str, List list) throws SSLPeerUnverifiedException;
}
