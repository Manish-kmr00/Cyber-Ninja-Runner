package com.moloco.sdk.internal.android_context;

import android.content.Context;
import androidx.startup.Initializer;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00070\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/internal/android_context/ApplicationContextStartupComponentInitialization;", "Landroidx/startup/Initializer;", "", "Landroid/content/Context;", "context", "a", "", "Ljava/lang/Class;", "dependencies", "<init>", "()V", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final class ApplicationContextStartupComponentInitialization implements Initializer<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String b = "ApplicationContextStartupComponentInitialization";
    public static boolean c;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.android_context.ApplicationContextStartupComponentInitialization$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b() {
        }

        public final boolean a() {
            return ApplicationContextStartupComponentInitialization.c;
        }

        public Companion() {
        }
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit create(Context context) {
        a(context);
        return Unit.INSTANCE;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b.a(context);
        c = true;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, b, "initialized", null, false, 12, null);
    }
}
