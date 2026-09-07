package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f401a;
    private CustomTabsClient b;

    class a extends CustomTabsServiceConnection {
        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            e1.this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f401a.O().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            e1.this.b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e1.this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f401a.O().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            e1.this.b = null;
        }
    }

    private class b extends CustomTabsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f403a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f403a = new WeakReference(aVar);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            com.applovin.impl.adview.a aVar = (com.applovin.impl.adview.a) this.f403a.get();
            if (aVar == null) {
                e1.this.f401a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    e1.this.f401a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). Controller is null.");
                }
                return;
            }
            com.applovin.impl.sdk.ad.b bVarG = aVar.g();
            if (bVarG == null) {
                e1.this.f401a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    e1.this.f401a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). No ad specified.");
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsNavigationStarted(bVarG);
                    }
                    break;
                case 2:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsNavigationFinished(bVarG);
                    }
                    break;
                case 3:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsNavigationFailed(bVarG);
                    }
                    break;
                case 4:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsNavigationAborted(bVarG);
                    }
                    break;
                case 5:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsTabShown(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_shown"), null);
                    q2.c(aVar.e(), bVarG, aVar.i());
                    break;
                case 6:
                    if (bVarG.Y0()) {
                        e1.this.f401a.k().trackCustomTabsTabHidden(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_hidden"), null);
                    q2.a(aVar.e(), bVarG, aVar.i());
                    break;
                default:
                    e1.this.f401a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        e1.this.f401a.O().a("CustomTabsManager", "Unknown navigation event: " + i);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            e1.this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f401a.O().a("CustomTabsManager", "Validation " + (z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : b9.h.t) + " for session-URL relation(" + i + "), requestedOrigin(" + uri + ")");
            }
        }
    }

    public e1(com.applovin.impl.sdk.k kVar) {
        this.f401a = kVar;
    }

    public static void safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(CustomTabsIntent p0, Context p1, Uri p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context;Landroid/net/Uri;)V");
        if (p2 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p2, com.safedk.android.utils.h.f8160a);
        p0.launchUrl(p1, p2);
    }

    public void b(final List list, final CustomTabsSession customTabsSession) {
        if (list.isEmpty()) {
            return;
        }
        if (customTabsSession != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(list, customTabsSession);
                }
            });
            return;
        }
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }

    public void a() {
        if (((Boolean) this.f401a.a(v4.Q6)).booleanValue() && this.b == null) {
            String packageName = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), this.f401a.c(v4.R6), true);
            String packageName2 = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f401a.a(v4.S6)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.f401a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f401a.O().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
                    return;
                }
                return;
            }
            a(linkedList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006e A[DONT_GENERATE] */
    private void a(LinkedList linkedList) {
        boolean zBindCustomTabsService = false;
        try {
            zBindCustomTabsService = CustomTabsClient.bindCustomTabsService(com.applovin.impl.sdk.k.o(), (String) linkedList.poll(), new a());
            if (!zBindCustomTabsService) {
                this.f401a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f401a.O().b("CustomTabsManager", "Custom Tabs service not available");
                }
            }
            if (zBindCustomTabsService || linkedList.isEmpty()) {
                return;
            }
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
            }
        } catch (Throwable th) {
            try {
                this.f401a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f401a.O().a("CustomTabsManager", "Failed to bind to service", th);
                }
            } finally {
                if (!zBindCustomTabsService && !linkedList.isEmpty()) {
                    this.f401a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        this.f401a.O().a("CustomTabsManager", "Retrying with next package name...");
                    }
                    a(linkedList);
                }
            }
        }
    }

    public CustomTabsSession a(com.applovin.impl.adview.a aVar) {
        if (this.b == null) {
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f401a.O().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession customTabsSessionNewSession = this.b.newSession(new b(aVar));
            a(customTabsSessionNewSession, aVar.g());
            return customTabsSessionNewSession;
        } catch (Exception e) {
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f401a.O().a("CustomTabsManager", "Failed to create Custom Tabs session", e);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, CustomTabsSession customTabsSession) {
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean zMayLaunchUrl = customTabsSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Warmup for URLs ".concat(zMayLaunchUrl ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : b9.h.t));
        }
    }

    public void a(final String str, final com.applovin.impl.adview.a aVar, final Activity activity) {
        if (a("launch url", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar, activity, str);
            }
        })) {
            this.f401a.n0().pauseForClick();
        } else {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_failure"), CollectionUtils.map("url", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, String str) {
        safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(a(aVar, activity), activity, Uri.parse(str));
    }

    private void a(final CustomTabsSession customTabsSession, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.F0()) {
            return;
        }
        a("client warmup", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(bVar, customTabsSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, CustomTabsSession customTabsSession) {
        this.b.warmup(0L);
        f1 f1VarA = bVar.A();
        if (f1VarA == null) {
            return;
        }
        Integer numE = f1VarA.e();
        String strB = f1VarA.b();
        if (numE == null || TextUtils.isEmpty(strB)) {
            return;
        }
        if (customTabsSession == null) {
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f401a.O().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Validating session-URL relation: " + numE + " with digital asset link: " + strB);
        }
        customTabsSession.validateRelationship(numE.intValue(), Uri.parse(strB), null);
    }

    private CustomTabsIntent a(com.applovin.impl.adview.a aVar, Activity activity) {
        this.f401a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f401a.O().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        com.applovin.impl.sdk.ad.b bVarG = aVar.g();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(aVar.h());
        f1 f1VarA = bVarG != null ? bVarG.A() : null;
        if (((Boolean) this.f401a.a(v4.T6)).booleanValue()) {
            builder.setStartAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
            builder.setExitAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
        }
        if (f1VarA != null) {
            Integer numH = f1VarA.h();
            if (numH != null) {
                builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(numH.intValue()).build());
            }
            Integer numA = f1VarA.a();
            if (numA != null) {
                builder.setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(numA.intValue()).build());
            }
            Boolean boolI = f1VarA.i();
            if (boolI != null) {
                builder.setUrlBarHidingEnabled(boolI.booleanValue());
            }
            Boolean boolG = f1VarA.g();
            if (boolG != null) {
                builder.setShowTitle(boolG.booleanValue());
            }
            Boolean boolC = f1VarA.c();
            if (boolC != null) {
                builder.setInstantAppsEnabled(boolC.booleanValue());
            }
            Integer numF = f1VarA.f();
            if (numF != null) {
                builder.setShareState(numF.intValue());
            }
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        if (f1VarA != null) {
            String strD = f1VarA.d();
            if (strD != null) {
                customTabsIntentBuild.intent.putExtra("android.intent.extra.REFERRER", Uri.parse(strD));
            }
            Bundle bundleV = bVarG.v();
            if (!bundleV.isEmpty()) {
                customTabsIntentBuild.intent.putExtra("com.android.browser.headers", bundleV);
            }
        }
        return customTabsIntentBuild;
    }

    private boolean a(String str, Runnable runnable) {
        try {
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f401a.O().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f401a.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return true;
            }
            this.f401a.O().a("CustomTabsManager", "Finished operation: " + str);
            return true;
        } catch (Throwable th) {
            this.f401a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f401a.O().a("CustomTabsManager", "Failed to run operation: " + str, th);
            }
            this.f401a.E().a("CustomTabsManager", str, th);
            return false;
        }
    }
}
