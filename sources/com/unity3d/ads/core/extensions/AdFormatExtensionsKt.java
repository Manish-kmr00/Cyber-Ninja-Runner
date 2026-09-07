package com.unity3d.ads.core.extensions;

import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFormatExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUnityAdFormat", "Lcom/unity3d/scar/adapter/common/scarads/UnityAdFormat;", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AdFormatExtensionsKt {

    /* JADX INFO: compiled from: AdFormatExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationResponseOuterClass.AdFormat.values().length];
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final UnityAdFormat toUnityAdFormat(InitializationResponseOuterClass.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[adFormat.ordinal()];
        if (i == 1) {
            return UnityAdFormat.REWARDED;
        }
        if (i == 2) {
            return UnityAdFormat.INTERSTITIAL;
        }
        if (i != 3) {
            return null;
        }
        return UnityAdFormat.BANNER;
    }
}
