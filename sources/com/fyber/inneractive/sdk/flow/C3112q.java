package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.AbstractC3270i;
import com.fyber.inneractive.sdk.web.InterfaceC3268g;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3112q implements InterfaceC3268g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3113s f1806a;

    public C3112q(C3113s c3113s) {
        this.f1806a = c3113s;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3268g
    public final void a(AbstractC3270i abstractC3270i) {
        C3113s c3113s = this.f1806a;
        c3113s.getClass();
        IAlog.a("%sweb view returned onReady!", IAlog.a(c3113s));
        com.fyber.inneractive.sdk.response.e eVar = this.f1806a.b;
        UnitDisplayType unitDisplayType = eVar != null ? ((com.fyber.inneractive.sdk.response.f) eVar).p : null;
        if (unitDisplayType != null && unitDisplayType.isFullscreenUnit()) {
            C3113s c3113s2 = this.f1806a;
            c3113s2.getClass();
            try {
                EnumC3144u enumC3144u = EnumC3144u.EVENT_READY_ON_CLIENT;
                InneractiveAdRequest inneractiveAdRequest = c3113s2.f1803a;
                x xVar = c3113s2.c;
                new C3146w(enumC3144u, inneractiveAdRequest, xVar != null ? ((O) xVar).b : null).a((String) null);
            } catch (Exception unused) {
            }
        }
        this.f1806a.f();
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3268g
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        this.f1806a.b(inneractiveInfrastructureError);
        C3113s c3113s = this.f1806a;
        c3113s.getClass();
        IAlog.a("%sweb view returned onFailedLoading!", IAlog.a(c3113s));
        this.f1806a.a(inneractiveInfrastructureError);
        if (inneractiveInfrastructureError.getErrorCode() == InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED) {
            EnumC3143t enumC3143t = EnumC3143t.MRAID_ERROR_UNSECURE_CONTENT;
            C3113s c3113s2 = this.f1806a;
            new C3146w(enumC3143t, c3113s2.f1803a, c3113s2.b).a((String) null);
        }
    }
}
