package com.yandex.div.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingEnvironmentExtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"withLogger", "Lcom/yandex/div/json/ParsingEnvironmentWrapper;", "Lcom/yandex/div/json/ParsingEnvironment;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParsingEnvironmentExtensionsKt {
    public static final ParsingEnvironmentWrapper withLogger(ParsingEnvironment parsingEnvironment, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(parsingEnvironment, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return new ParsingEnvironmentWrapper(parsingEnvironment, logger);
    }
}
