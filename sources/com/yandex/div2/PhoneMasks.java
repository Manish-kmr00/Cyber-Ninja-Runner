package com.yandex.div2;

import com.yandex.div.data.Hashable;
import com.yandex.div.json.expressions.ExpressionResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: PhoneMasks.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003J \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/PhoneMasks;", "Lcom/yandex/div/data/Hashable;", "value", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneMasks implements Hashable {
    public static final String EXTRA_NUMBERS = "00";
    private Integer _hash;
    public final JSONObject value;
    public static final JSONObject VALUE_DEFAULT_VALUE = new JSONObject("\n        {\n            \"1\": {\n                \"value\": \"+0 (000) 000-00-00\"\n            },\n            \"2\": {\n                \"0\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                },\n                \"7\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                },\n                \"4\": {\n                    \"4\": {\n                        \"value\": \"+000 000 000 000\"\n                    },\n                    \"*\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    }\n                },\n                \"*\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                }\n            },\n            \"3\": {\n                \"1\": {\n                    \"value\": \"+00 00 000 0000\"\n                },\n                \"5\": {\n                    \"0\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    },\n                    \"*\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    }\n                },\n                \"8\": {\n                    \"0\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    },\n                    \"*\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    }\n                },\n                \"7\": {\n                    \"3\": {\n                        \"value\": \"+000 (000) 0-00-00\"\n                    },\n                    \"4\": {\n                        \"value\": \"+000 (000) 000-00-00\"\n                    },\n                    \"5\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    },\n                    \"*\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    }\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"4\": {\n                \"1\": {\n                    \"value\": \"+00 00 000-00-00\"\n                },\n                \"2\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"4\": {\n                    \"value\": \"+00 0000 000000\"\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"5\": {\n                \"0\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"5\": {\n                    \"value\": \"+00 (00) 0000-0000\"\n                },\n                \"9\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"6\": {\n                \"7\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"8\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"9\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"7\": {\n                \"7\": {\n                    \"value\": \"+0 (000) 000-00-00\"\n                },\n                \"3\": {\n                    \"3\": {\n                        \"value\": \"+0 (000) 000-00-00\"\n                    },\n                    \"*\": {\n                        \"value\": \"+0 (000) 000-00-00\"\n                    }\n                },\n                \"*\": {\n                    \"value\": \"+0 (000) 000-00-00\"\n                }\n            },\n            \"8\": {\n                \"9\": {\n                    \"value\": \"0 (000) 000-00-00\"\n                },\n                \"5\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"8\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"9\": {\n                \"6\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"7\": {\n                    \"value\": \"+000 (00) 000-00-00\"\n                },\n                \"9\": {\n                    \"4\": {\n                        \"value\": \"+000 (000) 000-00-00\"\n                    },\n                    \"5\": {\n                        \"value\": \"+000 (000) 00-00-00\"\n                    },\n                    \"6\": {\n                        \"value\": \"+000 (000) 000-00-00\"\n                    },\n                    \"8\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    },\n                    \"*\": {\n                        \"value\": \"+000 (00) 000-00-00\"\n                    }\n                },\n                \"*\": {\n                    \"value\": \"+00 (000) 000-00-00\"\n                }\n            },\n            \"*\": {\n                \"value\": \"+0000000000000\"\n            }\n        }\n        ");

    public PhoneMasks() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PhoneMasks(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public /* synthetic */ PhoneMasks(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? VALUE_DEFAULT_VALUE : jSONObject);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.value.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(PhoneMasks other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        return Intrinsics.areEqual(this.value, other.value);
    }

    public static /* synthetic */ PhoneMasks copy$default(PhoneMasks phoneMasks, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = phoneMasks.value;
        }
        return phoneMasks.copy(jSONObject);
    }

    public final PhoneMasks copy(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new PhoneMasks(value);
    }
}
