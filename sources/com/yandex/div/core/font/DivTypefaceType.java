package com.yandex.div.core.font;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes9.dex */
public enum DivTypefaceType {
    REGULAR,
    MEDIUM,
    BOLD,
    LIGHT;

    /* JADX INFO: renamed from: com.yandex.div.core.font.DivTypefaceType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yandex$div$core$font$DivTypefaceType;

        static {
            int[] iArr = new int[DivTypefaceType.values().length];
            $SwitchMap$com$yandex$div$core$font$DivTypefaceType = iArr;
            try {
                iArr[DivTypefaceType.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yandex$div$core$font$DivTypefaceType[DivTypefaceType.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yandex$div$core$font$DivTypefaceType[DivTypefaceType.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Typeface getTypeface(DivTypefaceProvider divTypefaceProvider) {
        int i = AnonymousClass1.$SwitchMap$com$yandex$div$core$font$DivTypefaceType[ordinal()];
        if (i == 1) {
            return divTypefaceProvider.getBold();
        }
        if (i == 2) {
            return divTypefaceProvider.getMedium();
        }
        if (i == 3) {
            return divTypefaceProvider.getLight();
        }
        return divTypefaceProvider.getRegular();
    }
}
