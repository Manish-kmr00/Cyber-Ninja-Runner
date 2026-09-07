package com.moloco.sdk.internal.ortb.model;

import com.facebook.internal.NativeProtocol;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Serializable
public final class j {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6129a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final k h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6130a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6130a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DEC", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("app_icon_url", true);
            pluginGeneratedSerialDescriptor.addElement(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, true);
            pluginGeneratedSerialDescriptor.addElement("imp_link", true);
            pluginGeneratedSerialDescriptor.addElement("click_through", true);
            pluginGeneratedSerialDescriptor.addElement("click_tracking", true);
            pluginGeneratedSerialDescriptor.addElement("cta_text", true);
            pluginGeneratedSerialDescriptor.addElement("skip_event", true);
            pluginGeneratedSerialDescriptor.addElement("close", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j deserialize(Decoder decoder) {
            Object objDecodeNullableSerializableElement;
            int i;
            Object objDecodeNullableSerializableElement2;
            Object objDecodeNullableSerializableElement3;
            Object objDecodeNullableSerializableElement4;
            Object objDecodeNullableSerializableElement5;
            Object objDecodeNullableSerializableElement6;
            Object objDecodeNullableSerializableElement7;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 7;
            Object objDecodeNullableSerializableElement8 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                Object objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, stringSerializer, null);
                objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, stringSerializer, null);
                objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, stringSerializer, null);
                objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, stringSerializer, null);
                objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 4, stringSerializer, null);
                Object objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 5, stringSerializer, null);
                objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, stringSerializer, null);
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 7, k.a.f6132a, null);
                objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement9;
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement10;
                i = 255;
            } else {
                boolean z = true;
                int i3 = 0;
                Object objDecodeNullableSerializableElement11 = null;
                Object objDecodeNullableSerializableElement12 = null;
                objDecodeNullableSerializableElement = null;
                Object objDecodeNullableSerializableElement13 = null;
                Object objDecodeNullableSerializableElement14 = null;
                Object objDecodeNullableSerializableElement15 = null;
                Object objDecodeNullableSerializableElement16 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 7;
                            break;
                        case 0:
                            objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, StringSerializer.INSTANCE, objDecodeNullableSerializableElement8);
                            i3 |= 1;
                            i2 = 7;
                            break;
                        case 1:
                            objDecodeNullableSerializableElement13 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 1, StringSerializer.INSTANCE, objDecodeNullableSerializableElement13);
                            i3 |= 2;
                            i2 = 7;
                            break;
                        case 2:
                            objDecodeNullableSerializableElement14 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, StringSerializer.INSTANCE, objDecodeNullableSerializableElement14);
                            i3 |= 4;
                            i2 = 7;
                            break;
                        case 3:
                            objDecodeNullableSerializableElement15 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 3, StringSerializer.INSTANCE, objDecodeNullableSerializableElement15);
                            i3 |= 8;
                            i2 = 7;
                            break;
                        case 4:
                            objDecodeNullableSerializableElement16 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 4, StringSerializer.INSTANCE, objDecodeNullableSerializableElement16);
                            i3 |= 16;
                            break;
                        case 5:
                            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 5, StringSerializer.INSTANCE, objDecodeNullableSerializableElement);
                            i3 |= 32;
                            break;
                        case 6:
                            objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, StringSerializer.INSTANCE, objDecodeNullableSerializableElement12);
                            i3 |= 64;
                            break;
                        case 7:
                            objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i2, k.a.f6132a, objDecodeNullableSerializableElement11);
                            i3 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement11;
                objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement12;
                objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement13;
                objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement14;
                objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement15;
                objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement16;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new j(i, (String) objDecodeNullableSerializableElement8, (String) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement5, (String) objDecodeNullableSerializableElement6, (String) objDecodeNullableSerializableElement7, (String) objDecodeNullableSerializableElement, (String) objDecodeNullableSerializableElement3, (k) objDecodeNullableSerializableElement2, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(k.a.f6132a)};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, j value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            j.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<j> serializer() {
            return a.f6130a;
        }

        public b() {
        }
    }

    public j() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (k) null, 255, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(j jVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || jVar.f6129a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, jVar.f6129a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || jVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, jVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || jVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, jVar.c);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || jVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, jVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || jVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, jVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || jVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, jVar.f);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || jVar.g != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, jVar.g);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && jVar.h == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, k.a.f6132a, jVar.h);
    }

    @SerialName("app_icon_url")
    public static /* synthetic */ void b() {
    }

    @SerialName(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)
    public static /* synthetic */ void d() {
    }

    @SerialName("close")
    public static /* synthetic */ void f() {
    }

    @SerialName("cta_text")
    public static /* synthetic */ void h() {
    }

    @SerialName("click_tracking")
    public static /* synthetic */ void j() {
    }

    @SerialName("click_through")
    public static /* synthetic */ void l() {
    }

    @SerialName("imp_link")
    public static /* synthetic */ void n() {
    }

    @SerialName("skip_event")
    public static /* synthetic */ void p() {
    }

    public final String c() {
        return this.b;
    }

    public final k e() {
        return this.h;
    }

    public final String g() {
        return this.f;
    }

    public final String i() {
        return this.e;
    }

    public final String k() {
        return this.d;
    }

    public final String m() {
        return this.c;
    }

    public final String o() {
        return this.g;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ j(int i, @SerialName("app_icon_url") String str, @SerialName(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING) String str2, @SerialName("imp_link") String str3, @SerialName("click_through") String str4, @SerialName("click_tracking") String str5, @SerialName("cta_text") String str6, @SerialName("skip_event") String str7, @SerialName("close") k kVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f6129a = null;
        } else {
            this.f6129a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str6;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str7;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = kVar;
        }
    }

    public final String a() {
        return this.f6129a;
    }

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar) {
        this.f6129a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = kVar;
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? kVar : null);
    }
}
