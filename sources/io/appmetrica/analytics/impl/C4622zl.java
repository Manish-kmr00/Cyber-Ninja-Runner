package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.IParamsAppender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4622zl implements IParamsAppender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Yd f11883a;
    public final InterfaceC4340od b;
    public final Mb c = new Mb();

    public C4622zl(Yd yd, InterfaceC4340od interfaceC4340od) {
        this.f11883a = yd;
        this.b = interfaceC4340od;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void appendParams(Uri.Builder builder, Dl dl) {
        String str;
        C4044cg c4044cg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.DEVICE_ID), dl.getDeviceId());
        a(builder, C4486ua.E.g(), this.c);
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.APP_SET_ID), dl.getAppSetId());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.APP_SET_ID_SCOPE), dl.getAppSetIdScope());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.APP_PLATFORM), dl.getAppPlatform());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.PROTOCOL_VERSION), dl.getProtocolVersion());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), dl.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f11883a.a("model"), dl.getModel());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.MANUFACTURER), dl.getManufacturer());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.OS_VERSION), dl.getOsVersion());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(dl.getScreenWidth()));
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(dl.getScreenHeight()));
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(dl.getScreenDpi()));
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(dl.getScaleFactor()));
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.LOCALE), dl.getLocale());
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.DEVICE_TYPE), dl.getDeviceType());
        builder.appendQueryParameter(this.f11883a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("query_hosts"), String.valueOf(2));
        String strA = this.f11883a.a("features");
        List<String> listH = ((C4023bk) this.b).h();
        String[] strArr = {this.f11883a.a("permissions_collecting"), this.f11883a.a("features_collecting"), this.f11883a.a("google_aid"), this.f11883a.a("huawei_oaid"), this.f11883a.a("sim_info"), this.f11883a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(listH);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(strA, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f11883a.a("app_id"), dl.getPackageName());
        builder.appendQueryParameter(this.f11883a.a("app_debuggable"), ((Y5) dl).f11431a);
        if (dl.l) {
            String str2 = dl.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f11883a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f11883a.a("detect_locale"), String.valueOf(1));
        }
        L3 l3 = dl.i;
        if (!In.a(l3.f11236a)) {
            builder.appendQueryParameter(this.f11883a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f11883a.a("clids_set"), AbstractC4199im.a(l3.f11236a));
            int iOrdinal = l3.b.ordinal();
            if (iOrdinal == 1) {
                str = "api";
            } else if (iOrdinal != 2) {
                str = iOrdinal != 3 ? "" : "retail";
            } else {
                str = "satellite";
            }
            builder.appendQueryParameter(this.f11883a.a("clids_set_source"), str);
            String str3 = dl.f;
            String str4 = dl.g;
            if (TextUtils.isEmpty(str3) && (c4044cg = dl.o.b) != null) {
                str3 = c4044cg.f11496a;
                str4 = c4044cg.d.f11480a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f11883a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = "null";
                }
                builder.appendQueryParameter(this.f11883a.a("install_referrer_source"), str4);
            }
        }
        String uuid = dl.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f11883a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("app_system_flag"), ((Y5) dl).b);
        builder.appendQueryParameter(this.f11883a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a(com.json.c9.ATTRIBUTION), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f11883a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> mapD = ((C4023bk) this.b).d();
        for (String str5 : mapD.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(mapD.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, Mb mb) {
        mb.getClass();
        AdvertisingIdsHolder identifiers = C4486ua.E.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForReporter()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f11883a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}
