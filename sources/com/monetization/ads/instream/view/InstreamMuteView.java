package com.monetization.ads.instream.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.yandex.mobile.ads.R;
import com.yandex.mobile.ads.impl.ti2;
import com.yandex.mobile.ads.impl.v31;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/instream/view/InstreamMuteView;", "Landroid/widget/ImageView;", "Lcom/yandex/mobile/ads/impl/v31;", "", "muted", "", "setMuted", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamMuteView extends ImageView implements v31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ti2 f7216a;
    private boolean b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InstreamMuteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onMeasure(int i, int i2) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Resources resources = getResources();
        if (isFocused()) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.monetization_instream_internal_mute_width);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.monetization_instream_internal_mute_height);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.monetization_instream_internal_mute_width_v2);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.monetization_instream_internal_mute_height_v2);
        }
        setMeasuredDimension(dimensionPixelSize, dimensionPixelSize2);
    }

    @Override // com.yandex.mobile.ads.impl.v31
    public void setMuted(boolean muted) {
        this.b = muted;
        this.f7216a.a(this, muted);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InstreamMuteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private static ti2 a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MonetizationAdsInternalInstreamMuteView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MonetizationAdsInternalInstreamMuteView_monetization_internal_sound_on, R.drawable.monetization_ads_internal_ic_sound_on_default);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MonetizationAdsInternalInstreamMuteView_monetization_internal_sound_off, R.drawable.monetization_ads_internal_ic_sound_off_default);
        typedArrayObtainStyledAttributes.recycle();
        return new ti2(resourceId2, resourceId);
    }

    public /* synthetic */ InstreamMuteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstreamMuteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7216a = a(context, attributeSet);
        a();
    }

    private final void a() {
        setMuted(this.b);
    }
}
