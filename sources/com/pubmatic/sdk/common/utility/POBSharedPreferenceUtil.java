package com.pubmatic.sdk.common.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/pubmatic/sdk/common/utility/POBSharedPreferenceUtil;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "", "key", "defaultValue", "getStringFromSharedPreference", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "getIntegerFromSharedPreference", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/content/SharedPreferences;", "getDefaultSharedPreference", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "name", "getNamedSharedPreference", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;", "T", "prefName", "value", "writeValueInSharedPreference", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBSharedPreferenceUtil {
    public static final POBSharedPreferenceUtil INSTANCE = new POBSharedPreferenceUtil();
    public static final String TAG = "POBSharedPreferenceUtil";

    private POBSharedPreferenceUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        SharedPreferences defaultSharedPreference = getDefaultSharedPreference(context);
        if (defaultSharedPreference != null) {
            defaultSharedPreference.getString(POBConstants.TEST_MODE, null);
        }
    }

    @JvmStatic
    public static final SharedPreferences getDefaultSharedPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 29) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "{\n      PreferenceManage…references(context)\n    }");
            return defaultSharedPreferences;
        }
        SharedPreferences defaultSharedPreferences2 = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences2, "{\n      androidx.prefere…references(context)\n    }");
        return defaultSharedPreferences2;
    }

    @JvmStatic
    public static final Integer getIntegerFromSharedPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences defaultSharedPreference = getDefaultSharedPreference(context);
        if (defaultSharedPreference != null && defaultSharedPreference.contains(key)) {
            try {
                return Integer.valueOf(defaultSharedPreference.getInt(key, 0));
            } catch (ClassCastException e) {
                POBLog.warn(TAG, e.getMessage(), new Object[0]);
            }
        }
        return null;
    }

    @JvmStatic
    public static final SharedPreferences getNamedSharedPreference(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return context.getSharedPreferences(context.getPackageName() + name, 0);
        } catch (Exception e) {
            POBLog.warn(TAG, "Error occurred while reading the shared preference" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    @JvmStatic
    public static final String getStringFromSharedPreference(Context context, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences defaultSharedPreference = getDefaultSharedPreference(context);
        if (defaultSharedPreference != null) {
            return defaultSharedPreference.getString(key, defaultValue);
        }
        return null;
    }

    @JvmStatic
    public static final void init(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        POBTaskHandler.INSTANCE.getInstance().runOnBackgroundThread(new Runnable() { // from class: com.pubmatic.sdk.common.utility.POBSharedPreferenceUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                POBSharedPreferenceUtil.a(context);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T> void writeValueInSharedPreference(Context context, String prefName, String key, T value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefName, "prefName");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences namedSharedPreference = getNamedSharedPreference(context, prefName);
        SharedPreferences.Editor editorEdit = namedSharedPreference != null ? namedSharedPreference.edit() : null;
        if (value != 0) {
            String simpleName = Reflection.getOrCreateKotlinClass(value.getClass()).getSimpleName();
            if (Intrinsics.areEqual(simpleName, Reflection.getOrCreateKotlinClass(Integer.TYPE).getSimpleName())) {
                if (editorEdit != null) {
                    editorEdit.putInt(key, ((Integer) value).intValue());
                }
            } else if (Intrinsics.areEqual(simpleName, Reflection.getOrCreateKotlinClass(Float.TYPE).getSimpleName())) {
                if (editorEdit != null) {
                    editorEdit.putFloat(key, ((Float) value).floatValue());
                }
            } else if (Intrinsics.areEqual(simpleName, Reflection.getOrCreateKotlinClass(Long.TYPE).getSimpleName())) {
                if (editorEdit != null) {
                    editorEdit.putLong(key, ((Long) value).longValue());
                }
            } else if (Intrinsics.areEqual(simpleName, Reflection.getOrCreateKotlinClass(Boolean.TYPE).getSimpleName())) {
                if (editorEdit != null) {
                    editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            } else if (!Intrinsics.areEqual(simpleName, Reflection.getOrCreateKotlinClass(String.class).getSimpleName())) {
                POBLog.debug(TAG, Reflection.getOrCreateKotlinClass(value.getClass()).getSimpleName() + " data type is not supported for putting value in shared preference", new Object[0]);
            } else if (editorEdit != null) {
                editorEdit.putString(key, (String) value);
            }
        }
        if (editorEdit != null) {
            editorEdit.apply();
        }
    }
}
