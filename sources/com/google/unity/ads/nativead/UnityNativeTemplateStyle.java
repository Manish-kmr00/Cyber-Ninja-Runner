package com.google.unity.ads.nativead;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public final class UnityNativeTemplateStyle {
    final UnityNativeTemplateTextStyle callToActionStyle;
    final ColorDrawable mainBackgroundColor;
    final UnityNativeTemplateTextStyle primaryTextStyle;
    final UnityNativeTemplateTextStyle secondaryTextStyle;
    final UnityNativeTemplateType templateType;
    final UnityNativeTemplateTextStyle tertiaryTextStyle;

    public UnityNativeTemplateStyle(UnityNativeTemplateType templateType, ColorDrawable mainBackgroundColor, UnityNativeTemplateTextStyle callToActionStyle, UnityNativeTemplateTextStyle primaryTextStyle, UnityNativeTemplateTextStyle secondaryTextStyle, UnityNativeTemplateTextStyle tertiaryTextStyle) {
        this.templateType = templateType;
        this.mainBackgroundColor = mainBackgroundColor;
        this.callToActionStyle = callToActionStyle;
        this.primaryTextStyle = primaryTextStyle;
        this.secondaryTextStyle = secondaryTextStyle;
        this.tertiaryTextStyle = tertiaryTextStyle;
    }

    public TemplateView asTemplateView(Context context) {
        TemplateView templateView = (TemplateView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.templateType.resourceId(), (ViewGroup) null);
        if (templateView == null) {
            return null;
        }
        templateView.setStyles(asNativeTemplateStyle());
        return templateView;
    }

    public UnityNativeTemplateType getTemplateType() {
        return this.templateType;
    }

    public ColorDrawable getMainBackgroundColor() {
        return this.mainBackgroundColor;
    }

    public UnityNativeTemplateTextStyle getCallToActionStyle() {
        return this.callToActionStyle;
    }

    public UnityNativeTemplateTextStyle getPrimaryTextStyle() {
        return this.primaryTextStyle;
    }

    public UnityNativeTemplateTextStyle getSecondaryTextStyle() {
        return this.secondaryTextStyle;
    }

    public UnityNativeTemplateTextStyle getTertiaryTextStyle() {
        return this.tertiaryTextStyle;
    }

    public boolean equals(Object o) {
        ColorDrawable colorDrawable;
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof UnityNativeTemplateStyle)) {
            return false;
        }
        UnityNativeTemplateStyle unityNativeTemplateStyle = (UnityNativeTemplateStyle) o;
        return this.templateType == unityNativeTemplateStyle.templateType && (((colorDrawable = this.mainBackgroundColor) == null && unityNativeTemplateStyle.mainBackgroundColor == null) || colorDrawable.getColor() == unityNativeTemplateStyle.mainBackgroundColor.getColor()) && Objects.equals(this.callToActionStyle, unityNativeTemplateStyle.callToActionStyle) && Objects.equals(this.primaryTextStyle, unityNativeTemplateStyle.primaryTextStyle) && Objects.equals(this.secondaryTextStyle, unityNativeTemplateStyle.secondaryTextStyle) && Objects.equals(this.tertiaryTextStyle, unityNativeTemplateStyle.tertiaryTextStyle);
    }

    public int hashCode() {
        ColorDrawable colorDrawable = this.mainBackgroundColor;
        return Objects.hash(colorDrawable == null ? null : Integer.valueOf(colorDrawable.getColor()), this.callToActionStyle, this.primaryTextStyle, this.secondaryTextStyle, this.tertiaryTextStyle);
    }

    private NativeTemplateStyle asNativeTemplateStyle() {
        NativeTemplateStyle.Builder builder = new NativeTemplateStyle.Builder();
        ColorDrawable colorDrawable = this.mainBackgroundColor;
        if (colorDrawable != null) {
            builder.withMainBackgroundColor(colorDrawable);
        }
        UnityNativeTemplateTextStyle unityNativeTemplateTextStyle = this.callToActionStyle;
        if (unityNativeTemplateTextStyle != null) {
            if (unityNativeTemplateTextStyle.getBackgroundColor() != null) {
                builder.withCallToActionBackgroundColor(this.callToActionStyle.getBackgroundColor());
            }
            if (this.callToActionStyle.getTextColor() != null) {
                builder.withCallToActionTypefaceColor(this.callToActionStyle.getTextColor().getColor());
            }
            if (this.callToActionStyle.getFontStyle() != null) {
                builder.withCallToActionTextTypeface(this.callToActionStyle.getFontStyle().getTypeface());
            }
            if (this.callToActionStyle.getSize() != null) {
                builder.withCallToActionTextSize(this.callToActionStyle.getSize().floatValue());
            }
        }
        UnityNativeTemplateTextStyle unityNativeTemplateTextStyle2 = this.primaryTextStyle;
        if (unityNativeTemplateTextStyle2 != null) {
            if (unityNativeTemplateTextStyle2.getBackgroundColor() != null) {
                builder.withPrimaryTextBackgroundColor(this.primaryTextStyle.getBackgroundColor());
            }
            if (this.primaryTextStyle.getTextColor() != null) {
                builder.withPrimaryTextTypefaceColor(this.primaryTextStyle.getTextColor().getColor());
            }
            if (this.primaryTextStyle.getFontStyle() != null) {
                builder.withPrimaryTextTypeface(this.primaryTextStyle.getFontStyle().getTypeface());
            }
            if (this.primaryTextStyle.getSize() != null) {
                builder.withPrimaryTextSize(this.primaryTextStyle.getSize().floatValue());
            }
        }
        UnityNativeTemplateTextStyle unityNativeTemplateTextStyle3 = this.secondaryTextStyle;
        if (unityNativeTemplateTextStyle3 != null) {
            if (unityNativeTemplateTextStyle3.getBackgroundColor() != null) {
                builder.withSecondaryTextBackgroundColor(this.secondaryTextStyle.getBackgroundColor());
            }
            if (this.secondaryTextStyle.getTextColor() != null) {
                builder.withSecondaryTextTypefaceColor(this.secondaryTextStyle.getTextColor().getColor());
            }
            if (this.secondaryTextStyle.getFontStyle() != null) {
                builder.withSecondaryTextTypeface(this.secondaryTextStyle.getFontStyle().getTypeface());
            }
            if (this.secondaryTextStyle.getSize() != null) {
                builder.withSecondaryTextSize(this.secondaryTextStyle.getSize().floatValue());
            }
        }
        UnityNativeTemplateTextStyle unityNativeTemplateTextStyle4 = this.tertiaryTextStyle;
        if (unityNativeTemplateTextStyle4 != null) {
            if (unityNativeTemplateTextStyle4.getBackgroundColor() != null) {
                builder.withTertiaryTextBackgroundColor(this.tertiaryTextStyle.getBackgroundColor());
            }
            if (this.tertiaryTextStyle.getTextColor() != null) {
                builder.withTertiaryTextTypefaceColor(this.tertiaryTextStyle.getTextColor().getColor());
            }
            if (this.tertiaryTextStyle.getFontStyle() != null) {
                builder.withTertiaryTextTypeface(this.tertiaryTextStyle.getFontStyle().getTypeface());
            }
            if (this.tertiaryTextStyle.getSize() != null) {
                builder.withTertiaryTextSize(this.tertiaryTextStyle.getSize().floatValue());
            }
        }
        return builder.build();
    }
}
