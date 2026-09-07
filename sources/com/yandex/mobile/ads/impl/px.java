package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Serializable
public final class px {
    public static final b Companion = new b(0);
    private static final KSerializer<Object>[] g = {null, null, new ArrayListSerializer(mz0.a.f9681a), null, new ArrayListSerializer(q11.a.f9974a), new ArrayListSerializer(i11.a.f9164a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uw f9955a;
    private final vx b;
    private final List<mz0> c;
    private final xw d;
    private final List<q11> e;
    private final List<i11> f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<px> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9956a;
        private static final /* synthetic */ PluginGeneratedSerialDescriptor b;

        static {
            a aVar = new a();
            f9956a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.yandex.mobile.ads.features.debugpanel.data.model.DebugPanelReportData", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("app_data", false);
            pluginGeneratedSerialDescriptor.addElement("sdk_data", false);
            pluginGeneratedSerialDescriptor.addElement("adapters_data", false);
            pluginGeneratedSerialDescriptor.addElement("consents_data", false);
            pluginGeneratedSerialDescriptor.addElement("sdk_logs", false);
            pluginGeneratedSerialDescriptor.addElement("network_logs", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = px.g;
            return new KSerializer[]{uw.a.f10427a, vx.a.f10515a, kSerializerArr[2], xw.a.f10681a, kSerializerArr[4], kSerializerArr[5]};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            uw uwVar;
            vx vxVar;
            List list;
            xw xwVar;
            List list2;
            List list3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
            KSerializer[] kSerializerArr = px.g;
            int i2 = 3;
            uw uwVar2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                uwVar = (uw) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, uw.a.f10427a, null);
                vx vxVar2 = (vx) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, vx.a.f10515a, null);
                List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], null);
                xw xwVar2 = (xw) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 3, xw.a.f10681a, null);
                List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], null);
                list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], null);
                i = 63;
                list = list4;
                list2 = list5;
                xwVar = xwVar2;
                vxVar = vxVar2;
            } else {
                boolean z = true;
                int i3 = 0;
                vx vxVar3 = null;
                List list6 = null;
                xw xwVar3 = null;
                List list7 = null;
                List list8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 3;
                            break;
                        case 0:
                            uwVar2 = (uw) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, uw.a.f10427a, uwVar2);
                            i3 |= 1;
                            i2 = 3;
                            break;
                        case 1:
                            vxVar3 = (vx) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, vx.a.f10515a, vxVar3);
                            i3 |= 2;
                            break;
                        case 2:
                            list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], list6);
                            i3 |= 4;
                            break;
                        case 3:
                            xwVar3 = (xw) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, i2, xw.a.f10681a, xwVar3);
                            i3 |= 8;
                            break;
                        case 4:
                            list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], list7);
                            i3 |= 16;
                            break;
                        case 5:
                            list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], list8);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                uwVar = uwVar2;
                vxVar = vxVar3;
                list = list6;
                xwVar = xwVar3;
                list2 = list7;
                list3 = list8;
            }
            compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
            return new px(i, uwVar, vxVar, list, xwVar, list2, list3);
        }

        private a() {
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            px value = (px) obj;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
            px.a(value, compositeEncoderBeginStructure, pluginGeneratedSerialDescriptor);
            compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof px)) {
            return false;
        }
        px pxVar = (px) obj;
        return Intrinsics.areEqual(this.f9955a, pxVar.f9955a) && Intrinsics.areEqual(this.b, pxVar.b) && Intrinsics.areEqual(this.c, pxVar.c) && Intrinsics.areEqual(this.d, pxVar.d) && Intrinsics.areEqual(this.e, pxVar.e) && Intrinsics.areEqual(this.f, pxVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + aa.a(this.e, (this.d.hashCode() + aa.a(this.c, (this.b.hashCode() + (this.f9955a.hashCode() * 31)) * 31, 31)) * 31, 31);
    }

    public final String toString() {
        return "DebugPanelReportData(appData=" + this.f9955a + ", sdkData=" + this.b + ", networksData=" + this.c + ", consentsData=" + this.d + ", sdkLogs=" + this.e + ", networkLogs=" + this.f + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ px(int i, @SerialName("app_data") uw uwVar, @SerialName("sdk_data") vx vxVar, @SerialName("adapters_data") List list, @SerialName("consents_data") xw xwVar, @SerialName("sdk_logs") List list2, @SerialName("network_logs") List list3) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, a.f9956a.getDescriptor());
        }
        this.f9955a = uwVar;
        this.b = vxVar;
        this.c = list;
        this.d = xwVar;
        this.e = list2;
        this.f = list3;
    }

    @JvmStatic
    public static final /* synthetic */ void a(px pxVar, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<Object>[] kSerializerArr = g;
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 0, uw.a.f10427a, pxVar.f9955a);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 1, vx.a.f10515a, pxVar.b);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], pxVar.c);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 3, xw.a.f10681a, pxVar.d);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 4, kSerializerArr[4], pxVar.e);
        compositeEncoder.encodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], pxVar.f);
    }

    public px(uw appData, vx sdkData, List<mz0> networksData, xw consentsData, List<q11> sdkLogs, List<i11> networkLogs) {
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(sdkData, "sdkData");
        Intrinsics.checkNotNullParameter(networksData, "networksData");
        Intrinsics.checkNotNullParameter(consentsData, "consentsData");
        Intrinsics.checkNotNullParameter(sdkLogs, "sdkLogs");
        Intrinsics.checkNotNullParameter(networkLogs, "networkLogs");
        this.f9955a = appData;
        this.b = sdkData;
        this.c = networksData;
        this.d = consentsData;
        this.e = sdkLogs;
        this.f = networkLogs;
    }

    public static final class b {
        public final KSerializer<px> serializer() {
            return a.f9956a;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }
}
