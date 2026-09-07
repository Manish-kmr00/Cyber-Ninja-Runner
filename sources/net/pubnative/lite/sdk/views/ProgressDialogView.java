package net.pubnative.lite.sdk.views;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes14.dex */
public class ProgressDialogView extends RelativeLayout {
    private TextView progressDescTextView;
    private TextView progressTitleTextView;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ProgressDialogView(Context context) {
        this(context, null, 0);
    }

    public ProgressDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initUi();
        createViews();
    }

    private void initUi() {
        setVerticalGravity(8);
        setBackgroundColor(Color.argb(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 0, 0, 0));
    }

    private void createViews() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setPadding(40, 40, 40, 40);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(100, 0, 100, 0);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        this.progressTitleTextView = textView;
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.progressTitleTextView.setTypeface(Typeface.DEFAULT_BOLD);
        this.progressTitleTextView.setTextSize(24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, 40);
        this.progressTitleTextView.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(getContext());
        this.progressDescTextView = textView2;
        textView2.setTextColor(-7829368);
        this.progressDescTextView.setTextSize(16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.progressDescTextView.setLayoutParams(layoutParams3);
        ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleLarge);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(100, 100);
        layoutParams4.setMarginEnd(60);
        layoutParams4.gravity = 16;
        progressBar.setLayoutParams(layoutParams4);
        linearLayout2.addView(progressBar);
        linearLayout2.addView(this.progressDescTextView);
        linearLayout.addView(this.progressTitleTextView);
        linearLayout.addView(linearLayout2);
        addView(linearLayout);
    }

    public void show(String str, String str2) {
        if (str != null) {
            this.progressTitleTextView.setVisibility(0);
            this.progressTitleTextView.setText(str);
        } else {
            this.progressTitleTextView.setVisibility(8);
        }
        if (str2 != null) {
            this.progressDescTextView.setVisibility(0);
            this.progressDescTextView.setText(str2);
        } else {
            this.progressDescTextView.setVisibility(8);
        }
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
    }
}
