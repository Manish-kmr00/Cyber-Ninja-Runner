package com.yandex.mobile.ads.impl;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes13.dex */
public final class xq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dr1 f10672a;
    private final x61 b;

    public final ip1 a(o8 o8Var, o3 adConfiguration, u61 responseBody) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = a(o8Var, adConfiguration);
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        if (responseBody != null) {
            List<String> listA = this.b.a(responseBody);
            if (!listA.isEmpty()) {
                ip1Var.a(listA, "image_sizes");
            }
            this.b.getClass();
            Intrinsics.checkNotNullParameter(responseBody, "responseBody");
            List<c41> listE = responseBody.e();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(((c41) it.next()).g().a());
            }
            if (!arrayList.isEmpty()) {
                ip1Var.a(arrayList, "native_ad_types");
            }
            this.b.getClass();
            Intrinsics.checkNotNullParameter(responseBody, "responseBody");
            List<c41> listE2 = responseBody.e();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = listE2.iterator();
            while (it2.hasNext()) {
                String strA = ((c41) it2.next()).a();
                if (strA != null) {
                    arrayList2.add(strA);
                }
            }
            if (!arrayList2.isEmpty()) {
                ip1Var.a(arrayList2, "ad_ids");
            }
        }
        return jp1.a(ip1VarA, ip1Var);
    }

    public final ip1 b(o8<?> o8Var, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = a(o8Var, adConfiguration);
        ip1VarA.b(o8Var != null ? o8Var.d() : null, CreativeInfo.c);
        return ip1VarA;
    }

    public /* synthetic */ xq1() {
        this(new dr1(), new x61());
    }

    public xq1(dr1 responseTypeProvider, x61 nativeAdResponseDataProvider) {
        Intrinsics.checkNotNullParameter(responseTypeProvider, "responseTypeProvider");
        Intrinsics.checkNotNullParameter(nativeAdResponseDataProvider, "nativeAdResponseDataProvider");
        this.f10672a = responseTypeProvider;
        this.b = nativeAdResponseDataProvider;
    }

    public final ip1 a(o8<?> o8Var, u61 u61Var, o3 adConfiguration, c41 c41Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(c41Var, "native");
        ip1 ip1VarA = a(o8Var, adConfiguration);
        if (u61Var != null) {
            List<String> listA = this.b.a(u61Var);
            if (!listA.isEmpty()) {
                ip1VarA.a(listA, "image_sizes");
            }
        }
        ip1VarA.b(c41Var.a(), CreativeInfo.c);
        return ip1VarA;
    }

    private final ip1 a(o8<?> o8Var, o3 o3Var) {
        String strC;
        String strC2;
        String strA;
        String str;
        Map<String, ? extends Object> mapS;
        qs qsVarN;
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        if (o8Var == null || !o8Var.O()) {
            ip1Var.b(o8Var != null ? o8Var.o() : null, "ad_type_format");
            ip1Var.b(o8Var != null ? o8Var.H() : null, "product_type");
        }
        if (o8Var == null || (strC = o8Var.p()) == null) {
            strC = o3Var.c();
        }
        ip1Var.b(strC, "block_id");
        if (o8Var == null || (strC2 = o8Var.p()) == null) {
            strC2 = o3Var.c();
        }
        ip1Var.b(strC2, "ad_unit_id");
        ip1Var.b(o8Var != null ? o8Var.m() : null, FirebaseAnalytics.Param.AD_SOURCE);
        if (o8Var == null || (qsVarN = o8Var.n()) == null || (strA = qsVarN.a()) == null) {
            strA = o3Var.b().a();
        }
        ip1Var.b(strA, "ad_type");
        ip1Var.a(o8Var != null ? o8Var.w() : null, "design");
        ip1Var.a(o8Var != null ? o8Var.b() : null);
        ip1Var.a(o8Var != null ? o8Var.L() : null, "server_log_id");
        this.f10672a.getClass();
        if ((o8Var != null ? o8Var.D() : null) != null) {
            str = "mediation";
        } else {
            if ((o8Var != null ? o8Var.I() : null) != null) {
                str = Reporting.Key.CLICK_SOURCE_TYPE_AD;
            } else {
                str = "empty";
            }
        }
        ip1Var.b(str, ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE);
        if (o8Var != null && (mapS = o8Var.s()) != null) {
            ip1Var.a(mapS);
        }
        ip1Var.a(o8Var != null ? o8Var.a() : null);
        return ip1Var;
    }
}
