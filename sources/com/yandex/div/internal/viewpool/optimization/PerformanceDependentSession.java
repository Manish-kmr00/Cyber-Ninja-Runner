package com.yandex.div.internal.viewpool.optimization;

import androidx.collection.ArrayMap;
import com.yandex.div.core.view2.DivViewCreator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: PerformanceDependentSession.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH!¢\u0006\u0002\b\u000bJ-\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H!¢\u0006\u0002\b\u0014R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;", "", "()V", "viewObtainmentStatistics", "", "", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "getViewObtainmentStatistics", "()Ljava/util/Map;", "clear", "", "clear$div_release", "viewObtained", "viewType", "obtainmentDuration", "", "availableViews", "", "isObtainedWithBlock", "", "viewObtained$div_release", "Companion", "Detailed", "Lightweight", "ViewObtainmentStatistics", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed;", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Lightweight;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class PerformanceDependentSession {
    private static final Companion Companion = new Companion(null);

    public /* synthetic */ PerformanceDependentSession(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void clear$div_release();

    public abstract Map<String, ViewObtainmentStatistics> getViewObtainmentStatistics();

    public abstract void viewObtained$div_release(String viewType, long obtainmentDuration, int availableViews, boolean isObtainedWithBlock);

    /* JADX INFO: compiled from: PerformanceDependentSession.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0001\f¨\u0006\r"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "", "()V", "maxSuccessiveBlocked", "", "getMaxSuccessiveBlocked", "()I", "minUnused", "getMinUnused", "()Ljava/lang/Integer;", "toString", "", "Lcom/yandex/div/internal/viewpool/optimization/MutableViewObtainmentStatistics;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class ViewObtainmentStatistics {
        public /* synthetic */ ViewObtainmentStatistics(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getMaxSuccessiveBlocked();

        public abstract Integer getMinUnused();

        private ViewObtainmentStatistics() {
        }

        public String toString() {
            return "ViewObtainmentStatistics(maxSuccessiveBlocked=" + getMaxSuccessiveBlocked() + ", minUnused=" + getMinUnused() + ')';
        }
    }

    private PerformanceDependentSession() {
    }

    /* JADX INFO: compiled from: PerformanceDependentSession.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eJ-\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Lightweight;", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;", "()V", "mutableViewObtainmentStatistics", "Landroidx/collection/ArrayMap;", "", "Lcom/yandex/div/internal/viewpool/optimization/MutableViewObtainmentStatistics;", "viewObtainmentStatistics", "", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "getViewObtainmentStatistics", "()Ljava/util/Map;", "clear", "", "clear$div_release", "viewObtained", "viewType", "obtainmentDuration", "", "availableViews", "", "isObtainedWithBlock", "", "viewObtained$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Lightweight extends PerformanceDependentSession {
        private final ArrayMap<String, MutableViewObtainmentStatistics> mutableViewObtainmentStatistics;

        public Lightweight() {
            super(null);
            Companion unused = PerformanceDependentSession.Companion;
            ArrayMap<String, MutableViewObtainmentStatistics> arrayMap = new ArrayMap<>();
            for (String str : DivViewCreator.INSTANCE.getTAGS()) {
                arrayMap.put(str, new MutableViewObtainmentStatistics());
            }
            this.mutableViewObtainmentStatistics = arrayMap;
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public Map<String, ViewObtainmentStatistics> getViewObtainmentStatistics() {
            return this.mutableViewObtainmentStatistics;
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public void viewObtained$div_release(String viewType, long obtainmentDuration, int availableViews, boolean isObtainedWithBlock) {
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            MutableViewObtainmentStatistics mutableViewObtainmentStatistics = this.mutableViewObtainmentStatistics.get(viewType);
            if (mutableViewObtainmentStatistics != null) {
                mutableViewObtainmentStatistics.report(availableViews, isObtainedWithBlock);
            }
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public void clear$div_release() {
            Collection<MutableViewObtainmentStatistics> collectionValues = this.mutableViewObtainmentStatistics.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "mutableViewObtainmentStatistics.values");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ((MutableViewObtainmentStatistics) it.next()).clear();
            }
        }
    }

    /* JADX INFO: compiled from: PerformanceDependentSession.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00110\u0004J-\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001aR \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed;", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;", "()V", "viewObtainmentStatistics", "", "", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "getViewObtainmentStatistics", "()Ljava/util/Map;", "viewObtainments", "Landroidx/collection/ArrayMap;", "", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed$ViewObtainment;", "clear", "", "clear$div_release", "getViewObtainments", "", "viewObtained", "viewType", "obtainmentDuration", "", "availableViews", "", "isObtainedWithBlock", "", "viewObtained$div_release", "ViewObtainment", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Detailed extends PerformanceDependentSession {
        private final ArrayMap<String, List<ViewObtainment>> viewObtainments;

        /* JADX INFO: compiled from: PerformanceDependentSession.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B9\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed$ViewObtainment;", "", "seen1", "", "obtainmentTime", "", "obtainmentDuration", "availableViews", "isObtainedWithBlock", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JJIZ)V", "getAvailableViews", "()I", "()Z", "getObtainmentDuration", "()J", "getObtainmentTime", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        public static final /* data */ class ViewObtainment {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final int availableViews;
            private final boolean isObtainedWithBlock;
            private final long obtainmentDuration;
            private final long obtainmentTime;

            public static /* synthetic */ ViewObtainment copy$default(ViewObtainment viewObtainment, long j, long j2, int i, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    j = viewObtainment.obtainmentTime;
                }
                long j3 = j;
                if ((i2 & 2) != 0) {
                    j2 = viewObtainment.obtainmentDuration;
                }
                long j4 = j2;
                if ((i2 & 4) != 0) {
                    i = viewObtainment.availableViews;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    z = viewObtainment.isObtainedWithBlock;
                }
                return viewObtainment.copy(j3, j4, i3, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getObtainmentTime() {
                return this.obtainmentTime;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getObtainmentDuration() {
                return this.obtainmentDuration;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getAvailableViews() {
                return this.availableViews;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsObtainedWithBlock() {
                return this.isObtainedWithBlock;
            }

            public final ViewObtainment copy(long obtainmentTime, long obtainmentDuration, int availableViews, boolean isObtainedWithBlock) {
                return new ViewObtainment(obtainmentTime, obtainmentDuration, availableViews, isObtainedWithBlock);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ViewObtainment)) {
                    return false;
                }
                ViewObtainment viewObtainment = (ViewObtainment) other;
                return this.obtainmentTime == viewObtainment.obtainmentTime && this.obtainmentDuration == viewObtainment.obtainmentDuration && this.availableViews == viewObtainment.availableViews && this.isObtainedWithBlock == viewObtainment.isObtainedWithBlock;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            public int hashCode() {
                int iHashCode = ((((Long.hashCode(this.obtainmentTime) * 31) + Long.hashCode(this.obtainmentDuration)) * 31) + Integer.hashCode(this.availableViews)) * 31;
                boolean z = this.isObtainedWithBlock;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "ViewObtainment(obtainmentTime=" + this.obtainmentTime + ", obtainmentDuration=" + this.obtainmentDuration + ", availableViews=" + this.availableViews + ", isObtainedWithBlock=" + this.isObtainedWithBlock + ')';
            }

            /* JADX INFO: compiled from: PerformanceDependentSession.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed$ViewObtainment$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Detailed$ViewObtainment;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ViewObtainment> serializer() {
                    return PerformanceDependentSession$Detailed$ViewObtainment$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ ViewObtainment(int i, long j, long j2, int i2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i & 15)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 15, PerformanceDependentSession$Detailed$ViewObtainment$$serializer.INSTANCE.getDescriptor());
                }
                this.obtainmentTime = j;
                this.obtainmentDuration = j2;
                this.availableViews = i2;
                this.isObtainedWithBlock = z;
            }

            public ViewObtainment(long j, long j2, int i, boolean z) {
                this.obtainmentTime = j;
                this.obtainmentDuration = j2;
                this.availableViews = i;
                this.isObtainedWithBlock = z;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(ViewObtainment self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeLongElement(serialDesc, 0, self.obtainmentTime);
                output.encodeLongElement(serialDesc, 1, self.obtainmentDuration);
                output.encodeIntElement(serialDesc, 2, self.availableViews);
                output.encodeBooleanElement(serialDesc, 3, self.isObtainedWithBlock);
            }

            public final long getObtainmentTime() {
                return this.obtainmentTime;
            }

            public final long getObtainmentDuration() {
                return this.obtainmentDuration;
            }

            public final int getAvailableViews() {
                return this.availableViews;
            }

            public final boolean isObtainedWithBlock() {
                return this.isObtainedWithBlock;
            }
        }

        public Detailed() {
            super(null);
            Companion unused = PerformanceDependentSession.Companion;
            ArrayMap<String, List<ViewObtainment>> arrayMap = new ArrayMap<>();
            for (String str : DivViewCreator.INSTANCE.getTAGS()) {
                arrayMap.put(str, new ArrayList());
            }
            this.viewObtainments = arrayMap;
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public Map<String, ViewObtainmentStatistics> getViewObtainmentStatistics() {
            ArrayMap<String, List<ViewObtainment>> arrayMap = this.viewObtainments;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arrayMap.size()));
            Iterator<T> it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                List<ViewObtainment> value = (List) entry.getValue();
                MutableViewObtainmentStatistics mutableViewObtainmentStatistics = new MutableViewObtainmentStatistics();
                Intrinsics.checkNotNullExpressionValue(value, "value");
                for (ViewObtainment viewObtainment : value) {
                    mutableViewObtainmentStatistics.report(viewObtainment.getAvailableViews(), viewObtainment.isObtainedWithBlock());
                }
                linkedHashMap.put(key, mutableViewObtainmentStatistics);
            }
            return linkedHashMap;
        }

        public final Map<String, List<ViewObtainment>> getViewObtainments() {
            ArrayMap<String, List<ViewObtainment>> arrayMap = this.viewObtainments;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arrayMap.size()));
            Iterator<T> it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                List value = (List) entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "value");
                linkedHashMap.put(key, CollectionsKt.toList(value));
            }
            return linkedHashMap;
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public void viewObtained$div_release(String viewType, long obtainmentDuration, int availableViews, boolean isObtainedWithBlock) {
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            List<ViewObtainment> list = this.viewObtainments.get(viewType);
            if (list == null) {
                return;
            }
            ViewObtainment viewObtainment = new ViewObtainment(System.currentTimeMillis(), obtainmentDuration, availableViews, isObtainedWithBlock);
            synchronized (list) {
                list.add(viewObtainment);
            }
        }

        @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession
        public void clear$div_release() {
            Collection<List<ViewObtainment>> collectionValues = this.viewObtainments.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "viewObtainments.values");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                List it2 = (List) it.next();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                synchronized (it2) {
                    it2.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: compiled from: PerformanceDependentSession.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$Companion;", "", "()V", "prepare", "Landroidx/collection/ArrayMap;", "", "T", "defaultValue", "Lkotlin/Function0;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> ArrayMap<String, T> prepare(ArrayMap<String, T> arrayMap, Function0<? extends T> defaultValue) {
            Intrinsics.checkNotNullParameter(arrayMap, "<this>");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            for (String str : DivViewCreator.INSTANCE.getTAGS()) {
                arrayMap.put(str, defaultValue.invoke());
            }
            return arrayMap;
        }
    }
}
