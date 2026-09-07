package com.yandex.div.storage.templates;

import com.json.cc;
import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.TemplateParsingEnvironment;
import com.yandex.div2.DivData;
import com.yandex.div2.DivTemplate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivParsingHistogramProxy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001b\u0010\u0006\u001a\u00020\u00048RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/storage/templates/DivParsingHistogramProxy;", "", "initReporter", "Lkotlin/Function0;", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "(Lkotlin/jvm/functions/Function0;)V", "reporter", "getReporter", "()Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "reporter$delegate", "Lkotlin/Lazy;", "createDivData", "Lcom/yandex/div2/DivData;", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "json", "Lorg/json/JSONObject;", "componentName", "", "parseTemplatesWithResultsAndDependencies", "Lcom/yandex/div/json/TemplateParsingEnvironment$TemplateParsingResult;", "Lcom/yandex/div2/DivTemplate;", "Lcom/yandex/div/data/DivParsingEnvironment;", "templates", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivParsingHistogramProxy {

    /* JADX INFO: renamed from: reporter$delegate, reason: from kotlin metadata */
    private final Lazy reporter;

    public DivParsingHistogramProxy(Function0<? extends DivParsingHistogramReporter> initReporter) {
        Intrinsics.checkNotNullParameter(initReporter, "initReporter");
        this.reporter = LazyKt.lazy(initReporter);
    }

    private DivParsingHistogramReporter getReporter() {
        return (DivParsingHistogramReporter) this.reporter.getValue();
    }

    public DivData createDivData(final ParsingEnvironment env, final JSONObject json, String componentName) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        return (DivData) getReporter().measureDataParsing(json, componentName, new Function0<DivData>() { // from class: com.yandex.div.storage.templates.DivParsingHistogramProxy.createDivData.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DivData invoke() {
                return DivData.INSTANCE.fromJson(env, json);
            }
        });
    }

    public TemplateParsingEnvironment.TemplateParsingResult<DivTemplate> parseTemplatesWithResultsAndDependencies(final DivParsingEnvironment env, final JSONObject templates, String componentName) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(templates, "templates");
        return (TemplateParsingEnvironment.TemplateParsingResult) getReporter().measureTemplatesParsing(templates, componentName, new Function0<TemplateParsingEnvironment.TemplateParsingResult<DivTemplate>>() { // from class: com.yandex.div.storage.templates.DivParsingHistogramProxy.parseTemplatesWithResultsAndDependencies.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TemplateParsingEnvironment.TemplateParsingResult<DivTemplate> invoke() {
                return env.parseTemplatesWithResultAndDependencies(templates);
            }
        });
    }
}
