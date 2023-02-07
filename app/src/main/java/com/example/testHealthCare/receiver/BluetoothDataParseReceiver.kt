package com.example.testHealthCare.receiver

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import com.example.testHealthCare.util.BaseActionUtils
import com.zeroner.blemidautumn.bluetooth.SuperBleSDK

/**
 * Created by zm on 2016/10/12.
 */
class BluetoothDataParseReceiver : BluetoothCallbackReceiver() {
    private val mHandler: Handler = Handler(Looper.getMainLooper())
    private val mDisconnectRunnable: Runnable = object : Runnable {
        override fun run() {
            if (BaseActionUtils.isBackground && BluetoothUtil.isConnected()) {
                val bytes: ByteArray = SuperBleSDK.getSDKSendBluetoothCmdImpl(context).setUnbind()
                val task = BleWriteDataTask(context, bytes, true)
                if (BackgroundThreadManager.getInstance().getQueueSize() > 0) {
                    val lastTask: ITask = BackgroundThreadManager.getInstance().getLastTask()
                    if (lastTask is BleWriteDataTask && (lastTask as BleWriteDataTask).isUnbind()) {
                        return
                    }
                }
                BackgroundThreadManager.getInstance().addTask(task)
                SystemClock.sleep(5000)
                BluetoothUtil.setNeedReconnect(true)
                BluetoothUtil.connect()
            } else if (BaseActionUtils.isBackground && !BluetoothUtil.isConnected()) {
                SystemClock.sleep(5000)
                BluetoothUtil.setNeedReconnect(true)
                BluetoothUtil.connect()
            }
            judgeDisconnect()
        }
    }
    private val timeout: Int
        private get() = mConnectTimeout / 60000

    /**
     * 判断是否5m后断开
     */
    private fun judgeDisconnect() {
//        if (BaseActionUtils.isBackground) {
//            mHandler.removeCallbacks(mDisconnectRunnable);
//            mHandler.postDelayed(mDisconnectRunnable, mConnectTimeout);
//        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        initData()
        super.onReceive(context, intent)
        if (BaseActionUtils.BLE_COMMON_SEND.equals(intent.getAction())) {
            if (BaseActionUtils.isBackground) {
                judgeDisconnect()
            }
        } else if (BaseActionUtils.ON_CHARACTERISTIC_CHANGE.equals(intent.getAction())) {
            if (BaseActionUtils.isBackground) {
                judgeDisconnect()
            }
        } else if (BaseActionUtils.ACTION_CONNECT_TIMEOUT.equals(intent.getAction())) {
            if (BaseActionUtils.isBackground) {
                if (BluetoothUtil.isConnected()) {
                    judgeDisconnect()
                } else {
                    removeDisconnectRunnable()
                }
            } else {
                KLog.e("进入前台 : 移除" + timeout + "分钟后断开连接")
                removeDisconnectRunnable()
            }
        } else if (BaseActionUtils.ON_BLUETOOTH_ERROR.equals(intent.getAction())) {
            if (!BaseActionUtils.isBackground) {
                KLog.e("出现257错误提示用户 isBackground : " + BaseActionUtils.isBackground)
                //                BaseActionUtils.showToast(R.string.connect_error_257);
            }
        } else if (BaseActionUtils.BLE_CONNECT_STATUE.equals(intent.getAction())) {
        }
    }

    private fun removeDisconnectRunnable() {
        mHandler.removeCallbacks(mDisconnectRunnable)
    }

    private fun initData() {}
    override fun connectStatue(isConnect: Boolean) {
        super.connectStatue(isConnect)
        val myLifecycleHandler: MyLifecycleHandler =
            BleApplication.getInstance().getmMyLifecycleHandler()
        if (myLifecycleHandler != null) {
            KLog.e("background : " + myLifecycleHandler.isBackground())
        }
        val wristBand: WristBand = SuperBleSDK.createInstance(context).getWristBand()
        if (wristBand != null) {
            PrefUtil.save(context, BaseActionUtils.ACTION_DEVICE_NAME, wristBand.getName())
            PrefUtil.save(context, BaseActionUtils.ACTION_DEVICE_ADDRESS, wristBand.getAddress())
            //            KLog.e(TAG, JsonTool.toJson(wristBand));
        } else {
            KLog.e(TAG, "wristBand==null")
        }
        val dataMap = HashMap<String, Any>()
        dataMap[Event.Ble_Connect_Statue] = isConnect
        EventBus.getDefault().post(Event(Event.Ble_Connect_Statue, dataMap))
    }

