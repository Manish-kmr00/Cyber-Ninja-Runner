package com.yandex.div.storage.templates;

import com.safedk.android.analytics.brandsafety.l;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.storage.DivStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemplatesContainer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ7\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00180\u001eH\u0086\bø\u0001\u0000J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u0007R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\b\u0012\u00060\u0007j\u0002`\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Lcom/yandex/div/storage/templates/TemplateReferenceResolver;", "", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Lcom/yandex/div/json/ParsingErrorLogger;)V", "_templateHashes", "", "", "Lcom/yandex/div/storage/templates/TemplateHash;", "templateHashRefs", "", "Lcom/yandex/div/storage/templates/TemplateId;", "templateHashes", "", "getTemplateHashes", "()Ljava/util/Set;", "templateIdRefs", "", "Lcom/yandex/div/storage/templates/TemplateHashIds;", "getTemplateIdRefs", "()Ljava/util/Map;", "templateIdRefs$delegate", "Lkotlin/Lazy;", l.l, "", "templateReference", "Lcom/yandex/div/storage/DivStorage$TemplateReference;", "doOnEachResolvedId", "hash", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "templateId", "resolveTemplateHash", "id", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TemplateReferenceResolver {
    private final Set<String> _templateHashes;
    private final ParsingErrorLogger logger;
    private final Map<String, String> templateHashRefs;
    private final Set<String> templateHashes;

    /* JADX INFO: renamed from: templateIdRefs$delegate, reason: from kotlin metadata */
    private final Lazy templateIdRefs;

    public TemplateReferenceResolver(ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.templateHashRefs = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this._templateHashes = linkedHashSet;
        this.templateHashes = linkedHashSet;
        this.templateIdRefs = LazyKt.lazy(new Function0<HashMap<String, TemplateHashIds>>() { // from class: com.yandex.div.storage.templates.TemplateReferenceResolver$templateIdRefs$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, TemplateHashIds> invoke() {
                HashMap<String, TemplateHashIds> map = new HashMap<>(this.this$0.templateHashRefs.size());
                for (Map.Entry entry : this.this$0.templateHashRefs.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    TemplateHashIds templateHashIdsM6253boximpl = map.get(str2);
                    HashMap<String, TemplateHashIds> map2 = map;
                    if (templateHashIdsM6253boximpl == null) {
                        templateHashIdsM6253boximpl = TemplateHashIds.Single.m6260boximpl(TemplateHashIds.Single.m6261constructorimpl(str));
                    } else if (templateHashIdsM6253boximpl instanceof TemplateHashIds.Single) {
                        templateHashIdsM6253boximpl = TemplateHashIds.Collection.m6253boximpl(TemplateHashIds.Collection.m6254constructorimpl(CollectionsKt.mutableListOf(((TemplateHashIds.Single) templateHashIdsM6253boximpl).m6266unboximpl(), str)));
                    } else if (templateHashIdsM6253boximpl instanceof TemplateHashIds.Collection) {
                        ((TemplateHashIds.Collection) templateHashIdsM6253boximpl).getIds().add(str);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    map2.put(str2, templateHashIdsM6253boximpl);
                }
                return map;
            }
        });
    }

    public final Set<String> getTemplateHashes() {
        return this.templateHashes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, TemplateHashIds> getTemplateIdRefs() {
        return (Map) this.templateIdRefs.getValue();
    }

    public final void add(DivStorage.TemplateReference templateReference) {
        Intrinsics.checkNotNullParameter(templateReference, "templateReference");
        this.templateHashRefs.put(templateReference.getTemplateId(), templateReference.getTemplateHash());
        this._templateHashes.add(templateReference.getTemplateHash());
    }

    public final void doOnEachResolvedId(String hash, Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(block, "block");
        TemplateHashIds templateHashIds = (TemplateHashIds) getTemplateIdRefs().get(hash);
        if (!(templateHashIds instanceof TemplateHashIds.Collection)) {
            if (templateHashIds instanceof TemplateHashIds.Single) {
                block.invoke(((TemplateHashIds.Single) templateHashIds).m6266unboximpl());
                return;
            } else {
                if (templateHashIds == null) {
                    this.logger.logError(new IllegalStateException("No template id was found for hash!"));
                    return;
                }
                return;
            }
        }
        Iterator it = ((TemplateHashIds.Collection) templateHashIds).getIds().iterator();
        while (it.hasNext()) {
            block.invoke((String) it.next());
        }
    }

    public final String resolveTemplateHash(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.templateHashRefs.get(id);
    }
}
