package com.ogury.core;

import com.json.mediationsdk.metadata.a;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OguryLog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/ogury/core/OguryLog;", "", "<init>", "()V", a.j, "", "level", "Lcom/ogury/core/OguryLog$Level;", "Level", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OguryLog {
    public static final OguryLog INSTANCE = new OguryLog();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: OguryLog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ogury/core/OguryLog$Level;", "", "", "getLogPriority", "()I", "NONE", "DEBUG", "INFO", "ERROR", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0})
    public static final class Level {
        public static final Level DEBUG;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level NONE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f7485a;
        public static final /* synthetic */ EnumEntries b;

        /* JADX INFO: compiled from: OguryLog.kt */
        public static final class a extends Level {
            public a() {
                super("DEBUG", 1, null);
            }

            @Override // com.ogury.core.OguryLog.Level
            public final int getLogPriority() {
                return 3;
            }
        }

        /* JADX INFO: compiled from: OguryLog.kt */
        public static final class b extends Level {
            public b() {
                super("ERROR", 3, null);
            }

            @Override // com.ogury.core.OguryLog.Level
            public final int getLogPriority() {
                return 6;
            }
        }

        /* JADX INFO: compiled from: OguryLog.kt */
        public static final class c extends Level {
            public c() {
                super("INFO", 2, null);
            }

            @Override // com.ogury.core.OguryLog.Level
            public final int getLogPriority() {
                return 4;
            }
        }

        /* JADX INFO: compiled from: OguryLog.kt */
        public static final class d extends Level {
            public d() {
                super("NONE", 0, null);
            }

            @Override // com.ogury.core.OguryLog.Level
            public final int getLogPriority() {
                return 999;
            }
        }

        static {
            d dVar = new d();
            NONE = dVar;
            a aVar = new a();
            DEBUG = aVar;
            c cVar = new c();
            INFO = cVar;
            b bVar = new b();
            ERROR = bVar;
            Level[] levelArr = {dVar, aVar, cVar, bVar};
            f7485a = levelArr;
            b = EnumEntriesKt.enumEntries(levelArr);
        }

        public Level() {
            throw null;
        }

        public Level(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            super(str, i);
        }

        public static EnumEntries<Level> getEntries() {
            return b;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f7485a.clone();
        }

        public abstract int getLogPriority();
    }

    private OguryLog() {
    }

    @JvmStatic
    public static final void enable(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        IntegrationLogger.setLevel(level.getLogPriority());
    }
}