    override fun onDataArrived(context: Context?, ble_sdk_type: Int, dataType: Int, data: String?) {
        super.onDataArrived(context, ble_sdk_type, dataType, data)
        when (ble_sdk_type) {
            ZGDataParsePresenter.Type -> ZGDataParsePresenter.parseProtocolData(
                context,
                dataType,
                data
            )
            IwownDataParsePresenter.Type -> IwownDataParsePresenter.parseProtocolData(
                context,
                dataType,
                data
            )
            MtkDataParsePresenter.Type -> MtkDataParsePresenter.parseProtoclData(
                context,
                dataType,
                data
            )
            ProtoBufDataParsePersenter.Type, ProtoBufDataParsePersenter.Type2 -> ProtoBufDataParsePersenter.parseProtocolData(
                context,
                dataType,
                data
            )
            else -> {}
        }
    }

    override fun onBluetoothInit() {
        super.onBluetoothInit()
        KLog.i(TAG, "onBluetoothInit")
        if (SyncData.getInstance().isSyncDataInfo() && !SuperBleSDK.isMtk(context)) {
            SyncData.getInstance().stopSyncDataAll()
        } else if ((!MtkSync.getInstance(context).isSyncDataInfo() || !MTKHeadSetSync.getInstance()
                .isSyncDataInfo()) && SuperBleSDK.isMtk(context)
        ) {
            DataSupport.deleteAll(TB_f1_index::class.java)
            DataSupport.deleteAll(TB_sum_61_62_64::class.java)
            DataSupport.deleteAll(TB_62_data::class.java)
            DataSupport.deleteAll(TB_60_data::class.java)
            DataSupport.deleteAll(TB_61_data::class.java)
            DataSupport.deleteAll(TB_64_data::class.java)
            DataSupport.deleteAll(TB_68_data::class.java)

//            you should get the data counts first and then get them from device
//            in this demo when we get response, we will save it in TB_sum_61_62_64 table
            val data_from: String = PrefUtil.getString(
                BleApplication.getInstance(),
                BaseActionUtils.ACTION_DEVICE_NAME
            ) + ""

//            if (data_from.toUpperCase().contains("VOICE")) {
//                KLog.e("voice18", "---------voice开始同步");
//                MTKHeadSetSync.getInstance().syncDataInfo();
//            } else {
//                MtkSync.getInstance(context).getDatasIndexTables();
//            }
        }
        if (SuperBleSDK.isIown(context)) {
            val power: ByteArray = SuperBleSDK.getSDKSendBluetoothCmdImpl(context).getBattery()
            BackgroundThreadManager.getInstance().addWriteData(context, power)
            val data7: ByteArray =
                SuperBleSDK.getSDKSendBluetoothCmdImpl(context).getFirmwareInformation()
            BackgroundThreadManager.getInstance().addWriteData(context, data7)
            val bytes: ByteArray = SuperBleSDK.getSDKSendBluetoothCmdImpl(context).setTime()
            BackgroundThreadManager.getInstance().addWriteData(context, bytes)
            if (!BaseActionUtils.isBackground || TextUtils.isEmpty(
                    PrefUtil.getString(
                        context,
                        BaseActionUtils.ACTION_DEVICE_ADDRESS
                    )
                )
            ) {
                SyncData.getInstance().syncDataInfo()
            }
        } else if (SuperBleSDK.isMtk(context)) {
            SportWatchCmdHelper.getSomeBaseInfo(context.getApplicationContext())
        } else if (SuperBleSDK.isProtoBuf(context)) {
            val battery: ByteArray = SuperBleSDK.getSDKSendBluetoothCmdImpl(context).getBattery()
            BackgroundThreadManager.getInstance().addWriteData(context, battery)
            //            byte[] time = SuperBleSDK.getSDKSendBluetoothCmdImpl(context).setTime();
//            BackgroundThreadManager.getInstance().addWriteData(context, time);
        } else if (SuperBleSDK.isZG(context)) {
            val hardwareFeatures: ByteArray =
                SuperBleSDK.getSDKSendBluetoothCmdImpl(context).getHardwareFeatures()
            BackgroundThreadManager.getInstance().addWriteData(context, hardwareFeatures)
        }
    }

    companion object {
        private const val TAG = "BluetoothDataParseReceiver"
        private const val CONNECT_TIME_OUT = 60000 * 60
        private const val mConnectTimeout = CONNECT_TIME_OUT
    }
}