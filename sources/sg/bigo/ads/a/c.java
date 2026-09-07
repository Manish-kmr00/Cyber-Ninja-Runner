package sg.bigo.ads.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent;
import com.safedk.android.utils.Logger;
import io.ktor.http.LinkHeader;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f12475a = true;

    private static void a() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs libs does not exist.");
        f12475a = false;
    }

    public static void a(final Context context) {
        a(context, "", null, "warmup", new Runnable() { // from class: sg.bigo.ads.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                b bVarA = b.a();
                Context context2 = context;
                if (context2 != null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs warming up.");
                    bVarA.a(context2.getApplicationContext());
                }
            }
        });
    }

    static void a(final Context context, final String str, final int i, final int i2, final boolean z, final Bitmap bitmap, final a.c cVar, final a.b bVar) {
        a(context, str, bVar, "open", new Runnable() { // from class: sg.bigo.ads.a.c.2
            public static void safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(CustomTabsIntent p0, Context p1, Uri p2) {
                Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context;Landroid/net/Uri;)V");
                if (p2 == null) {
                    return;
                }
                p0.launchUrl(p1, p2);
            }

            @Override // java.lang.Runnable
            public final void run() {
                Uri uri;
                final b bVarA = b.a();
                Context context2 = context;
                final String str2 = str;
                int i3 = i;
                int i4 = i2;
                boolean z2 = z;
                Bitmap bitmap2 = bitmap;
                final a.c cVar2 = cVar;
                final a.b bVar2 = bVar;
                if (!TextUtils.isEmpty(str2)) {
                    bVarA.b.remove(str2);
                }
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Start load url: " + str2 + " with chrome tab current thread: " + Thread.currentThread().getName() + ".");
                try {
                    uri = Uri.parse(str2);
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Stop open chrome tab with error url.");
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                bVarA.a(context2);
                bVarA.f12470a.d = new CustomTabsCallback() { // from class: sg.bigo.ads.a.b.1
                    @Override // androidx.browser.customtabs.CustomTabsCallback
                    public final void onNavigationEvent(int i5, Bundle bundle) {
                        super.onNavigationEvent(i5, bundle);
                        if (cVar2 == null) {
                            return;
                        }
                        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Receive custom tab event: " + b.a(i5));
                        if (i5 == 5) {
                            cVar2.a();
                            return;
                        }
                        if (i5 == 1) {
                            cVar2.b();
                            return;
                        }
                        if (i5 == 3) {
                            cVar2.d();
                            return;
                        }
                        if (i5 == 4) {
                            cVar2.c();
                            return;
                        }
                        if (i5 == 2) {
                            cVar2.e();
                        } else if (i5 == 6) {
                            cVar2.o();
                            b.this.f12470a.d = null;
                        }
                    }
                };
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(bVarA.f12470a.a());
                if (i3 != 0) {
                    builder.setToolbarColor(i3);
                }
                if (i4 != 0) {
                    builder.setSecondaryToolbarColor(i4);
                }
                if (bitmap2 != null) {
                    builder.setCloseButtonIcon(bitmap2);
                }
                builder.setShowTitle(z2);
                CustomTabsIntent customTabsIntentBuild = builder.build();
                try {
                    Context contextB = sg.bigo.ads.common.f.b.b();
                    if (contextB == null) {
                        contextB = context2;
                    }
                    sg.bigo.ads.a.a.a.b bVar3 = new sg.bigo.ads.a.a.a.b() { // from class: sg.bigo.ads.a.b.2
                        @Override // sg.bigo.ads.a.a.a.b
                        public final void a(Context context3, sg.bigo.ads.a.a.b.a aVar) {
                            a.b bVar4 = bVar2;
                            if (bVar4 != null) {
                                bVar4.a(context3, str2, 2, aVar == null ? "" : aVar.b);
                            }
                        }

                        @Override // sg.bigo.ads.a.a.a.b
                        public final void a(sg.bigo.ads.a.a.b.a aVar) {
                            a.b bVar4 = bVar2;
                            if (bVar4 == null || aVar == null) {
                                return;
                            }
                            bVar4.a(aVar.e, aVar.d, aVar.c);
                        }
                    };
                    sg.bigo.ads.a.a.b.a aVarA = sg.bigo.ads.a.a.b.a(contextB);
                    if (aVarA != null && aVarA.f12468a) {
                        customTabsIntentBuild.intent.setPackage(aVarA.e);
                        safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(customTabsIntentBuild, contextB, uri);
                        bVar3.a(aVarA);
                        return;
                    }
                    bVar3.a(contextB, aVarA);
                } catch (Exception e) {
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 4, e.toString());
                    }
                    bVarA.f12470a.d = null;
                }
            }
        });
    }

    public static void a(final Context context, final String str, final a.b bVar) {
        a(context, str, bVar, LinkHeader.Rel.PreLoad, new Runnable() { // from class: sg.bigo.ads.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVarA = b.a();
                Context context2 = context;
                String str2 = str;
                a.b bVar2 = bVar;
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Start preload url: " + str2 + " with chrome tab current thread: " + Thread.currentThread().getName() + ".");
                if (context2 == null) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Preload: empty context!");
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 3, "Invalid context");
                        return;
                    }
                    return;
                }
                Context applicationContext = context2.getApplicationContext();
                if (TextUtils.isEmpty(str2)) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Preload: empty url!");
                    if (bVar2 != null) {
                        bVar2.a(applicationContext, str2, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                bVarA.b.add(str2);
                if (bVarA.a(applicationContext)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Meet the conditions for connection of Chrome service.");
                    bVarA.b();
                    if (bVar2 != null) {
                        bVar2.a("", "0", "");
                        return;
                    }
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Failed to make connection of Chrome service.");
                bVarA.b.remove(str2);
                if (bVar2 != null) {
                    bVar2.a(applicationContext, str2, 2, "Failed to make connection of Chrome service.");
                }
            }
        });
    }

    private static void a(Context context, String str, a.b bVar, String str2, Runnable runnable) {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "start ".concat(String.valueOf(str2)));
        if (!f12475a) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with not exists chrome tab libs");
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 1, "NoClassDefFoundError");
            return;
        }
        try {
            runnable.run();
        } catch (NoClassDefFoundError e) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with not exists chrome tab libs");
            a();
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 1, e.toString());
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with unknown reason: " + th.toString());
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 4, th.toString());
        }
    }
}
