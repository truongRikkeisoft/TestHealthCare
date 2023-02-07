package com.example.testHealthCare.util

import android.content.IntentFilter
import java.util.*

object BaseActionUtils {
    object FilePath {
        //61数据ble日志
        const val Mtk_Ble_61_Data_Log_Dir = "/Zeroner/sdk/blelog/61_data/"

        //61数据睡眠
        const val Mtk_Ble_61_Sleep_Dir = "/Zeroner/sdk/sleep/"

        //62数据ble日志
        const val Mtk_Ble_62_Data_Log_Dir = "/Zeroner/sdk/blelog/62_data/"
        const val ProtoBuf_Ble_Data_Log_Dir = "/Zeroner/sdk/sleep/"
        const val ProtoBuf_Ble_80_Sleep_Dir = "/Zeroner/sdk/protobuf/sleep/"
        const val ProtoBuf_Ble_80_Sleep_Dir_Test = "/Zeroner/sdk/test/"
    }

    var isBackground = false

    /**
     * nordic firmware upgrade UUID
     */
    val NODIC_UPDATE_SERVICE = UUID.fromString("00001530-0000-1000-8000-00805f9b34fb")
    val UPDATE_SERVICE_MAIN_DFU = UUID.fromString("0000fe59-0000-1000-8000-00805f9b34fb")

    /**
     * bluetooth action
     */
    const val ON_SCAN_RESULT = "com.zeroner.app.ON_SCAN_RESULT"
    const val ON_DATA_ARRIVED = "com.zeroner.app.ON_DATA_ARRIVED"
    const val ON_BLUETOOTH_INIT = "com.zeroner.app.ON_BLUETOOTH_INIT"
    const val ON_CONNECT_STATUE = "com.zeroner.app.ON_CONNECT_STATUE"
    const val ON_DISCOVER_SERVICE = "com.zeroner.app.ON_DISCOVER_SERVICE"
    const val ON_DISCOVER_CHARACTER = "com.zeroner.app.ON_DISCOVER_CHARACTER"
    const val ON_COMMON_SEND = "com.zeroner.app.ON_COMMON_SEND"
    const val ON_COMMON_RECEIVER = "com.zeroner.app.ON_COMMON_RECEIVER"
    const val ON_CHARACTERISTIC_CHANGE = "com.zeroner.app.ON_CHARACTERISTIC_CHANGE"
    const val ON_BLUETOOTH_ERROR = "com.zeroner.app.ON_BLUETOOTH_ERROR"
    const val BLE_SDK_TYPE = "com.zeroner.app.BLE_SDK_TYPE"
    const val BLE_DATA_TYPE = "com.zeroner.app.BLE_DATA_TYPE"
    const val BLE_ARRIVED_DATA = "com.zeroner.app.BLE_ARRIVED_DATA"
    const val BLE_SCAN_RESULT_DEVICE = "com.zeroner.app.BLE_SCAN_RESULT_DEVICE"
    const val BLE_CONNECT_STATUE = "com.zeroner.app.BLE_CONNECT_STAUE"
    const val BLE_SERVICE_UUID = "com.zeroner.app.BLE_SERVICE_UUID"
    const val BLE_CHARACTER_UUID = "com.zeroner.app.CHARACTER_UUID"
    const val BLE_COMMON_SEND = "com.zeroner.app.BLE_COMMON_SEND"
    const val BLE_BLUETOOTH_ADDRESS = "com.zeroner.app.BLE_BLUETOOTH_ADDRESS"
    const val BLE_PRE_CONNECT = "com.zeroner.app.BLE_PRE_CONEECT"
    const val BLE_NO_CALLBACK = "com.zeroner.app.BLE_NO_CALLBACK"
    const val ACTION_CONNECT_TIMEOUT = "com.zeroner.app.ACTION_CONNECT_TIMEOUT"
    const val Action_Phone_Statue_Out = "com.kunekt.healthy.ACTION_PHONE_STATUE_OUT"

    /**
     * bluetooth intentFilter
     * @return
     */
    fun getIntentFilter(): IntentFilter? {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ON_SCAN_RESULT)
        intentFilter.addAction(ON_DATA_ARRIVED)
        intentFilter.addAction(ON_BLUETOOTH_INIT)
        intentFilter.addAction(ON_CONNECT_STATUE)
        intentFilter.addAction(ON_DISCOVER_SERVICE)
        intentFilter.addAction(ON_DISCOVER_CHARACTER)
        intentFilter.addAction(ON_COMMON_SEND)
        intentFilter.addAction(ON_CHARACTERISTIC_CHANGE)
        intentFilter.addAction(ON_BLUETOOTH_ERROR)
        intentFilter.addAction(BLE_DATA_TYPE)
        intentFilter.addAction(BLE_ARRIVED_DATA)
        intentFilter.addAction(BLE_SCAN_RESULT_DEVICE)
        intentFilter.addAction(BLE_CONNECT_STATUE)
        intentFilter.addAction(BLE_SERVICE_UUID)
        intentFilter.addAction(BLE_CHARACTER_UUID)
        intentFilter.addAction(BLE_COMMON_SEND)
        intentFilter.addAction(BLE_SDK_TYPE)
        intentFilter.addAction(BLE_BLUETOOTH_ADDRESS)
        intentFilter.addAction(BLE_PRE_CONNECT)
        intentFilter.addAction(BLE_NO_CALLBACK)
        intentFilter.addAction(ON_COMMON_RECEIVER)
        return intentFilter
    }

    //action device
    const val APP_SDK_UPDATE_Content = "com.zeroner.app.APP_SDK_UPDATE_Content"
    const val ACTION_DEVICE_NAME = "com.zeroner.app.ACTION_DEVICE_NAME"
    const val ACTION_DEVICE_ADDRESS = "com.zeroner.app.ACTION_DEVICE_ADDRESS"
    const val Action_device_Battery = "com.zeroner.app.ACTION_DEVICE_Battery"
    const val Action_device_Model = "com.zeroner.app.Action_device_Model"
    const val Action_device_FirmwareInfo = "com.zeroner.app.Action_device_FirmwareInfo"
    const val Action_device_Settings = "com.zeroner.app.Action_device_Settings"

    const val Action_device_version = "com.zeroner.app.Action_device_version"


    //action settings
    const val Action_Setting_Shake = "com.zeroner.app.Action_Setting_Shake"
    const val Action_Setting_Time_Format = "com.zeroner.app.Action_Setting_Time_Format"
    const val Action_Setting_Date_Format = "com.zeroner.app.Action_Setting_Date_Format"
    const val Action_Setting_Unit = "com.zeroner.app.Action_Setting_Unit"
    const val Action_Setting_Weather_Unit = "com.zeroner.app.Action_Setting_Weather_Unit"
    const val Action_Setting_Roll = "com.zeroner.app.Action_Setting_Roll"
    const val Action_Setting_Roll_Time = "com.zeroner.app.Action_Setting_Roll_Time"
    const val Action_Setting_Hand = "com.zeroner.app.Action_Setting_Hand"
    const val Action_Setting_Language = "com.zeroner.app.Action_Setting_Language"

    //action data
    const val Action_Data_Sleep = "com.zeroner.app.Action_Data_Sleep"
    const val Action_Last_Sync_Data_Time = "com.zeroner.app.Action_Last_Sync_Data_Time"

    //
    const val HAS_SELECT_SDK_FIRST = "com.zeroner.app.HAS_SELECT_SDK_FIRST"


    const val PROTOBUF_MTU_INFO = "com.zeroner.app.PROTOBUF_MTU_INFO"
}