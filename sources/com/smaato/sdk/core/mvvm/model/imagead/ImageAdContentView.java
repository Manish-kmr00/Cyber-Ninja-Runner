package com.smaato.sdk.core.mvvm.model.imagead;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.ui.ProgressView;
import com.smaato.sdk.core.ui.WatermarkImageButton;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.mvvmcommon.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ImageAdContentView extends AdContentView {
    private final List<Extension> extensions;
    private ImageView imageView;
    private final View.OnClickListener internalClickListener;
    private final Logger logger;

    @Override // com.smaato.sdk.core.ui.AdContentView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void startShowingView() {
    }

    private ImageAdContentView(Context context, Bitmap bitmap, int i, int i2, View.OnClickListener onClickListener, List<Extension> list, Logger logger) {
        super(context);
        this.internalClickListener = onClickListener;
        this.extensions = list;
        this.logger = logger;
        init(bitmap, i, i2);
    }

    public static ImageAdContentView create(Context context, Bitmap bitmap, int i, int i2, View.OnClickListener onClickListener, List<Extension> list, Logger logger) {
        if (context == null) {
            throw new NullPointerException("'context' specified as non-null is null");
        }
        if (bitmap == null) {
            throw new NullPointerException("'bitmap' specified as non-null is null");
        }
        if (onClickListener == null) {
            throw new NullPointerException("'internalClickListener' specified as non-null is null");
        }
        if (logger != null) {
            return new ImageAdContentView((Context) Objects.requireNonNull(context, "Parameter context cannot be null for StaticImageAdContentView::create"), (Bitmap) Objects.requireNonNull(bitmap, "Parameter bitmap cannot be null for StaticImageAdContentView::create"), i, i2, (View.OnClickListener) Objects.requireNonNull(onClickListener, "Parameter internalClickListener cannot be null for StaticImageAdContentView::create"), list, logger);
        }
        throw new NullPointerException("'logger' specified as non-null is null");
    }

    private void init(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            throw new NullPointerException("'bitmap' specified as non-null is null");
        }
        this.imageView = new ImageView(getContext());
        if (i > 0) {
            i = UIUtils.dpToPx(getContext(), i);
        }
        if (i2 > 0) {
            i2 = UIUtils.dpToPx(getContext(), i2);
        }
        addView(this.imageView, AdContentView.generateDefaultLayoutParams(i, i2));
        addView(new WatermarkImageButton(getContext()));
        this.imageView.setImageBitmap(bitmap);
        setLayoutParams(new FrameLayout.LayoutParams(i, i2, 17));
        super.setOnClickListener(this.internalClickListener);
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener onClickListener) {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.core.mvvm.model.imagead.ImageAdContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5552x30d22db2(onClickListener, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setOnClickListener$1$com-smaato-sdk-core-mvvm-model-imagead-ImageAdContentView, reason: not valid java name */
    /* synthetic */ void m5552x30d22db2(View.OnClickListener onClickListener, final View view) {
        this.internalClickListener.onClick(view);
        Objects.onNotNull(onClickListener, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.imagead.ImageAdContentView$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((View.OnClickListener) obj).onClick(view);
            }
        });
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void showProgressIndicator(boolean z) {
        Threads.ensureMainThread();
        if (z) {
            addView(new ProgressView(getContext()));
        } else {
            removeView((ProgressView) findViewById(R.id.smaato_sdk_core_progress_view_id));
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForVisibilityTracking() {
        return this.imageView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForOmTracking() {
        return this.imageView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void destroy() {
        this.imageView = null;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap() {
        return getViewabilityResourcesMap(this.extensions);
    }

    private Map<String, List<ViewabilityVerificationResource>> getViewabilityResourcesMap(List<Extension> list) {
        HashMap map = new HashMap();
        if (list != null) {
            try {
                for (Extension extension : list) {
                    if (extension != null && extension.getName().equalsIgnoreCase(Extension.OM)) {
                        ViewabilityVerificationResource viewabilityVerificationResource = new ViewabilityVerificationResource(extension.getExtConfig().getVendorKey(), extension.getScript(), "", extension.getExtConfig().getVerificationParam(), true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(viewabilityVerificationResource);
                        map.put(CampaignEx.KEY_OMID, arrayList);
                    }
                }
            } catch (Exception e) {
                this.logger.error(LogDomain.CORE, e, "Error while creating ViewabilityResourcesMap", new Object[0]);
            }
        }
        return map;
    }
}
