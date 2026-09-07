package com.facebook.ads.redexgen.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class mQ implements InterfaceC13987l {
    public final C12752p A00;
    public final AnonymousClass33 A01;
    public final C14067t A02;
    public final C2699k1 A03;
    public final boolean A04;

    public mQ(C2699k1 c2699k1, AnonymousClass33 anonymousClass33, C14067t c14067t, C12752p c12752p, boolean z) {
        this.A03 = c2699k1;
        this.A01 = anonymousClass33;
        this.A02 = c14067t;
        this.A00 = c12752p;
        this.A04 = z;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        AnonymousClass34 playableWebViewClient = new AnonymousClass34(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0F());
        playableWebViewClient.A03();
    }

    private void A01(boolean z) {
        if (this.A00.A0A() == EnumC12762q.A05) {
            A00();
            return;
        }
        String strA0F = this.A00.A0F();
        if (z) {
            C14067t c14067t = this.A02;
            String markupUrlResult = this.A00.A0F();
            strA0F = c14067t.A0R(markupUrlResult);
        }
        this.A00.A0K(strA0F);
        this.A01.AEU();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACa() {
        if (this.A04) {
            this.A01.AET(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACj() {
        A01(true);
    }
}
