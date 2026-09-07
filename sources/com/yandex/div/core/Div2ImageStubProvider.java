package com.yandex.div.core;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public interface Div2ImageStubProvider {
    public static final Div2ImageStubProvider STUB = new Div2ImageStubProvider() { // from class: com.yandex.div.core.Div2ImageStubProvider$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.Div2ImageStubProvider
        public final Drawable getImageStubDrawable(int i) {
            return Div2ImageStubProvider.$r8$lambda$gYlXKjRCTyX4ZwPWOfIMiw7KzQA(i);
        }
    };

    static /* synthetic */ ColorDrawable $r8$lambda$gYlXKjRCTyX4ZwPWOfIMiw7KzQA(int i) {
        return new ColorDrawable(i);
    }

    Drawable getImageStubDrawable(int i);
}
