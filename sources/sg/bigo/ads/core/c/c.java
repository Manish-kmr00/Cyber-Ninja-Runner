package sg.bigo.ads.core.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.bigosg.Omid;
import com.iab.omid.library.bigosg.ScriptInjector;
import com.iab.omid.library.bigosg.adsession.AdSession;
import com.iab.omid.library.bigosg.adsession.AdSessionConfiguration;
import com.iab.omid.library.bigosg.adsession.AdSessionContext;
import com.iab.omid.library.bigosg.adsession.CreativeType;
import com.iab.omid.library.bigosg.adsession.ImpressionType;
import com.iab.omid.library.bigosg.adsession.Owner;
import com.iab.omid.library.bigosg.adsession.Partner;
import com.iab.omid.library.bigosg.adsession.VerificationScriptResource;
import com.iab.omid.library.bigosg.adsession.media.MediaEvents;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.omsdk.POBOMSDKUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.h.d;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends d {
    protected String e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f13533a = new c(0);
    }

    private c() {
        this.e = "";
    }

    /* synthetic */ c(byte b) {
        this();
    }

    @Override // sg.bigo.ads.common.h.d
    public final String a() {
        return POBOMSDKUtil.TAG;
    }

    @Override // sg.bigo.ads.common.h.d
    public final String a(Context context) {
        return o.g(context);
    }

    public final b a(WebView webView, View... viewArr) {
        AdSession adSessionCreateAdSession;
        if (!this.b) {
            return null;
        }
        try {
            adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner("Bigosg", "5.2.1"), webView, null));
            try {
                adSessionCreateAdSession.registerAdView(webView);
                for (View view : viewArr) {
                    if (view != null) {
                        adSessionCreateAdSession.addFriendlyObstruction(view);
                    }
                }
                adSessionCreateAdSession.start();
                sg.bigo.ads.common.t.a.a(0, 3, POBOMSDKUtil.TAG, "createHtmlOmsdkEvent success, AdSession Id: " + adSessionCreateAdSession.getAdSessionId());
                return new b(adSessionCreateAdSession, null);
            } catch (Exception e) {
                e = e;
                sg.bigo.ads.common.t.a.b(POBOMSDKUtil.TAG, "createHtmlOmsdkEvent error: " + e.getMessage());
                if (adSessionCreateAdSession != null) {
                    adSessionCreateAdSession.finish();
                }
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            adSessionCreateAdSession = null;
        }
    }

    public final b a(List<sg.bigo.ads.core.c.a> list, boolean z, View view, View... viewArr) {
        AdSession adSessionCreateAdSession;
        String str;
        if (!this.b) {
            str = "Fail to create native OM AdSession: OMSDK is not ready";
        } else if (list == null) {
            str = "Fail to create native OM AdSession: OM configs is null";
        } else {
            try {
                Partner partnerCreatePartner = Partner.createPartner("Bigosg", "5.2.1");
                ArrayList arrayList = new ArrayList();
                for (sg.bigo.ads.core.c.a aVar : list) {
                    if (!TextUtils.isEmpty(aVar.f13526a)) {
                        arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(aVar.b, new URL(aVar.f13526a), aVar.c));
                        sg.bigo.ads.common.t.a.a(0, 3, POBOMSDKUtil.TAG, "Create verificationScriptResource: " + aVar.b + " " + aVar.f13526a + " " + aVar.c);
                    }
                }
                if (arrayList.size() == 0) {
                    sg.bigo.ads.common.t.a.b(POBOMSDKUtil.TAG, "Fail to create native OM AdSession: no verification script resources");
                    return null;
                }
                adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(z ? CreativeType.VIDEO : CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, z ? Owner.NATIVE : Owner.NONE, false), AdSessionContext.createNativeAdSessionContext(partnerCreatePartner, this.f13206a, arrayList, ""));
                try {
                    adSessionCreateAdSession.registerAdView(view);
                    if (viewArr != null) {
                        for (View view2 : viewArr) {
                            if (view2 != null) {
                                adSessionCreateAdSession.addFriendlyObstruction(view2);
                            }
                        }
                    }
                    MediaEvents mediaEventsCreateMediaEvents = z ? MediaEvents.createMediaEvents(adSessionCreateAdSession) : null;
                    adSessionCreateAdSession.start();
                    sg.bigo.ads.common.t.a.a(0, 3, POBOMSDKUtil.TAG, "Create native OM AdSession success, AdSession Id: " + adSessionCreateAdSession.getAdSessionId());
                    return new b(adSessionCreateAdSession, mediaEventsCreateMediaEvents);
                } catch (Exception e) {
                    e = e;
                    sg.bigo.ads.common.t.a.b(POBOMSDKUtil.TAG, "Fail to create native OM Session: : " + e.getMessage());
                    if (adSessionCreateAdSession != null) {
                        adSessionCreateAdSession.finish();
                    }
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                adSessionCreateAdSession = null;
            }
        }
        sg.bigo.ads.common.t.a.b(POBOMSDKUtil.TAG, str);
        return null;
    }

    public final void a(final Context context, String str) {
        try {
            Omid.activate(context);
            sg.bigo.ads.common.t.a.a(POBOMSDKUtil.TAG, "OM SDK initialized successfully.");
            this.e = str;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.c.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = c.this;
                    Context context2 = context;
                    if (!cVar.e(context2)) {
                        cVar.a("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js", context2);
                        return;
                    }
                    cVar.f13206a = cVar.d(context2);
                    if (TextUtils.isEmpty(cVar.f13206a)) {
                        cVar.a("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js", context2);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(POBOMSDKUtil.TAG, "Fetch omsdk-v1.js from file successfully.");
                    cVar.b = true;
                    cVar.b(context2);
                }
            });
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(1, 5, POBOMSDKUtil.TAG, "Failed to initialize OM SDK initialize: " + th.getMessage());
        }
    }

    @Override // sg.bigo.ads.common.h.d
    public final void a(String str) {
        sg.bigo.ads.common.x.a.b(str);
    }

    @Override // sg.bigo.ads.common.h.d
    public final boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }

    @Override // sg.bigo.ads.common.h.d
    public final String b() {
        return POBCommonConstants.INTERNAL_SERVICE_FILE_NAME;
    }

    @Override // sg.bigo.ads.common.h.d
    public final boolean b(String str) {
        return str.contains("omidGlobal");
    }

    @Override // sg.bigo.ads.common.h.d
    public final String c() {
        return "https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js";
    }

    public final String c(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.f13206a, str);
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // sg.bigo.ads.common.h.d
    public final String d() {
        return this.e;
    }

    @Override // sg.bigo.ads.common.h.d
    public final String e() {
        return sg.bigo.ads.common.x.a.g();
    }
}
