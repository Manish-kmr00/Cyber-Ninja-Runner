package com.pubmatic.sdk.nativead.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeTemplateView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f7707a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private Button g;
    protected ImageView mainImage;

    protected POBNativeTemplateView(Context context, int i) {
        super(context);
        this.f7707a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.mainImage = null;
        View.inflate(context, i, this);
        this.f7707a = (ImageView) findViewById(R.id.pob_ad_icon);
        this.b = (ImageView) findViewById(R.id.pob_privacy_icon);
        this.c = (ImageView) findViewById(R.id.pob_icon_image);
        this.e = (TextView) findViewById(R.id.pob_title);
        this.f = (TextView) findViewById(R.id.pob_description);
        this.g = (Button) findViewById(R.id.pob_cta_text);
        this.d = (ImageView) findViewById(R.id.pob_dsa_info_btn);
        if (i == R.layout.pob_medium_template) {
            this.mainImage = (ImageView) findViewById(R.id.pob_main_image);
        }
    }

    private void setAdClickListeners(View.OnClickListener onClickListener) {
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        Button button = this.g;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
        ImageView imageView2 = this.mainImage;
        if (imageView2 != null) {
            imageView2.setOnClickListener(onClickListener);
        }
        ImageView imageView3 = this.b;
        if (imageView3 != null) {
            imageView3.setOnClickListener(onClickListener);
        }
        ImageView imageView4 = this.d;
        if (imageView4 != null) {
            imageView4.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public ImageView getAdIcon() {
        return this.f7707a;
    }

    public Button getCta() {
        return this.g;
    }

    public ImageView getDSAIcon() {
        return this.d;
    }

    public TextView getDescription() {
        return this.f;
    }

    public ImageView getIconImage() {
        return this.c;
    }

    public ImageView getMainImage() {
        return null;
    }

    public ImageView getPrivacyIcon() {
        return this.b;
    }

    public TextView getTitle() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setTag(2);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setTag(1);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setTag(3);
        }
        Button button = this.g;
        if (button != null) {
            button.setTag(4);
        }
        ImageView imageView2 = this.b;
        if (imageView2 != null) {
            imageView2.setTag(POBNativeConstants.POB_NATIVE_ID_PRIVACY);
        }
        ImageView imageView3 = this.mainImage;
        if (imageView3 != null) {
            imageView3.setTag(5);
        }
        ImageView imageView4 = this.d;
        if (imageView4 != null) {
            imageView4.setTag(POBNativeConstants.POB_NATIVE_ID_DSA);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setAdIcon(ImageView imageView) {
        this.f7707a = imageView;
    }

    public void setCta(Button button) {
        this.g = button;
    }

    public void setDSAIcon(ImageView imageView) {
        this.d = imageView;
    }

    public void setDescription(TextView textView) {
        this.f = textView;
    }

    public void setIconImage(ImageView imageView) {
        this.c = imageView;
    }

    public void setMainImage(ImageView imageView) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener != null) {
            setAdClickListeners(onClickListener);
        }
    }

    public void setPrivacyIcon(ImageView imageView) {
        this.b = imageView;
    }

    public void setTitle(TextView textView) {
        this.e = textView;
    }

    public POBNativeTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7707a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.mainImage = null;
    }

    public POBNativeTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7707a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.mainImage = null;
    }

    public POBNativeTemplateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f7707a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.mainImage = null;
    }
}
