package com.yandex.div.histogram;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivParsingHistogramReporter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\nH\u0016¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J3\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/histogram/DefaultDivParsingHistogramReporter;", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "()V", "measureDataParsing", "D", "json", "Lorg/json/JSONObject;", "componentName", "", "parse", "Lkotlin/Function0;", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "measureJsonParsing", "measureTemplatesParsing", "T", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class DefaultDivParsingHistogramReporter implements DivParsingHistogramReporter {
    @Override // com.yandex.div.histogram.DivParsingHistogramReporter
    public <D> D measureDataParsing(JSONObject json, String componentName, Function0<? extends D> parse) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(parse, "parse");
        return parse.invoke();
    }

    @Override // com.yandex.div.histogram.DivParsingHistogramReporter
    public <T> T measureTemplatesParsing(JSONObject json, String componentName, Function0<? extends T> parse) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(parse, "parse");
        return parse.invoke();
    }

    @Override // com.yandex.div.histogram.DivParsingHistogramReporter
    public JSONObject measureJsonParsing(String componentName, Function0<? extends JSONObject> parse) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        return parse.invoke();
    }
}
