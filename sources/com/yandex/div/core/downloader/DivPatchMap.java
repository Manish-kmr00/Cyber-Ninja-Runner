package com.yandex.div.core.downloader;

import com.json.b9;
import com.yandex.div.internal.util.CollectionsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div2.Div;
import com.yandex.div2.DivPatch;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPatchMap.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/downloader/DivPatchMap;", "", "divPatch", "Lcom/yandex/div2/DivPatch;", "(Lcom/yandex/div2/DivPatch;)V", b9.a.t, "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivPatch$Mode;", "getMode", "()Lcom/yandex/div/json/expressions/Expression;", "patches", "", "", "", "Lcom/yandex/div2/Div;", "getPatches", "()Ljava/util/Map;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPatchMap {
    private final Expression<DivPatch.Mode> mode;
    private final Map<String, List<Div>> patches;

    public DivPatchMap(DivPatch divPatch) {
        Intrinsics.checkNotNullParameter(divPatch, "divPatch");
        this.patches = CollectionsKt.arrayMap();
        this.mode = divPatch.mode;
        for (DivPatch.Change change : divPatch.changes) {
            Map<String, List<Div>> map = this.patches;
            String str = change.id;
            List<Div> listEmptyList = change.items;
            if (listEmptyList == null) {
                listEmptyList = kotlin.collections.CollectionsKt.emptyList();
            }
            map.put(str, listEmptyList);
        }
    }

    public final Map<String, List<Div>> getPatches() {
        return this.patches;
    }

    public final Expression<DivPatch.Mode> getMode() {
        return this.mode;
    }
}
