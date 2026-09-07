package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4649z extends AbstractC4628d {
    public static final a i = new a(null);
    private final File g;
    private final String h = "aints";

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.z$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C4649z(File file) {
        this.g = file;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4628d
    public File a(ReaderConfig.Rule rule) {
        return new File(this.g, s0.b(rule.getPath()));
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public String a() {
        return this.h;
    }
}
