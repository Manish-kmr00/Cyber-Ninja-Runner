package io.bidmachine.rendering.internal.adform.html;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.IabSettings;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.mraid.MraidPlacementType;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Utils;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class a extends io.bidmachine.rendering.internal.adform.a {
    private final HtmlMeasurer i;
    MraidAdView j;

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, c cVar, io.bidmachine.rendering.internal.event.a aVar2, HtmlMeasurer htmlMeasurer) {
        super(context, aVar, adElementParams, cVar, aVar2);
        this.i = htmlMeasurer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        MraidAdView mraidAdView = this.j;
        if (mraidAdView != null) {
            mraidAdView.destroy();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        MraidAdView mraidAdView = this.j;
        if (mraidAdView != null) {
            mraidAdView.show();
            C();
        }
    }

    private void C() {
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer != null) {
            htmlMeasurer.onShown();
        }
        r().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MraidPlacementType mraidPlacementType, String str, String str2) {
        try {
            MraidAdView mraidAdViewBuild = new MraidAdView.Builder(s(), mraidPlacementType, new b(this, r(), p(), this.i)).setBaseUrl(str).setAllowedNativeFeatures(x()).build();
            this.j = mraidAdViewBuild;
            mraidAdViewBuild.load(str2);
            HtmlMeasurer htmlMeasurer = this.i;
            if (htmlMeasurer != null) {
                htmlMeasurer.onViewCreated(this.j.getWebView());
            }
        } catch (Throwable th) {
            m.b(th);
            a(Error.create(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup) {
        MraidAdView mraidAdView;
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer == null || (mraidAdView = this.j) == null) {
            return;
        }
        htmlMeasurer.onViewAddedToContainer(mraidAdView.getWebView(), viewGroup);
    }

    @Override // io.bidmachine.rendering.internal.a
    public void c() {
        final String source = i().getSource();
        if (TextUtils.isEmpty(source)) {
            a(new Error("Source is null or empty"));
            return;
        }
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer != null) {
            source = htmlMeasurer.prepareCreativeForMeasure(source);
        }
        final MraidPlacementType mraidPlacementTypeZ = z();
        final String strY = y();
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(mraidPlacementTypeZ, strY, source);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.a
    public void e() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda1
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.B();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.a
    public View k() {
        return this.j;
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.a
    public void n() {
        MraidAdView mraidAdView = this.j;
        if (mraidAdView != null) {
            mraidAdView.handleRedirectView();
        } else {
            super.n();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void v() {
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer != null) {
            htmlMeasurer.destroy(new l() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda2
                @Override // io.bidmachine.rendering.utils.SafeRunnable
                public final void onRun() {
                    this.f$0.w();
                }
            });
        } else {
            w();
        }
    }

    void w() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda0
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.A();
            }
        });
    }

    String[] x() {
        try {
            String customParam = i().getCustomParam("features");
            if (!TextUtils.isEmpty(customParam)) {
                String[] strArrSplit = customParam.split(StringUtils.COMMA);
                for (int i = 0; i < strArrSplit.length; i++) {
                    strArrSplit[i] = strArrSplit[i].trim();
                }
                return strArrSplit;
            }
        } catch (Exception unused) {
        }
        return new String[0];
    }

    String y() {
        AdElementParams adElementParamsI = i();
        if (!adElementParamsI.getCustomParams().containsKey("base_url")) {
            return IabSettings.DEF_BASE_URL;
        }
        String customParam = adElementParamsI.getCustomParam("base_url");
        if (Utils.isUrlValid(customParam)) {
            return customParam;
        }
        return null;
    }

    MraidPlacementType z() {
        String customParam = i().getCustomParam("placement_type");
        if (Objects.equals(customParam, "fullscreen")) {
            return MraidPlacementType.INTERSTITIAL;
        }
        if (Objects.equals(customParam, "view")) {
            return MraidPlacementType.INLINE;
        }
        return null;
    }

    @Override // io.bidmachine.rendering.internal.a
    public void a(final ViewGroup viewGroup) {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda4
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.b(viewGroup);
            }
        });
    }

    void b(Error error) {
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer != null) {
            htmlMeasurer.onError(error);
        }
        r().a(this, error);
    }

    void a(Error error) {
        HtmlMeasurer htmlMeasurer = this.i;
        if (htmlMeasurer != null) {
            htmlMeasurer.onError(error);
        }
        r().c(this, error);
    }
}
