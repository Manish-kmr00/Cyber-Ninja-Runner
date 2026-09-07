package com.yandex.div.storage.analytics;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorExplanation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yandex/div/storage/analytics/ErrorExplanation;", "", "shortReason", "", "details", "(Ljava/lang/String;Ljava/lang/String;)V", "getShortReason", "()Ljava/lang/String;", "getAllDetails", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorExplanation {
    private final String details;
    private final String shortReason;

    public ErrorExplanation(String shortReason, String str) {
        Intrinsics.checkNotNullParameter(shortReason, "shortReason");
        this.shortReason = shortReason;
        this.details = str;
    }

    public /* synthetic */ ErrorExplanation(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getShortReason() {
        return this.shortReason;
    }

    public final Map<String, String> getAllDetails() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.details;
        if (str != null) {
            linkedHashMap.put("details", str);
        }
        return linkedHashMap;
    }
}
