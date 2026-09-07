package com.safedk.android.analytics.brandsafety;

import android.graphics.Bitmap;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface a extends AppLovinCommunicatorSubscriber, f, com.safedk.android.internal.a {
    BrandSafetyUtils.AdType a();

    c a(String str, RedirectDetails redirectDetails, m mVar, boolean z, boolean z2);

    List<CreativeInfo> a(String str, String str2);

    void a(Bitmap bitmap, c cVar);

    void a(String str);

    void a(String str, String str2, String str3);

    boolean a(o oVar);

    boolean a(String str, x xVar);

    boolean a(String str, String str2, String str3, boolean z);

    boolean a(String str, String str2, boolean z, String str3);

    c b(String str);

    List<CreativeInfo> b(String str, String str2);

    void b();

    boolean b(String str, String str2, String str3);

    c c(String str);

    void c();

    void c(String str, String str2, String str3);

    void d(String str);

    boolean e(String str);
}
