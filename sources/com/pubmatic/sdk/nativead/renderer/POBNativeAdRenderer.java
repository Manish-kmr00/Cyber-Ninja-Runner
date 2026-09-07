package com.pubmatic.sdk.nativead.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.R;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBImageDownloadManager;
import com.pubmatic.sdk.common.utility.POBUrlHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBNativeMeasurementProvider;
import com.pubmatic.sdk.nativead.POBNativeAdView;
import com.pubmatic.sdk.nativead.POBNativeAdViewHandler;
import com.pubmatic.sdk.nativead.POBNativeAdViewListener;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import com.pubmatic.sdk.nativead.POBNativeTrackerHandler;
import com.pubmatic.sdk.nativead.response.POBNativeAdDataResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdImageResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdLinkResponse;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponse;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdTitleResponseAsset;
import com.pubmatic.sdk.nativead.views.POBNativeTemplateView;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class POBNativeAdRenderer implements POBNativeAdRendering, POBNativeAdViewListener, POBImageDownloadManager.POBImageDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7696a;
    private POBNativeRendererListener b;
    private POBUrlHandler c;
    private POBNativeAdResponse d;
    private POBNativeTemplateView e;
    private POBNativeMeasurementProvider f;
    private POBNativeAdViewHandler g;
    private boolean h = false;
    private final View.OnAttachStateChangeListener i = new a();
    private final POBNativeTrackerHandler j;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (POBNativeAdRenderer.this.g != null) {
                POBNativeAdRenderer.this.g.onAdViewAttachedToWindow();
                view.removeOnAttachStateChangeListener(this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class b implements POBUrlHandler.UrlHandlerListener {
        b() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onErrorOpenUrl(String str) {
            POBLog.warn("POBNativeAdRenderer", "Unable to open " + str, new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserClose(String str) {
            if (POBNativeAdRenderer.this.b != null) {
                POBNativeAdRenderer.this.b.onAdClosed();
            }
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserOpen(String str) {
            if (POBNativeAdRenderer.this.b != null) {
                POBNativeAdRenderer.this.b.onAdOpened();
            }
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onLeaveApp(String str) {
            if (POBNativeAdRenderer.this.b != null) {
                POBNativeAdRenderer.this.b.onAdLeavingApplication();
            }
        }
    }

    class c implements POBNativeMeasurementProvider.POBOmidSessionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBNativeMeasurementProvider f7699a;
        final /* synthetic */ View b;

        c(POBNativeMeasurementProvider pOBNativeMeasurementProvider, View view) {
            this.f7699a = pOBNativeMeasurementProvider;
            this.b = view;
        }

        @Override // com.pubmatic.sdk.common.viewability.POBNativeMeasurementProvider.POBOmidSessionListener
        public void onOmidSessionInitializationFailed() {
            POBLog.debug("POBNativeAdRenderer", POBNativeLogConstants.NATIVE_OM_NOT_INITIALISED, new Object[0]);
            POBNativeAdRenderer.this.a(this.b);
        }

        @Override // com.pubmatic.sdk.common.viewability.POBNativeMeasurementProvider.POBOmidSessionListener
        public void onOmidSessionInitialized() {
            POBLog.debug("POBNativeAdRenderer", POBNativeLogConstants.NATIVE_OM_INITIALISED, new Object[0]);
            POBNativeMeasurementProvider pOBNativeMeasurementProvider = this.f7699a;
            if (pOBNativeMeasurementProvider != null) {
                pOBNativeMeasurementProvider.signalAdEvent(POBNativeMeasurementProvider.POBNativeAdEventType.LOADED);
            }
            POBNativeAdRenderer.this.a(this.b);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBNativeAdRenderer.this.f != null) {
                POBNativeAdRenderer.this.f.signalAdEvent(POBNativeMeasurementProvider.POBNativeAdEventType.IMPRESSION);
            }
        }
    }

    public POBNativeAdRenderer(Context context) {
        this.f7696a = context;
        a(context);
        this.j = new POBNativeTrackerHandler(POBInstanceProvider.getTrackerHandler(POBInstanceProvider.getNetworkHandler(context)));
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void destroy() {
        this.b = null;
        this.e = null;
        this.c = null;
        POBNativeMeasurementProvider pOBNativeMeasurementProvider = this.f;
        if (pOBNativeMeasurementProvider != null) {
            pOBNativeMeasurementProvider.finishAdSession();
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void enableDsaIcon(boolean z) {
        this.h = z;
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdViewListener
    public void onAssetClicked(View view, int i) {
        POBNativeAdResponse pOBNativeAdResponse = this.d;
        if (pOBNativeAdResponse != null) {
            POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(i);
            POBNativeAdLinkResponse link = this.d.getLink();
            if (asset != null && asset.getLink() != null) {
                a(asset.getLink(), link);
            } else if (link != null) {
                a(link.getUrl(), link.getFallbackURL(), link.getClickTrackers());
            }
        }
        POBNativeRendererListener pOBNativeRendererListener = this.b;
        if (pOBNativeRendererListener != null) {
            pOBNativeRendererListener.onAdClicked(i);
        }
    }

    @Override // com.pubmatic.sdk.common.utility.POBImageDownloadManager.POBImageDownloadListener
    public void onComplete(Map<String, Bitmap> map) {
        POBNativeAdResponse pOBNativeAdResponse;
        Bitmap bitmap;
        ImageView mainImage;
        Bitmap bitmap2;
        ImageView iconImage;
        if (this.b != null) {
            if (this.e == null) {
                Trace.endSection();
                this.b.onAdRenderingFailed(new POBError(1006, POBNativeLogConstants.TEMPLATE_VIEW_NULL));
                return;
            }
            if (!map.isEmpty() && (pOBNativeAdResponse = this.d) != null) {
                String strA = a(pOBNativeAdResponse, 2);
                if (strA != null && (bitmap2 = map.get(strA)) != null && (iconImage = this.e.getIconImage()) != null) {
                    iconImage.setImageDrawable(new BitmapDrawable(this.f7696a.getResources(), bitmap2));
                }
                String strA2 = a(this.d, 5);
                if (strA2 != null && (bitmap = map.get(strA2)) != null && (mainImage = this.e.getMainImage()) != null) {
                    mainImage.setImageDrawable(new BitmapDrawable(this.f7696a.getResources(), bitmap));
                }
            }
            b(a());
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdViewListener
    public void onNonAssetClicked(View view, String str) {
        POBNativeRendererListener pOBNativeRendererListener;
        if (str.equals(POBNativeConstants.POB_NATIVE_ID_PRIVACY)) {
            b();
        } else {
            if (!str.equals(POBNativeConstants.POB_NATIVE_ID_DSA) || (pOBNativeRendererListener = this.b) == null) {
                return;
            }
            pOBNativeRendererListener.onDsaInfoIconClicked();
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdViewListener
    public void onRecordClick(View view) {
        POBNativeAdResponse pOBNativeAdResponse = this.d;
        if (pOBNativeAdResponse != null && pOBNativeAdResponse.getLink() != null) {
            a(this.d.getLink().getUrl(), this.d.getLink().getFallbackURL(), this.d.getLink().getClickTrackers());
        }
        POBNativeRendererListener pOBNativeRendererListener = this.b;
        if (pOBNativeRendererListener != null) {
            pOBNativeRendererListener.onAdClicked();
        }
    }

    public void onRecordImpression(View view) {
        c();
        POBNativeAdResponse pOBNativeAdResponse = this.d;
        if (pOBNativeAdResponse != null) {
            POBNativeTrackerHandler pOBNativeTrackerHandler = this.j;
            Context context = this.f7696a;
            POBNativeEventType pOBNativeEventType = POBNativeEventType.IMPRESSION;
            pOBNativeTrackerHandler.executeImpressionTracker(context, pOBNativeAdResponse.getEventTrackers(pOBNativeEventType, POBNativeEventTrackingMethod.JAVASCRIPT), this.d.getEventTrackers(pOBNativeEventType, POBNativeEventTrackingMethod.IMAGE), this.d.getImpressionTrackers(), this.d.getJsTracker());
        }
        POBNativeRendererListener pOBNativeRendererListener = this.b;
        if (pOBNativeRendererListener != null) {
            pOBNativeRendererListener.onAdImpression();
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void registerView(POBNativeAdResponse pOBNativeAdResponse, View view, List<View> list) {
        this.d = pOBNativeAdResponse;
        if (this.g == null) {
            this.g = new POBNativeAdViewHandler();
            b(view);
        }
        this.g.setAdView(view);
        this.g.setListener(this);
        for (View view2 : list) {
            if (view2 != null) {
                view2.setOnClickListener(this.g);
            }
        }
        view.setOnClickListener(this.g);
        view.addOnAttachStateChangeListener(this.i);
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void renderAd(POBNativeAdResponse pOBNativeAdResponse, POBNativeTemplateView pOBNativeTemplateView) {
        String strA;
        Button cta;
        TextView description;
        TextView title;
        Trace.beginSection("POB Render");
        this.d = pOBNativeAdResponse;
        this.e = pOBNativeTemplateView;
        POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(1);
        if ((asset instanceof POBNativeAdTitleResponseAsset) && (title = pOBNativeTemplateView.getTitle()) != null) {
            title.setText(((POBNativeAdTitleResponseAsset) asset).getTitle());
        }
        POBNativeAdResponseAsset asset2 = pOBNativeAdResponse.getAsset(3);
        if ((asset2 instanceof POBNativeAdDataResponseAsset) && (description = pOBNativeTemplateView.getDescription()) != null) {
            description.setText(((POBNativeAdDataResponseAsset) asset2).getValue());
        }
        POBNativeAdResponseAsset asset3 = pOBNativeAdResponse.getAsset(4);
        if ((asset3 instanceof POBNativeAdDataResponseAsset) && (cta = pOBNativeTemplateView.getCta()) != null) {
            cta.setText(((POBNativeAdDataResponseAsset) asset3).getValue());
        }
        HashSet hashSet = new HashSet();
        String strA2 = a(pOBNativeAdResponse, 2);
        if (strA2 != null) {
            hashSet.add(strA2);
        }
        if (pOBNativeTemplateView.getMainImage() != null && (strA = a(pOBNativeAdResponse, 5)) != null) {
            hashSet.add(strA);
        }
        if (pOBNativeAdResponse.getPrivacyUrl() == null && pOBNativeTemplateView.getPrivacyIcon() != null) {
            pOBNativeTemplateView.getPrivacyIcon().setVisibility(8);
        }
        ImageView dSAIcon = pOBNativeTemplateView.getDSAIcon();
        if (dSAIcon != null) {
            if (this.h) {
                dSAIcon.setImageResource(R.drawable.pob_dsa_info_icon_native);
            } else {
                dSAIcon.setVisibility(4);
            }
        }
        POBImageDownloadManager pOBImageDownloadManager = new POBImageDownloadManager(this.f7696a, hashSet);
        pOBImageDownloadManager.setListener(this);
        pOBImageDownloadManager.start();
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void setAdRendererListener(POBNativeRendererListener pOBNativeRendererListener) {
        this.b = pOBNativeRendererListener;
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering
    public void setNativeMeasurementProvider(POBNativeMeasurementProvider pOBNativeMeasurementProvider) {
        this.f = pOBNativeMeasurementProvider;
    }

    private void b(View view) {
        if (view != null) {
            POBNativeMeasurementProvider pOBNativeMeasurementProvider = this.f;
            if (pOBNativeMeasurementProvider != null) {
                a(view, pOBNativeMeasurementProvider);
            } else {
                POBLog.debug("POBNativeAdRenderer", POBNativeLogConstants.NATIVE_OM_NOT_INITIALISED, new Object[0]);
                a(view);
            }
        }
    }

    private void c() {
        new Handler(Looper.getMainLooper()).postDelayed(new d(), 1000L);
    }

    private void a(Context context) {
        this.c = new POBUrlHandler(context, new b());
    }

    private String a(POBNativeAdResponse pOBNativeAdResponse, int i) {
        POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(i);
        if (asset instanceof POBNativeAdImageResponseAsset) {
            return ((POBNativeAdImageResponseAsset) asset).getImageURL();
        }
        return null;
    }

    private POBNativeAdView a() {
        POBNativeTemplateView pOBNativeTemplateView = this.e;
        if (pOBNativeTemplateView == null) {
            return null;
        }
        POBError pOBErrorA = a(pOBNativeTemplateView);
        if (pOBErrorA != null) {
            POBNativeRendererListener pOBNativeRendererListener = this.b;
            if (pOBNativeRendererListener != null) {
                pOBNativeRendererListener.onAdRenderingFailed(pOBErrorA);
            }
            return null;
        }
        POBNativeAdView pOBNativeAdView = new POBNativeAdView(this.f7696a);
        pOBNativeAdView.setListener(this);
        this.e.setOnClickListener(pOBNativeAdView);
        pOBNativeAdView.addView(this.e);
        return pOBNativeAdView;
    }

    private void b() {
        POBNativeAdResponse pOBNativeAdResponse = this.d;
        if (pOBNativeAdResponse != null) {
            POBNativeAdLinkResponse link = pOBNativeAdResponse.getLink();
            a(this.d.getPrivacyUrl(), null, link != null ? link.getClickTrackers() : null);
            POBNativeRendererListener pOBNativeRendererListener = this.b;
            if (pOBNativeRendererListener != null) {
                pOBNativeRendererListener.onAdClicked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Trace.endSection();
        POBNativeRendererListener pOBNativeRendererListener = this.b;
        if (pOBNativeRendererListener != null) {
            pOBNativeRendererListener.onAdRendered(view);
        }
    }

    private void a(View view, POBNativeMeasurementProvider pOBNativeMeasurementProvider) {
        POBNativeAdResponse pOBNativeAdResponse = this.d;
        if (pOBNativeAdResponse != null) {
            pOBNativeMeasurementProvider.startAdSession(view, pOBNativeAdResponse.getEventTrackers(POBNativeEventType.OMID, POBNativeEventTrackingMethod.JAVASCRIPT), new c(pOBNativeMeasurementProvider, view));
        } else {
            POBLog.debug("POBNativeAdRenderer", POBNativeLogConstants.NATIVE_OM_NOT_INITIALISED, new Object[0]);
            a(view);
        }
    }

    private POBError a(POBNativeTemplateView pOBNativeTemplateView) {
        if (pOBNativeTemplateView.getParent() == null) {
            return null;
        }
        POBError pOBError = new POBError(1009, POBCommonConstants.NATIVE_TEMPLATE_VIEW_PARENT_ERROR_MSG);
        POBLog.error("POBNativeAdRenderer", POBCommonConstants.NATIVE_TEMPLATE_VIEW_PARENT_ERROR_MSG, new Object[0]);
        return pOBError;
    }

    private void a(String str, String str2, List list) {
        this.j.executeClickTrackers(list);
        POBUrlHandler pOBUrlHandler = this.c;
        if (pOBUrlHandler != null) {
            pOBUrlHandler.open(str, str2);
        }
    }

    private void a(POBNativeAdLinkResponse pOBNativeAdLinkResponse, POBNativeAdLinkResponse pOBNativeAdLinkResponse2) {
        List<String> arrayList = new ArrayList<>();
        if (!POBUtils.isListNullOrEmpty(pOBNativeAdLinkResponse.getClickTrackers())) {
            arrayList.addAll(pOBNativeAdLinkResponse.getClickTrackers());
            if (pOBNativeAdLinkResponse2 != null) {
                arrayList.addAll(POBUtils.filterListOfStrings(pOBNativeAdLinkResponse2.getClickTrackers(), POBNativeConstants.PUBMATIC_CLICK_TRACKERS_IDENTIFIER));
            }
        } else if (pOBNativeAdLinkResponse2 != null) {
            arrayList = pOBNativeAdLinkResponse2.getClickTrackers();
        }
        this.j.executeClickTrackers(arrayList);
        POBUrlHandler pOBUrlHandler = this.c;
        if (pOBUrlHandler != null) {
            pOBUrlHandler.open(pOBNativeAdLinkResponse.getUrl(), pOBNativeAdLinkResponse.getFallbackURL());
        }
    }
}
