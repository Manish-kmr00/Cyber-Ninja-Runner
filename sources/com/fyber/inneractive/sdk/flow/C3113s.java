package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.RunnableC3239c;
import com.fyber.inneractive.sdk.web.C3266e;
import com.fyber.inneractive.sdk.web.EnumC3286z;
import com.fyber.inneractive.sdk.web.InterfaceC3268g;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3113s extends AbstractC3106k {
    public IAmraidWebViewController m;
    public final C3112q n = new C3112q(this);

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final InneractiveInfrastructureError c() {
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        int i = 0;
        if (aVar != null) {
            int i2 = this.i;
            if (aVar.g) {
                i2 = aVar.f1932a - i2;
            }
            i = (i2 == aVar.f1932a ? aVar.h : 0) + (aVar.b * i2) + aVar.d;
        }
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, EnumC3104i.WEBVIEW_LOAD_TIMEOUT, new Exception("LoadTimeout after " + i + " ms"));
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final String d() {
        return "send_failed_display_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final void g() {
        EnumC3286z enumC3286z;
        String str;
        O o = new O(e(), this.g);
        this.c = o;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) eVar;
        o.b = fVar;
        o.f = this.h;
        com.fyber.inneractive.sdk.measurement.e eVar2 = null;
        UnitDisplayType unitDisplayType = eVar != null ? fVar.p : null;
        com.fyber.inneractive.sdk.web.C c = com.fyber.inneractive.sdk.web.C.INLINE;
        if (unitDisplayType == null) {
            this.n.a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.EMPTY_UNIT_DISPLAY_TYPE, new Exception("Unit display type was not found")));
            return;
        }
        int i = r.f1807a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            enumC3286z = EnumC3286z.ENABLED;
            InneractiveAdRequest inneractiveAdRequest = this.f1803a;
            if (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen()) {
                c = com.fyber.inneractive.sdk.web.C.INTERSTITIAL;
            }
        } else {
            enumC3286z = EnumC3286z.ENABLED;
        }
        com.fyber.inneractive.sdk.web.C c2 = c;
        EnumC3286z enumC3286z2 = enumC3286z;
        com.fyber.inneractive.sdk.response.e eVar3 = this.b;
        boolean z = (eVar3 == null || (str = ((com.fyber.inneractive.sdk.response.f) eVar3).M) == null || str.contains("iaNotifyLoadFinished")) ? false : true;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        boolean z2 = !unitDisplayType.isFullscreenUnit() || iAConfigManager.u.b.a(true, "use_fraud_detection_fullscreen");
        try {
            com.fyber.inneractive.sdk.web.D d = com.fyber.inneractive.sdk.web.D.AD_CONTROLLED;
            com.fyber.inneractive.sdk.config.global.r rVar = this.g;
            if (rVar != null) {
                Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.m) rVar.a(com.fyber.inneractive.sdk.config.global.features.m.class)).c(com.json.mediationsdk.metadata.a.j);
                boolean zBooleanValue = boolC != null ? boolC.booleanValue() : false;
                IAlog.a("OMSDK AB %s", String.valueOf(zBooleanValue));
                if (zBooleanValue) {
                    eVar2 = iAConfigManager.K;
                }
            }
            IAmraidWebViewController iAmraidWebViewController = new IAmraidWebViewController(z2, c2, enumC3286z2, d, z, eVar2, this.g);
            this.m = iAmraidWebViewController;
            iAmraidWebViewController.setAdContent(this.c);
            this.m.setAdRequest(this.f1803a);
            IAmraidWebViewController iAmraidWebViewController2 = this.m;
            O o2 = (O) this.c;
            o2.getClass();
            iAmraidWebViewController2.setMuteMraidVideo(iAConfigManager.k || o2.f);
            ((O) this.c).i = this.m;
            com.fyber.inneractive.sdk.response.e eVar4 = this.b;
            if (eVar4 != null) {
                UnitDisplayType unitDisplayType2 = ((com.fyber.inneractive.sdk.response.f) eVar4).p;
                InneractiveAdRequest inneractiveAdRequest2 = this.f1803a;
                boolean z3 = inneractiveAdRequest2 == null || inneractiveAdRequest2.getAllowFullscreen();
                StringBuilder sb = new StringBuilder();
                if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z3) {
                    sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
                }
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                if (unitDisplayType2 != null && !unitDisplayType2.isFullscreenUnit()) {
                    if (unitDisplayType2 == UnitDisplayType.BANNER) {
                        sb2.append(" body {display: flex;} #iawrapper { position:unset !important; display: unset !important; } ");
                    } else {
                        sb2.append(" #iawrapper { position:unset !important; display: unset !important; }");
                    }
                }
                String string2 = sb2.toString();
                this.m.setAutoplayMRAIDVideos(unitDisplayType.isFullscreenUnit());
                IAmraidWebViewController iAmraidWebViewController3 = this.m;
                int i2 = AbstractC3081k.f1710a;
                String property = System.getProperty("ia.testEnvironmentConfiguration.name");
                String str2 = TextUtils.isEmpty(property) ? "wv.inner-active.mobi/simpleM2M/" : property + ".inner-active.mobi/simpleM2M/";
                String str3 = "" + ((com.fyber.inneractive.sdk.response.f) this.b).M;
                iAmraidWebViewController3.f = this.n;
                try {
                    iAmraidWebViewController3.h();
                    C3266e c3266e = new C3266e(iAmraidWebViewController3, str3, true, string, string2, str2);
                    iAmraidWebViewController3.o = c3266e;
                    c3266e.a().post(new RunnableC3239c(c3266e));
                } catch (Throwable th) {
                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_CONFIGURE_WEBVIEW, th);
                    InterfaceC3268g interfaceC3268g = iAmraidWebViewController3.f;
                    if (interfaceC3268g != null) {
                        interfaceC3268g.a(inneractiveInfrastructureError);
                    }
                    iAmraidWebViewController3.b(true);
                }
            }
        } catch (Throwable th2) {
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_CREATE_WEBVIEW_CONTROLLER, th2));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        IAmraidWebViewController iAmraidWebViewController;
        IAlog.a("%s : IAMraidContentLoader : destroyController", IAlog.a(this));
        if (this.c != null && (iAmraidWebViewController = this.m) != null) {
            com.fyber.inneractive.sdk.measurement.tracker.f fVar = iAmraidWebViewController.I;
            if (fVar != null) {
                fVar.a(false);
            }
            this.m.e();
            this.m = null;
        }
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        IAmraidWebViewController iAmraidWebViewController;
        IAlog.a("%s : IAMraidContentLoader : destroyController", IAlog.a(this));
        if (this.c != null && (iAmraidWebViewController = this.m) != null) {
            com.fyber.inneractive.sdk.measurement.tracker.f fVar = iAmraidWebViewController.I;
            if (fVar != null) {
                fVar.a(false);
            }
            this.m.e();
            this.m = null;
        }
        this.k.a();
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.f1803a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
