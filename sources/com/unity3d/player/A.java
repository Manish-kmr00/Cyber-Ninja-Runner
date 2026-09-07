package com.unity3d.player;

import android.view.inputmethod.InputMethodSubtype;

/* JADX INFO: loaded from: classes12.dex */
abstract class A {
    public static String a(InputMethodSubtype inputMethodSubtype) {
        return PlatformSupport.NOUGAT_SUPPORT ? inputMethodSubtype.getLanguageTag() : inputMethodSubtype.getLocale();
    }
}
