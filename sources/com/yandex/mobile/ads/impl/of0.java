package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes7.dex */
public final class of0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f9811a;
    private long b;

    public of0(BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f9811a = source;
        this.b = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final nf0 a() throws IOException {
        nf0.a aVar = new nf0.a();
        while (true) {
            String line = b();
            if (line.length() == 0) {
                return aVar.a();
            }
            Intrinsics.checkNotNullParameter(line, "line");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) line, AbstractJsonLexerKt.COLON, 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = line.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = line.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                aVar.a(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                aVar.a("", strSubstring3);
            } else {
                aVar.a("", line);
            }
        }
    }

    public final String b() throws IOException {
        String utf8LineStrict = this.f9811a.readUtf8LineStrict(this.b);
        this.b -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }
}
