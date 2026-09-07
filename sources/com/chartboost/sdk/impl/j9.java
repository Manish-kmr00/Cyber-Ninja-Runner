package com.chartboost.sdk.impl;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/j9;", "", "Ljava/io/File;", "htmlFile", "", "params", "adm", "a", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class j9 {
    public final String a(File htmlFile, String params, String adm) {
        Intrinsics.checkNotNullParameter(htmlFile, "htmlFile");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(adm, "adm");
        try {
            return StringsKt.replace$default(StringsKt.replace$default(FilesKt.readText(htmlFile, Charsets.UTF_8), "\"{% params %}\"", params, false, 4, (Object) null), "{% adm %}", adm, false, 4, (Object) null);
        } catch (Exception e) {
            b7.b("Parse sdk bidding template exception", e);
            return null;
        }
    }
}
