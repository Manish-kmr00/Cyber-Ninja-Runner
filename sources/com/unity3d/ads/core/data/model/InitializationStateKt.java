package com.unity3d.ads.core.data.model;

import com.unity3d.services.core.properties.SdkProperties;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitializationState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toBold", "Lcom/unity3d/ads/core/data/model/InitializationState;", "Lcom/unity3d/services/core/properties/SdkProperties$InitializationState;", "toLegacy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InitializationStateKt {

    /* JADX INFO: compiled from: InitializationState.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitializationState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SdkProperties.InitializationState.values().length];
            try {
                iArr2[SdkProperties.InitializationState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZED_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final SdkProperties.InitializationState toLegacy(InitializationState initializationState) {
        Intrinsics.checkNotNullParameter(initializationState, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[initializationState.ordinal()];
        if (i == 1) {
            return SdkProperties.InitializationState.NOT_INITIALIZED;
        }
        if (i == 2) {
            return SdkProperties.InitializationState.INITIALIZING;
        }
        if (i == 3) {
            return SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY;
        }
        if (i == 4) {
            return SdkProperties.InitializationState.INITIALIZED_FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final InitializationState toBold(SdkProperties.InitializationState initializationState) {
        Intrinsics.checkNotNullParameter(initializationState, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[initializationState.ordinal()];
        if (i == 1) {
            return InitializationState.NOT_INITIALIZED;
        }
        if (i == 2) {
            return InitializationState.INITIALIZING;
        }
        if (i == 3) {
            return InitializationState.INITIALIZED;
        }
        if (i == 4) {
            return InitializationState.FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }
}
