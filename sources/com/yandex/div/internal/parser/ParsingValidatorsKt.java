package com.yandex.div.internal.parser;

import android.net.Uri;
import java.util.Collection;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingValidators.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\b\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0018\u0010\b\u001a\u00020\u0005*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¨\u0006\f"}, d2 = {"cast", "Lcom/yandex/div/internal/parser/ListValidator;", "T", "R", "doesMatch", "", "", "regex", "hasScheme", "Landroid/net/Uri;", "schemes", "", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParsingValidatorsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <R, T> ListValidator<T> cast(ListValidator<R> listValidator) {
        Intrinsics.checkNotNullParameter(listValidator, "<this>");
        return listValidator;
    }

    public static final boolean doesMatch(String str, String regex) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return Pattern.matches(regex, str);
    }

    public static final boolean hasScheme(Uri uri, Collection<String> schemes) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(schemes, "schemes");
        String scheme = uri.getScheme();
        if (scheme != null) {
            return schemes.contains(scheme);
        }
        return false;
    }
}
