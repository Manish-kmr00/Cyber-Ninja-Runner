package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class Bl extends BaseRequestConfig.BaseRequestArguments {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11077a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Bl(C4007b4 c4007b4) {
        this(c4007b4.a().d(), c4007b4.a().e(), c4007b4.a().a(), c4007b4.a().i(), c4007b4.a().b());
    }

    public final boolean a(Bl bl) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Bl mergeFrom(Bl bl) {
        return new Bl((String) WrapUtils.getOrDefaultNullable(this.f11077a, bl.f11077a), (String) WrapUtils.getOrDefaultNullable(this.b, bl.b), (Map) WrapUtils.getOrDefaultNullable(this.c, bl.c), this.d || bl.d, bl.d ? bl.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f11077a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public Bl(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f11077a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Bl() {
        this(null, null, null, false, null);
    }
}
