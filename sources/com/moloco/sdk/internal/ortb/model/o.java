package com.moloco.sdk.internal.ortb.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes7.dex */
@Serializable
public final class o {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f6140a;
    public final s b;
    public final p c;
    public final n d;
    public final g e;
    public final boolean f;
    public final com.moloco.sdk.internal.ortb.model.a g;
    public final t h;
    public final j i;
    public final i j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements GeneratedSerializer<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6141a;
        public static final /* synthetic */ PluginGeneratedSerialDescriptor b;
        public static final int c = 0;

        static {
            a aVar = new a();
            f6141a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Player", aVar, 10);
            pluginGeneratedSerialDescriptor.addElement(EventConstants.SKIP, true);
            pluginGeneratedSerialDescriptor.addElement("close", false);
            pluginGeneratedSerialDescriptor.addElement("progress_bar", true);
            pluginGeneratedSerialDescriptor.addElement("mute", false);
            pluginGeneratedSerialDescriptor.addElement("cta", true);
            pluginGeneratedSerialDescriptor.addElement("is_all_area_clickable", false);
            pluginGeneratedSerialDescriptor.addElement("auto_store", true);
            pluginGeneratedSerialDescriptor.addElement("vast_privacy_icon", true);
            pluginGeneratedSerialDescriptor.addElement(com.safedk.android.analytics.brandsafety.l.Q, true);
            pluginGeneratedSerialDescriptor.addElement("countdown_timer", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o deserialize(Decoder decoder) {
            Object objDecodeNullableSerializableElement;
            Object objDecodeNullableSerializableElement2;
            Object objDecodeNullableSerializableElement3;
            Object objDecodeNullableSerializableElement4;
            Object objDecodeNullableSerializableElement5;
            Object objDecodeSerializableElement;
            Object objDecodeNullableSerializableElement6;
            int i;
            Object objDecodeNullableSerializableElement7;
            boolean z;
            Object objDecodeSerializableElement2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
            int i2 = 9;
            int i3 = 8;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                s.a aVar = s.a.f6149a;
                objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, aVar, null);
                objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, aVar, null);
                objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, p.a.f6143a, null);
                objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, n.a.f6139a, null);
                objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 4, g.a.f6125a, null);
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 5);
                objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, com.moloco.sdk.internal.ortb.model.a.C0536a.f6115a, null);
                objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 7, t.a.f6151a, null);
                objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 8, j.a.f6130a, null);
                objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 9, i.a.f6128a, null);
                i = 1023;
                z = zDecodeBooleanElement;
            } else {
                boolean z2 = true;
                boolean zDecodeBooleanElement2 = false;
                Object objDecodeNullableSerializableElement8 = null;
                Object objDecodeNullableSerializableElement9 = null;
                Object objDecodeNullableSerializableElement10 = null;
                Object objDecodeNullableSerializableElement11 = null;
                Object objDecodeNullableSerializableElement12 = null;
                Object objDecodeSerializableElement3 = null;
                Object objDecodeNullableSerializableElement13 = null;
                Object objDecodeSerializableElement4 = null;
                Object objDecodeNullableSerializableElement14 = null;
                int i4 = 0;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 8;
                            break;
                        case 0:
                            objDecodeNullableSerializableElement13 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 0, s.a.f6149a, objDecodeNullableSerializableElement13);
                            i4 |= 1;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 1:
                            objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, s.a.f6149a, objDecodeSerializableElement4);
                            i4 |= 2;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 2:
                            objDecodeNullableSerializableElement14 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 2, p.a.f6143a, objDecodeNullableSerializableElement14);
                            i4 |= 4;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 3:
                            objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 3, n.a.f6139a, objDecodeSerializableElement3);
                            i4 |= 8;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 4:
                            objDecodeNullableSerializableElement12 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 4, g.a.f6125a, objDecodeNullableSerializableElement12);
                            i4 |= 16;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 5:
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor, 5);
                            i4 |= 32;
                            i2 = 9;
                            break;
                        case 6:
                            objDecodeNullableSerializableElement10 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 6, com.moloco.sdk.internal.ortb.model.a.C0536a.f6115a, objDecodeNullableSerializableElement10);
                            i4 |= 64;
                            i2 = 9;
                            break;
                        case 7:
                            objDecodeNullableSerializableElement11 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, 7, t.a.f6151a, objDecodeNullableSerializableElement11);
                            i4 |= 128;
                            i2 = 9;
                            break;
                        case 8:
                            objDecodeNullableSerializableElement9 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i3, j.a.f6130a, objDecodeNullableSerializableElement9);
                            i4 |= 256;
                            break;
                        case 9:
                            objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor, i2, i.a.f6128a, objDecodeNullableSerializableElement8);
                            i4 |= 512;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                objDecodeNullableSerializableElement = objDecodeNullableSerializableElement8;
                objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement9;
                objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement10;
                objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement11;
                objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement12;
                objDecodeSerializableElement = objDecodeSerializableElement3;
                objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement14;
                i = i4;
                objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement13;
                z = zDecodeBooleanElement2;
                objDecodeSerializableElement2 = objDecodeSerializableElement4;
            }
            compositeDecoderBeginStructure.endStructure(descriptor);
            return new o(i, (s) objDecodeNullableSerializableElement7, (s) objDecodeSerializableElement2, (p) objDecodeNullableSerializableElement6, (n) objDecodeSerializableElement, (g) objDecodeNullableSerializableElement5, z, (com.moloco.sdk.internal.ortb.model.a) objDecodeNullableSerializableElement3, (t) objDecodeNullableSerializableElement4, (j) objDecodeNullableSerializableElement2, (i) objDecodeNullableSerializableElement, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] childSerializers() {
            s.a aVar = s.a.f6149a;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(aVar), aVar, BuiltinSerializersKt.getNullable(p.a.f6143a), n.a.f6139a, BuiltinSerializersKt.getNullable(g.a.f6125a), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(com.moloco.sdk.internal.ortb.model.a.C0536a.f6115a), BuiltinSerializersKt.getNullable(t.a.f6151a), BuiltinSerializersKt.getNullable(j.a.f6130a), BuiltinSerializersKt.getNullable(i.a.f6128a)};
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
        public void serialize(Encoder encoder, o value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
            o.a(value, compositeEncoderBeginStructure, descriptor);
            compositeEncoderBeginStructure.endStructure(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<o> serializer() {
            return a.f6141a;
        }

        public b() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ o(int i, @SerialName(EventConstants.SKIP) s sVar, @SerialName("close") s sVar2, @SerialName("progress_bar") p pVar, @SerialName("mute") n nVar, @SerialName("cta") g gVar, @SerialName("is_all_area_clickable") boolean z, @SerialName("auto_store") com.moloco.sdk.internal.ortb.model.a aVar, @SerialName("vast_privacy_icon") t tVar, @SerialName(com.safedk.android.analytics.brandsafety.l.Q) j jVar, @SerialName("countdown_timer") i iVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (42 != (i & 42)) {
            PluginExceptionsKt.throwMissingFieldException(i, 42, a.f6141a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.f6140a = null;
        } else {
            this.f6140a = sVar;
        }
        this.b = sVar2;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = pVar;
        }
        this.d = nVar;
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = gVar;
        }
        this.f = z;
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = aVar;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = tVar;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = jVar;
        }
        if ((i & 512) == 0) {
            this.j = null;
        } else {
            this.j = iVar;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(o oVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || oVar.f6140a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, s.a.f6149a, oVar.f6140a);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, s.a.f6149a, oVar.b);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || oVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, p.a.f6143a, oVar.c);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, n.a.f6139a, oVar.d);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || oVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, g.a.f6125a, oVar.e);
        }
        compositeEncoder.encodeBooleanElement(serialDescriptor, 5, oVar.f);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || oVar.g != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, com.moloco.sdk.internal.ortb.model.a.C0536a.f6115a, oVar.g);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || oVar.h != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, t.a.f6151a, oVar.h);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || oVar.i != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, j.a.f6130a, oVar.i);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && oVar.j == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, i.a.f6128a, oVar.j);
    }

    @SerialName("auto_store")
    public static /* synthetic */ void b() {
    }

    @SerialName("close")
    public static /* synthetic */ void d() {
    }

    @SerialName("countdown_timer")
    public static /* synthetic */ void f() {
    }

    @SerialName("cta")
    public static /* synthetic */ void h() {
    }

    @SerialName(com.safedk.android.analytics.brandsafety.l.Q)
    public static /* synthetic */ void j() {
    }

    @SerialName("mute")
    public static /* synthetic */ void l() {
    }

    @SerialName("progress_bar")
    public static /* synthetic */ void n() {
    }

    @SerialName(EventConstants.SKIP)
    public static /* synthetic */ void p() {
    }

    @SerialName("vast_privacy_icon")
    public static /* synthetic */ void r() {
    }

    @SerialName("is_all_area_clickable")
    public static /* synthetic */ void t() {
    }

    public final s c() {
        return this.b;
    }

    public final i e() {
        return this.j;
    }

    public final g g() {
        return this.e;
    }

    public final j i() {
        return this.i;
    }

    public final n k() {
        return this.d;
    }

    public final p m() {
        return this.c;
    }

    public final s o() {
        return this.f6140a;
    }

    public final t q() {
        return this.h;
    }

    public final boolean s() {
        return this.f;
    }

    public final com.moloco.sdk.internal.ortb.model.a a() {
        return this.g;
    }

    public o(s sVar, s close, p pVar, n mute, g gVar, boolean z, com.moloco.sdk.internal.ortb.model.a aVar, t tVar, j jVar, i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        Intrinsics.checkNotNullParameter(mute, "mute");
        this.f6140a = sVar;
        this.b = close;
        this.c = pVar;
        this.d = mute;
        this.e = gVar;
        this.f = z;
        this.g = aVar;
        this.h = tVar;
        this.i = jVar;
        this.j = iVar;
    }

    public /* synthetic */ o(s sVar, s sVar2, p pVar, n nVar, g gVar, boolean z, com.moloco.sdk.internal.ortb.model.a aVar, t tVar, j jVar, i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sVar, sVar2, (i & 4) != 0 ? null : pVar, nVar, (i & 16) != 0 ? null : gVar, z, (i & 64) != 0 ? null : aVar, (i & 128) != 0 ? null : tVar, (i & 256) != 0 ? null : jVar, (i & 512) != 0 ? null : iVar);
    }
}
