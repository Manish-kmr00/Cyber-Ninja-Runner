package com.amazon.aps.ads.util;

import com.amazon.aps.ads.ApsAdView;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DTBMRAIDCloseButtonListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsMraidHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/amazon/aps/ads/util/ApsMraidHandler;", "Lcom/amazon/device/ads/DTBAdMRAIDController;", "apsAdView", "Lcom/amazon/aps/ads/ApsAdView;", "(Lcom/amazon/aps/ads/ApsAdView;)V", "mraidListener", "Lcom/amazon/aps/ads/util/ApsMraidCloseButtonListener;", "setCloseButtonListener", "", "apsMraidListener", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApsMraidHandler extends DTBAdMRAIDController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MRAID_CLOSE = DTBAdMRAIDController.MRAID_CLOSE;
    private ApsMraidCloseButtonListener mraidListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsMraidHandler(ApsAdView apsAdView) {
        super(apsAdView);
        Intrinsics.checkNotNullParameter(apsAdView, "apsAdView");
        super.setCustomButtonListener(new DTBMRAIDCloseButtonListener() { // from class: com.amazon.aps.ads.util.ApsMraidHandler$$ExternalSyntheticLambda0
            @Override // com.amazon.device.ads.DTBMRAIDCloseButtonListener
            public final void useCustomButtonUpdated() {
                ApsMraidHandler.m4365_init_$lambda0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m4365_init_$lambda0(ApsMraidHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApsMraidCloseButtonListener apsMraidCloseButtonListener = this$0.mraidListener;
        if (apsMraidCloseButtonListener == null) {
            return;
        }
        apsMraidCloseButtonListener.useCustomButtonUpdated();
    }

    public final void setCloseButtonListener(ApsMraidCloseButtonListener apsMraidListener) {
        Intrinsics.checkNotNullParameter(apsMraidListener, "apsMraidListener");
        this.mraidListener = apsMraidListener;
    }

    /* JADX INFO: compiled from: ApsMraidHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/amazon/aps/ads/util/ApsMraidHandler$Companion;", "", "()V", "MRAID_CLOSE", "", "getMRAID_CLOSE", "()Ljava/lang/String;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMRAID_CLOSE() {
            return ApsMraidHandler.MRAID_CLOSE;
        }
    }
}
