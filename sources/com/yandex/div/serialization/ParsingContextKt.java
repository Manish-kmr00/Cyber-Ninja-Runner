package com.yandex.div.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingContext.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0000\u001a\f\u0010\n\u001a\u00020\u0004*\u00020\u0004H\u0000\"(\u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"collectedErrors", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/yandex/div/serialization/ParsingContext;", "getCollectedErrors$annotations", "(Lcom/yandex/div/serialization/ParsingContext;)V", "getCollectedErrors", "(Lcom/yandex/div/serialization/ParsingContext;)Ljava/util/List;", "collectingErrors", "restrictPropertyOverride", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParsingContextKt {
    public static /* synthetic */ void getCollectedErrors$annotations(ParsingContext parsingContext) {
    }

    public static final ParsingContext collectingErrors(ParsingContext parsingContext) {
        Intrinsics.checkNotNullParameter(parsingContext, "<this>");
        return parsingContext instanceof ErrorCollectingParsingContext ? parsingContext : new ErrorCollectingParsingContext(parsingContext);
    }

    public static final List<Exception> getCollectedErrors(ParsingContext parsingContext) {
        Intrinsics.checkNotNullParameter(parsingContext, "<this>");
        if (parsingContext instanceof ErrorCollectingParsingContext) {
            return ((ErrorCollectingParsingContext) parsingContext).getErrors();
        }
        return parsingContext instanceof ParsingContextWrapper ? getCollectedErrors(((ParsingContextWrapper) parsingContext).getBaseContext()) : CollectionsKt.emptyList();
    }

    public static final ParsingContext restrictPropertyOverride(ParsingContext parsingContext) {
        Intrinsics.checkNotNullParameter(parsingContext, "<this>");
        return parsingContext instanceof OverrideRestrictingParsingContext ? parsingContext : new OverrideRestrictingParsingContext(parsingContext);
    }
}
