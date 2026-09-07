package com.yandex.div.core.resources;

import android.content.res.Resources;
import android.util.TypedValue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: PrimitiveResourceCache.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\\\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00130\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u00130\u0018H\u0082\b¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div/core/resources/PrimitiveResourceCache;", "Lcom/yandex/div/core/resources/ResourcesWrapper;", "baseResources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "booleans", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "dimensionPixelOffsets", "dimensionPixelSizes", "dimensions", "", "integers", "tmpValue", "Landroid/util/TypedValue;", "tmpValueLock", "Ljava/lang/Object;", "getAndCacheIfPossible", "T", "", "id", Reporting.EventType.CACHE, "validate", "Lkotlin/Function1;", "transform", "(ILjava/util/concurrent/ConcurrentHashMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getBoolean", "getDimension", "getDimensionPixelOffset", "getDimensionPixelSize", "getInteger", "obtainTempTypedValue", "releaseTempTypedValue", "", "value", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PrimitiveResourceCache extends ResourcesWrapper {
    private final ConcurrentHashMap<Integer, Boolean> booleans;
    private final ConcurrentHashMap<Integer, Integer> dimensionPixelOffsets;
    private final ConcurrentHashMap<Integer, Integer> dimensionPixelSizes;
    private final ConcurrentHashMap<Integer, Float> dimensions;
    private final ConcurrentHashMap<Integer, Integer> integers;
    private TypedValue tmpValue;
    private final Object tmpValueLock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveResourceCache(Resources baseResources) {
        super(baseResources);
        Intrinsics.checkNotNullParameter(baseResources, "baseResources");
        this.booleans = new ConcurrentHashMap<>();
        this.dimensions = new ConcurrentHashMap<>();
        this.dimensionPixelOffsets = new ConcurrentHashMap<>();
        this.dimensionPixelSizes = new ConcurrentHashMap<>();
        this.integers = new ConcurrentHashMap<>();
        this.tmpValue = new TypedValue();
        this.tmpValueLock = new Object();
    }

    @Override // com.yandex.div.core.resources.ResourcesWrapper, android.content.res.Resources
    public boolean getBoolean(int id) throws Resources.NotFoundException {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.booleans;
        Boolean it = concurrentHashMap.get(Integer.valueOf(id));
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
        } else {
            TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
            boolean z = true;
            try {
                super.getValue(id, typedValueObtainTempTypedValue, true);
                if (typedValueObtainTempTypedValue.type < 16 || typedValueObtainTempTypedValue.type > 31) {
                    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
                }
                if (typedValueObtainTempTypedValue.data == 0) {
                    z = false;
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(id), boolValueOf);
                }
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                it = boolValueOf;
            } catch (Throwable th) {
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                throw th;
            }
        }
        return it.booleanValue();
    }

    @Override // com.yandex.div.core.resources.ResourcesWrapper, android.content.res.Resources
    public float getDimension(int id) throws Resources.NotFoundException {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.dimensions;
        Float it = concurrentHashMap.get(Integer.valueOf(id));
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
        } else {
            TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
            try {
                super.getValue(id, typedValueObtainTempTypedValue, true);
                if (typedValueObtainTempTypedValue.type != 5) {
                    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
                }
                Float fValueOf = Float.valueOf(TypedValue.complexToDimension(typedValueObtainTempTypedValue.data, getDisplayMetrics()));
                if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(id), fValueOf);
                }
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                it = fValueOf;
            } catch (Throwable th) {
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                throw th;
            }
        }
        return it.floatValue();
    }

    @Override // com.yandex.div.core.resources.ResourcesWrapper, android.content.res.Resources
    public int getDimensionPixelOffset(int id) throws Resources.NotFoundException {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.dimensionPixelOffsets;
        Integer it = concurrentHashMap.get(Integer.valueOf(id));
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
        } else {
            TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
            try {
                super.getValue(id, typedValueObtainTempTypedValue, true);
                if (typedValueObtainTempTypedValue.type != 5) {
                    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
                }
                Integer numValueOf = Integer.valueOf(TypedValue.complexToDimensionPixelOffset(typedValueObtainTempTypedValue.data, getDisplayMetrics()));
                if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(id), numValueOf);
                }
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                it = numValueOf;
            } catch (Throwable th) {
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                throw th;
            }
        }
        return it.intValue();
    }

    @Override // com.yandex.div.core.resources.ResourcesWrapper, android.content.res.Resources
    public int getDimensionPixelSize(int id) throws Resources.NotFoundException {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.dimensionPixelSizes;
        Integer it = concurrentHashMap.get(Integer.valueOf(id));
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
        } else {
            TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
            try {
                super.getValue(id, typedValueObtainTempTypedValue, true);
                if (typedValueObtainTempTypedValue.type != 5) {
                    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
                }
                Integer numValueOf = Integer.valueOf(TypedValue.complexToDimensionPixelSize(typedValueObtainTempTypedValue.data, getDisplayMetrics()));
                if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(id), numValueOf);
                }
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                it = numValueOf;
            } catch (Throwable th) {
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                throw th;
            }
        }
        return it.intValue();
    }

    @Override // com.yandex.div.core.resources.ResourcesWrapper, android.content.res.Resources
    public int getInteger(int id) throws Resources.NotFoundException {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.integers;
        Integer it = concurrentHashMap.get(Integer.valueOf(id));
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
        } else {
            TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
            try {
                super.getValue(id, typedValueObtainTempTypedValue, true);
                if (typedValueObtainTempTypedValue.type < 16 || typedValueObtainTempTypedValue.type > 31) {
                    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
                }
                Integer numValueOf = Integer.valueOf(typedValueObtainTempTypedValue.data);
                if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(id), numValueOf);
                }
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                it = numValueOf;
            } catch (Throwable th) {
                releaseTempTypedValue(typedValueObtainTempTypedValue);
                throw th;
            }
        }
        return it.intValue();
    }

    private final <T> T getAndCacheIfPossible(int id, ConcurrentHashMap<Integer, T> cache, Function1<? super TypedValue, Boolean> validate, Function1<? super TypedValue, ? extends T> transform) throws Resources.NotFoundException {
        T t = cache.get(Integer.valueOf(id));
        if (t != null) {
            return t;
        }
        TypedValue typedValueObtainTempTypedValue = obtainTempTypedValue();
        try {
            super.getValue(id, typedValueObtainTempTypedValue, true);
            if (!validate.invoke(typedValueObtainTempTypedValue).booleanValue()) {
                throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id) + " type #0x" + Integer.toHexString(typedValueObtainTempTypedValue.type) + " is not valid");
            }
            T tInvoke = transform.invoke(typedValueObtainTempTypedValue);
            if (typedValueObtainTempTypedValue.changingConfigurations == 0) {
                cache.putIfAbsent(Integer.valueOf(id), tInvoke);
            }
            InlineMarker.finallyStart(1);
            releaseTempTypedValue(typedValueObtainTempTypedValue);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            releaseTempTypedValue(typedValueObtainTempTypedValue);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final TypedValue obtainTempTypedValue() {
        TypedValue typedValue;
        synchronized (this.tmpValueLock) {
            typedValue = this.tmpValue;
            if (typedValue != null) {
                this.tmpValue = null;
            } else {
                typedValue = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        return typedValue == null ? new TypedValue() : typedValue;
    }

    private final void releaseTempTypedValue(TypedValue value) {
        synchronized (this.tmpValueLock) {
            if (this.tmpValue == null) {
                this.tmpValue = value;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
