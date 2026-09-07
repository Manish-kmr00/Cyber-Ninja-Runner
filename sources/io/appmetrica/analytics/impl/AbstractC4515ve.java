package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.Locale;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ve, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4515ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafePackageManager f11816a = new SafePackageManager();
    public static final C4391qe b = new C4391qe();
    public static final C4415re c = new C4415re();
    public static final C4440se d = new C4440se(2);

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        String script = locale.getScript();
        if (!TextUtils.isEmpty(script)) {
            sb.append('-').append(script);
        }
        if (!TextUtils.isEmpty(country)) {
            sb.append('_').append(country);
        }
        return sb.toString();
    }

    public static EnumC4490ue a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        EnumC4490ue enumC4490ue = EnumC4490ue.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!AndroidUtils.isApiAchieved(29) ? !(activeNetwork != null && ((networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || networkInfo.isConnected())) : activeNetwork == null) {
            return EnumC4490ue.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            return enumC4490ue;
        }
        for (Integer num : c.f11206a.keySet()) {
            if (networkCapabilities.hasTransport(num.intValue())) {
                return (EnumC4490ue) c.a(num);
            }
        }
        return enumC4490ue;
    }
}
