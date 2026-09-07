package com.fyber.inneractive.sdk.player.ui.remote;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.player.ui.n;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.util.r;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements com.fyber.inneractive.sdk.web.remoteui.a, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.web.remoteui.a f2243a;
    public final com.fyber.inneractive.sdk.web.remoteui.b b;
    public final S c;
    public final e d;
    public n e;
    public final String f;
    public boolean i;
    public C3102g j;
    public boolean g = false;
    public boolean h = false;
    public final b k = new b(this);
    public final c l = new c(this);
    public boolean m = false;
    public boolean n = false;

    public d(Context context, S s, String str) {
        this.c = s;
        this.f = str;
        com.fyber.inneractive.sdk.web.remoteui.b bVar = new com.fyber.inneractive.sdk.web.remoteui.b();
        this.b = bVar;
        this.d = new e(this);
        bVar.setCommandHandler(this);
        bVar.setResultFailureListener(this);
        bVar.setCommandHandler(this);
        this.j = new C3102g(context, true, s != null ? s.f1840a : null, b(), null);
    }

    @Override // com.fyber.inneractive.sdk.web.remoteui.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, boolean z, HashMap map) {
        IAlog.a("%s : cancel UI load timeout task", "RemoteUIWebviewController");
        r.b.removeCallbacks(this.k);
        String str2 = (map == null || !map.containsKey("failedURL")) ? this.f : (String) map.get("failedURL");
        if (z) {
            if (b() != null) {
                b().L = false;
            }
            a();
            EnumC3143t enumC3143t = EnumC3143t.VAST_ERROR_DVC_FAILURE;
            S s = this.c;
            com.fyber.inneractive.sdk.network.events.a.a(enumC3143t, bVar, s != null ? s.f1840a : null, b(), str, str2, Boolean.valueOf(this.i));
        } else {
            EnumC3143t enumC3143t2 = EnumC3143t.VAST_ERROR_DVC_FAILURE;
            String strName = bVar.name();
            S s2 = this.c;
            com.fyber.inneractive.sdk.network.events.a.a(enumC3143t2, strName, str2, s2 != null ? s2.f1840a : null, b(), map, Boolean.valueOf(this.i));
        }
        com.fyber.inneractive.sdk.web.remoteui.a aVar = this.f2243a;
        if (aVar != null) {
            aVar.a(bVar, str, z, map);
        }
    }

    public final com.fyber.inneractive.sdk.response.e b() {
        S s = this.c;
        if (s != null) {
            return s.b;
        }
        return null;
    }

    public final void a() {
        this.h = true;
        this.e = null;
        e eVar = this.d;
        eVar.b.clear();
        eVar.f2244a = null;
        IAlog.a("%s : cancel UI load timeout task", "RemoteUIWebviewController");
        r.b.removeCallbacks(this.k);
        this.b.setVisibility(8);
        this.b.setUiReady(false);
        this.b.destroy();
        this.j = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.fyber.inneractive.sdk.player.ui.remote.a
    public final void a(String str, HashMap map) {
        d dVar;
        C3102g c3102g;
        h0 lastClickedLocation = this.b.getLastClickedLocation();
        e eVar = this.d;
        eVar.getClass();
        str.getClass();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1965090009:
                if (str.equals("clickSkip")) {
                    b = 0;
                }
                break;
            case -1744940703:
                if (str.equals("expandCollapseClick")) {
                    b = 1;
                }
                break;
            case -1379096487:
                if (str.equals("appInfoClick")) {
                    b = 2;
                }
                break;
            case -1351774483:
                if (str.equals("shouldSkipUpdateUi.true")) {
                    b = 3;
                }
                break;
            case -866863745:
                if (str.equals("onGeneralError")) {
                    b = 4;
                }
                break;
            case -841999016:
                if (str.equals("ctaClick")) {
                    b = 5;
                }
                break;
            case -791299859:
                if (str.equals("isSkipEnabled.false")) {
                    b = 6;
                }
                break;
            case -671397037:
                if (str.equals("clickMuteUnmute")) {
                    b = 7;
                }
                break;
            case -505134137:
                if (str.equals("DOMLoaded")) {
                    b = 8;
                }
                break;
            case -315413572:
                if (str.equals("adIdentifierClick")) {
                    b = 9;
                }
                break;
            case 1031220132:
                if (str.equals("shouldSkipUpdateUi.false")) {
                    b = 10;
                }
                break;
            case 1221833860:
                if (str.equals("isSkipEnabled.true")) {
                    b = Ascii.VT;
                }
                break;
            case 1696642316:
                if (str.equals("onVideoClick")) {
                    b = Ascii.FF;
                }
                break;
            case 1812159227:
                if (str.equals("onResourceError")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                eVar.a(6, lastClickedLocation);
                break;
            case 1:
                eVar.a(5, lastClickedLocation);
                break;
            case 2:
                eVar.a(10, lastClickedLocation);
                break;
            case 3:
                d dVar2 = eVar.f2244a;
                if (dVar2 != null) {
                    dVar2.m = true;
                }
                break;
            case 4:
                d dVar3 = eVar.f2244a;
                if (dVar3 != null) {
                    dVar3.a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_GENERAL_ERROR, (String) map.get("error"), "true".equalsIgnoreCase((String) map.get("shouldFailUi")), map);
                }
                break;
            case 5:
                eVar.a(3, lastClickedLocation);
                break;
            case 6:
                d dVar4 = eVar.f2244a;
                if (dVar4 != null) {
                    dVar4.n = false;
                }
                break;
            case 7:
                eVar.a(1, lastClickedLocation);
                break;
            case 8:
                String str2 = eVar.c ? "FyberRemoteUiBridge.setMute()" : "FyberRemoteUiBridge.setUnmute()";
                d dVar5 = eVar.f2244a;
                if (dVar5 != null) {
                    dVar5.b.a(str2);
                }
                Iterator it = eVar.b.keySet().iterator();
                while (it.hasNext()) {
                    String str3 = (String) eVar.b.get((String) it.next());
                    if (!TextUtils.isEmpty(str3) && (dVar = eVar.f2244a) != null) {
                        dVar.b.a(str3);
                    }
                }
                eVar.b.clear();
                d dVar6 = eVar.f2244a;
                if (dVar6 != null) {
                    IAlog.a("%s : remote UI loaded successfully", "RemoteUIWebviewController");
                    IAlog.a("%s : cancel UI load timeout task", "RemoteUIWebviewController");
                    r.b.removeCallbacks(dVar6.k);
                    dVar6.g = false;
                    dVar6.b.setUiReady(true);
                    if (dVar6.b() != null) {
                        dVar6.b().L = true;
                    }
                    dVar6.b.setVisibility(0);
                }
                break;
            case 9:
                d dVar7 = eVar.f2244a;
                if (dVar7 != null && (c3102g = dVar7.j) != null) {
                    c3102g.a();
                }
                break;
            case 10:
                d dVar8 = eVar.f2244a;
                if (dVar8 != null) {
                    dVar8.m = false;
                }
                break;
            case 11:
                d dVar9 = eVar.f2244a;
                if (dVar9 != null) {
                    dVar9.n = true;
                }
                break;
            case 12:
                eVar.a(7, lastClickedLocation);
                break;
            case 13:
                d dVar10 = eVar.f2244a;
                if (dVar10 != null) {
                    dVar10.a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_RESOURCE_ERROR, (String) map.get("error"), true, map);
                }
                break;
            default:
                IAlog.a("%s: unknown command: %s", "RemoteUiCommandHandler", str);
                break;
        }
        d dVar11 = eVar.f2244a;
        if (dVar11 != null) {
            dVar11.b.a("FyberRemoteUiBridge.nativeCallComplete()");
        }
    }
}
