package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.appopen.AppOpenAd;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends g {
    public e(d dVar, ClientContext clientContext) {
        super(dVar, clientContext);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        if (!ReflectionUtils.isArgumentsOfClasses(objArr, AdValue.class, AppOpenAd.class)) {
            return false;
        }
        AdValue adValue = (AdValue) objArr[0];
        AppOpenAd appOpenAd = (AppOpenAd) objArr[1];
        this.f10927a.getClass();
        a(d.a(adValue, ModuleAdType.APP_OPEN, "appOpenAd", appOpenAd.getResponseInfo(), appOpenAd.getAdUnitId()));
        return true;
    }
}
