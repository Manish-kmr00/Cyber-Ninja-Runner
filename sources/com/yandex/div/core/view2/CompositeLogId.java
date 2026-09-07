package com.yandex.div.core.view2;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompositeLogId.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/core/view2/CompositeLogId;", "", "dataTag", "", "scopeLogId", "actionLogId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionLogId", "()Ljava/lang/String;", "compositeLogId", "getCompositeLogId", "compositeLogId$delegate", "Lkotlin/Lazy;", "getDataTag", "getScopeLogId", "component1", "component2", "component3", "copy", "equals", "", "other", "formatCompositeLogId", "hashCode", "", "toString", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class CompositeLogId {
    private final String actionLogId;

    /* JADX INFO: renamed from: compositeLogId$delegate, reason: from kotlin metadata */
    private final Lazy compositeLogId;
    private final String dataTag;
    private final String scopeLogId;

    public static /* synthetic */ CompositeLogId copy$default(CompositeLogId compositeLogId, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = compositeLogId.dataTag;
        }
        if ((i & 2) != 0) {
            str2 = compositeLogId.scopeLogId;
        }
        if ((i & 4) != 0) {
            str3 = compositeLogId.actionLogId;
        }
        return compositeLogId.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDataTag() {
        return this.dataTag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScopeLogId() {
        return this.scopeLogId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActionLogId() {
        return this.actionLogId;
    }

    public final CompositeLogId copy(String dataTag, String scopeLogId, String actionLogId) {
        Intrinsics.checkNotNullParameter(dataTag, "dataTag");
        Intrinsics.checkNotNullParameter(scopeLogId, "scopeLogId");
        Intrinsics.checkNotNullParameter(actionLogId, "actionLogId");
        return new CompositeLogId(dataTag, scopeLogId, actionLogId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompositeLogId)) {
            return false;
        }
        CompositeLogId compositeLogId = (CompositeLogId) other;
        return Intrinsics.areEqual(this.dataTag, compositeLogId.dataTag) && Intrinsics.areEqual(this.scopeLogId, compositeLogId.scopeLogId) && Intrinsics.areEqual(this.actionLogId, compositeLogId.actionLogId);
    }

    public int hashCode() {
        return (((this.dataTag.hashCode() * 31) + this.scopeLogId.hashCode()) * 31) + this.actionLogId.hashCode();
    }

    public CompositeLogId(String dataTag, String scopeLogId, String actionLogId) {
        Intrinsics.checkNotNullParameter(dataTag, "dataTag");
        Intrinsics.checkNotNullParameter(scopeLogId, "scopeLogId");
        Intrinsics.checkNotNullParameter(actionLogId, "actionLogId");
        this.dataTag = dataTag;
        this.scopeLogId = scopeLogId;
        this.actionLogId = actionLogId;
        this.compositeLogId = LazyKt.lazy(new Function0<String>() { // from class: com.yandex.div.core.view2.CompositeLogId$compositeLogId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.formatCompositeLogId();
            }
        });
    }

    public final String getDataTag() {
        return this.dataTag;
    }

    public final String getScopeLogId() {
        return this.scopeLogId;
    }

    public final String getActionLogId() {
        return this.actionLogId;
    }

    private final String getCompositeLogId() {
        return (String) this.compositeLogId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatCompositeLogId() {
        return this.dataTag + (this.scopeLogId.length() > 0 ? "#" + this.scopeLogId : "") + '#' + this.actionLogId;
    }

    public String toString() {
        return getCompositeLogId();
    }
}
