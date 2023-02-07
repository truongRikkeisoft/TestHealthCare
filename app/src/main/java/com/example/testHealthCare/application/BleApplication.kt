package com.example.testHealthCare.application

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.text.TextUtils
import android.util.Log
import com.example.testHealthCare.receiver.BluetoothDataParseReceiver
import com.example.testHealthCare.util.BaseActionUtils
import com.example.testHealthCare.util.PrefUtil
import com.zeroner.blemidautumn.bean.WristBand
import com.zeroner.blemidautumn.bluetooth.IBle
import com.zeroner.blemidautumn.bluetooth.IDataReceiveHandler
import com.zeroner.blemidautumn.bluetooth.SuperBleSDK
import com.zeroner.blemidautumn.bluetooth.impl.AbsBle
import com.zeroner.blemidautumn.bluetooth.impl.BleService
import com.zeroner.blemidautumn.bluetooth.impl.BleService.LocalBinder
import java.util.Objects

class BleApplication : Application() {

    private lateinit var context: BleApplication
    private lateinit var mBle: IBle
    private lateinit var mService: BleService
    private lateinit var sObjects: Objects
    private lateinit var bluetoothDataParseReceiver: BluetoothDataParseReceiver

    companion object {
        @JvmStatic
        fun getInstance(): BleApplication {
            return BleApplication().context
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        //Register receiver
        val intentFilter = BaseActionUtils.getIntentFilter()

        //Start Service
        SuperBleSDK.addBleListener(this, object : IDataReceiveHandler {
            override fun onDataArrived(ble_sdk_type: Int, dataType: Int, data: String?) {
                val intent = Intent(BaseActionUtils.ON_DATA_ARRIVED)
                intent.apply {
                    putExtra(BaseActionUtils.BLE_SDK_TYPE, ble_sdk_type)
                    putExtra(BaseActionUtils.BLE_DATA_TYPE, dataType)
                    putExtra(BaseActionUtils.BLE_ARRIVED_DATA, data)
                }

            }

            override fun onScanResult(p0: WristBand?) {
                TODO("Not yet implemented")
            }

            override fun onBluetoothInit() {
                TODO("Not yet implemented")
            }

            override fun connectStatue(p0: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onDiscoverService(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun onDiscoverCharacter(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun onCommonSend(p0: ByteArray?) {
                TODO("Not yet implemented")
            }

            override fun onCmdReceive(p0: ByteArray?) {
                TODO("Not yet implemented")
            }

            override fun onCharacteristicChange(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun onBluetoothError() {
                TODO("Not yet implemented")
            }

            override fun onPreConnect() {
                TODO("Not yet implemented")
            }

            override fun noCallback() {
                TODO("Not yet implemented")
            }

            override fun onConnectionStateChanged(p0: Int, p1: Int) {
                TODO("Not yet implemented")
            }

            override fun onSdkAutoReconnectTimesOut() {
                TODO("Not yet implemented")
            }

        })
    }

    fun getIBle(): IBle? {
        return mBle
    }

    /*private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            className: ComponentName,
            rawBinder: IBinder
        ) {
            try {
                mService = (rawBinder as LocalBinder).service
                mBle = mService.getBle()

                if (!TextUtils.isEmpty(
                        PrefUtil.getString(
                            BluetoothUtil.context,
                            BaseActionUtils.ACTION_DEVICE_NAME
                        )
                    ) && !TextUtils.isEmpty(
                        PrefUtil.getString(
                            BluetoothUtil.context,
                            BaseActionUtils.ACTION_DEVICE_ADDRESS
                        )
                    )
                ) {
                    (mBle as AbsBle).wristBand =
                        WristBand(
                            PrefUtil.getString(
                                BluetoothUtil.context,
                                BaseActionUtils.ACTION_DEVICE_NAME
                            ),
                            PrefUtil.getString(
                                BluetoothUtil.context,
                                BaseActionUtils.ACTION_DEVICE_ADDRESS
                            )
                        )
                }
                synchronized(BleApplication) { BleApplication.getObject().notifyAll() }
            } catch (e: Exception) {
                Log.d("TestApp", "onServiceConnected: $e")
            }
        }

        override fun onServiceDisconnected(classname: ComponentName) {
            Log.d("TestApp", "onServiceDisconnected: ")
            mService = null
        }
    }*/
}