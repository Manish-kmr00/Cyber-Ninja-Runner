package com.yasirkula.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.webkit.internal.AssetHelper;
import com.adjust.sdk.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class NativeShare {
    public static boolean alwaysUseCustomShareDialog;
    public static String authority;
    private static int isXiaomiOrMIUI;
    public static NativeShareResultReceiver shareResultReceiver;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        p0.startActivity(p1);
    }

    public static void Share(final Context context, final NativeShareResultReceiver shareResultReceiver2, final String[] targetPackages, final String[] targetClasses, final String[] files, final String[] mimes, final String subject, final String text, final String title) {
        if (files.length > 0 && GetAuthority(context) == null) {
            Log.e("Unity", "Can't find ContentProvider, share not possible!");
            shareResultReceiver2.OnShareCompleted(2, "");
            return;
        }
        shareResultReceiver = shareResultReceiver2;
        Bundle bundle = new Bundle();
        bundle.putString(NativeShareFragment.SUBJECT_ID, subject);
        bundle.putString(NativeShareFragment.TEXT_ID, text);
        bundle.putString(NativeShareFragment.TITLE_ID, title);
        bundle.putStringArrayList(NativeShareFragment.FILES_ID, ConvertArrayToArrayList(files));
        bundle.putStringArrayList(NativeShareFragment.MIMES_ID, ConvertArrayToArrayList(mimes));
        bundle.putStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID, ConvertArrayToArrayList(targetPackages));
        bundle.putStringArrayList(NativeShareFragment.TARGET_CLASS_ID, ConvertArrayToArrayList(targetClasses));
        boolean z = true;
        boolean z2 = alwaysUseCustomShareDialog || targetPackages.length > 1;
        if (!z2 && shareResultReceiver2.HasManagedCallback() && "huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            z2 = true;
        }
        if (z2 || !IsXiaomiOrMIUI() || (Build.VERSION.SDK_INT != 30 && !IsUnityInLandscapeMode((Activity) context))) {
            z = z2;
        }
        if (z) {
            Log.d("Unity", "Creating custom share dialog");
            Intent intent = new Intent(context, (Class<?>) NativeShareCustomShareDialogActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(1073741824);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
            return;
        }
        Log.d("Unity", "Creating standard share dialog");
        NativeShareFragment nativeShareFragment = new NativeShareFragment();
        nativeShareFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeShareFragment).commit();
    }

    public static Intent CreateIntentFromBundle(Context context, Bundle bundle) {
        String str;
        String mimeTypeFromExtension;
        int iIndexOf;
        String string = bundle.getString(NativeShareFragment.SUBJECT_ID);
        String string2 = bundle.getString(NativeShareFragment.TEXT_ID);
        String string3 = bundle.getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeShareFragment.FILES_ID);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(NativeShareFragment.MIMES_ID);
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList4 = bundle.getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        Intent intent = new Intent();
        if (string.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", string);
        }
        if (string2.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", string2);
        }
        int i = 1;
        if (stringArrayList.size() > 0) {
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (i2 < stringArrayList.size()) {
                if (stringArrayList2.get(i2).length() > 0) {
                    mimeTypeFromExtension = stringArrayList2.get(i2);
                } else {
                    int iLastIndexOf = stringArrayList.get(i2).lastIndexOf(46);
                    if (iLastIndexOf >= 0 && iLastIndexOf != stringArrayList.get(i2).length() - i) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(stringArrayList.get(i2).substring(iLastIndexOf + 1).toLowerCase(Locale.ENGLISH));
                    }
                    str2 = "*";
                    str3 = str2;
                    break;
                }
                if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0 && (iIndexOf = mimeTypeFromExtension.indexOf(47)) > 0 && iIndexOf != mimeTypeFromExtension.length() - i) {
                    String strSubstring = mimeTypeFromExtension.substring(0, iIndexOf);
                    String strSubstring2 = mimeTypeFromExtension.substring(iIndexOf + 1);
                    if (str2 == null) {
                        str2 = strSubstring;
                    } else if (!str2.equals(strSubstring)) {
                    }
                    if (str3 == null) {
                        str3 = strSubstring2;
                    } else if (!str3.equals(strSubstring2)) {
                        str3 = "*";
                    }
                    i2++;
                    i = 1;
                }
                str2 = "*";
                str3 = str2;
            }
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3;
            if (stringArrayList.size() == 1) {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(0))));
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(stringArrayList.size());
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    arrayList.add(NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(i3))));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            }
        } else {
            intent.setAction("android.intent.action.SEND");
            str = AssetHelper.DEFAULT_MIME_TYPE;
        }
        if (string3.length() > 0) {
            intent.putExtra("android.intent.extra.TITLE", string3);
        }
        intent.setType(str);
        intent.setFlags(1);
        if (stringArrayList3.size() == 1) {
            intent.setPackage(stringArrayList3.get(0));
            if (stringArrayList4.get(0).length() > 0) {
                intent.setClassName(stringArrayList3.get(0), stringArrayList4.get(0));
            }
        }
        return intent;
    }

    private static String GetAuthority(Context context) {
        if (authority == null) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
                if (providerInfoArr != null) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (providerInfo.name != null && providerInfo.packageName != null && providerInfo.authority != null && providerInfo.name.equals(NativeShareContentProvider.class.getName()) && providerInfo.packageName.equals(context.getPackageName()) && providerInfo.authority.length() > 0) {
                            authority = providerInfo.authority;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("Unity", "Exception:", e);
            }
        }
        return authority;
    }

    private static ArrayList<String> ConvertArrayToArrayList(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>(arr.length);
        for (String str : arr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean IsUnityInLandscapeMode(Activity unityActivity) {
        return unityActivity.getResources().getConfiguration().orientation == 2;
    }

    private static boolean IsXiaomiOrMIUI() throws Throwable {
        int i = isXiaomiOrMIUI;
        if (i > 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (Constants.REFERRER_API_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            isXiaomiOrMIUI = 1;
            return true;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null && line.length() > 0) {
                        isXiaomiOrMIUI = 1;
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                        return true;
                    }
                    isXiaomiOrMIUI = -1;
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused2) {
                    }
                    return false;
                } catch (Exception unused3) {
                    bufferedReader = bufferedReader2;
                    isXiaomiOrMIUI = -1;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean TargetExists(Context context, String packageName, String className) {
        try {
            if (className.length() == 0) {
                context.getPackageManager().getPackageInfo(packageName, 0);
                return true;
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(packageName, 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo.name.equals(className)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static String FindMatchingTarget(Context context, String packageNameRegex, String classNameRegex) {
        ActivityInfo[] activityInfoArr;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(1);
        if (installedPackages != null) {
            Pattern patternCompile = Pattern.compile(packageNameRegex);
            Pattern patternCompile2 = classNameRegex.length() > 0 ? Pattern.compile(classNameRegex) : null;
            for (PackageInfo packageInfo : installedPackages) {
                if (patternCompile.matcher(packageInfo.packageName).find() && (activityInfoArr = packageInfo.activities) != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (patternCompile2 == null || patternCompile2.matcher(activityInfo.name).find()) {
                            return packageInfo.packageName + ">" + activityInfo.name;
                        }
                    }
                }
            }
            return "";
        }
        return "";
    }
}
