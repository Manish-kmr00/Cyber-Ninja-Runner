package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes11.dex */
@Serializable
public final class d01 implements Parcelable {
    private final long b;
    private final List<a01> c;
    public static final b Companion = new b(0);
    public static final Parcelable.Creator<d01> CREATOR = new c();
    private static final KSerializer<Object>[] d = {null, new ArrayListSerializer(a01.a.f8347a)};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<d01> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8654a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f8654a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.monetization.ads.base.model.mediation.prefetch.config.MediationPrefetchSettings", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("load_timeout_millis", true);
            pluginGeneratedSerialDescriptor.addElement("mediation_prefetch_ad_units", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{LongSerializer.INSTANCE, d01.d[1]};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            long jDecodeLongElement;
            int i;
            List list;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = d01.d;
            List list2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                list = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, kSerializerArr[1], null);
                i = 3;
            } else {
                jDecodeLongElement = 0;
                boolean z = true;
                i = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(pluginGeneratedSerialDescriptor, 0);
                        i |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, kSerializerArr[1], list2);
                        i |= 2;
                    }
                }
                list = list2;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new d01(i, jDecodeLongElement, list);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            d01 value = (d01) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            d01.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    public static final class c implements Parcelable.Creator<d01> {
        @Override // android.os.Parcelable.Creator
        public final d01 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(a01.CREATOR.createFromParcel(parcel));
            }
            return new d01(j, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final d01[] newArray(int i) {
            return new d01[i];
        }
    }

    public d01() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d01)) {
            return false;
        }
        d01 d01Var = (d01) obj;
        return this.b == d01Var.b && Intrinsics.areEqual(this.c, d01Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (Long.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "MediationPrefetchSettings(loadTimeoutMillis=" + this.b + ", mediationPrefetchAdUnits=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.b);
        List<a01> list = this.c;
        out.writeInt(list.size());
        Iterator<a01> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i);
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(d01 d01Var, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = d;
        if (compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 0) || d01Var.b != 30000) {
            compositeEncoder.encodeLongElement(pluginGeneratedSerialDescriptor, 0, d01Var.b);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 1) && Intrinsics.areEqual(d01Var.c, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 1, kSerializerArr[1], d01Var.c);
    }

    public /* synthetic */ d01(int i) {
        this(30000L, CollectionsKt.emptyList());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ d01(int i, @SerialName("load_timeout_millis") long j, @SerialName("mediation_prefetch_ad_units") List list) {
        this.b = (i & 1) == 0 ? 30000L : j;
        if ((i & 2) == 0) {
            this.c = CollectionsKt.emptyList();
        } else {
            this.c = list;
        }
    }

    public static final class b {
        public final KSerializer<d01> serializer() {
            return a.f8654a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final long d() {
        return this.b;
    }

    public d01(long j, List<a01> mediationPrefetchAdUnits) {
        Intrinsics.checkNotNullParameter(mediationPrefetchAdUnits, "mediationPrefetchAdUnits");
        this.b = j;
        this.c = mediationPrefetchAdUnits;
    }

    public final List<a01> e() {
        return this.c;
    }
}
