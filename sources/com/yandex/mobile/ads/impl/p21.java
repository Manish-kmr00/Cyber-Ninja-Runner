package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class p21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9890a = new Regex("(?m)^//.*(?=\\n)").replace(new Regex("(?m)^\\s+").replace("!function(e){function t(r){if(n[r])return n[r].exports;var o=n[r]={exports:{},id:r,loaded:!1};return e[r].call(o.exports,o,o.exports,t),o.loaded=!0,o.exports}var n={};return t.m=e,t.c=n,t.p=\"\",t(0)}([function(e,t,n){var r,o;r=[n,t,n(1)],o=function(e,t,n){\"use strict\";Object.defineProperty(t,\"__esModule\",{value:!0});var r=window;r.mraid=n.mraid,r.mraidbridge=n.mraidbridge}.apply(t,r),!(void 0!==o&&(e.exports=o))},function(e,t,n){var r,o;r=[n,t,n(2)],o=function(e,t,n){\"use strict\";function r(){return O}function o(){return b}function i(){return I}function s(e,t){e&&t||V(_.ERROR,\"Both event and listener are required.\",\"addEventListener\"),\"undefined\"==typeof w[e]&&(w[e]=new n.default(e)),w[e].add(t)}function u(e,t){if(!e)return void V(_.ERROR,\"Event is required.\",\"removeEventListener\");if(t){var n=!1;if(w[e]&&(n=w[e].remove(t)),!n)return void V(_.ERROR,\"Listener not currently registered for event.\",\"removeEventListener\")}else!t&&w[e]&&w[e].removeAll();w[e]&&0===w[e].count&&(w[e]=null,delete w[e])}function a(e){for(var t in e)if(e.hasOwnProperty(t)){var n=U[t];n(e[t])}}function d(e){I=e,V(\"stateChange\",I)}function l(e){N=e}function c(){return{x:N.x,y:N.y,width:N.width,height:N.height}}function f(e){P=e}function v(){return{x:P.x,y:P.y,width:P.width,height:P.height}}function p(){L=!0,V(\"ready\")}function E(e,t){V(_.ERROR,e,t)}function h(e){T=Boolean(e),m([\"usecustomclose\",\"shouldUseCustomClose\",e?\"true\":\"false\"])}function R(){return T}function g(){return 0===G.length?void(H=!1):void(x.location=G.pop())}function y(e){e?m([\"open\",\"url\",e]):V(_.ERROR,\"`url` parameter is required\",\"open\")}function m(e){var t=e.shift();if(!L)return console.log(\"rejecting \"+t+\" because mraid is not ready\"),void E(\"mraid is not ready\",t);for(var n=\"mraid://\"+t,r=!0,o=0;o<e.length;o+=2){var i=void 0,s=void 0;i=e[o],s=e[o+1],null!==s&&(r?(n+=\"?\",r=!1):n+=\"&\",n+=encodeURIComponent(i)+\"=\"+encodeURIComponent(s))}H?G.push(n):(x.location=n,H=!0)}function C(e){return S[e]}function A(){I===D.HIDDEN?V(_.ERROR,\"Ad cannot be closed when it is already hidden.\",\"close\"):m([\"close\"])}Object.defineProperty(t,\"__esModule\",{value:!0});var x=window,O=\"2.0\",b=!1,w={},P={},N={},D={LOADING:\"loading\",DEFAULT:\"default\",EXPANDED:\"expanded\",RESIZED:\"resized\",HIDDEN:\"hidden\"},_={READY:\"ready\",ERROR:\"error\",STATE_CHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\",SIZECHANGE:\"sizeChange\",EXPOSURECHANGE:\"exposureChange\"},S={sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1},I=\"loading\",L=!1,H=!1,G=[],T=!1,V=function(){for(var e=[],t=0;t<arguments.length;t++)e[t]=arguments[t];var n=e.shift();w[n]&&(r=w[n]).broadcast.apply(r,e);var r},U={state:function(e){I=e,V(_.STATE_CHANGE,I)},viewable:function(e){b=e,V(_.VIEWABLECHANGE,b)},supports:function(e){S=e},exposure:function(e){var t=e.exposedPercentage,n=e.visibleRectangle,r=e.occlusionRectangles;V(_.EXPOSURECHANGE,t,n,r)}};t.mraidbridge={setState:d,setCurrentPosition:f,setDefaultPosition:l,notifyReadyEvent:p,notifyErrorEvent:E,executeNativeCall:m,fireChangeEvent:a,nativeCallComplete:g},t.mraid={EVENTS:_,STATES:D,getVersion:r,getCurrentPosition:v,getDefaultPosition:c,isViewable:o,getState:i,addEventListener:s,removeEventListener:u,supports:C,close:A,useCustomClose:h,open:y,__PRIV__:{usesCustomClose:R}}}.apply(t,r),!(void 0!==o&&(e.exports=o))},function(e,t,n){var r,o;r=[n,t],o=function(e,t){\"use strict\";Object.defineProperty(t,\"__esModule\",{value:!0});var n=function(){function e(e){this.event=e,this.count=0,this.listeners=[]}return e.prototype.add=function(e){var t=this.listeners;t.push(e),this.count++},e.prototype.remove=function(e){var t=this.listeners,n=t.indexOf(e);return n!==-1&&(t.splice(n,1),this.count--,!0)},e.prototype.removeAll=function(){this.listeners;this.listeners=[],this.count=0},e.prototype.broadcast=function(){for(var e=[],t=0;t<arguments.length;t++)e[t]=arguments[t];for(var n=this.listeners,r=0,o=n;r<o.length;r++){var i=o[r];i.apply(void 0,e)}},e}();t.default=n}.apply(t,r),!(void 0!==o&&(e.exports=o))}]);", ""), "");

    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a onLoadListener, String str) {
        Intrinsics.checkNotNullParameter(onLoadListener, "$onLoadListener");
        Intrinsics.checkNotNull(str);
        onLoadListener.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a onLoadListener, ki2 ki2Var) {
        Intrinsics.checkNotNullParameter(onLoadListener, "$onLoadListener");
        onLoadListener.a(f9890a);
        op0.f(new Object[0]);
    }

    public static void a(Context context, String requestTag, a onLoadListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(onLoadListener, "onLoadListener");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        String strC = cu1VarA != null ? cu1VarA.C() : null;
        if (strC != null && strC.length() > 0) {
            x22 request = a(strC, requestTag, onLoadListener);
            int i2 = zp1.c;
            synchronized (zp1.a.a()) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(request, "request");
                dd1.a(context).a(request);
            }
            return;
        }
        onLoadListener.a(f9890a);
        op0.f(new Object[0]);
    }

    private static x22 a(String str, String str2, final a aVar) {
        x22 x22Var = new x22(str, new qq1.b() { // from class: com.yandex.mobile.ads.impl.p21$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.qq1.b
            public final void a(Object obj) {
                p21.a(aVar, (String) obj);
            }
        }, new qq1.a() { // from class: com.yandex.mobile.ads.impl.p21$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.qq1.a
            public final void a(ki2 ki2Var) {
                p21.a(aVar, ki2Var);
            }
        });
        x22Var.b((Object) str2);
        return x22Var;
    }
}
