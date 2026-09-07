package com.pubmatic.sdk.webrendering;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.pubmatic.sdk.common.log.POBLog;

/* JADX INFO: loaded from: classes8.dex */
public class POBUIUtil {
    private static InsetDrawable a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        Resources resources = context.getResources();
        gradientDrawable.setColor(resources.getColor(R.color.pob_controls_background_color));
        gradientDrawable.setStroke(resources.getDimensionPixelOffset(R.dimen.pob_control_stroke_width), resources.getColor(R.color.pob_controls_stroke_color));
        gradientDrawable.setAlpha(resources.getInteger(R.integer.pob_controls_alpha));
        return new InsetDrawable((Drawable) gradientDrawable, resources.getDimensionPixelOffset(R.dimen.pob_control_padding));
    }

    public static ImageButton createDsaInfoIconButton(Context context, int i, int i2, boolean z, boolean z2) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_icon_margin_fullscreen);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_icon_margin);
        ImageButton imageButton = new ImageButton(context);
        imageButton.setId(i);
        Resources resources = context.getResources();
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setBackgroundColor(0);
        imageButton.setImageResource(i2);
        imageButton.setPadding(0, 0, 0, 0);
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_width_full_screen), resources.getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_height_full_screen));
            layoutParams.leftMargin = dimensionPixelOffset;
            if (z2) {
                layoutParams.bottomMargin = dimensionPixelOffset;
                layoutParams.gravity = 8388691;
            } else {
                layoutParams.topMargin = dimensionPixelOffset;
                layoutParams.gravity = 8388659;
            }
        } else {
            layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_width), resources.getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_height));
            layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset2);
            layoutParams.gravity = GravityCompat.START;
        }
        imageButton.setLayoutParams(layoutParams);
        return imageButton;
    }

    public static ImageButton createSkipButton(Context context, int i, int i2) {
        ImageButton imageButton = new ImageButton(context);
        imageButton.setId(i);
        Resources resources = context.getResources();
        imageButton.setBackground(a(context));
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setImageResource(i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.pob_control_width), resources.getDimensionPixelOffset(R.dimen.pob_control_height));
        layoutParams.gravity = GravityCompat.END;
        layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.pob_close_button_right_margin);
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.pob_close_button_top_margin);
        imageButton.setLayoutParams(layoutParams);
        return imageButton;
    }

    public static TextView createSkipDurationTextView(Context context, int i) {
        TextView textViewCreateTextView = createTextView(context, "", context.getResources().getDimensionPixelOffset(R.dimen.pob_text_size), i);
        textViewCreateTextView.setBackground(a(context));
        textViewCreateTextView.setPadding(0, 0, 0, 0);
        return textViewCreateTextView;
    }

    public static TextView createTextView(Context context, String str, float f, int i) {
        TextView textView = new TextView(context);
        textView.setAllCaps(false);
        textView.setGravity(17);
        textView.setTextColor(context.getResources().getColor(android.R.color.white));
        textView.setTextSize(0, f);
        textView.setTextAlignment(4);
        textView.setText(str);
        try {
            textView.setTypeface(Typeface.SANS_SERIF, 1);
        } catch (Exception unused) {
            POBLog.warn("POBUIUtil", "SANS_SERIF font not found!", new Object[0]);
        }
        textView.setId(i);
        return textView;
    }

    public static FrameLayout.LayoutParams getLayoutParamsForTopRightPosition(Context context) {
        Resources resources = context.getResources();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.pob_control_width), resources.getDimensionPixelOffset(R.dimen.pob_control_height));
        layoutParams.gravity = GravityCompat.END;
        layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.pob_skip_control_right_margin);
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.pob_skip_control_top_margin);
        return layoutParams;
    }

    public static String getLocalizedStringForKey(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        if (identifier != 0) {
            String string = resources.getString(identifier);
            if (!string.isEmpty()) {
                return string;
            }
        }
        return str2;
    }

    public static void resizeDsaInfoBtn(Context context, ImageButton imageButton, boolean z) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_icon_margin_fullscreen);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_icon_margin);
        FrameLayout.LayoutParams layoutParams = imageButton.getLayoutParams() != null ? (FrameLayout.LayoutParams) imageButton.getLayoutParams() : new FrameLayout.LayoutParams(-2, -2);
        imageButton.setPadding(0, 0, 0, 0);
        if (z) {
            layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_height_full_screen);
            layoutParams.width = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_width_full_screen);
            layoutParams.leftMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset;
            layoutParams.gravity = 80;
        } else {
            layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_height);
            layoutParams.width = context.getResources().getDimensionPixelOffset(R.dimen.pob_dsa_info_icon_height);
            layoutParams.leftMargin = dimensionPixelOffset2;
            layoutParams.topMargin = dimensionPixelOffset2;
            layoutParams.gravity = GravityCompat.START;
        }
        imageButton.setLayoutParams(layoutParams);
    }

    public static void updateSkipBtnColor(Context context, ImageView imageView, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        Resources resources = context.getResources();
        gradientDrawable.setColor(resources.getColor(R.color.pob_skip_button_background_color));
        gradientDrawable.setStroke(resources.getDimensionPixelOffset(R.dimen.pob_control_stroke_width), resources.getColor(i));
        imageView.setBackground(new InsetDrawable((Drawable) gradientDrawable, resources.getDimensionPixelOffset(R.dimen.pob_control_padding)));
    }

    public static void updateSkipButtonToCloseButton(ImageButton imageButton) {
        imageButton.setImageResource(R.drawable.pob_ic_close_black_24dp);
        imageButton.setId(com.pubmatic.sdk.common.R.id.pob_close_btn);
    }
}
