package com.applovin.mediation.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.a3;
import com.applovin.impl.mediation.ads.b;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.nativeAd.AppLovinStarRatingView;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class MaxNativeAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f793a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final Button e;
    private final ImageView f;
    private final FrameLayout g;
    private final ViewGroup h;
    private final FrameLayout i;
    private final ViewGroup j;
    private final ViewGroup k;
    private final FrameLayout l;
    private b m;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f794a;
        final /* synthetic */ ViewGroup b;

        a(WeakReference weakReference, ViewGroup viewGroup) {
            this.f794a = weakReference;
            this.b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f794a.get();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                k.D0.O();
                if (o.a()) {
                    k.D0.O().k("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                }
            } else {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.f794a.clear();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = ((View) this.b.getParent()).getWidth();
            this.b.setLayoutParams(layoutParams);
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, activity, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Landroid/app/Activity;)V");
        CreativeInfoManager.onMaxNativeAdCreated(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxNativeAdView(MaxNativeAd p1, Activity p2, StatsEvent p3) {
        this(p1, (String) null, p2);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Landroid/app/Activity;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Landroid/app/Activity;)V" == 0) {
        } else {
            this(p1, (String) null, p2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this(maxNativeAd, maxNativeAdViewBinder, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxNativeAdCreated(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        this(maxNativeAd, str, activity, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/app/Activity;)V");
        CreativeInfoManager.onMaxNativeAdCreated(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Context context) {
        this(maxNativeAd, str, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxNativeAdCreated(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this(maxNativeAdViewBinder, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxNativeAdCreated(this);
    }

    private void b(MaxNativeAd maxNativeAd) {
        if (StringUtils.isValidString(maxNativeAd.getTitle())) {
            this.b.setText(maxNativeAd.getTitle());
        } else {
            this.b.setVisibility(8);
        }
        if (this.c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.c.setVisibility(8);
            }
        }
        if (this.d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.d.setText(maxNativeAd.getBody());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(4);
            }
        }
        if (this.e != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.e.setText(maxNativeAd.getCallToAction());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.g;
        if (frameLayout != null) {
            if (icon == null || this.f == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.g.removeAllViews();
                    this.g.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.f.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null || !StringUtils.isValidString(icon.getUri().toString())) {
                this.g.setVisibility(8);
            } else {
                ImageViewUtils.setAndDownscaleImageUri(this.f, icon.getUri());
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.i;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.i.addView(optionsView);
            this.i.bringToFront();
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.l != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.l.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.l.setVisibility(8);
            }
        }
        if (this.j != null) {
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                this.j.removeAllViews();
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.j.addView(appLovinStarRatingView);
            } else {
                this.j.setVisibility(8);
            }
        }
        b();
        postDelayed(new Runnable() { // from class: com.applovin.mediation.nativeAds.MaxNativeAdView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, 2000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.f8160a, this, me);
        return super.dispatchTouchEvent(me);
    }

    public b getAdViewTracker() {
        return this.m;
    }

    public TextView getAdvertiserTextView() {
        return this.c;
    }

    public TextView getBodyTextView() {
        return this.d;
    }

    public Button getCallToActionButton() {
        return this.e;
    }

    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList(5);
        TextView textView = this.b;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.d;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        Button button = this.e;
        if (button != null) {
            arrayList.add(button);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        return arrayList;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.g;
    }

    public ImageView getIconImageView() {
        return this.f;
    }

    public View getMainView() {
        return this.f793a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.l;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.k;
        return viewGroup != null ? viewGroup : this.l;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.i;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.h;
        return viewGroup != null ? viewGroup : this.i;
    }

    public ViewGroup getStarRatingContentViewGroup() {
        return this.j;
    }

    public TextView getTitleTextView() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.m;
        if (bVar != null) {
            bVar.c();
        }
        if (isHardwareAccelerated()) {
            return;
        }
        o.j("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void recycle() {
        setOnClickListener(null);
        b bVar = this.m;
        if (bVar != null) {
            bVar.a();
            this.m = null;
        }
        View view = this.f793a;
        if (view == null || view.getParent() == this) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f793a.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            removeView(viewGroup);
        }
        addView(this.f793a);
    }

    public void render(a3 a3Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a, k kVar) {
        recycle();
        if (!a3Var.p0().get() || !a3Var.o0().get()) {
            this.m = new b(a3Var, this, interfaceC0135a, kVar);
        }
        final MaxNativeAd nativeAd = a3Var.getNativeAd();
        if (a3Var.q0() && nativeAd.isContainerClickable()) {
            kVar.O();
            if (o.a()) {
                kVar.O().a("MaxNativeAdView", "Enabling container click");
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.nativeAds.MaxNativeAdView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nativeAd.performClick();
                }
            });
        }
        kVar.O();
        if (o.a()) {
            kVar.O().a("MaxNativeAdView", "Rendering custom ad view");
        }
        a(nativeAd);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxNativeAdView(MaxNativeAd p1, String p2, Activity p3, StatsEvent p4) {
        this(p1, p2, p3.getApplicationContext());
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/app/Activity;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/app/Activity;)V" == 0) {
        } else {
            this(p1, p2, p3.getApplicationContext());
        }
    }

    private int a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            if ("vertical_banner_template".equals(str)) {
                return R.layout.max_native_ad_vertical_banner_view;
            }
            if ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) {
                return R.layout.max_native_ad_media_banner_view;
            }
            return "vertical_media_banner_template".equals(str) ? R.layout.max_native_ad_vertical_media_banner_view : R.layout.max_native_ad_banner_view;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return "vertical_leader_template".equals(str) ? R.layout.max_native_ad_vertical_leader_view : R.layout.max_native_ad_leader_view;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return R.layout.max_native_ad_mrec_view;
        }
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid template: " + str);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxNativeAdView(MaxNativeAd p1, String p2, Context p3, StatsEvent p4) {
        this(p1, new MaxNativeAdViewBinder.Builder(-1).setTemplateType(p2).setTitleTextViewId(R.id.applovin_native_title_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setCallToActionButtonId(R.id.applovin_native_cta_button).setIconImageViewId(R.id.applovin_native_icon_image_view).setIconContentViewId(R.id.applovin_native_icon_view).setOptionsContentViewGroupId(R.id.applovin_native_options_view).setOptionsContentFrameLayoutId(R.id.applovin_native_options_view).setStarRatingContentViewGroupId(R.id.applovin_native_star_rating_view).setMediaContentViewGroupId(R.id.applovin_native_media_content_view).setMediaContentFrameLayoutId(R.id.applovin_native_media_content_view).build(), p3);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Ljava/lang/String;Landroid/content/Context;)V" == 0) {
        } else {
            this(p1, new MaxNativeAdViewBinder.Builder(-1).setTemplateType(p2).setTitleTextViewId(R.id.applovin_native_title_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setCallToActionButtonId(R.id.applovin_native_cta_button).setIconImageViewId(R.id.applovin_native_icon_image_view).setIconContentViewId(R.id.applovin_native_icon_view).setOptionsContentViewGroupId(R.id.applovin_native_options_view).setOptionsContentFrameLayoutId(R.id.applovin_native_options_view).setStarRatingContentViewGroupId(R.id.applovin_native_star_rating_view).setMediaContentViewGroupId(R.id.applovin_native_media_content_view).setMediaContentFrameLayoutId(R.id.applovin_native_media_content_view).build(), p3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxNativeAdView(MaxNativeAdViewBinder p1, Context p2, StatsEvent p3) {
        this((MaxNativeAd) null, p1, p2);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V" == 0) {
        } else {
            this((MaxNativeAd) null, p1, p2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private MaxNativeAdView(MaxNativeAd p1, MaxNativeAdViewBinder p2, Context p3, StatsEvent p4) {
        int iA;
        super(p3);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdView;-><init>(Lcom/applovin/mediation/nativeAds/MaxNativeAd;Lcom/applovin/mediation/nativeAds/MaxNativeAdViewBinder;Landroid/content/Context;)V" == 0) {
            return;
        }
        super(p3);
        boolean z = p2.templateType != null;
        MaxAdFormat format = p1 != null ? p1.getFormat() : MaxAdFormat.NATIVE;
        View view = p2.mainView;
        if (view != null) {
            this.f793a = view;
        } else {
            if (z) {
                iA = a(p2.templateType, format);
            } else {
                iA = p2.layoutResourceId;
            }
            this.f793a = LayoutInflater.from(p3).inflate(iA, (ViewGroup) this, false);
        }
        addView(this.f793a);
        this.b = (TextView) findViewById(p2.titleTextViewId);
        this.c = (TextView) findViewById(p2.advertiserTextViewId);
        this.d = (TextView) findViewById(p2.bodyTextViewId);
        this.e = (Button) findViewById(p2.callToActionButtonId);
        this.f = (ImageView) findViewById(p2.iconImageViewId);
        this.g = (FrameLayout) findViewById(p2.iconContentViewId);
        this.h = (ViewGroup) findViewById(p2.optionsContentViewGroupId);
        this.i = (FrameLayout) findViewById(p2.optionsContentFrameLayoutId);
        this.j = (ViewGroup) findViewById(p2.starRatingContentViewGroupId);
        this.k = (ViewGroup) findViewById(p2.mediaContentViewGroupId);
        this.l = (FrameLayout) findViewById(p2.mediaContentFrameLayoutId);
        if (p1 != null) {
            b(p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        setSelected(true);
    }

    private void a(MaxNativeAd maxNativeAd) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(maxNativeAd.getTitle());
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(maxNativeAd.getBody());
        }
        TextView textView3 = this.c;
        if (textView3 != null) {
            textView3.setText(maxNativeAd.getAdvertiser());
        }
        Button button = this.e;
        if (button != null) {
            button.setText(maxNativeAd.getCallToAction());
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.f;
        if (imageView != null) {
            if (icon != null) {
                if (icon.getDrawable() != null) {
                    this.f.setImageDrawable(icon.getDrawable());
                } else if (icon.getUri() != null) {
                    ImageViewUtils.setAndDownscaleImageUri(this.f, icon.getUri());
                } else {
                    this.f.setImageDrawable(null);
                }
            } else {
                imageView.setImageDrawable(null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.k.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.h;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.h.addView(optionsView);
                this.h.bringToFront();
            }
        }
        ViewGroup viewGroup3 = this.j;
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.j.addView(appLovinStarRatingView);
            }
        }
    }

    private void b() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.applovin_native_inner_parent_layout);
        if (viewGroup == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new a(new WeakReference(viewTreeObserver), viewGroup));
        }
    }
}
