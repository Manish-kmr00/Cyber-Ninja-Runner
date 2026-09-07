package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.L;
import com.fyber.inneractive.sdk.util.RunnableC3239c;
import com.fyber.inneractive.sdk.util.i0;
import com.fyber.inneractive.sdk.web.C3263b;
import com.fyber.inneractive.sdk.web.C3266e;
import com.fyber.inneractive.sdk.web.C3274m;
import com.fyber.inneractive.sdk.web.EnumC3286z;
import com.fyber.inneractive.sdk.web.InterfaceC3268g;
import com.fyber.inneractive.sdk.web.j0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.controller.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3153d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f1954a;
    public final com.fyber.inneractive.sdk.web.C b;
    public final UnitDisplayType c;
    public final EnumC3286z d;
    public final boolean e;

    public C3153d(Context context, com.fyber.inneractive.sdk.flow.vast.a aVar, com.fyber.inneractive.sdk.model.vast.i iVar, com.fyber.inneractive.sdk.flow.endcard.p pVar) {
        this.b = com.fyber.inneractive.sdk.web.C.INLINE;
        EnumC3286z enumC3286z = EnumC3286z.ENABLED;
        this.d = enumC3286z;
        UnitDisplayType unitDisplayType = aVar.f1834a;
        boolean z = aVar.b;
        this.c = unitDisplayType;
        this.e = z;
        int i = AbstractC3152c.f1953a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            this.d = enumC3286z;
            if (z) {
                this.b = com.fyber.inneractive.sdk.web.C.INTERSTITIAL;
            }
        } else {
            this.d = enumC3286z;
        }
        try {
            UnitDisplayType unitDisplayType2 = aVar.f1834a;
            boolean z2 = !(unitDisplayType2 == null || unitDisplayType2.isFullscreenUnit()) || IAConfigManager.O.u.b.a(true, "use_fraud_detection_fullscreen");
            j0 c3263b = iVar == com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card ? new C3263b(pVar, z2) : new IAmraidWebViewController(z2, this.b, this.d, com.fyber.inneractive.sdk.web.D.AD_CONTROLLED, true, null, null);
            this.f1954a = c3263b;
            C3274m c3274m = c3263b.b;
            if (c3274m != null) {
                int i2 = AbstractC3152c.b[iVar.ordinal()];
                if (i2 == 1) {
                    c3274m.setId(R.id.ia_inneractive_vast_endcard_static);
                } else if (i2 == 2 || i2 == 3) {
                    c3274m.setId(R.id.ia_inneractive_vast_endcard_html);
                } else if (i2 == 4) {
                    c3274m.setId(R.id.ia_inneractive_vast_endcard_iframe);
                }
            }
            j0 j0Var = this.f1954a;
            C3274m c3274m2 = j0Var.b;
            if (c3274m2 != null) {
                L.f2347a.a(context, c3274m2, j0Var);
            }
            j0 j0Var2 = this.f1954a;
            j0Var2.b.setTapListener(j0Var2);
            i0 i0VarA = com.fyber.inneractive.sdk.renderers.k.a(aVar.c, aVar.d, aVar.e);
            this.f1954a.setAdDefaultSize(i0VarA.f2365a, i0VarA.b);
        } catch (Throwable unused) {
            this.f1954a = null;
        }
    }

    public final void a(String str, InterfaceC3268g interfaceC3268g, boolean z) {
        if (this.f1954a == null || TextUtils.isEmpty(str)) {
            interfaceC3268g.a(new InneractiveInfrastructureError(InneractiveErrorCode.UNSPECIFIED, EnumC3104i.NO_WEBVIEW_CONTROLLER_AVAILABLE));
            return;
        }
        j0 j0Var = this.f1954a;
        UnitDisplayType unitDisplayType = this.c;
        j0Var.setAutoplayMRAIDVideos(unitDisplayType != null && unitDisplayType.isFullscreenUnit());
        this.f1954a.setCenteringTagsRequired(false);
        j0 j0Var2 = this.f1954a;
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String str2 = TextUtils.isEmpty(property) ? "wv.inner-active.mobi/simpleM2M/" : property + ".inner-active.mobi/simpleM2M/";
        UnitDisplayType unitDisplayType2 = this.c;
        boolean z2 = this.e;
        StringBuilder sb = new StringBuilder();
        if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z2) {
            sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
        }
        String string = sb.toString();
        UnitDisplayType unitDisplayType3 = this.c;
        StringBuilder sb2 = new StringBuilder();
        if (unitDisplayType3 != null && !unitDisplayType3.isFullscreenUnit()) {
            if (unitDisplayType3 == UnitDisplayType.BANNER) {
                sb2.append(" body {display: flex;} #iawrapper { position:unset !important; display: unset !important; } ");
            } else {
                sb2.append(" #iawrapper { position:unset !important; display: unset !important; }");
            }
        }
        String string2 = sb2.toString();
        j0Var2.f = interfaceC3268g;
        try {
            j0Var2.h();
            C3266e c3266e = new C3266e(j0Var2, str, z, string, string2, str2);
            j0Var2.o = c3266e;
            c3266e.a().post(new RunnableC3239c(c3266e));
        } catch (Throwable th) {
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_CONFIGURE_WEBVIEW, th);
            InterfaceC3268g interfaceC3268g2 = j0Var2.f;
            if (interfaceC3268g2 != null) {
                interfaceC3268g2.a(inneractiveInfrastructureError);
            }
            j0Var2.b(true);
        }
    }

    public final void a() {
        C3274m c3274m;
        j0 j0Var = this.f1954a;
        if (j0Var == null || (c3274m = j0Var.b) == null) {
            return;
        }
        WebSettings settings = c3274m.getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }
}
