package com.yandex.div.histogram;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivParsingHistogramReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ3\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\tH&¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J3\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH&¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "", "measureDataParsing", "D", "json", "Lorg/json/JSONObject;", "componentName", "", "parse", "Lkotlin/Function0;", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "measureJsonParsing", "measureTemplatesParsing", "T", "Companion", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivParsingHistogramReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    <D> D measureDataParsing(JSONObject json, String componentName, Function0<? extends D> parse);

    JSONObject measureJsonParsing(String componentName, Function0<? extends JSONObject> parse);

    <T> T measureTemplatesParsing(JSONObject json, String componentName, Function0<? extends T> parse);

    /* JADX INFO: compiled from: DivParsingHistogramReporter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/yandex/div/histogram/DivParsingHistogramReporter$Companion;", "", "()V", "DEFAULT", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "getDEFAULT", "()Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "DEFAULT$delegate", "Lkotlin/Lazy;", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: DEFAULT$delegate, reason: from kotlin metadata */
        private static final Lazy<DefaultDivParsingHistogramReporter> DEFAULT = LazyKt.lazy(DivParsingHistogramReporter$Companion$DEFAULT$2.INSTANCE);

        private Companion() {
        }

        public final DivParsingHistogramReporter getDEFAULT() {
            return DEFAULT.getValue();
        }
    }
}
