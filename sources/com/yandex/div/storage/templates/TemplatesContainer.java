package com.yandex.div.storage.templates;

import com.mbridge.msdk.foundation.tools.SameMD5;
import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.TemplateParsingEnvironment;
import com.yandex.div.json.templates.CachingTemplateProvider;
import com.yandex.div.storage.DivStorage;
import com.yandex.div.storage.DivStorageErrorException;
import com.yandex.div.storage.analytics.ErrorExplanation;
import com.yandex.div.storage.database.StorageException;
import com.yandex.div.storage.histogram.HistogramNameProvider;
import com.yandex.div.storage.histogram.HistogramRecorder;
import com.yandex.div2.DivTemplate;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TemplatesContainer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ(\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010$\u001a\u00020%H\u0012J$\u0010(\u001a\u0016\u0012\b\u0012\u00060\u0010j\u0002`)\u0012\b\u0012\u00060\u0010j\u0002`*0\u000f2\u0006\u0010$\u001a\u00020%H\u0012J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0010H\u0012J\"\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H\u0017J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u0010H\u0012J\b\u00102\u001a\u000203H\u0012J\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u0010052\b\u00106\u001a\u0004\u0018\u00010\u00102\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0012J\u0012\u00107\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020908H\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u001b0\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/yandex/div/storage/templates/TemplatesContainer;", "", "divStorage", "Lcom/yandex/div/storage/DivStorage;", "errorLogger", "Lcom/yandex/div/json/ParsingErrorLogger;", "histogramRecorder", "Lcom/yandex/div/storage/histogram/HistogramRecorder;", "parsingHistogramProxy", "Ljavax/inject/Provider;", "Lcom/yandex/div/storage/templates/DivParsingHistogramProxy;", "histogramNameProvider", "Lcom/yandex/div/storage/histogram/HistogramNameProvider;", "(Lcom/yandex/div/storage/DivStorage;Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/storage/histogram/HistogramRecorder;Ljavax/inject/Provider;Lcom/yandex/div/storage/histogram/HistogramNameProvider;)V", "groupTemplateReferences", "", "", "Lcom/yandex/div/storage/templates/GroupId;", "Lcom/yandex/div/storage/templates/TemplateReferenceResolver;", "histogramComponentName", "messageDigest", "Ljava/security/MessageDigest;", "getMessageDigest", "()Ljava/security/MessageDigest;", "messageDigest$delegate", "Lkotlin/Lazy;", "templateEnvironments", "Lcom/yandex/div/data/DivParsingEnvironment;", "templateReferencesLoaded", "", "templatesPool", "Lcom/yandex/div/storage/templates/CommonTemplatesPool;", "addTemplates", "", "Lcom/yandex/div/storage/templates/Template;", "groupId", "json", "Lorg/json/JSONObject;", "sourceType", "calculateJsonChecksum", "calculateTemplateHashes", "Lcom/yandex/div/storage/templates/TemplateId;", "Lcom/yandex/div/storage/templates/TemplateHash;", "createEnvBy", "explainMissingTemplate", "Lcom/yandex/div/storage/analytics/ErrorExplanation;", "cardId", "templateId", "getEnvironment", "getTemplates", "loadIfNeeded", "", "parsingHistograms", "", "baseName", "loadedTemplatesDetails", "Lcom/yandex/div/json/templates/CachingTemplateProvider;", "Lcom/yandex/div2/DivTemplate;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class TemplatesContainer {
    private final DivStorage divStorage;
    private final ParsingErrorLogger errorLogger;
    private final Map<String, TemplateReferenceResolver> groupTemplateReferences;
    private final String histogramComponentName;
    private final HistogramNameProvider histogramNameProvider;
    private final HistogramRecorder histogramRecorder;

    /* JADX INFO: renamed from: messageDigest$delegate, reason: from kotlin metadata */
    private final Lazy messageDigest;
    private final Provider<DivParsingHistogramProxy> parsingHistogramProxy;
    private final Map<String, DivParsingEnvironment> templateEnvironments;
    private boolean templateReferencesLoaded;
    private final CommonTemplatesPool templatesPool;

    public TemplatesContainer(DivStorage divStorage, ParsingErrorLogger errorLogger, HistogramRecorder histogramRecorder, Provider<DivParsingHistogramProxy> parsingHistogramProxy, HistogramNameProvider histogramNameProvider) {
        Intrinsics.checkNotNullParameter(divStorage, "divStorage");
        Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
        Intrinsics.checkNotNullParameter(histogramRecorder, "histogramRecorder");
        Intrinsics.checkNotNullParameter(parsingHistogramProxy, "parsingHistogramProxy");
        this.divStorage = divStorage;
        this.errorLogger = errorLogger;
        this.histogramRecorder = histogramRecorder;
        this.parsingHistogramProxy = parsingHistogramProxy;
        this.histogramNameProvider = histogramNameProvider;
        String componentName = histogramNameProvider != null ? histogramNameProvider.getComponentName() : null;
        this.histogramComponentName = componentName;
        this.templatesPool = new CommonTemplatesPool(divStorage, errorLogger, componentName, histogramRecorder, parsingHistogramProxy);
        this.groupTemplateReferences = new LinkedHashMap();
        this.templateEnvironments = new LinkedHashMap();
        this.messageDigest = LazyKt.lazy(new Function0<MessageDigest>() { // from class: com.yandex.div.storage.templates.TemplatesContainer$messageDigest$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MessageDigest invoke() {
                try {
                    return MessageDigest.getInstance(SameMD5.TAG);
                } catch (NoSuchAlgorithmException e) {
                    this.this$0.errorLogger.logError(new IllegalStateException("Storage cannot work with templates!", e));
                    return null;
                }
            }
        });
    }

    public /* synthetic */ TemplatesContainer(DivStorage divStorage, ParsingErrorLogger parsingErrorLogger, HistogramRecorder histogramRecorder, Provider provider, HistogramNameProvider histogramNameProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(divStorage, parsingErrorLogger, histogramRecorder, provider, (i & 16) != 0 ? null : histogramNameProvider);
    }

    private MessageDigest getMessageDigest() {
        return (MessageDigest) this.messageDigest.getValue();
    }

    public DivParsingEnvironment getEnvironment(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        loadIfNeeded();
        Map<String, DivParsingEnvironment> map = this.templateEnvironments;
        DivParsingEnvironment divParsingEnvironmentCreateEnvBy = map.get(groupId);
        if (divParsingEnvironmentCreateEnvBy == null) {
            divParsingEnvironmentCreateEnvBy = createEnvBy(groupId);
            map.put(groupId, divParsingEnvironmentCreateEnvBy);
        }
        return divParsingEnvironmentCreateEnvBy;
    }

    public ErrorExplanation explainMissingTemplate(String cardId, String groupId, String templateId) {
        String str;
        String strLoadedTemplatesDetails;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        TemplateReferenceResolver templateReferenceResolver = this.groupTemplateReferences.get(groupId);
        String strResolveTemplateHash = templateReferenceResolver != null ? templateReferenceResolver.resolveTemplateHash(templateId) : null;
        DivParsingEnvironment divParsingEnvironment = this.templateEnvironments.get(groupId);
        CachingTemplateProvider<DivTemplate> templates = divParsingEnvironment != null ? divParsingEnvironment.getTemplates() : null;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if ((templates != null ? (DivTemplate) templates.get(templateId) : null) != null) {
            str = "unknown, template is loaded";
        } else if (!explainMissingTemplate$templateStored(strResolveTemplateHash, this, arrayList)) {
            sb.append("supported responses: " + CollectionsKt.joinToString$default(this.groupTemplateReferences.keySet(), null, null, null, 0, null, null, 63, null));
            if (this.groupTemplateReferences.keySet().contains(groupId)) {
                sb.append(" " + (templates != null ? loadedTemplatesDetails(templates) : null));
                str = "cached, but loaded partially";
            } else {
                str = "cached, but not loaded into memory";
            }
        } else if (!explainMissingTemplate$cardStored(cardId, this, groupId, arrayList)) {
            str = "access templates ahead of time";
        } else {
            if (arrayList.isEmpty()) {
                str = "not present in original response";
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append(((DivStorageErrorException) it.next()).getMessage() + ";\n");
                }
                str = "fatal exception when explaining reason";
            }
            if (templates != null && (strLoadedTemplatesDetails = loadedTemplatesDetails(templates)) != null) {
                sb.append(strLoadedTemplatesDetails);
            }
        }
        return new ErrorExplanation(str, sb.toString());
    }

    private static final boolean explainMissingTemplate$cardStored(String str, TemplatesContainer templatesContainer, String str2, List<DivStorageErrorException> list) {
        if (str == null) {
            return false;
        }
        try {
            return templatesContainer.divStorage.isCardExists(str, str2);
        } catch (DivStorageErrorException e) {
            list.add(e);
            return false;
        }
    }

    private static final boolean explainMissingTemplate$templateStored(String str, TemplatesContainer templatesContainer, List<DivStorageErrorException> list) {
        if (str == null) {
            return false;
        }
        try {
            return templatesContainer.divStorage.isTemplateExists(str);
        } catch (DivStorageErrorException e) {
            list.add(e);
            return false;
        }
    }

    public List<Template> addTemplates(String groupId, JSONObject json, String sourceType) {
        TemplateParsingEnvironment.TemplateParsingResult<DivTemplate> templatesWithResultsAndDependencies;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(json, "json");
        HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
        String divParsingHistogramName = histogramNameProvider != null ? histogramNameProvider.getDivParsingHistogramName() : null;
        Map<String, String> mapCalculateTemplateHashes = calculateTemplateHashes(json);
        DivParsingEnvironment environment = getEnvironment(groupId);
        if (divParsingHistogramName != null) {
            Set<String> setParsingHistograms = parsingHistograms(divParsingHistogramName, sourceType);
            long jCurrentTimeMillis = System.currentTimeMillis();
            templatesWithResultsAndDependencies = this.parsingHistogramProxy.get().parseTemplatesWithResultsAndDependencies(environment, json, this.histogramComponentName);
            this.histogramRecorder.reportTemplatesParseTime(setParsingHistograms, System.currentTimeMillis() - jCurrentTimeMillis);
        } else {
            templatesWithResultsAndDependencies = this.parsingHistogramProxy.get().parseTemplatesWithResultsAndDependencies(environment, json, this.histogramComponentName);
        }
        environment.getTemplates().putAll(templatesWithResultsAndDependencies.getParsedTemplates());
        ArrayList arrayList = new ArrayList(templatesWithResultsAndDependencies.getParsedTemplates().size());
        for (Map.Entry<String, DivTemplate> entry : templatesWithResultsAndDependencies.getParsedTemplates().entrySet()) {
            String key = entry.getKey();
            DivTemplate value = entry.getValue();
            String str = mapCalculateTemplateHashes.get(key);
            if (str == null) {
                this.errorLogger.logError(new IllegalStateException("No corresponding template was found for templateId = " + key));
            } else {
                this.templatesPool.put(str, value);
                JSONObject jSONObjectOptJSONObject = json.optJSONObject(key);
                if (jSONObjectOptJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(id)");
                    arrayList.add(new Template(key, str, jSONObjectOptJSONObject));
                } else {
                    this.errorLogger.logError(new IllegalStateException("No raw template found for templateId = " + key));
                }
            }
        }
        this.templateEnvironments.put(groupId, environment);
        this.groupTemplateReferences.put(groupId, new TemplateReferenceResolver(this.errorLogger));
        return arrayList;
    }

    private String loadedTemplatesDetails(CachingTemplateProvider<DivTemplate> cachingTemplateProvider) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        cachingTemplateProvider.takeSnapshot(linkedHashMap);
        return "in-memory templates count: " + linkedHashMap.size();
    }

    private Set<String> parsingHistograms(String baseName, String sourceType) {
        if (baseName != null) {
            LinkedHashSet linkedHashSetLinkedSetOf = SetsKt.linkedSetOf(baseName);
            if (sourceType != null) {
                linkedHashSetLinkedSetOf.add(baseName + '.' + sourceType);
            }
            return linkedHashSetLinkedSetOf;
        }
        return SetsKt.emptySet();
    }

    private void loadIfNeeded() {
        if (this.templateReferencesLoaded) {
            return;
        }
        this.templateReferencesLoaded = true;
        DivStorage.LoadDataResult<DivStorage.TemplateReference> templateReferences = this.divStorage.readTemplateReferences();
        Iterator<T> it = templateReferences.getErrors().iterator();
        while (it.hasNext()) {
            this.errorLogger.logError((StorageException) it.next());
        }
        for (DivStorage.TemplateReference templateReference : templateReferences.getRestoredData()) {
            Map<String, TemplateReferenceResolver> map = this.groupTemplateReferences;
            String groupId = templateReference.getGroupId();
            TemplateReferenceResolver templateReferenceResolver = map.get(groupId);
            if (templateReferenceResolver == null) {
                templateReferenceResolver = new TemplateReferenceResolver(this.errorLogger);
                map.put(groupId, templateReferenceResolver);
            }
            templateReferenceResolver.add(templateReference);
        }
    }

    private DivParsingEnvironment createEnvBy(String groupId) {
        TemplateReferenceResolver templates = getTemplates(groupId);
        if (templates == null) {
            return TemplatesContainerKt.createEmptyEnv(this.errorLogger);
        }
        Map<String, DivTemplate> mapLoad = this.templatesPool.load(templates);
        DivParsingEnvironment divParsingEnvironmentCreateEmptyEnv = TemplatesContainerKt.createEmptyEnv(this.errorLogger);
        HashMap map = new HashMap(mapLoad.size());
        for (Map.Entry<String, DivTemplate> entry : mapLoad.entrySet()) {
            String key = entry.getKey();
            DivTemplate value = entry.getValue();
            TemplateHashIds templateHashIds = (TemplateHashIds) templates.getTemplateIdRefs().get(key);
            if (templateHashIds instanceof TemplateHashIds.Collection) {
                Iterator it = ((TemplateHashIds.Collection) templateHashIds).getIds().iterator();
                while (it.hasNext()) {
                    map.put((String) it.next(), value);
                }
            } else if (templateHashIds instanceof TemplateHashIds.Single) {
                map.put(((TemplateHashIds.Single) templateHashIds).m6266unboximpl(), value);
            } else if (templateHashIds == null) {
                templates.logger.logError(new IllegalStateException("No template id was found for hash!"));
            }
        }
        divParsingEnvironmentCreateEmptyEnv.getTemplates().putAll(map);
        return divParsingEnvironmentCreateEmptyEnv;
    }

    private TemplateReferenceResolver getTemplates(String groupId) {
        loadIfNeeded();
        return this.groupTemplateReferences.get(groupId);
    }

    private Map<String, String> calculateTemplateHashes(JSONObject json) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = json.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            String key = keys.next();
            Object obj = json.get(key);
            if (obj instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String strCalculateJsonChecksum = calculateJsonChecksum((JSONObject) obj);
                if (strCalculateJsonChecksum != null) {
                    linkedHashMap.put(key, strCalculateJsonChecksum);
                }
            }
        }
        return linkedHashMap;
    }

    private String calculateJsonChecksum(JSONObject json) {
        byte[] bArrDigest;
        String string = json.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        synchronized (this) {
            MessageDigest messageDigest = getMessageDigest();
            bArrDigest = messageDigest != null ? messageDigest.digest(bytes) : null;
        }
        if (bArrDigest == null) {
            return null;
        }
        String string2 = new BigInteger(1, bArrDigest).toString(16);
        Intrinsics.checkNotNullExpressionValue(string2, "BigInteger(1, md5bytes).toString(16)");
        return StringsKt.padStart(string2, 32, '0');
    }
}
