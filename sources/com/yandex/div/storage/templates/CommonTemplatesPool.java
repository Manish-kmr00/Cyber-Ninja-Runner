package com.yandex.div.storage.templates;

import android.os.SystemClock;
import com.json.cc;
import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.storage.DivStorage;
import com.yandex.div.storage.database.StorageException;
import com.yandex.div.storage.histogram.HistogramRecorder;
import com.yandex.div2.DivTemplate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TemplatesContainer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u001e\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00192\n\u0010\u001d\u001a\u00060\u0007j\u0002`\u00102\u0006\u0010\u001e\u001a\u00020\u0011R\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/storage/templates/CommonTemplatesPool;", "", "divStorage", "Lcom/yandex/div/storage/DivStorage;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "histogramComponent", "", "histogramRecorder", "Lcom/yandex/div/storage/histogram/HistogramRecorder;", "parsingHistogramProxy", "Ljavax/inject/Provider;", "Lcom/yandex/div/storage/templates/DivParsingHistogramProxy;", "(Lcom/yandex/div/storage/DivStorage;Lcom/yandex/div/json/ParsingErrorLogger;Ljava/lang/String;Lcom/yandex/div/storage/histogram/HistogramRecorder;Ljavax/inject/Provider;)V", "commonTemplates", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/yandex/div/storage/templates/TemplateHash;", "Lcom/yandex/div2/DivTemplate;", cc.o, "Lcom/yandex/div/data/DivParsingEnvironment;", "load", "", "templateReferences", "Lcom/yandex/div/storage/templates/TemplateReferenceResolver;", "loadFromStorage", "", "templateHashes", "", "put", "templateHash", "template", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class CommonTemplatesPool {
    private final ConcurrentHashMap<String, DivTemplate> commonTemplates;
    private final DivStorage divStorage;
    private final DivParsingEnvironment env;
    private final String histogramComponent;
    private final HistogramRecorder histogramRecorder;
    private final Provider<DivParsingHistogramProxy> parsingHistogramProxy;

    public CommonTemplatesPool(DivStorage divStorage, ParsingErrorLogger logger, String str, HistogramRecorder histogramRecorder, Provider<DivParsingHistogramProxy> parsingHistogramProxy) {
        Intrinsics.checkNotNullParameter(divStorage, "divStorage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(histogramRecorder, "histogramRecorder");
        Intrinsics.checkNotNullParameter(parsingHistogramProxy, "parsingHistogramProxy");
        this.divStorage = divStorage;
        this.histogramComponent = str;
        this.histogramRecorder = histogramRecorder;
        this.parsingHistogramProxy = parsingHistogramProxy;
        this.commonTemplates = new ConcurrentHashMap<>();
        this.env = TemplatesContainerKt.createEmptyEnv(logger);
    }

    public final Map<String, DivTemplate> load(TemplateReferenceResolver templateReferences) {
        Intrinsics.checkNotNullParameter(templateReferences, "templateReferences");
        Set<String> templateHashes = templateReferences.getTemplateHashes();
        Set<String> mutableSet = CollectionsKt.toMutableSet(templateHashes);
        Set<String> setKeySet = this.commonTemplates.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "commonTemplates.keys");
        mutableSet.removeAll(setKeySet);
        if (!mutableSet.isEmpty()) {
            loadFromStorage(this.env, templateReferences, mutableSet);
        }
        ConcurrentHashMap<String, DivTemplate> concurrentHashMap = this.commonTemplates;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, DivTemplate> entry : concurrentHashMap.entrySet()) {
            if (templateHashes.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final void loadFromStorage(DivParsingEnvironment env, TemplateReferenceResolver templateReferences, Set<String> templateHashes) {
        Object jSONObject;
        long jUptimeMillis = SystemClock.uptimeMillis();
        DivStorage.LoadDataResult<RawTemplateData> templates = this.divStorage.readTemplates(templateHashes);
        HistogramRecorder.reportTemplateLoadedTime$default(this.histogramRecorder, SystemClock.uptimeMillis() - jUptimeMillis, null, 2, null);
        JSONObject jSONObject2 = new JSONObject();
        for (RawTemplateData rawTemplateData : templates.getRestoredData()) {
            String hash = rawTemplateData.getHash();
            try {
                jSONObject = new JSONObject(new String(rawTemplateData.getData(), Charsets.UTF_8));
            } catch (JSONException e) {
                env.getLogger().logError(new IllegalStateException("Template deserialization failed (hash: " + hash + ")!", e));
                jSONObject = Unit.INSTANCE;
            }
            TemplateHashIds templateHashIds = (TemplateHashIds) templateReferences.getTemplateIdRefs().get(hash);
            if (templateHashIds instanceof TemplateHashIds.Collection) {
                for (String str : ((TemplateHashIds.Collection) templateHashIds).getIds()) {
                    try {
                        jSONObject2.put(str, jSONObject);
                    } catch (JSONException e2) {
                        env.getLogger().logError(new IllegalStateException("Template '" + str + "' adding to json failed!", e2));
                    }
                }
            } else if (templateHashIds instanceof TemplateHashIds.Single) {
                String strM6266unboximpl = ((TemplateHashIds.Single) templateHashIds).m6266unboximpl();
                try {
                    jSONObject2.put(strM6266unboximpl, jSONObject);
                } catch (JSONException e3) {
                    env.getLogger().logError(new IllegalStateException("Template '" + strM6266unboximpl + "' adding to json failed!", e3));
                }
            } else if (templateHashIds == null) {
                templateReferences.logger.logError(new IllegalStateException("No template id was found for hash!"));
            }
        }
        Iterator<T> it = templates.getErrors().iterator();
        while (it.hasNext()) {
            env.getLogger().logError((StorageException) it.next());
        }
        for (Map.Entry<String, DivTemplate> entry : this.parsingHistogramProxy.get().parseTemplatesWithResultsAndDependencies(env, jSONObject2, this.histogramComponent).getParsedTemplates().entrySet()) {
            String key = entry.getKey();
            DivTemplate value = entry.getValue();
            String strResolveTemplateHash = templateReferences.resolveTemplateHash(key);
            if (strResolveTemplateHash == null) {
                env.getLogger().logError(new IllegalStateException("Failed to resolve template hash for id: " + key));
            } else {
                this.commonTemplates.put(strResolveTemplateHash, value);
            }
        }
    }

    public final void put(String templateHash, DivTemplate template) {
        Intrinsics.checkNotNullParameter(templateHash, "templateHash");
        Intrinsics.checkNotNullParameter(template, "template");
        this.commonTemplates.put(templateHash, template);
    }
}
