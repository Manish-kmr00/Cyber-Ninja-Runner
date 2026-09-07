package com.ogury.ad.internal;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class x0 extends f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f7437a;
    public final String b;

    public x0(Pattern whitelistPattern) {
        Intrinsics.checkNotNullParameter(whitelistPattern, "whitelistPattern");
        this.f7437a = whitelistPattern;
        this.b = whitelistPattern.pattern();
    }

    @Override // com.ogury.ad.internal.f5
    public final boolean b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String stringPattern = this.b;
        Intrinsics.checkNotNullExpressionValue(stringPattern, "stringPattern");
        return stringPattern.length() > 0 && !this.f7437a.matcher(url).find();
    }
}
