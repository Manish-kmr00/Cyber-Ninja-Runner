package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C4645v extends AbstractC4628d {
    public static final a h = new a(null);
    private final String g = "aexs";

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.v$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4628d
    public File a(ReaderConfig.Rule rule) {
        return new File(s0.b(rule.getPath()));
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public String a() {
        return this.g;
    }
}
