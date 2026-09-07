package com.yandex.mobile.ads.impl;

import android.location.Location;
import com.yandex.mobile.ads.common.AdRequestConfiguration;
import com.yandex.mobile.ads.common.AdTheme;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class dl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hq1 f8707a;

    public final v7 a(AdRequestConfiguration adRequestConfiguration) {
        Intrinsics.checkNotNullParameter(adRequestConfiguration, "adRequestConfiguration");
        String age = adRequestConfiguration.getAge();
        String gender = adRequestConfiguration.getGender();
        String contextQuery = adRequestConfiguration.getContextQuery();
        List<String> contextTags = adRequestConfiguration.getContextTags();
        Location location = adRequestConfiguration.getLocation();
        Map<String, String> parameters = adRequestConfiguration.getParameters();
        String biddingData = adRequestConfiguration.getBiddingData();
        AdTheme preferredTheme = adRequestConfiguration.getPreferredTheme();
        v7.a aVar = new v7.a(adRequestConfiguration.getAdUnitId());
        if (age != null) {
            if (StringsKt.isBlank(age)) {
                age = null;
            }
            if (age != null) {
                aVar.a(age);
            }
        }
        if (gender != null) {
            if (StringsKt.isBlank(gender)) {
                gender = null;
            }
            if (gender != null) {
                aVar.c(gender);
            }
        }
        if (contextQuery != null) {
            aVar = aVar.b(contextQuery);
        }
        if (contextTags != null) {
            aVar = aVar.a(contextTags);
        }
        if (location != null) {
            aVar = aVar.a(location);
        }
        if (parameters != null) {
            aVar = aVar.a(parameters);
        }
        if (biddingData != null) {
            aVar = aVar.d(biddingData);
        }
        if (preferredTheme != null) {
            this.f8707a.getClass();
            aVar = aVar.a(hq1.a(preferredTheme));
        }
        return aVar.a();
    }

    public /* synthetic */ dl2() {
        this(new hq1());
    }

    public dl2(hq1 requestedAdThemeFactory) {
        Intrinsics.checkNotNullParameter(requestedAdThemeFactory, "requestedAdThemeFactory");
        this.f8707a = requestedAdThemeFactory;
    }
}
