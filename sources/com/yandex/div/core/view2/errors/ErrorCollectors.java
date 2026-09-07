package com.yandex.div.core.view2.errors;

import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div2.DivData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorCollectors.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "", "()V", "collectors", "", "", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "getOrCreate", "tag", "Lcom/yandex/div/DivDataTag;", "divData", "Lcom/yandex/div2/DivData;", "getOrNull", TimerController.RESET_COMMAND, "", "tags", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class ErrorCollectors {
    private final Map<String, ErrorCollector> collectors = new LinkedHashMap();

    @Inject
    public ErrorCollectors() {
    }

    public ErrorCollector getOrCreate(DivDataTag tag, DivData divData) {
        ErrorCollector errorCollector;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.collectors) {
            Map<String, ErrorCollector> map = this.collectors;
            String id = tag.getId();
            Intrinsics.checkNotNullExpressionValue(id, "tag.id");
            ErrorCollector errorCollector2 = map.get(id);
            if (errorCollector2 == null) {
                errorCollector2 = new ErrorCollector();
                map.put(id, errorCollector2);
            }
            errorCollector2.attachParsingErrors(divData);
            errorCollector = errorCollector2;
        }
        return errorCollector;
    }

    public ErrorCollector getOrNull(DivDataTag tag, DivData divData) {
        ErrorCollector errorCollector;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.collectors) {
            errorCollector = this.collectors.get(tag.getId());
            if (errorCollector != null) {
                errorCollector.attachParsingErrors(divData);
            } else {
                errorCollector = null;
            }
        }
        return errorCollector;
    }

    public void reset(List<? extends DivDataTag> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (tags.isEmpty()) {
            this.collectors.clear();
            return;
        }
        Iterator<T> it = tags.iterator();
        while (it.hasNext()) {
            this.collectors.remove(((DivDataTag) it.next()).getId());
        }
    }
}
