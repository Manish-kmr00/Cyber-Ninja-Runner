package com.yandex.div.core.font;

import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: loaded from: classes6.dex */
public interface DivTypefaceProvider {
    public static final DivTypefaceProvider DEFAULT = new DivTypefaceProvider() { // from class: com.yandex.div.core.font.DivTypefaceProvider.1
        @Override // com.yandex.div.core.font.DivTypefaceProvider
        public Typeface getBold() {
            return null;
        }

        @Override // com.yandex.div.core.font.DivTypefaceProvider
        public Typeface getLight() {
            return null;
        }

        @Override // com.yandex.div.core.font.DivTypefaceProvider
        public Typeface getMedium() {
            return null;
        }

        @Override // com.yandex.div.core.font.DivTypefaceProvider
        public Typeface getRegular() {
            return null;
        }

        @Override // com.yandex.div.core.font.DivTypefaceProvider
        public Typeface getTypefaceFor(int i) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Typeface.create(Typeface.DEFAULT, i, false);
            }
            return super.getTypefaceFor(i);
        }
    };

    Typeface getBold();

    Typeface getLight();

    Typeface getMedium();

    Typeface getRegular();

    default Typeface getTypefaceFor(int i) {
        if (i >= 0 && i < 350) {
            return getLight();
        }
        if (i >= 350 && i < 450) {
            return getRegular();
        }
        if (i >= 450 && i < 600) {
            return getMedium();
        }
        return getBold();
    }
}
