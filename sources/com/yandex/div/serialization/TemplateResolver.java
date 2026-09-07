package com.yandex.div.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.core.annotations.ExperimentalApi;
import com.yandex.div.data.EntityTemplate;
import kotlin.Metadata;

/* JADX INFO: compiled from: TemplateResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003*\u0004\b\u0002\u0010\u00042\u00020\u0005J%\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/serialization/TemplateResolver;", "D", "T", "Lcom/yandex/div/data/EntityTemplate;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "(Lcom/yandex/div/serialization/ParsingContext;Lcom/yandex/div/data/EntityTemplate;Ljava/lang/Object;)Ljava/lang/Object;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalApi
public interface TemplateResolver<D, T extends EntityTemplate<V>, V> {
    V resolve(ParsingContext context, T template, D data);
}
