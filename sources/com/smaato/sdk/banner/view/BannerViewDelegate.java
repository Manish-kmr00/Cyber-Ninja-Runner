package com.smaato.sdk.banner.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.viewmodel.BannerViewModel;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdDimension;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.util.HtmlPlayerUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class BannerViewDelegate extends SmaatoSdkViewDelegate {
    private final BannerViewModel bannerViewModel;
    private WeakReference bannerViewReference;
    HtmlPlayerUtils htmlPlayerUtils;
    private final Logger logger;

    public BannerViewDelegate(Logger logger, BannerViewModel bannerViewModel, HtmlPlayerUtils htmlPlayerUtils) {
        super(bannerViewModel);
        this.bannerViewReference = new WeakReference(null);
        this.logger = logger;
        this.bannerViewModel = bannerViewModel;
        this.htmlPlayerUtils = htmlPlayerUtils;
    }

    public void init(BannerView bannerView) {
        this.bannerViewReference = new WeakReference(bannerView);
        if (!SmaatoSdk.isGPSEnabled()) {
            this.logger.warning(LogDomain.BANNER, "Usage of the GPS coordinates for advertising purposes is disabled. You can change that by setting setGPSLocation to TRUE.", new Object[0]);
        }
        this.bannerViewModel.setViewModelListener(createViewModelListener());
        this.bannerViewModel.setBannerView(bannerView);
    }

    public void setEventListener(BannerView.EventListener eventListener) {
        this.bannerViewModel.setBannerViewEventListener(eventListener);
    }

    public String getSessionId() {
        return this.bannerViewModel.getSessionId();
    }

    public String getCreativeId() {
        return this.bannerViewModel.getCreativeId();
    }

    public String getAdSpaceId() {
        return this.bannerViewModel.getAdSpaceId();
    }

    public BannerAdSize getBannerAdSize() {
        return this.bannerViewModel.getBannerAdSize();
    }

    public void setMediationNetworkName(String str) {
        this.bannerViewModel.setMediationNetworkName(str);
    }

    public void setMediationNetworkSDKVersion(String str) {
        this.bannerViewModel.setMediationNetworkSDKVersion(str);
    }

    public void setMediationAdapterVersion(String str) {
        this.bannerViewModel.setMediationAdapterVersion(str);
    }

    public KeyValuePairs getKeyValuePairs() {
        return this.bannerViewModel.getKeyValuePairs();
    }

    public void setKeyValuePairs(KeyValuePairs keyValuePairs) {
        this.bannerViewModel.setKeyValuePairs(keyValuePairs);
    }

    public AutoReloadInterval getAutoReloadInterval() {
        return this.bannerViewModel.getAutoReloadInterval();
    }

    public void setAutoReloadInterval(AutoReloadInterval autoReloadInterval) {
        this.bannerViewModel.setAutoReloadInterval(autoReloadInterval);
    }

    public void setObjectExtras(Map<String, Object> map) {
        this.bannerViewModel.setObjectExtras(map);
    }

    public void loadAd(String str, AdFormat adFormat, BannerAdSize bannerAdSize, String str2) {
        this.bannerViewModel.loadAd(str, adFormat, bannerAdSize, str2);
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void destroy() {
        withBannerView(new Consumer() { // from class: com.smaato.sdk.banner.view.BannerViewDelegate$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BannerView) obj).removeAllViews();
            }
        });
        this.bannerViewModel.onDestroy();
    }

    public void onWindowFocusChanged(boolean z) {
        this.bannerViewModel.onWindowFocusChanged(z);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.banner.view.BannerViewDelegate$1, reason: invalid class name */
    class AnonymousClass1 implements SmaatoSdkViewModelListener {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onImageAdLoaded(final Bitmap bitmap, final int i, final int i2, final List<Extension> list, final ImpressionCountingType impressionCountingType) {
            BannerViewDelegate.this.withBannerView(new Consumer() { // from class: com.smaato.sdk.banner.view.BannerViewDelegate$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5501x73768078(bitmap, i, i2, list, impressionCountingType, (BannerView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onImageAdLoaded$0$com-smaato-sdk-banner-view-BannerViewDelegate$1, reason: not valid java name */
        /* synthetic */ void m5501x73768078(Bitmap bitmap, int i, int i2, List list, ImpressionCountingType impressionCountingType, BannerView bannerView) {
            bannerView.removeAllViews();
            BannerViewDelegate.this.createImageAdContentView(bannerView.getContext(), bitmap, i, i2, list, impressionCountingType);
            if (((AdContentView) ((SmaatoSdkViewDelegate) BannerViewDelegate.this).adContentViewReference.get()) != null) {
                bannerView.addView((View) ((SmaatoSdkViewDelegate) BannerViewDelegate.this).adContentViewReference.get());
            }
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onRichMediaAdLoaded(final String str, final int i, final int i2, final ImpressionCountingType impressionCountingType) {
            BannerViewDelegate.this.withBannerView(new Consumer() { // from class: com.smaato.sdk.banner.view.BannerViewDelegate$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5502xb9a27546(str, i, i2, impressionCountingType, (BannerView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onRichMediaAdLoaded$1$com-smaato-sdk-banner-view-BannerViewDelegate$1, reason: not valid java name */
        /* synthetic */ void m5502xb9a27546(String str, int i, int i2, ImpressionCountingType impressionCountingType, BannerView bannerView) {
            bannerView.removeAllViews();
            BannerViewDelegate bannerViewDelegate = BannerViewDelegate.this;
            bannerViewDelegate.createRichMediaAdContentView(((SmaatoSdkViewDelegate) bannerViewDelegate).richMediaAdContentViewCreator, bannerView.getContext(), str, i, i2, false, impressionCountingType);
            if (((AdContentView) ((SmaatoSdkViewDelegate) BannerViewDelegate.this).adContentViewReference.get()) != null) {
                bannerView.addView((View) ((SmaatoSdkViewDelegate) BannerViewDelegate.this).adContentViewReference.get());
            }
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onVideoAdLoaded(Object obj, ImpressionCountingType impressionCountingType) {
            try {
                AdDimension adDimension = BannerViewDelegate.this.getAdDimension(BannerViewDelegate.this.bannerViewModel.getBannerAdSize());
                if (obj instanceof String) {
                    onRichMediaAdLoaded(BannerViewDelegate.this.htmlPlayerUtils.vastToRichMedia((String) obj), adDimension.getWidth(), adDimension.getHeight(), impressionCountingType);
                    return;
                }
                throw new Exception(BannerViewDelegate.this.onWrongVastObjectCreated(obj));
            } catch (Exception e) {
                BannerViewDelegate.this.bannerViewModel.onFailedToCreateContentView(e);
            }
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onCsmAdObjectLoaded(final Object obj, final ImpressionCountingType impressionCountingType) {
            BannerViewDelegate.this.withBannerView(new Consumer() { // from class: com.smaato.sdk.banner.view.BannerViewDelegate$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj2) {
                    this.f$0.m5500xd098e2fb(obj, impressionCountingType, (BannerView) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onCsmAdObjectLoaded$2$com-smaato-sdk-banner-view-BannerViewDelegate$1, reason: not valid java name */
        /* synthetic */ void m5500xd098e2fb(Object obj, ImpressionCountingType impressionCountingType, BannerView bannerView) {
            bannerView.removeAllViews();
            if (obj instanceof View) {
                BannerViewDelegate.this.createCsmImageAdContentView((View) obj, impressionCountingType);
                bannerView.addView((View) ((SmaatoSdkViewDelegate) BannerViewDelegate.this).adContentViewReference.get());
            } else {
                BannerViewDelegate.this.bannerViewModel.onFailedToCreateContentView(new IllegalStateException("Csm object is not of type View:" + obj));
            }
        }
    }

    private SmaatoSdkViewModelListener createViewModelListener() {
        return new AnonymousClass1();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    protected void onPredrawOfAdContentView(AdContentView adContentView) {
        checkContentSize(adContentView);
    }

    private void checkContentSize(final AdContentView adContentView) {
        withBannerView(new Consumer() { // from class: com.smaato.sdk.banner.view.BannerViewDelegate$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5499xe8a545d3(adContentView, (BannerView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$checkContentSize$0$com-smaato-sdk-banner-view-BannerViewDelegate, reason: not valid java name */
    /* synthetic */ void m5499xe8a545d3(AdContentView adContentView, BannerView bannerView) {
        int measuredWidth = bannerView.getMeasuredWidth();
        int measuredHeight = bannerView.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = adContentView.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (i > measuredWidth || i2 > measuredHeight) {
            this.logger.error(LogDomain.BANNER, "Content size[%d x %d] is bigger than BannerView [%d x %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdDimension getAdDimension(BannerAdSize bannerAdSize) {
        if (bannerAdSize != null) {
            return bannerAdSize.adDimension;
        }
        return BannerAdSize.XX_LARGE_320x50.adDimension;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void withBannerView(Consumer consumer) {
        Objects.onNotNull((BannerView) this.bannerViewReference.get(), consumer);
    }
}
