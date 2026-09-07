package io.bidmachine;

import android.content.Context;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class BidMachine {
    public static final String NAME = "BidMachine";
    private static final String TAG = "BidMachine";
    public static final String VERSION = "3.2.1";

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    public static void initialize(Context context, final String str, InitializationCallback initializationCallback) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda8
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("initialize - %s", str);
            }
        });
        BidMachineImpl.get().initialize(context, str, initializationCallback);
    }

    public static boolean isInitialized() {
        return BidMachineImpl.get().isInitialized();
    }

    public static void setEndpoint(final String str) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setEndpoint - %s", str);
            }
        });
        UrlProvider.setEndpoint(str);
    }

    public static void setLoggingEnabled(boolean z) {
        if (!z) {
            Logger.d("BidMachine", "setLoggingEnabled - false");
            Logger.setLoggingEnabled(false);
        } else {
            Logger.setLoggingEnabled(true);
            Logger.d("BidMachine", "setLoggingEnabled - true");
        }
        NetworkRegistry.setLoggingEnabled(z);
    }

    public static void setTestMode(final boolean z) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setTestMode - %s", Boolean.valueOf(z));
            }
        });
        BidMachineImpl.get().setTestMode(z);
    }

    public static void setTargetingParams(TargetingParams targetingParams) {
        Logger.d("BidMachine", "setTargetingParams");
        BidMachineImpl.get().setTargetingParams(targetingParams);
    }

    public static void setConsentConfig(final boolean z, final String str) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setConsentConfig - %s, %s", Boolean.valueOf(z), str);
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setConsentConfig(z, str);
    }

    public static void setSubjectToGDPR(final Boolean bool) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda6
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setSubjectToGDPR - %s", bool);
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setSubjectToGDPR(bool);
    }

    public static void setCoppa(final Boolean bool) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setCoppa - %s", bool);
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setCoppa(bool);
    }

    public static void setUSPrivacyString(final String str) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setUSPrivacyString - %s", str);
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setUSPrivacyString(str);
    }

    public static void setGPP(final String str, final List<Integer> list) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("setGPP - %s, [%s]", str, Utils.join(list));
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setGPP(str, list);
    }

    public static void setPublisher(Publisher publisher) {
        Logger.d("BidMachine", "setPublisher");
        BidMachineImpl.get().setPublisher(publisher);
    }

    public static void registerNetworks(NetworkConfig... networkConfigArr) {
        Logger.d("BidMachine", "registerNetworks with NetworkConfig array");
        NetworkRegistry.registerNetworks(networkConfigArr);
    }

    public static void registerNetworks(Context context, String str) {
        Logger.d("BidMachine", "registerNetworks with JSON string");
        NetworkRegistry.registerNetworks(context, str);
    }

    public static void registerNetworks(Context context, String str, NetworkRegistryCallback networkRegistryCallback) {
        Logger.d("BidMachine", "registerNetworks with JSON string");
        NetworkRegistry.registerNetworks(context, str, networkRegistryCallback);
    }

    @Deprecated
    public static String getBidToken(Context context) {
        return getBidToken(context, (AdsFormat) null);
    }

    public static String getBidToken(Context context, AdsFormat adsFormat) {
        final String strCreateBidToken = BidTokenManager.createBidToken(context.getApplicationContext(), adsFormat);
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda7
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("getBidToken - %s", strCreateBidToken);
            }
        });
        return strCreateBidToken;
    }

    @Deprecated
    public static void getBidToken(Context context, BidTokenCallback bidTokenCallback) {
        getBidToken(context, null, bidTokenCallback);
    }

    public static void getBidToken(Context context, final AdsFormat adsFormat, final BidTokenCallback bidTokenCallback) {
        final Context applicationContext = context.getApplicationContext();
        BidTokenTaskManager.execute(new Runnable() { // from class: io.bidmachine.BidMachine.1
            @Override // java.lang.Runnable
            public void run() {
                bidTokenCallback.onCollected(BidMachine.getBidToken(applicationContext, adsFormat));
            }
        });
    }

    public static Object getExtrasParam(Context context, String str) {
        return ExtraParamsManager.get().getPublic(context, str);
    }

    public static void registerAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        Logger.d("BidMachine", "registerAdRequestListener");
        BidMachineImpl.get().registerAdRequestListener(adRequestListener);
    }

    public static void unregisterAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        Logger.d("BidMachine", "unregisterAdRequestListener");
        BidMachineImpl.get().unregisterAdRequestListener(adRequestListener);
    }
}
