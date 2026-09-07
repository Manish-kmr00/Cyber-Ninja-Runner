package com.yandex.mobile.ads.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class w42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<u42> f10533a;
    private final ng1 b;
    private final mj1 c;
    private final x42 d;

    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    public final fa2 a(String rawValue) {
        Long lValueOf;
        fa2 fa2Var;
        Integer numValueOf;
        Float floatOrNull;
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        if (this.f10533a.contains(u42.d) && Intrinsics.areEqual("start", rawValue)) {
            return new fa2(fa2.b.b, 0.0f);
        }
        if (this.f10533a.contains(u42.e) && Intrinsics.areEqual("end", rawValue)) {
            return new fa2(fa2.b.c, 100.0f);
        }
        if (this.f10533a.contains(u42.c) && StringsKt.endsWith$default(rawValue, "%", false, 2, (Object) null)) {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            try {
                String strSubstring = rawValue.substring(0, StringsKt.getLastIndex(rawValue));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                floatOrNull = StringsKt.toFloatOrNull(strSubstring);
                if (floatOrNull != null) {
                    float fFloatValue = floatOrNull.floatValue();
                    if (0.0f > fFloatValue || fFloatValue > 100.0f) {
                        floatOrNull = null;
                    }
                } else {
                    floatOrNull = null;
                }
            } catch (Throwable unused) {
            }
            if (floatOrNull != null) {
                fa2Var = new fa2(fa2.b.c, floatOrNull.floatValue());
                return fa2Var;
            }
            return null;
        }
        if (this.f10533a.contains(u42.f) && StringsKt.startsWith$default(rawValue, "#", false, 2, (Object) null)) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            try {
                String strSubstring2 = rawValue.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                int i = Integer.parseInt(strSubstring2);
                numValueOf = i >= 1 ? Integer.valueOf(i) : null;
            } catch (Exception unused2) {
            }
            if (numValueOf != null) {
                fa2Var = new fa2(fa2.b.d, numValueOf.intValue());
                return fa2Var;
            }
            return null;
        }
        if (this.f10533a.contains(u42.b)) {
            this.d.getClass();
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
                lValueOf = Long.valueOf(simpleDateFormat.parse(rawValue).getTime() - simpleDateFormat.parse("00:00:00").getTime());
            } catch (ParseException unused3) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                fa2Var = new fa2(fa2.b.b, lValueOf.longValue());
                return fa2Var;
            }
        }
        return null;
    }

    public /* synthetic */ w42(Set set) {
        this(set, new ng1(), new mj1(), new x42());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w42(Set<? extends u42> allowedFormats, ng1 percentageParser, mj1 positionParser, x42 timeParser) {
        Intrinsics.checkNotNullParameter(allowedFormats, "allowedFormats");
        Intrinsics.checkNotNullParameter(percentageParser, "percentageParser");
        Intrinsics.checkNotNullParameter(positionParser, "positionParser");
        Intrinsics.checkNotNullParameter(timeParser, "timeParser");
        this.f10533a = allowedFormats;
        this.b = percentageParser;
        this.c = positionParser;
        this.d = timeParser;
    }
}
