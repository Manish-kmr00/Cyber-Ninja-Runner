package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.ResolveInfo;
import java.net.URISyntaxException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.d3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3337d3 {
    public static int a(Context context, String url, InterfaceC3386ga redirectionValidator, String api, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (l4 != null) {
            ((M4) l4).c("DeeplinkHandler", "In appLinkOrDeepLinkHandled");
        }
        if (url.length() == 0) {
            if (l4 == null) {
                return 2;
            }
            ((M4) l4).c("DeeplinkHandler", "AppLink url is Empty or null");
            return 2;
        }
        try {
            ArrayList arrayListB = AbstractC3392h2.b(context, url);
            if (!arrayListB.isEmpty()) {
                if (l4 != null) {
                    ((M4) l4).c("DeeplinkHandler", "Resolve Info " + ((ResolveInfo) arrayListB.get(0)).activityInfo.name);
                }
                return a(context, url, (ResolveInfo) arrayListB.get(0), redirectionValidator, api, l4);
            }
            if (l4 != null) {
                ((M4) l4).c("DeeplinkHandler", " Resolve Info Empty");
            }
            try {
                return AbstractC3392h2.a(context, url, redirectionValidator, api);
            } catch (ActivityNotFoundException unused) {
                return a(context, url, null, redirectionValidator, api, l4);
            } catch (NullPointerException unused2) {
                return a(context, url, null, redirectionValidator, api, l4);
            } catch (SecurityException unused3) {
                if (l4 != null) {
                    ((M4) l4).b("DeeplinkHandler", "SecurityException");
                }
                return 12;
            } catch (URISyntaxException unused4) {
                if (l4 == null) {
                    return 5;
                }
                ((M4) l4).b("DeeplinkHandler", "uriSyntaxException");
                return 5;
            } catch (Exception e) {
                if (l4 != null) {
                    ((M4) l4).b("DeeplinkHandler", "Exception: " + e);
                }
                return 9;
            }
        } catch (URISyntaxException unused5) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", "URISyntaxException for url: ".concat(url));
            }
            return 5;
        }
    }

    public static int a(Context context, String str, ResolveInfo resolveInfo, InterfaceC3386ga interfaceC3386ga, String str2, L4 l4) {
        try {
            return AbstractC3392h2.a(context, str, resolveInfo, interfaceC3386ga, str2);
        } catch (ActivityNotFoundException unused) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", S.a("ActivityNotFoundException for url: ", str));
            }
            return 6;
        } catch (NullPointerException unused2) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", S.a("NullPointerException for url: ", str));
            }
            return 13;
        } catch (SecurityException unused3) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", S.a("SecurityException for url: ", str));
            }
            return 12;
        } catch (URISyntaxException unused4) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", S.a("URISyntaxException for url: ", str));
            }
            return 5;
        } catch (Exception e) {
            if (l4 != null) {
                ((M4) l4).b("DeeplinkHandler", "Exception: " + e);
            }
            return 9;
        }
    }
}
