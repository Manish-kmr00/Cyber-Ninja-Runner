package com.json;

import android.content.Context;
import com.json.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/x9;", "Lcom/ironsource/di;", "Lcom/ironsource/ci;", "Landroid/content/Context;", "context", "Lcom/ironsource/w9;", "source", "", "key", "value", "", "a", "Lcom/ironsource/mf;", "Lcom/ironsource/mf;", "sharedSignalsStorageFactory", "<init>", "(Lcom/ironsource/mf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class x9 implements di, ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final mf sharedSignalsStorageFactory;

    public x9() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public x9(mf sharedSignalsStorageFactory) {
        Intrinsics.checkNotNullParameter(sharedSignalsStorageFactory, "sharedSignalsStorageFactory");
        this.sharedSignalsStorageFactory = sharedSignalsStorageFactory;
    }

    public /* synthetic */ x9(mf mfVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new aa() : mfVar);
    }

    @Override // com.json.di
    public String a(Context context, w9 source, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        ca caVarA = this.sharedSignalsStorageFactory.a(context, source);
        if (caVarA != null) {
            return ca.a(caVarA, key, null, 2, null);
        }
        IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        return null;
    }

    @Override // com.json.ci
    public void a(Context context, w9 source, String key, String value) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ca caVarA = this.sharedSignalsStorageFactory.a(context, source);
        if (caVarA != null) {
            caVarA.a(key, value);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        }
    }
}
