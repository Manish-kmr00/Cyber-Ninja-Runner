package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import android.webkit.URLUtil;
import androidx.browser.customtabs.CustomTabsClient;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class U5 {
    public static final /* synthetic */ int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3211a;
    public final V5 b;
    public final O1 c;
    public final C3614wa d;
    public final H1 e;
    public final C3297a6 f;
    public final L4 g;
    public int h;

    /* JADX WARN: Multi-variable type inference failed */
    public U5(Context context, V5 landingPageState, O1 o1, C3614wa c3614wa, InterfaceC3386ga redirectionValidator, C3297a6 c3297a6, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(landingPageState, "landingPageState");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        this.f3211a = context;
        this.b = landingPageState;
        this.c = o1;
        this.d = c3614wa;
        this.e = (H1) redirectionValidator;
        this.f = c3297a6;
        this.g = l4;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:113:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e4  */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public static S5 a(U5 u5, String api, String str, String str2, Z5 z5, boolean z, int i2) {
        L4 l4;
        L4 l5;
        L4 l6;
        if ((i2 & 8) != 0) {
            z5 = null;
        }
        int iC = 0;
        if ((i2 & 16) != 0) {
            z = false;
        }
        u5.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        L4 l7 = u5.g;
        if (l7 != null) {
            ((M4) l7).c("U5", P5.a("U5", "TAG", "processing URL - ", str2));
        }
        if (z5 == null) {
            C3297a6 c3297a6 = u5.f;
            if (c3297a6 == null || u5.b.f3218a || z) {
                z5 = null;
            } else {
                String strA = R5.a(str2);
                int i3 = u5.h + 1;
                u5.h = i3;
                z5 = new Z5(c3297a6, strA, i3, 8);
            }
        }
        N5 n5 = N5.LPClickStart;
        R5.a(n5, z5, (Integer) null, Q5.a(n5, "funnelState", u5));
        if (str2 == null || str2.length() == 0) {
            L4 l8 = u5.g;
            if (l8 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l8).c("U5", "url is empty");
            }
            N5 n6 = N5.LPStartFailed;
            R5.a(n6, z5, (Integer) 2, (Function2) Q5.a(n6, "funnelState", u5));
            u5.b(api, str, str2);
            return new S5(3, 2);
        }
        Uri uri = Uri.parse(str2);
        String scheme = uri.getScheme();
        if (scheme == null || scheme.length() == 0) {
            L4 l9 = u5.g;
            if (l9 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l9).c("U5", "url scheme is empty");
            }
            N5 n7 = N5.LPStartFailed;
            R5.a(n7, z5, (Integer) 4, (Function2) Q5.a(n7, "funnelState", u5));
            u5.b(api, str, str2);
            return new S5(3, 4);
        }
        if (Intrinsics.areEqual(uri.getScheme(), "inmobinativebrowser")) {
            L4 l10 = u5.g;
            if (l10 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l10).c("U5", "inmobi native browser scheme");
            }
            return u5.b(api, str, str2, z5);
        }
        if (Intrinsics.areEqual(uri.getScheme(), "inmobideeplink")) {
            L4 l11 = u5.g;
            if (l11 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l11).c("U5", "inmobi deeplink scheme");
            }
            return u5.a(api, str, str2, z5);
        }
        if (V0.a(u5.f3211a, str2, u5.e, api, u5.g)) {
            L4 l12 = u5.g;
            if (l12 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l12).c("U5", "appstore link");
            }
            u5.c(api, str, str2);
            if (z5 != null) {
                z5.g = "EX_NATIVE";
            }
            N5 n8 = N5.LPStartSuccess;
            R5.a(n8, z5, (Integer) null, Q5.a(n8, "funnelState", u5));
            return new S5(1);
        }
        Intrinsics.checkNotNull(uri);
        if (!AbstractC3392h2.a(uri)) {
            int iA = AbstractC3337d3.a(u5.f3211a, str2, u5.e, api, u5.g);
            if (z5 != null) {
                z5.g = "EX_NATIVE";
            }
            if (iA == 0 || iA == 1) {
                N5 n9 = N5.LPStartSuccess;
                R5.a(n9, z5, (Integer) null, Q5.a(n9, "funnelState", u5));
                u5.c(api, str, str2);
                L4 l13 = u5.g;
                if (l13 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l13).c("U5", "Deeplink url handled successfully");
                }
                return new S5(1);
            }
            L4 l14 = u5.g;
            if (l14 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l14).c("U5", "In processOpenRequest else");
            }
            u5.b(api, str, str2);
            N5 n10 = N5.LPBrowserOpenFailed;
            R5.a(n10, z5, Integer.valueOf(iA), Q5.a(n10, "funnelState", u5));
            return new S5(2, Integer.valueOf(iA));
        }
        L4 l15 = u5.g;
        if (l15 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l15).c("U5", "http link");
        }
        V5 v5 = u5.b;
        if (v5.f3218a) {
            return new S5(0);
        }
        String str3 = v5.b;
        int iHashCode = str3.hashCode();
        if (iHashCode != -2032180703) {
            if (iHashCode != -702637789) {
                if (iHashCode != 112775115) {
                    if (iHashCode == 409244785 && str3.equals("IN_NATIVE")) {
                        l5 = u5.g;
                        if (l5 != null) {
                            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                            ((M4) l5).c("U5", "default - internal native");
                        }
                        iC = u5.c(api, str, str2, z5);
                    }
                } else if (str3.equals("IN_CUSTOM")) {
                    L4 l16 = u5.g;
                    if (l16 != null) {
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l16).c("U5", "open internal custom");
                    }
                    L4 l17 = u5.g;
                    if (l17 != null) {
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l17).a("U5", "In processOpenInternalCustomRequest");
                    }
                    iC = u5.b(str2, api, z5);
                    if ((iC == 0 || iC == 1) && (l6 = u5.g) != null) {
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l6).c("U5", "Internal Custom handled successfully");
                    }
                }
                l4 = u5.g;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l4).c("U5", "invalid scheme - open internal native");
                }
                iC = u5.c(api, str, str2, z5);
            } else if (str3.equals("EX_NATIVE")) {
                L4 l18 = u5.g;
                if (l18 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l18).c("U5", "open external native");
                }
                L4 l19 = u5.g;
                if (l19 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l19).a("U5", "In processOpenExternalNativeRequest");
                }
                int iA2 = AbstractC3337d3.a(u5.f3211a, str2, u5.e, api, u5.g);
                if (iA2 == 0 || iA2 == 1) {
                    if (z5 != null) {
                        z5.g = "EX_NATIVE";
                    }
                    N5 n11 = N5.LPStartSuccess;
                    R5.a(n11, z5, (Integer) null, Q5.a(n11, "funnelState", u5));
                    u5.c(api, str, str2);
                    L4 l20 = u5.g;
                    if (l20 != null) {
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l20).c("U5", "External Native handled successfully");
                    }
                } else {
                    iC = u5.d(api, str, str2, z5);
                }
            } else {
                l4 = u5.g;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l4).c("U5", "invalid scheme - open internal native");
                }
                iC = u5.c(api, str, str2, z5);
            }
        } else if (str3.equals("DEFAULT")) {
            l5 = u5.g;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l5).c("U5", "default - internal native");
            }
            iC = u5.c(api, str, str2, z5);
        } else {
            l4 = u5.g;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l4).c("U5", "invalid scheme - open internal native");
            }
            iC = u5.c(api, str, str2, z5);
        }
        if (iC == 0 || iC == 1) {
            return new S5(1);
        }
        if (z5 != null) {
            z5.g = u5.b.b;
        }
        N5 n12 = N5.LPBrowserOpenFailed;
        R5.a(n12, z5, Integer.valueOf(iC), Q5.a(n12, "funnelState", u5));
        return new S5(2, Integer.valueOf(iC));
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final S5 b(String str, String str2, String str3, Z5 z5) {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l4).c("U5", "In processInMobiNativeBrowserScheme");
        }
        String queryParameter = Uri.parse(str3).getQueryParameter("url");
        if (queryParameter == null || queryParameter.length() == 0) {
            C3614wa c3614wa = this.d;
            if (c3614wa != null) {
                Intrinsics.checkNotNullParameter("Invalid URL", "message");
                c3614wa.f3467a.a(str2, "Invalid URL", str);
            }
            L4 l5 = this.g;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l5).c("U5", "InMobiNativeBrowserScheme url is Empty or null");
            }
            N5 n5 = N5.LPStartFailed;
            R5.a(n5, z5, (Integer) 8001, (Function2) Q5.a(n5, "funnelState", this));
            return new S5(3, 8001);
        }
        int iA = AbstractC3337d3.a(this.f3211a, queryParameter, this.e, str, this.g);
        if (z5 != null) {
            z5.g = "EX_NATIVE";
        }
        if (iA == 0 || iA == 1) {
            N5 n6 = N5.LPStartSuccess;
            R5.a(n6, z5, (Integer) null, Q5.a(n6, "funnelState", this));
            c(str, str2, str3);
            L4 l6 = this.g;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l6).c("U5", "InmobiNativeBrowser scheme url handled successfully");
            }
            return new S5(1);
        }
        C3614wa c3614wa2 = this.d;
        if (c3614wa2 != null) {
            Intrinsics.checkNotNullParameter("Invalid URL", "message");
            c3614wa2.f3467a.a(str2, "Invalid URL", str);
        }
        L4 l7 = this.g;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l7).c("U5", "InmobiNativeBrowser scheme url handling failed");
        }
        N5 n7 = N5.LPBrowserOpenFailed;
        R5.a(n7, z5, Integer.valueOf(iA), Q5.a(n7, "funnelState", this));
        return new S5(2, Integer.valueOf(iA));
    }

    public final int c(String str, String str2, String str3, Z5 z5) {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l4).a("U5", "In processInternalNativeRequest");
        }
        try {
            return d(str, str2, str3, z5);
        } catch (Exception e) {
            C3614wa c3614wa = this.d;
            if (c3614wa != null) {
                Intrinsics.checkNotNullParameter("Unexpected error", "message");
                c3614wa.f3467a.a(str2, "Unexpected error", "open");
            }
            AbstractC3498o6.a((byte) 1, "InMobi", "Failed to open URL SDK encountered unexpected error");
            L4 l5 = this.g;
            if (l5 != null) {
                ((M4) l5).b("U5", ld.a(e, O5.a("U5", "TAG", "SDK encountered unexpected error in handling open() request from creative ")));
            }
            return 9;
        }
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final int d(String api, String str, String str2, Z5 z5) {
        String strA;
        Intrinsics.checkNotNullParameter(api, "api");
        L4 l4 = this.g;
        if (l4 != null) {
            ((M4) l4).c("U5", P5.a("U5", "TAG", "processOpenCCTRequest - url - ", str2));
        }
        if (z5 != null) {
            z5.g = "IN_NATIVE";
        }
        if (str2 == null || (StringsKt.startsWith$default(str2, "http", false, 2, (Object) null) && !URLUtil.isValidUrl(str2))) {
            L4 l5 = this.g;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l5).c("U5", api + " called with invalid url (" + str2 + ')');
            }
            C3614wa c3614wa = this.d;
            if (c3614wa != null) {
                Intrinsics.checkNotNullParameter("Invalid URL", "message");
                c3614wa.f3467a.a(str, "Invalid URL", api);
            }
            N5 n5 = N5.LPStartFailed;
            R5.a(n5, z5, (Integer) 3, (Function2) Q5.a(n5, "funnelState", this));
            return 3;
        }
        String strA2 = Y2.a(this.f3211a);
        try {
            try {
                boolean z = this.b.c;
                if (strA2 != null && z) {
                    S1 s1 = new S1(str2, this.f3211a, this.c, this.e, z5, api);
                    W2 w2 = s1.f;
                    Context context = s1.g;
                    if (w2.f3223a == null && context != null && (strA = Y2.a(context)) != null) {
                        U2 u2 = new U2(w2);
                        w2.b = u2;
                        CustomTabsClient.bindCustomTabsService(context, strA, u2);
                    }
                    L4 l6 = this.g;
                    if (l6 != null) {
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l6).c("U5", "Default and Internal Native handled successfully");
                    }
                    return 0;
                }
                L4 l7 = this.g;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l7).a("U5", "ChromeCustomTab fallback to Embedded");
                }
                return b(str2, api, z5);
            } catch (Exception unused) {
                int iA = AbstractC3392h2.a(this.f3211a, str2, (InterfaceC3386ga) this.e, api);
                if (iA != 0 && iA != 1) {
                    return iA;
                }
                C3614wa c3614wa2 = this.d;
                if (c3614wa2 != null) {
                    Ba.a(c3614wa2.f3467a, api, str, str2);
                }
                C3614wa c3614wa3 = this.d;
                if (c3614wa3 != null) {
                    c3614wa3.f3467a.getListener().a();
                }
                if (z5 != null) {
                    z5.g = "EX_NATIVE";
                }
                N5 funnelState = N5.LPStartSuccess;
                Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                R5.a(funnelState, z5, (Integer) null, new T5(this));
                return iA;
            }
        } catch (Exception e) {
            L4 l8 = this.g;
            if (l8 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l8).a("U5", "Exception occurred while opening External ", e);
            }
            return 9;
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final void e(String str, String str2, String str3, Z5 z5) {
        try {
            AbstractC3392h2.a(this.f3211a, str2, (InterfaceC3386ga) this.e, "openExternal");
            N5 n5 = N5.LPStartSuccess;
            R5.a(n5, z5, (Integer) null, Q5.a(n5, "funnelState", this));
            c("openExternal", str, str2);
        } catch (ActivityNotFoundException e) {
            a(this, str, str2, str3, z5, e);
        } catch (NullPointerException e2) {
            a(this, str, str2, str3, z5, e2);
        } catch (URISyntaxException e3) {
            a(this, str, str2, str3, z5, e3);
        } catch (Exception e4) {
            N5 n6 = N5.LPBrowserOpenFailed;
            R5.a(n6, z5, (Integer) 9, (Function2) Q5.a(n6, "funnelState", this));
            C3614wa c3614wa = this.d;
            if (c3614wa != null) {
                Intrinsics.checkNotNullParameter("Unexpected error", "message");
                c3614wa.f3467a.a(str, "Unexpected error", "openExternal");
            }
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            AbstractC3498o6.a((byte) 1, "U5", "Could not open URL SDK encountered an unexpected error");
            L4 l4 = this.g;
            if (l4 != null) {
                ((M4) l4).b("U5", ld.a(e4, O5.a("U5", "TAG", "SDK encountered unexpected error in handling openExternal() request from creative ")));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final int a(String str, String str2, Z5 z5) {
        Intrinsics.checkNotNullParameter("customExpand", "api");
        if (str2 != null && str2.length() != 0) {
            Uri uri = Uri.parse(str2);
            String scheme = uri.getScheme();
            if (scheme != null && scheme.length() != 0) {
                if (Intrinsics.areEqual(uri.getScheme(), "inmobinativebrowser")) {
                    b("customExpand", str, str2, z5);
                    return 2;
                }
                if (Intrinsics.areEqual(uri.getScheme(), "inmobideeplink")) {
                    if (a("customExpand", str, str2, z5).f3190a == 1) {
                        return 2;
                    }
                } else {
                    if (V0.a(this.f3211a, str2, this.e, "customExpand", this.g)) {
                        c("customExpand", str, str2);
                        if (z5 != null) {
                            z5.g = "EX_NATIVE";
                        }
                        N5 n5 = N5.LPStartSuccess;
                        R5.a(n5, z5, (Integer) null, Q5.a(n5, "funnelState", this));
                        return 2;
                    }
                    Intrinsics.checkNotNull(uri);
                    if (AbstractC3392h2.a(uri)) {
                        return 3;
                    }
                    int iA = AbstractC3337d3.a(this.f3211a, str2, this.e, "customExpand", this.g);
                    if (z5 != null) {
                        z5.g = "EX_NATIVE";
                    }
                    if (iA != 0 && iA != 1) {
                        L4 l4 = this.g;
                        if (l4 != null) {
                            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                            ((M4) l4).b("U5", "CustomExpand handling failed");
                        }
                        N5 n6 = N5.LPCompleteFailed;
                        R5.a(n6, z5, (Integer) null, Q5.a(n6, "funnelState", this));
                    } else {
                        c("customExpand", str, str2);
                        N5 n7 = N5.LPStartSuccess;
                        R5.a(n7, z5, (Integer) null, Q5.a(n7, "funnelState", this));
                        L4 l5 = this.g;
                        if (l5 == null) {
                            return 2;
                        }
                        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                        ((M4) l5).c("U5", "Deeplink url handled successfully");
                        return 2;
                    }
                }
                return 4;
            }
            b("customExpand", str, str2);
            N5 n8 = N5.LPStartFailed;
            R5.a(n8, z5, (Integer) 4, (Function2) Q5.a(n8, "funnelState", this));
            return 1;
        }
        b("customExpand", str, str2);
        N5 n9 = N5.LPStartFailed;
        R5.a(n9, z5, (Integer) 2, (Function2) Q5.a(n9, "funnelState", this));
        return 1;
    }

    public final S5 a(String str, String str2, String str3, Z5 z5) {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l4).a("U5", "In processInMobiDeepLinkScheme");
        }
        Uri uri = Uri.parse(str3);
        int iA = a(str, uri.getQueryParameter("primaryUrl"), uri.getQueryParameter("primaryTrackingUrl"));
        if (iA != 0 && iA != 1) {
            int iA2 = a(str, uri.getQueryParameter("fallbackUrl"), uri.getQueryParameter("fallbackTrackingUrl"));
            if (z5 != null) {
                z5.g = "EX_NATIVE";
            }
            if (iA2 != 0 && iA2 != 1) {
                C3614wa c3614wa = this.d;
                if (c3614wa != null) {
                    Intrinsics.checkNotNullParameter("Invalid URL", "message");
                    c3614wa.f3467a.a(str2, "Invalid URL", str);
                }
                L4 l5 = this.g;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l5).c("U5", "InMobiDeepLinkScheme Fallback Url handling failed");
                }
                N5 n5 = N5.LPBrowserOpenFailed;
                R5.a(n5, z5, Integer.valueOf(iA2), Q5.a(n5, "funnelState", this));
                return new S5(2, Integer.valueOf(iA2));
            }
            L4 l6 = this.g;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l6).c("U5", "InMobiDeepLinkScheme Fallback Url handled successfully");
            }
            N5 n6 = N5.LPStartSuccess;
            R5.a(n6, z5, (Integer) null, Q5.a(n6, "funnelState", this));
            c(str, str2, str3);
            return new S5(1);
        }
        L4 l7 = this.g;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l7).c("U5", "InMobiDeepLinkScheme Primary Url handled successfully");
        }
        if (z5 != null) {
            z5.g = "EX_NATIVE";
        }
        N5 n7 = N5.LPStartSuccess;
        R5.a(n7, z5, (Integer) null, Q5.a(n7, "funnelState", this));
        c(str, str2, str3);
        return new S5(1);
    }

    public final void c(String str, String str2, String str3) {
        C3614wa c3614wa = this.d;
        if (c3614wa != null) {
            c3614wa.f3467a.getListener().a();
        }
        C3614wa c3614wa2 = this.d;
        if (c3614wa2 != null) {
            Ba.a(c3614wa2.f3467a, str, str2, str3);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final int a(String str, String str2, String str3) {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l4).c("U5", "inMobiDeepLinkSchemeUrlHandled - url - " + str2 + " trackingUrl " + str3);
        }
        if (str2 != null && str2.length() != 0) {
            int iA = AbstractC3337d3.a(this.f3211a, str2, this.e, str, this.g);
            if (iA != 0 && iA != 1) {
                L4 l5 = this.g;
                if (l5 == null) {
                    return iA;
                }
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l5).c("U5", "InMobiDeepLinkScheme scheme applink/http url handling failed");
                return iA;
            }
            if (AbstractC3420j2.a(str3)) {
                C3364f2 c3364f2 = C3364f2.f3308a;
                Intrinsics.checkNotNull(str3);
                c3364f2.a(str3, true, this.g);
            } else {
                L4 l6 = this.g;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                    ((M4) l6).b("U5", "InMobiDeepLinkScheme scheme tracking url handling is invalid ");
                }
            }
            L4 l7 = this.g;
            if (l7 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l7).c("U5", "InMobiDeepLinkScheme scheme applink/http url handled successfully");
            }
            return 0;
        }
        L4 l8 = this.g;
        if (l8 == null) {
            return 2;
        }
        Intrinsics.checkNotNullExpressionValue("U5", "TAG");
        ((M4) l8).b("U5", "InMobiDeepLinkScheme url is Empty or null");
        return 2;
    }

    public static final void a(U5 u5, String str, String str2, String str3, Z5 z5, Exception exc) {
        L4 l4 = u5.g;
        if (l4 != null) {
            ((M4) l4).b("U5", ld.a(exc, O5.a("U5", "TAG", "Error message in processing openExternal: ")));
        }
        C3614wa c3614wa = u5.d;
        if (c3614wa != null) {
            StringBuilder sb = new StringBuilder("Cannot resolve URI (");
            try {
                String strEncode = URLEncoder.encode(str2, "UTF-8");
                Intrinsics.checkNotNull(strEncode);
                str2 = strEncode;
            } catch (UnsupportedEncodingException unused) {
            }
            String message = sb.append(str2).append(')').toString();
            Intrinsics.checkNotNullParameter(message, "message");
            c3614wa.f3467a.a(str, message, "openExternal");
        }
        if (str3 != null) {
            u5.e(str, str3, null, z5);
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.inmobi.media.H1, com.inmobi.media.ga] */
    public final int b(String url, String api, Z5 z5) {
        Z5 z6;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
        if (z5 != null) {
            z5.g = "IN_CUSTOM";
        }
        if (url.length() == 0) {
            L4 l4 = this.g;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("U5", "TAG");
                ((M4) l4).b("U5", "processOpenEmbeddedRequest failed due to empty URL");
            }
            N5 n5 = N5.LPStartFailed;
            R5.a(n5, z5, (Integer) null, Q5.a(n5, "funnelState", this));
            return 2;
        }
        if (V0.a(this.f3211a, url, this.e, api, this.g)) {
            return 0;
        }
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        if (AbstractC3392h2.a(uri)) {
            Intent intent = new Intent(this.f3211a, (Class<?>) InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", url);
            intent.putExtra("viewTouchTimestamp", this.e.getViewTouchTimestamp());
            if (z5 != null) {
                C3297a6 landingPageTelemetryMetaData = z5.f3254a;
                String urlType = z5.b;
                int i2 = z5.c;
                long j = z5.d;
                Intrinsics.checkNotNullParameter(landingPageTelemetryMetaData, "landingPageTelemetryMetaData");
                Intrinsics.checkNotNullParameter(urlType, "urlType");
                z6 = new Z5(landingPageTelemetryMetaData, urlType, i2, j);
                N5 n6 = N5.LPClickStart;
                z6.f = 2;
                Unit unit = Unit.INSTANCE;
            } else {
                z6 = null;
            }
            intent.putExtra("lpTelemetryControlInfo", z6);
            L4 obj = this.g;
            if (obj != null) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                HashMap map = AbstractC3636y4.f3484a;
                String key = string.toString();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(obj, "obj");
                AbstractC3636y4.f3484a.put(key, new WeakReference(obj));
                intent.putExtra("loggerCacheKey", string.toString());
            }
            C3614wa c3614wa = this.d;
            if (c3614wa != null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                intent.putExtra("creativeId", c3614wa.f3467a.getCreativeId());
                intent.putExtra("impressionId", c3614wa.f3467a.getImpressionId());
                intent.putExtra("placementId", c3614wa.f3467a.getPlacementId());
                SparseArray sparseArray = InMobiAdActivity.k;
                Ba ba = c3614wa.f3467a;
                InMobiAdActivity.l = ba;
                C3517pb.f3400a.a(ba.getContainerContext(), intent);
            }
            N5 n7 = N5.LPStartSuccess;
            R5.a(n7, z5, (Integer) null, Q5.a(n7, "funnelState", this));
            C3614wa c3614wa2 = this.d;
            if (c3614wa2 != null) {
                Ba.a(c3614wa2.f3467a, null, null, url);
            }
            return 1;
        }
        L4 l5 = this.g;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l5).b("U5", "Embedded request unable to handle ".concat(url));
        }
        return 10;
    }

    public final void b(String str, String str2, String str3) {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("U5", "TAG");
            ((M4) l4).c("U5", str + " called with invalid url (" + str3 + ')');
        }
        C3614wa c3614wa = this.d;
        if (c3614wa != null) {
            Intrinsics.checkNotNullParameter("Invalid URL", "message");
            c3614wa.f3467a.a(str2, "Invalid URL", str);
        }
    }
}
