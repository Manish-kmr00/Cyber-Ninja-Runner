package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class F3 {
    public static String[] A07 = {"MaUhfef1XHChQSOAsPU", "01oMUC4JT554rhL", "9TYVZPZrh7WqyaB", "ShOi1FYvFM9bF84GqYiu0GZZ4HOF35Af", "s", "YvdeaQsxQHJ3CZVDgFIjqRdATcpqYXuO", "b384kAccrLIUxrnk6NdGu", "f4PnsWwvvRSNWXAtteJ0H"};
    public final String A00 = F3.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<InterfaceC12391f> A03;
    public final WeakReference<F4> A04;
    public final WeakReference<JL> A05;
    public final WeakReference<C2496ge> A06;

    public F3(C2496ge c2496ge, F4 f4, JL jl, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C2699k1 c2699k1) {
        this.A06 = new WeakReference<>(c2496ge);
        this.A04 = new WeakReference<>(f4);
        this.A05 = new WeakReference<>(jl);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(c2699k1.A0F());
    }

    private InterfaceC12391f A00() {
        InterfaceC12391f funnel = this.A03.get();
        if (funnel == null) {
            return new C2899nL();
        }
        return funnel;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return CV.A01(C14228k.A02());
    }

    @JavascriptInterface
    public void logFunnel(int i, String str) {
        A00().AJw(i, str);
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().AJx();
        if (this.A06.get() != null && this.A01.get() != null && this.A02.get() != null && this.A02.get().get()) {
            this.A01.get().set(true);
            A00().AJy();
            if (this.A06.get().isShown()) {
                A00().AJz();
                new Handler(Looper.getMainLooper()).post(new C2498gg(this.A05));
            }
            F4 f4 = this.A04.get();
            if (f4 != null) {
                new Handler(Looper.getMainLooper()).post(new F2(this, f4));
            }
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        C2496ge webView = this.A06.get();
        if (webView == null || webView.A06()) {
            A00().AK0(true);
            return;
        }
        F4 f4 = this.A04.get();
        if (f4 == null) {
            A00().AK0(true);
            return;
        }
        InterfaceC12391f interfaceC12391fA00 = A00();
        String[] strArr = A07;
        if (strArr[3].charAt(2) == strArr[5].charAt(2)) {
            throw new RuntimeException();
        }
        A07[6] = "MExJxptNjWm815DyzsGP1";
        interfaceC12391fA00.AK0(false);
        f4.AEN();
    }
}
