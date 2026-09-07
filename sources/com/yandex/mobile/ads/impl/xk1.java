package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class xk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy<byte[]> f10663a = LazyKt.lazy(a.b);

    static final class a extends Lambda implements Function0<byte[]> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final byte[] invoke() {
            return Base64.decode("/9j/2wBDAAUDBAQEAwUEBAQFBQUGBwwIBwcHBw8LCwkMEQ8SEhEPERETFhwXExQaFRERGCEYGh0dHx8fExciJCIeJBweHx7/2wBDAQUFBQcGBw4ICA4eFBEUHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh7/xAAfAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgv/xAC1EAACAQMDAgQDBQUEBAAAAX0BAgMABBEFEiExQQYTUWEHInEUMoGRoQgjQrHBFVLR8CQzYnKCCQoWFxgZGiUmJygpKjQ1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4eLj5OXm5+jp6vHy8/T19vf4+fr/xAAfAQADAQEBAQEBAQEBAAAAAAAAAQIDBAUGBwgJCgv/xAC1EQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fo=", 0);
        }
    }

    public static Bitmap a(String previewBase64) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(previewBase64, "previewBase64");
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArrB = b(previewBase64);
            objM7904constructorimpl = Result.m7904constructorimpl(!(bArrB.length == 0) ? BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (Bitmap) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    private static byte[] b(String str) {
        byte[] bArrDecode = Base64.decode(StringsKt.removePrefix(str, (CharSequence) "data:image/png;base64,"), 0);
        if (!StringsKt.startsWith$default(str, "data:image/png;base64,", false, 2, (Object) null)) {
            Intrinsics.checkNotNull(bArrDecode);
            if (bArrDecode.length == 0) {
                bArrDecode = new byte[0];
            } else {
                byte[] value = f10663a.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "access$getPreviewHeader(...)");
                bArrDecode = ArraysKt.plus(value, bArrDecode);
            }
        }
        Intrinsics.checkNotNull(bArrDecode);
        return bArrDecode;
    }
}
