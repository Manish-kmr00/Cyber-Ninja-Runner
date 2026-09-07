package com.yandex.mobile.ads.nativeads.template.appearance;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.yandex.mobile.ads.impl.cu;
import com.yandex.mobile.ads.impl.oh2;
import com.yandex.mobile.ads.nativeads.template.HorizontalOffset;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010#\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001a\u0010&\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u001a\u0010)\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001a\u0010,\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001cR\u001a\u0010/\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010\u001cR\u001a\u00105\u001a\u0002008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00108\u001a\u0002008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001a\u0010>\u001a\u0002098\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010D\u001a\u00020?8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance;", "Landroid/os/Parcelable;", "Lcom/yandex/mobile/ads/impl/cu;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/yandex/mobile/ads/nativeads/template/appearance/BannerAppearance;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/yandex/mobile/ads/nativeads/template/appearance/BannerAppearance;", "getBannerAppearance", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/BannerAppearance;", "bannerAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "getAgeAppearance", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "ageAppearance", "d", "getBodyAppearance", "bodyAppearance", "e", "getDomainAppearance", "domainAppearance", InneractiveMediationDefs.GENDER_FEMALE, "getReviewCountAppearance", "reviewCountAppearance", "g", "getSponsoredAppearance", "sponsoredAppearance", "h", "getTitleAppearance", "titleAppearance", "i", "getWarningAppearance", "warningAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ImageAppearance;", "j", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ImageAppearance;", "getFaviconAppearance", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/ImageAppearance;", "faviconAppearance", CampaignEx.JSON_KEY_AD_K, "getImageAppearance", "imageAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ButtonAppearance;", "l", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ButtonAppearance;", "getCallToActionAppearance", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/ButtonAppearance;", "callToActionAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/RatingAppearance;", "m", "Lcom/yandex/mobile/ads/nativeads/template/appearance/RatingAppearance;", "getRatingAppearance", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/RatingAppearance;", "ratingAppearance", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class NativeTemplateAppearance implements Parcelable, cu {
    public static final Parcelable.Creator<NativeTemplateAppearance> CREATOR = new a();
    private static final int n = Color.parseColor("#7f7f7f");
    private static final int o = Color.parseColor("#ffd200");
    private static final int p = Color.parseColor("#ffd200");
    private static final int q = Color.parseColor("#f4c900");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final BannerAppearance bannerAppearance;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final TextAppearance ageAppearance;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final TextAppearance bodyAppearance;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final TextAppearance domainAppearance;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final TextAppearance reviewCountAppearance;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final TextAppearance sponsoredAppearance;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final TextAppearance titleAppearance;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final TextAppearance warningAppearance;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final ImageAppearance faviconAppearance;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final ImageAppearance imageAppearance;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final ButtonAppearance callToActionAppearance;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final RatingAppearance ratingAppearance;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010\bJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\bJ\u0015\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010\bJ\u0015\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "", "Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance;", "build", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance;", "Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "ageAppearance", "withAgeAppearance", "(Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;)Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "Lcom/yandex/mobile/ads/nativeads/template/appearance/BannerAppearance;", "bannerAppearance", "withBannerAppearance", "(Lcom/yandex/mobile/ads/nativeads/template/appearance/BannerAppearance;)Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "bodyAppearance", "withBodyAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ButtonAppearance;", "appearance", "withCallToActionAppearance", "(Lcom/yandex/mobile/ads/nativeads/template/appearance/ButtonAppearance;)Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "domainAppearance", "withDomainAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/ImageAppearance;", "faviconAppearance", "withFaviconAppearance", "(Lcom/yandex/mobile/ads/nativeads/template/appearance/ImageAppearance;)Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "imageAppearance", "withImageAppearance", "Lcom/yandex/mobile/ads/nativeads/template/appearance/RatingAppearance;", "ratingAppearance", "withRatingAppearance", "(Lcom/yandex/mobile/ads/nativeads/template/appearance/RatingAppearance;)Lcom/yandex/mobile/ads/nativeads/template/appearance/NativeTemplateAppearance$Builder;", "reviewCountAppearance", "withReviewCountAppearance", "sponsoredAppearance", "withSponsoredAppearance", "titleAppearance", "withTitleAppearance", "warningAppearance", "withWarningAppearance", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BannerAppearance f10895a = b();
        private ButtonAppearance k = d();
        private ImageAppearance i = g();
        private ImageAppearance j = f();
        private RatingAppearance l = h();
        private TextAppearance b = a();
        private TextAppearance c = c();
        private TextAppearance d = e();
        private TextAppearance e = i();
        private TextAppearance f = j();
        private TextAppearance g = k();
        private TextAppearance h = l();

        private static TextAppearance a() {
            return new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.n).setTextSize(15.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        private static BannerAppearance b() {
            return new BannerAppearance.Builder().setBackgroundColor(-1).setBorderColor(oh2.a(ViewCompat.MEASURED_STATE_MASK, 90.0f)).setBorderWidth(1.0f).setContentPadding(new HorizontalOffset(10.0f, 10.0f)).setImageMargins(new HorizontalOffset(0.0f, 10.0f)).build();
        }

        private static TextAppearance c() {
            return new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        private static ButtonAppearance d() {
            return new ButtonAppearance.Builder().setBorderColor(NativeTemplateAppearance.o).setBorderWidth(1.0f).setNormalColor(-1).setPressedColor(NativeTemplateAppearance.p).setTextAppearance(new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build()).build();
        }

        private static TextAppearance e() {
            return new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.n).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        private static ImageAppearance f() {
            return new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.FIXED, 16.0f)).build();
        }

        private static ImageAppearance g() {
            return new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.PREFERRED_RATIO, 0.3f)).build();
        }

        private static RatingAppearance h() {
            return new RatingAppearance.Builder().setBackgroundStarColor(-3355444).setProgressStarColor(NativeTemplateAppearance.q).build();
        }

        private static TextAppearance i() {
            return new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.n).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        private static TextAppearance j() {
            return new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.n).setTextSize(11.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        private static TextAppearance k() {
            return new TextAppearance.Builder().setTextColor(ViewCompat.MEASURED_STATE_MASK).setTextSize(15.0f).setFontFamilyName(null).setFontStyle(1).build();
        }

        private static TextAppearance l() {
            return new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.n).setTextSize(13.0f).setFontFamilyName(null).setFontStyle(0).build();
        }

        public final NativeTemplateAppearance build() {
            return new NativeTemplateAppearance(this.f10895a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.j, this.i, this.k, this.l, null);
        }

        public final Builder withAgeAppearance(TextAppearance ageAppearance) {
            Intrinsics.checkNotNullParameter(ageAppearance, "ageAppearance");
            TextAppearance textAppearance = this.b;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (ageAppearance != null && !Intrinsics.areEqual(textAppearance, ageAppearance)) {
                int textColor = ageAppearance.getTextColor();
                float textSize = ageAppearance.getTextSize();
                String fontFamilyName = ageAppearance.getFontFamilyName();
                int fontStyle = ageAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.b = textAppearance;
            return this;
        }

        public final Builder withBannerAppearance(BannerAppearance bannerAppearance) {
            Intrinsics.checkNotNullParameter(bannerAppearance, "bannerAppearance");
            BannerAppearance bannerAppearance2 = this.f10895a;
            Intrinsics.checkNotNullParameter(bannerAppearance2, "bannerAppearance");
            if (bannerAppearance != null && !Intrinsics.areEqual(bannerAppearance2, bannerAppearance)) {
                int backgroundColor = bannerAppearance.getBackgroundColor();
                if (backgroundColor == 0) {
                    backgroundColor = bannerAppearance2.getBackgroundColor();
                }
                int borderColor = bannerAppearance.getBorderColor();
                if (borderColor == 0) {
                    borderColor = bannerAppearance2.getBorderColor();
                }
                float borderWidth = bannerAppearance.getBorderWidth();
                if (borderWidth < 0.0f) {
                    borderWidth = bannerAppearance2.getBorderWidth();
                }
                HorizontalOffset contentPadding = bannerAppearance2.getContentPadding();
                if (contentPadding != null) {
                    HorizontalOffset contentPadding2 = bannerAppearance.getContentPadding();
                    if (contentPadding2 != null && !Intrinsics.areEqual(contentPadding, contentPadding2)) {
                        contentPadding = new HorizontalOffset(contentPadding2.getLeft() >= 0.0f ? contentPadding2.getLeft() : 0.0f, contentPadding2.getRight() >= 0.0f ? contentPadding2.getRight() : 0.0f);
                    }
                } else {
                    contentPadding = null;
                }
                HorizontalOffset imageMargins = bannerAppearance.getImageMargins();
                if (imageMargins == null) {
                    imageMargins = bannerAppearance2.getImageMargins();
                }
                BannerAppearance.Builder builder = new BannerAppearance.Builder();
                builder.setBackgroundColor(backgroundColor);
                builder.setBorderColor(borderColor);
                builder.setBorderWidth(borderWidth);
                if (contentPadding != null) {
                    builder.setContentPadding(contentPadding);
                }
                if (imageMargins != null) {
                    builder.setImageMargins(imageMargins);
                }
                bannerAppearance2 = builder.build();
            }
            this.f10895a = bannerAppearance2;
            return this;
        }

        public final Builder withBodyAppearance(TextAppearance bodyAppearance) {
            Intrinsics.checkNotNullParameter(bodyAppearance, "bodyAppearance");
            TextAppearance textAppearance = this.c;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (bodyAppearance != null && !Intrinsics.areEqual(textAppearance, bodyAppearance)) {
                int textColor = bodyAppearance.getTextColor();
                float textSize = bodyAppearance.getTextSize();
                String fontFamilyName = bodyAppearance.getFontFamilyName();
                int fontStyle = bodyAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.c = textAppearance;
            return this;
        }

        public final Builder withCallToActionAppearance(ButtonAppearance appearance) {
            Intrinsics.checkNotNullParameter(appearance, "appearance");
            ButtonAppearance buttonAppearance = this.k;
            Intrinsics.checkNotNullParameter(buttonAppearance, "buttonAppearance");
            if (appearance != null && !Intrinsics.areEqual(buttonAppearance, appearance)) {
                TextAppearance textAppearance = buttonAppearance.getTextAppearance();
                if (textAppearance != null) {
                    TextAppearance textAppearance2 = appearance.getTextAppearance();
                    Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
                    if (textAppearance2 != null && !Intrinsics.areEqual(textAppearance, textAppearance2)) {
                        int textColor = textAppearance2.getTextColor();
                        float textSize = textAppearance2.getTextSize();
                        String fontFamilyName = textAppearance2.getFontFamilyName();
                        int fontStyle = textAppearance2.getFontStyle();
                        if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                            fontFamilyName = textAppearance.getFontFamilyName();
                        }
                        TextAppearance.Builder builder = new TextAppearance.Builder();
                        if (textColor == 0) {
                            textColor = textAppearance.getTextColor();
                        }
                        TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                        if (textSize < 1.0f) {
                            textSize = textAppearance.getTextSize();
                        }
                        textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
                    }
                } else {
                    textAppearance = null;
                }
                int borderColor = appearance.getBorderColor();
                float borderWidth = appearance.getBorderWidth();
                int normalColor = appearance.getNormalColor();
                int pressedColor = appearance.getPressedColor();
                ButtonAppearance.Builder builder2 = new ButtonAppearance.Builder();
                if (textAppearance != null) {
                    builder2.setTextAppearance(textAppearance);
                }
                if (borderColor == 0) {
                    borderColor = buttonAppearance.getBorderColor();
                }
                builder2.setBorderColor(borderColor);
                if (borderWidth < 0.0f) {
                    borderWidth = buttonAppearance.getBorderWidth();
                }
                builder2.setBorderWidth(borderWidth);
                if (normalColor == 0) {
                    normalColor = buttonAppearance.getNormalColor();
                }
                builder2.setNormalColor(normalColor);
                if (pressedColor == 0) {
                    pressedColor = buttonAppearance.getPressedColor();
                }
                builder2.setPressedColor(pressedColor);
                buttonAppearance = builder2.build();
            }
            this.k = buttonAppearance;
            return this;
        }

        public final Builder withDomainAppearance(TextAppearance domainAppearance) {
            Intrinsics.checkNotNullParameter(domainAppearance, "domainAppearance");
            TextAppearance textAppearance = this.d;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (domainAppearance != null && !Intrinsics.areEqual(textAppearance, domainAppearance)) {
                int textColor = domainAppearance.getTextColor();
                float textSize = domainAppearance.getTextSize();
                String fontFamilyName = domainAppearance.getFontFamilyName();
                int fontStyle = domainAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.d = textAppearance;
            return this;
        }

        public final Builder withFaviconAppearance(ImageAppearance faviconAppearance) {
            Intrinsics.checkNotNullParameter(faviconAppearance, "faviconAppearance");
            ImageAppearance imageAppearance = this.j;
            Intrinsics.checkNotNullParameter(imageAppearance, "imageAppearance");
            if (faviconAppearance != null && !Intrinsics.areEqual(imageAppearance, faviconAppearance)) {
                SizeConstraint widthConstraint = faviconAppearance.getWidthConstraint();
                if (widthConstraint == null) {
                    widthConstraint = imageAppearance.getWidthConstraint();
                }
                ImageAppearance.Builder builder = new ImageAppearance.Builder();
                if (widthConstraint != null) {
                    builder.setWidthConstraint(widthConstraint);
                }
                imageAppearance = builder.build();
            }
            this.j = imageAppearance;
            return this;
        }

        public final Builder withImageAppearance(ImageAppearance imageAppearance) {
            Intrinsics.checkNotNullParameter(imageAppearance, "imageAppearance");
            ImageAppearance imageAppearance2 = this.i;
            Intrinsics.checkNotNullParameter(imageAppearance2, "imageAppearance");
            if (imageAppearance != null && !Intrinsics.areEqual(imageAppearance2, imageAppearance)) {
                SizeConstraint widthConstraint = imageAppearance.getWidthConstraint();
                if (widthConstraint == null) {
                    widthConstraint = imageAppearance2.getWidthConstraint();
                }
                ImageAppearance.Builder builder = new ImageAppearance.Builder();
                if (widthConstraint != null) {
                    builder.setWidthConstraint(widthConstraint);
                }
                imageAppearance2 = builder.build();
            }
            this.i = imageAppearance2;
            return this;
        }

        public final Builder withRatingAppearance(RatingAppearance ratingAppearance) {
            Intrinsics.checkNotNullParameter(ratingAppearance, "ratingAppearance");
            RatingAppearance ratingAppearance2 = this.l;
            Intrinsics.checkNotNullParameter(ratingAppearance2, "ratingAppearance");
            if (ratingAppearance != null && !Intrinsics.areEqual(ratingAppearance2, ratingAppearance)) {
                int backgroundStarColor = ratingAppearance.getBackgroundStarColor();
                int progressStarColor = ratingAppearance.getProgressStarColor();
                if (backgroundStarColor == 0) {
                    backgroundStarColor = ratingAppearance2.getBackgroundStarColor();
                }
                if (progressStarColor == 0) {
                    progressStarColor = ratingAppearance2.getProgressStarColor();
                }
                ratingAppearance2 = new RatingAppearance.Builder().setBackgroundStarColor(backgroundStarColor).setProgressStarColor(progressStarColor).build();
            }
            this.l = ratingAppearance2;
            return this;
        }

        public final Builder withReviewCountAppearance(TextAppearance reviewCountAppearance) {
            Intrinsics.checkNotNullParameter(reviewCountAppearance, "reviewCountAppearance");
            TextAppearance textAppearance = this.e;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (reviewCountAppearance != null && !Intrinsics.areEqual(textAppearance, reviewCountAppearance)) {
                int textColor = reviewCountAppearance.getTextColor();
                float textSize = reviewCountAppearance.getTextSize();
                String fontFamilyName = reviewCountAppearance.getFontFamilyName();
                int fontStyle = reviewCountAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.e = textAppearance;
            return this;
        }

        public final Builder withSponsoredAppearance(TextAppearance sponsoredAppearance) {
            Intrinsics.checkNotNullParameter(sponsoredAppearance, "sponsoredAppearance");
            TextAppearance textAppearance = this.f;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (sponsoredAppearance != null && !Intrinsics.areEqual(textAppearance, sponsoredAppearance)) {
                int textColor = sponsoredAppearance.getTextColor();
                float textSize = sponsoredAppearance.getTextSize();
                String fontFamilyName = sponsoredAppearance.getFontFamilyName();
                int fontStyle = sponsoredAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.f = textAppearance;
            return this;
        }

        public final Builder withTitleAppearance(TextAppearance titleAppearance) {
            Intrinsics.checkNotNullParameter(titleAppearance, "titleAppearance");
            TextAppearance textAppearance = this.g;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (titleAppearance != null && !Intrinsics.areEqual(textAppearance, titleAppearance)) {
                int textColor = titleAppearance.getTextColor();
                float textSize = titleAppearance.getTextSize();
                String fontFamilyName = titleAppearance.getFontFamilyName();
                int fontStyle = titleAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.g = textAppearance;
            return this;
        }

        public final Builder withWarningAppearance(TextAppearance warningAppearance) {
            Intrinsics.checkNotNullParameter(warningAppearance, "warningAppearance");
            TextAppearance textAppearance = this.h;
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            if (warningAppearance != null && !Intrinsics.areEqual(textAppearance, warningAppearance)) {
                int textColor = warningAppearance.getTextColor();
                float textSize = warningAppearance.getTextSize();
                String fontFamilyName = warningAppearance.getFontFamilyName();
                int fontStyle = warningAppearance.getFontStyle();
                if (fontFamilyName == null || fontFamilyName.length() <= 0) {
                    fontFamilyName = textAppearance.getFontFamilyName();
                }
                TextAppearance.Builder builder = new TextAppearance.Builder();
                if (textColor == 0) {
                    textColor = textAppearance.getTextColor();
                }
                TextAppearance.Builder textColor2 = builder.setTextColor(textColor);
                if (textSize < 1.0f) {
                    textSize = textAppearance.getTextSize();
                }
                textAppearance = textColor2.setTextSize(textSize).setFontFamilyName(fontFamilyName).setFontStyle(fontStyle).build();
            }
            this.h = textAppearance;
            return this;
        }
    }

    public static final class a implements Parcelable.Creator<NativeTemplateAppearance> {
        @Override // android.os.Parcelable.Creator
        public final NativeTemplateAppearance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            BannerAppearance bannerAppearanceCreateFromParcel = BannerAppearance.CREATOR.createFromParcel(parcel);
            Parcelable.Creator<TextAppearance> creator = TextAppearance.CREATOR;
            TextAppearance textAppearanceCreateFromParcel = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel2 = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel3 = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel4 = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel5 = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel6 = creator.createFromParcel(parcel);
            TextAppearance textAppearanceCreateFromParcel7 = creator.createFromParcel(parcel);
            Parcelable.Creator<ImageAppearance> creator2 = ImageAppearance.CREATOR;
            return new NativeTemplateAppearance(bannerAppearanceCreateFromParcel, textAppearanceCreateFromParcel, textAppearanceCreateFromParcel2, textAppearanceCreateFromParcel3, textAppearanceCreateFromParcel4, textAppearanceCreateFromParcel5, textAppearanceCreateFromParcel6, textAppearanceCreateFromParcel7, creator2.createFromParcel(parcel), creator2.createFromParcel(parcel), ButtonAppearance.CREATOR.createFromParcel(parcel), RatingAppearance.CREATOR.createFromParcel(parcel), null);
        }

        @Override // android.os.Parcelable.Creator
        public final NativeTemplateAppearance[] newArray(int i) {
            return new NativeTemplateAppearance[i];
        }
    }

    public /* synthetic */ NativeTemplateAppearance(BannerAppearance bannerAppearance, TextAppearance textAppearance, TextAppearance textAppearance2, TextAppearance textAppearance3, TextAppearance textAppearance4, TextAppearance textAppearance5, TextAppearance textAppearance6, TextAppearance textAppearance7, ImageAppearance imageAppearance, ImageAppearance imageAppearance2, ButtonAppearance buttonAppearance, RatingAppearance ratingAppearance, DefaultConstructorMarker defaultConstructorMarker) {
        this(bannerAppearance, textAppearance, textAppearance2, textAppearance3, textAppearance4, textAppearance5, textAppearance6, textAppearance7, imageAppearance, imageAppearance2, buttonAppearance, ratingAppearance);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(NativeTemplateAppearance.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance");
        NativeTemplateAppearance nativeTemplateAppearance = (NativeTemplateAppearance) other;
        if (Intrinsics.areEqual(getBannerAppearance(), nativeTemplateAppearance.getBannerAppearance()) && Intrinsics.areEqual(getAgeAppearance(), nativeTemplateAppearance.getAgeAppearance()) && Intrinsics.areEqual(getBodyAppearance(), nativeTemplateAppearance.getBodyAppearance()) && Intrinsics.areEqual(getDomainAppearance(), nativeTemplateAppearance.getDomainAppearance()) && Intrinsics.areEqual(getReviewCountAppearance(), nativeTemplateAppearance.getReviewCountAppearance()) && Intrinsics.areEqual(getSponsoredAppearance(), nativeTemplateAppearance.getSponsoredAppearance()) && Intrinsics.areEqual(getTitleAppearance(), nativeTemplateAppearance.getTitleAppearance()) && Intrinsics.areEqual(getWarningAppearance(), nativeTemplateAppearance.getWarningAppearance()) && Intrinsics.areEqual(getFaviconAppearance(), nativeTemplateAppearance.getFaviconAppearance()) && Intrinsics.areEqual(getImageAppearance(), nativeTemplateAppearance.getImageAppearance()) && Intrinsics.areEqual(getCallToActionAppearance(), nativeTemplateAppearance.getCallToActionAppearance())) {
            return Intrinsics.areEqual(getRatingAppearance(), nativeTemplateAppearance.getRatingAppearance());
        }
        return false;
    }

    public int hashCode() {
        return getRatingAppearance().hashCode() + ((getCallToActionAppearance().hashCode() + ((getImageAppearance().hashCode() + ((getFaviconAppearance().hashCode() + ((getWarningAppearance().hashCode() + ((getTitleAppearance().hashCode() + ((getSponsoredAppearance().hashCode() + ((getReviewCountAppearance().hashCode() + ((getDomainAppearance().hashCode() + ((getBodyAppearance().hashCode() + ((getAgeAppearance().hashCode() + (getBannerAppearance().hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.bannerAppearance.writeToParcel(parcel, flags);
        this.ageAppearance.writeToParcel(parcel, flags);
        this.bodyAppearance.writeToParcel(parcel, flags);
        this.domainAppearance.writeToParcel(parcel, flags);
        this.reviewCountAppearance.writeToParcel(parcel, flags);
        this.sponsoredAppearance.writeToParcel(parcel, flags);
        this.titleAppearance.writeToParcel(parcel, flags);
        this.warningAppearance.writeToParcel(parcel, flags);
        this.faviconAppearance.writeToParcel(parcel, flags);
        this.imageAppearance.writeToParcel(parcel, flags);
        this.callToActionAppearance.writeToParcel(parcel, flags);
        this.ratingAppearance.writeToParcel(parcel, flags);
    }

    private NativeTemplateAppearance(BannerAppearance bannerAppearance, TextAppearance textAppearance, TextAppearance textAppearance2, TextAppearance textAppearance3, TextAppearance textAppearance4, TextAppearance textAppearance5, TextAppearance textAppearance6, TextAppearance textAppearance7, ImageAppearance imageAppearance, ImageAppearance imageAppearance2, ButtonAppearance buttonAppearance, RatingAppearance ratingAppearance) {
        this.bannerAppearance = bannerAppearance;
        this.ageAppearance = textAppearance;
        this.bodyAppearance = textAppearance2;
        this.domainAppearance = textAppearance3;
        this.reviewCountAppearance = textAppearance4;
        this.sponsoredAppearance = textAppearance5;
        this.titleAppearance = textAppearance6;
        this.warningAppearance = textAppearance7;
        this.faviconAppearance = imageAppearance;
        this.imageAppearance = imageAppearance2;
        this.callToActionAppearance = buttonAppearance;
        this.ratingAppearance = ratingAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getAgeAppearance() {
        return this.ageAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public BannerAppearance getBannerAppearance() {
        return this.bannerAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getBodyAppearance() {
        return this.bodyAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public ButtonAppearance getCallToActionAppearance() {
        return this.callToActionAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getDomainAppearance() {
        return this.domainAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public ImageAppearance getFaviconAppearance() {
        return this.faviconAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public ImageAppearance getImageAppearance() {
        return this.imageAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public RatingAppearance getRatingAppearance() {
        return this.ratingAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getReviewCountAppearance() {
        return this.reviewCountAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getSponsoredAppearance() {
        return this.sponsoredAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getTitleAppearance() {
        return this.titleAppearance;
    }

    @Override // com.yandex.mobile.ads.impl.cu
    public TextAppearance getWarningAppearance() {
        return this.warningAppearance;
    }
}
