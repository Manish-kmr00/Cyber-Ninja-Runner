package com.yandex.div.internal.viewpool;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ViewPreCreationProfile.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\""}, d2 = {"Lcom/yandex/div/internal/viewpool/PreCreationModel;", "", "seen1", "", "capacity", "min", "max", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(III)V", "getCapacity", "()I", "getMax", "getMin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class PreCreationModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int capacity;
    private final int max;
    private final int min;

    public static /* synthetic */ PreCreationModel copy$default(PreCreationModel preCreationModel, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = preCreationModel.capacity;
        }
        if ((i4 & 2) != 0) {
            i2 = preCreationModel.min;
        }
        if ((i4 & 4) != 0) {
            i3 = preCreationModel.max;
        }
        return preCreationModel.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    public final PreCreationModel copy(int capacity, int min, int max) {
        return new PreCreationModel(capacity, min, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreCreationModel)) {
            return false;
        }
        PreCreationModel preCreationModel = (PreCreationModel) other;
        return this.capacity == preCreationModel.capacity && this.min == preCreationModel.min && this.max == preCreationModel.max;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.capacity) * 31) + Integer.hashCode(this.min)) * 31) + Integer.hashCode(this.max);
    }

    public String toString() {
        return "PreCreationModel(capacity=" + this.capacity + ", min=" + this.min + ", max=" + this.max + ')';
    }

    /* JADX INFO: compiled from: ViewPreCreationProfile.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/internal/viewpool/PreCreationModel$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/yandex/div/internal/viewpool/PreCreationModel;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PreCreationModel> serializer() {
            return PreCreationModel$$serializer.INSTANCE;
        }
    }

    public PreCreationModel(int i, int i2, int i3) {
        this.capacity = i;
        this.min = i2;
        this.max = i3;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PreCreationModel(int i, int i2, int i3, int i4, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, PreCreationModel$$serializer.INSTANCE.getDescriptor());
        }
        this.capacity = i2;
        if ((i & 2) == 0) {
            this.min = 0;
        } else {
            this.min = i3;
        }
        if ((i & 4) == 0) {
            this.max = Integer.MAX_VALUE;
        } else {
            this.max = i4;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(PreCreationModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.capacity);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.min != 0) {
            output.encodeIntElement(serialDesc, 1, self.min);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.max == Integer.MAX_VALUE) {
            return;
        }
        output.encodeIntElement(serialDesc, 2, self.max);
    }

    public /* synthetic */ PreCreationModel(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? Integer.MAX_VALUE : i3);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getMax() {
        return this.max;
    }
}
