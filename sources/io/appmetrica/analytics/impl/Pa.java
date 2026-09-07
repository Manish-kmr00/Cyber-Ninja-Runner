package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Pa extends Ka, Nc {
    void a(Activity activity);

    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Cdo cdo);

    void a(EnumC4326o enumC4326o);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ void a(String str);

    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    /* synthetic */ void a(boolean z);

    void b(Activity activity);

    void b(String str);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ void b(String str, String str2);

    /* synthetic */ void b(boolean z);

    @Override // io.appmetrica.analytics.impl.Ka
    /* synthetic */ boolean b();

    void c();

    List<String> f();
}
