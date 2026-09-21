package com.moonedgestudio.cyberninjarunner

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.Log
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

// Official TopOn (New Platform) SDK Imports (v6.6.22)
import com.secmtp.sdk.core.api.ATSDK
import com.secmtp.sdk.core.api.ATAdInfo
import com.secmtp.sdk.core.api.AdError
import com.secmtp.sdk.rewardvideo.api.ATRewardVideoAd
import com.secmtp.sdk.rewardvideo.api.ATRewardVideoListener
import com.secmtp.sdk.interstitial.api.ATInterstitial
import com.secmtp.sdk.interstitial.api.ATInterstitialListener

// Official Google User Messaging Platform (UMP) Imports
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import com.google.android.ump.FormError

/**
 * Android Monetization Bridge for Cyber Ninja Runner.
 *
 * Provides genuine native integration with:
 * 1. TopOn New Platform Mediation Core & Format Modules (v6.6.22)
 *
 * Operates strictly on the dedicated MethodChannel 'com.moonedgestudio.cyberninjarunner/monetization'
 * completely isolated from FMOD audio channels.
 */
class MonetizationBridge private constructor(
    private val activity: Activity,
    private val channel: MethodChannel
) : MethodChannel.MethodCallHandler {

    companion object {
        private const val TAG = "MonetizationBridge"
        const val CHANNEL_NAME = "com.moonedgestudio.cyberninjarunner/monetization"

        fun registerWith(activity: Activity, messenger: BinaryMessenger): MonetizationBridge {
            val channel = MethodChannel(messenger, CHANNEL_NAME)
            val bridge = MonetizationBridge(activity, channel)
            channel.setMethodCallHandler(bridge)
            Log.i(TAG, "MonetizationBridge registered on channel: $CHANNEL_NAME")
            return bridge
        }
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private var isInitialized = false
    private var isTestMode = true
    private var activeAppId: String = ""

    // Real Native TopOn Ad Instances
    private val rewardedAdMap = mutableMapOf<String, ATRewardVideoAd>()
    private var activeRewardedTransactionId: String? = null
    private var activeRewardedContext: String? = null

    private val interstitialAdMap = mutableMapOf<String, ATInterstitial>()

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            "requestConsent" -> {
                val testMode = call.argument<Boolean>("isTestMode") ?: true
                requestConsent(testMode, result)
            }
            "showPrivacyOptionsForm" -> {
                showPrivacyOptionsForm(result)
            }
            "isPrivacyOptionsRequired" -> {
                isPrivacyOptionsRequired(result)
            }
            "canRequestAds" -> {
                canRequestAds(result)
            }
            "initMonetization" -> {
                val appId = call.argument<String>("appId") ?: ""
                val appKey = call.argument<String>("appKey") ?: ""
                val testMode = call.argument<Boolean>("isTestMode") ?: true
                initMonetization(appId, appKey, testMode, result)
            }
            "isRewardedReady" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                val scenarioId = call.argument<String>("scenarioId")
                var rewardVideoAd = rewardedAdMap[placementId]
                if (rewardVideoAd == null) {
                    rewardVideoAd = ATRewardVideoAd(activity, placementId)
                    rewardedAdMap[placementId] = rewardVideoAd
                }
                val ready = rewardVideoAd.isAdReady
                Log.i(TAG, "isRewardedReady checked: placement=$placementId, scenario=$scenarioId, ready=$ready")
                result.success(ready)
            }
            "loadRewarded" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                val scenarioId = call.argument<String>("scenarioId")
                loadRewarded(placementId, scenarioId, result)
            }
            "showRewarded" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                val transactionId = call.argument<String>("transactionId") ?: ""
                val rewardContext = call.argument<String>("rewardContext") ?: "reward"
                val scenarioId = call.argument<String>("scenarioId")
                showRewarded(placementId, transactionId, rewardContext, scenarioId, result)
            }
            "isInterstitialReady" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                val ready = interstitialAdMap[placementId]?.isAdReady ?: false
                result.success(ready)
            }
            "loadInterstitial" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                loadInterstitial(placementId, result)
            }
            "showInterstitial" -> {
                val placementId = call.argument<String>("placementId") ?: ""
                showInterstitial(placementId, result)
            }
            "getDiagnostics" -> {
                result.success(getDiagnosticsMap())
            }
            else -> {
                result.notImplemented()
            }
        }
    }

    private fun requestConsent(testMode: Boolean, result: MethodChannel.Result) {
        mainHandler.post {
            try {
                val consentInformation = UserMessagingPlatform.getConsentInformation(activity)

                val paramsBuilder = ConsentRequestParameters.Builder()
                    .setTagForUnderAgeOfConsent(false)

                if (testMode) {
                    val debugSettings = ConsentDebugSettings.Builder(activity)
                        .build()
                    paramsBuilder.setConsentDebugSettings(debugSettings)
                }

                val params = paramsBuilder.build()

                Log.i(TAG, "Requesting UMP consent information update (testMode=$testMode)...")
                consentInformation.requestConsentInfoUpdate(
                    activity,
                    params,
                    {
                        Log.i(TAG, "UMP consent info update success. Status: ${consentInformation.consentStatus}, PrivacyOptions: ${consentInformation.privacyOptionsRequirementStatus}")
                        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) { formError ->
                            if (formError != null) {
                                Log.w(TAG, "Consent form dismiss/load error: [${formError.errorCode}] ${formError.message}")
                            } else {
                                Log.i(TAG, "Consent form completed or not required.")
                            }
                            val canRequest = consentInformation.canRequestAds()
                            val statusName = getConsentStatusName(consentInformation.consentStatus)
                            val isPrivacyRequired = consentInformation.privacyOptionsRequirementStatus == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
                            Log.i(TAG, "UMP completed: canRequestAds=$canRequest, status=$statusName, privacyOptionsRequired=$isPrivacyRequired")
                            result.success(mapOf(
                                "canRequestAds" to canRequest,
                                "consentStatus" to statusName,
                                "isPrivacyOptionsRequired" to isPrivacyRequired
                            ))
                        }
                    },
                    { requestError ->
                        Log.w(TAG, "UMP consent info update failed: [${requestError.errorCode}] ${requestError.message}")
                        val canRequest = consentInformation.canRequestAds()
                        val statusName = getConsentStatusName(consentInformation.consentStatus)
                        val isPrivacyRequired = consentInformation.privacyOptionsRequirementStatus == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
                        result.success(mapOf(
                            "canRequestAds" to canRequest,
                            "consentStatus" to statusName,
                            "isPrivacyOptionsRequired" to isPrivacyRequired,
                            "error" to requestError.message
                        ))
                    }
                )
            } catch (e: Throwable) {
                Log.e(TAG, "Unexpected error in requestConsent: ${e.message}", e)
                result.success(mapOf(
                    "canRequestAds" to true,
                    "consentStatus" to "ERROR",
                    "isPrivacyOptionsRequired" to false,
                    "error" to (e.message ?: "Unknown error")
                ))
            }
        }
    }

    private fun showPrivacyOptionsForm(result: MethodChannel.Result) {
        mainHandler.post {
            try {
                UserMessagingPlatform.showPrivacyOptionsForm(activity) { formError ->
                    if (formError != null) {
                        Log.w(TAG, "showPrivacyOptionsForm error: [${formError.errorCode}] ${formError.message}")
                        result.success(mapOf(
                            "success" to false,
                            "error" to formError.message
                        ))
                    } else {
                        Log.i(TAG, "Privacy options form completed successfully.")
                        val consentInformation = UserMessagingPlatform.getConsentInformation(activity)
                        result.success(mapOf(
                            "success" to true,
                            "canRequestAds" to consentInformation.canRequestAds(),
                            "consentStatus" to getConsentStatusName(consentInformation.consentStatus)
                        ))
                    }
                }
            } catch (e: Throwable) {
                Log.e(TAG, "Error showing privacy options form: ${e.message}", e)
                result.success(mapOf(
                    "success" to false,
                    "error" to (e.message ?: "Exception showing privacy options")
                ))
            }
        }
    }

    private fun isPrivacyOptionsRequired(result: MethodChannel.Result) {
        try {
            val consentInformation = UserMessagingPlatform.getConsentInformation(activity)
            val isRequired = consentInformation.privacyOptionsRequirementStatus == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
            result.success(isRequired)
        } catch (e: Throwable) {
            result.success(false)
        }
    }

    private fun canRequestAds(result: MethodChannel.Result) {
        try {
            val canRequest = UserMessagingPlatform.getConsentInformation(activity).canRequestAds()
            result.success(canRequest)
        } catch (e: Throwable) {
            result.success(true)
        }
    }

    private fun getConsentStatusName(status: Int): String {
        return when (status) {
            ConsentInformation.ConsentStatus.NOT_REQUIRED -> "NOT_REQUIRED"
            ConsentInformation.ConsentStatus.REQUIRED -> "REQUIRED"
            ConsentInformation.ConsentStatus.OBTAINED -> "OBTAINED"
            else -> "UNKNOWN"
        }
    }

    private fun initMonetization(
        appId: String,
        appKey: String,
        testMode: Boolean,
        result: MethodChannel.Result
    ) {
        activeAppId = appId
        isTestMode = testMode

        Log.i(TAG, "Initializing TopOn Monetization SDK: AppId=$appId, TestMode=$testMode")

        try {
            // Initialize TopOn (AnyThink) Native SDK
            ATSDK.setNetworkLogDebug(testMode)
            try {
                ATSDK.integrationChecking(activity.applicationContext)
            } catch (e: Throwable) {
                Log.w(TAG, "TopOn integrationChecking note: ${e.message}")
            }
            com.secmtp.sdk.core.api.ATCommonConfig.isShowInitErrorTips = false
            ATSDK.init(activity.applicationContext, appId, appKey)
            Log.i(TAG, "TopOn ATSDK initialized successfully. Version: ${ATSDK.getSDKVersionName()}")

            isInitialized = true
            result.success(true)
        } catch (e: Throwable) {
            Log.e(TAG, "TopOn SDK Init error: ${e.message}", e)
            isInitialized = false
            result.success(false)
        }
    }

    private fun loadRewarded(placementId: String, scenarioId: String?, result: MethodChannel.Result) {
        Log.i(TAG, "loadRewarded requested for real placement: $placementId")
        result.success(null)

        mainHandler.post {
            try {
                var rewardVideoAd = rewardedAdMap[placementId]
                if (rewardVideoAd == null) {
                    // Create new rewarded video ad instance
                    rewardVideoAd = ATRewardVideoAd(activity, placementId)
                    rewardedAdMap[placementId] = rewardVideoAd
                }
                // Register scenario if provided
                if (scenarioId != null) {
                    rewardVideoAd.entryAdScenario(scenarioId)
                }
                rewardVideoAd.setAdListener(object : ATRewardVideoListener {
                    override fun onRewardedVideoAdLoaded() {
                        Log.i(TAG, "[Real SDK Callback] onRewardedVideoAdLoaded: $placementId")
                        Log.i(TAG, "REVIVE_DEBUG: AD_LOAD_SUCCESS placement=$placementId")
                        channel.invokeMethod("onRewardedLoaded", mapOf("placementId" to placementId))
                    }

                    override fun onRewardedVideoAdFailed(adError: AdError) {
                        Log.e(TAG, "[Real SDK Callback] onRewardedVideoAdFailed: $placementId - Code: ${adError.code}, Desc: ${adError.desc}, Full: ${adError.fullErrorInfo}")
                        Log.e(TAG, "REVIVE_DEBUG: AD_LOAD_FAILED placement=$placementId code=${adError.code} platformCode=${adError.platformCode} desc=${adError.desc} fullError=${adError.fullErrorInfo}")
                        channel.invokeMethod(
                            "onRewardedLoadFailed",
                            mapOf(
                                "placementId" to placementId,
                                "error" to (adError.fullErrorInfo ?: adError.desc ?: "Ad load failed"),
                                "code" to (adError.code ?: "")
                            )
                        )
                    }

                    override fun onRewardedVideoAdPlayStart(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onRewardedVideoAdPlayStart: $placementId (network: ${adInfo.networkName})")
                        channel.invokeMethod(
                            "onRewardedPlayStart",
                            mapOf(
                                "placementId" to placementId,
                                "network" to adInfo.networkName
                            )
                        )
                    }

                    override fun onRewardedVideoAdPlayEnd(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onRewardedVideoAdPlayEnd: $placementId")
                    }

                    override fun onRewardedVideoAdPlayFailed(adError: AdError, adInfo: ATAdInfo) {
                        Log.e(TAG, "[Real SDK Callback] onRewardedVideoAdPlayFailed: $placementId - ${adError.fullErrorInfo}")
                        channel.invokeMethod(
                            "onRewardedLoadFailed",
                            mapOf(
                                "placementId" to placementId,
                                "error" to adError.fullErrorInfo
                            )
                        )
                    }

                    override fun onRewardedVideoAdClosed(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onRewardedVideoAdClosed: $placementId (context: $activeRewardedContext)")
                        channel.invokeMethod(
                            "onRewardedClosed",
                            mapOf(
                                "placementId" to placementId,
                                "rewardContext" to (activeRewardedContext ?: "")
                            )
                        )
                        activeRewardedTransactionId = null
                        activeRewardedContext = null
                    }

                    override fun onRewardedVideoAdPlayClicked(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onRewardedVideoAdPlayClicked: $placementId")
                    }

                    override fun onReward(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onReward granted: $placementId (tx: $activeRewardedTransactionId, context: $activeRewardedContext, network: ${adInfo.networkName})")
                        channel.invokeMethod(
                            "onRewardedRewardGranted",
                            mapOf(
                                "placementId" to placementId,
                                "transactionId" to (activeRewardedTransactionId ?: ""),
                                "rewardContext" to (activeRewardedContext ?: ""),
                                "network" to adInfo.networkName,
                                "ecpm" to adInfo.ecpm
                            )
                        )
                    }
                })
                Log.i(TAG, "Calling real ATRewardVideoAd.load() for placement: $placementId")
                rewardVideoAd.load()


            } catch (e: Throwable) {
                Log.e(TAG, "Error executing real ATRewardVideoAd.load(): ${e.message}", e)
                channel.invokeMethod(
                    "onRewardedLoadFailed",
                    mapOf(
                        "placementId" to placementId,
                        "error" to (e.message ?: "Exception in loadRewarded")
                    )
                )
            }
        }
    }

    private fun showRewarded(
        placementId: String,
        transactionId: String,
        rewardContext: String,
        scenarioId: String?,
        result: MethodChannel.Result
    ) {
        Log.i(TAG, "REVIVE_DEBUG: SHOW_REQUESTED")
        Log.i(TAG, "REVIVE_DEBUG: placement=$placementId")
        Log.i(TAG, "REVIVE_DEBUG: scenario=$scenarioId")
        Log.i(TAG, "REVIVE_DEBUG: activityClass=${activity.javaClass.name}")
        Log.i(TAG, "REVIVE_DEBUG: isFinishing=${activity.isFinishing}")
        Log.i(TAG, "REVIVE_DEBUG: isDestroyed=${activity.isDestroyed}")

        if (activity.isFinishing || activity.isDestroyed) {
            Log.e(TAG, "REVIVE_DEBUG: SHOW_FAILED Activity is finishing or destroyed")
            result.success(false)
            return
        }

        var rewardVideoAd = rewardedAdMap[placementId]
        if (rewardVideoAd == null) {
            rewardVideoAd = ATRewardVideoAd(activity, placementId)
            rewardedAdMap[placementId] = rewardVideoAd
        }

        val ready = rewardVideoAd.isAdReady
        if (!ready) {
            Log.w(TAG, "REVIVE_DEBUG: SHOW_FAILED real ad is not ready: placement=$placementId, scenario=$scenarioId")
            result.success(false)
            return
        }

        activeRewardedTransactionId = transactionId
        activeRewardedContext = rewardContext
        Log.i(TAG, "Showing Real Rewarded Video: placement=$placementId, tx=$transactionId, context=$rewardContext, scenario=${scenarioId ?: "none"}")
        result.success(true)

        mainHandler.post {
            try {
                if (scenarioId != null) {
                    try {
                        rewardVideoAd.entryAdScenario(scenarioId)
                    } catch (e: Throwable) {
                        Log.w(TAG, "entryAdScenario note: ${e.message}")
                    }
                }
                rewardVideoAd.show(activity)
            } catch (e: Throwable) {
                Log.e(TAG, "Error showing real rewarded ad: ${e.message}", e)
            }
        }
    }

    private fun loadInterstitial(placementId: String, result: MethodChannel.Result) {
        Log.i(TAG, "loadInterstitial requested for real placement: $placementId")
        result.success(null)

        mainHandler.post {
            try {
                var interstitialAd = interstitialAdMap[placementId]
                if (interstitialAd == null) {
                    interstitialAd = ATInterstitial(activity, placementId)
                    interstitialAdMap[placementId] = interstitialAd
                }

                interstitialAd.setAdListener(object : ATInterstitialListener {
                    override fun onInterstitialAdLoaded() {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdLoaded: $placementId")
                        channel.invokeMethod("onInterstitialLoaded", mapOf("placementId" to placementId))
                    }

                    override fun onInterstitialAdLoadFail(adError: AdError) {
                        Log.e(TAG, "[Real SDK Callback] onInterstitialAdLoadFail: $placementId - Code: ${adError.code}, Desc: ${adError.desc}, Full: ${adError.fullErrorInfo}")
                        channel.invokeMethod(
                            "onInterstitialLoadFailed",
                            mapOf(
                                "placementId" to placementId,
                                "error" to (adError.fullErrorInfo ?: adError.desc ?: "Interstitial load failed"),
                                "code" to (adError.code ?: "")
                            )
                        )
                    }

                    override fun onInterstitialAdShow(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdShow: $placementId (network: ${adInfo.networkName})")
                        channel.invokeMethod("onInterstitialShown", mapOf("placementId" to placementId))
                    }

                    override fun onInterstitialAdClose(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdClose: $placementId")
                        channel.invokeMethod("onInterstitialClosed", mapOf("placementId" to placementId))
                    }

                    override fun onInterstitialAdClicked(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdClicked: $placementId")
                    }

                    override fun onInterstitialAdVideoStart(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdVideoStart: $placementId")
                    }

                    override fun onInterstitialAdVideoEnd(adInfo: ATAdInfo) {
                        Log.i(TAG, "[Real SDK Callback] onInterstitialAdVideoEnd: $placementId")
                    }

                    override fun onInterstitialAdVideoError(adError: AdError) {
                        Log.e(TAG, "[Real SDK Callback] onInterstitialAdVideoError: $placementId - ${adError.fullErrorInfo}")
                    }
                })

                // Issue REAL SDK network ad load request
                Log.i(TAG, "Calling real ATInterstitial.load() for placement: $placementId")
                interstitialAd.load()
            } catch (e: Throwable) {
                Log.e(TAG, "Error executing real ATInterstitial.load(): ${e.message}", e)
                channel.invokeMethod(
                    "onInterstitialLoadFailed",
                    mapOf(
                        "placementId" to placementId,
                        "error" to (e.message ?: "Exception in loadInterstitial")
                    )
                )
            }
        }
    }

    private fun showInterstitial(placementId: String, result: MethodChannel.Result) {
        val interstitialAd = interstitialAdMap[placementId]
        val ready = interstitialAd?.isAdReady ?: false
        if (!ready) {
            Log.w(TAG, "showInterstitial called but real ad is not ready: $placementId")
            result.success(false)
            return
        }

        Log.i(TAG, "Showing Real Interstitial: placement=$placementId")
        result.success(true)

        mainHandler.post {
            try {
                interstitialAd.show(activity)
            } catch (e: Throwable) {
                Log.e(TAG, "Error showing real interstitial ad: ${e.message}", e)
            }
        }
    }

    private fun getDiagnosticsMap(): Map<String, Any> {
        val topOnVersion = try {
            ATSDK.getSDKVersionName() ?: "Unknown"
        } catch (_: Throwable) {
            "Not Initialized"
        }

        val consentInfo = try {
            UserMessagingPlatform.getConsentInformation(activity)
        } catch (_: Throwable) {
            null
        }
        val umpStatus = if (consentInfo != null) getConsentStatusName(consentInfo.consentStatus) else "UNKNOWN"
        val umpCanRequest = consentInfo?.canRequestAds() ?: true
        val umpPrivacyRequired = consentInfo?.privacyOptionsRequirementStatus == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED

        return mapOf(
            "isInitialized" to isInitialized,
            "isTestMode" to isTestMode,
            "appId" to activeAppId,
            "topOnSdkDetected" to true,
            "topOnSdkVersion" to topOnVersion,
            "mintegralSdkDetected" to false,
            "omidPresent" to false,
            "omidVersion" to "N/A",
            "omidActive" to false,
            "omidSessionCreated" to false,
            "umpConsentStatus" to umpStatus,
            "umpCanRequestAds" to umpCanRequest,
            "umpPrivacyOptionsRequired" to umpPrivacyRequired,
            "rewardedReadyPlacements" to rewardedAdMap.filter { it.value.isAdReady }.keys.toList(),
            "interstitialReadyPlacements" to interstitialAdMap.filter { it.value.isAdReady }.keys.toList()
        )
    }
}
