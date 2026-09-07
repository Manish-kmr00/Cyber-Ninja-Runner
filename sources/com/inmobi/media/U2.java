package com.inmobi.media;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.playon.bridge.AdUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class U2 extends CustomTabsServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W2 f3209a;

    public U2(W2 w2) {
        this.f3209a = w2;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f3209a.f3223a = null;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(client, "client");
        W2 w2 = this.f3209a;
        w2.f3223a = client;
        S1 s1 = w2.c;
        if (s1 != null) {
            Uri uri = Uri.parse(s1.f3186a);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            W2 w3 = s1.f;
            CustomTabsClient customTabsClient = w3.f3223a;
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(customTabsClient != null ? customTabsClient.newSession(new V2(w3)) : null);
            builder.enableUrlBarHiding();
            Context context = s1.g;
            CustomTabsIntent customTabsIntentBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
            T2.a(context, customTabsIntentBuild, uri, s1.b, s1.d, s1.c, s1.e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        W2 w2 = this.f3209a;
        w2.f3223a = null;
        S1 s1 = w2.c;
        if (s1 != null) {
            Z5 z5 = s1.d;
            if (z5 != null) {
                z5.g = "IN_NATIVE";
            }
            O1 o1 = s1.b;
            if (o1 != null) {
                o1.a(N5.LPBrowserOpenFailed, z5, Integer.valueOf(AdUnit.ERROR_UNSUPPORTED_MIME_TYPE));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f3209a.f3223a = null;
    }
}
