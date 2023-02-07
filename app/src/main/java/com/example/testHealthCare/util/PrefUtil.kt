package com.example.testHealthCare.util

import android.content.Context

/**
 * SharedPreferences工具类
 *
 * @author zhoushujie 2014-7-24 上午9:28:02
 */
object PrefUtil {
    /**
     * 默认数据记录文件名称
     */
    private const val PREF_FILE = "Zeroner_WRISTBAND_SHAREDPREFERENCES"

    /**
     * 存储长整型数据
     *
     * @param context
     * 上下文
     * @param prefFile
     * 文件名称
     * @param key
     * 键
     * @param value
     * long值
     * @return
     */
    fun save(
        prefFile: String?, context: Context, key: String?,
        value: Long
    ): Boolean {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        ) // 读取文件,如果没有则会创建
        val editor = settings.edit()
        editor.putLong(key, value)
        return editor.commit()
    }

    /**
     * 存储长整型数据
     *
     * @param context
     * 上下文
     * @param key
     * 存储数据特定的键
     * @param value
     * 存储的数据 （long类型）
     */
    fun save(context: Context, key: String?, value: Long): Boolean {
        return save(PREF_FILE, context, key, value)
    }

    /**
     * 存储字符串数据
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param value
     * String值
     * @return
     */
    fun save(
        prefFile: String?, context: Context, key: String?,
        value: String?
    ): Boolean {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        val editor = settings.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    /**
     * 存储字符串数据
     *
     * @param context
     * 上下文
     * @param key
     * 存储数据特定的键
     * @param value
     * 存储的数据 （String类型）
     */
    fun save(context: Context, key: String?, value: String?): Boolean {
        return save(PREF_FILE, context, key, value)
    }

    /**
     * 保存整形数据
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param value
     * int值
     * @return
     */
    fun save(
        prefFile: String?, context: Context, key: String?,
        value: Int
    ): Boolean {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        val editor = settings.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    /**
     * 保存整形数据
     *
     * @param context
     * @param key
     * 键
     * @param value
     * int值
     * @return
     */
    fun save(context: Context, key: String?, value: Int): Boolean {
        // 读取文件,如果没有则会创建
        return save(PREF_FILE, context, key, value)
    }

    /**
     * 保存浮点型数据
     *
     * @param prefFile
     * 记录文件名称
     * @param context
     * @param key
     * 键
     * @param value
     * float值
     * @return
     */
    fun save(
        prefFile: String?, context: Context, key: String?,
        value: Float
    ): Boolean {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        val editor = settings.edit()
        editor.putFloat(key, value)
        return editor.commit()
    }

    /**
     * 保存浮点型数据
     *
     * @param context
     * @param key
     * 键
     * @param value
     * float值
     * @return
     */
    fun save(context: Context, key: String?, value: Float): Boolean {
        return save(PREF_FILE, context, key, value)
    }

    /**
     * 保存布尔型数据
     *
     * @param prefFile
     * 记录文件名称
     * @param context
     * @param key
     * 键
     * @param value
     * boolean值
     * @return
     */
    fun save(
        prefFile: String?, context: Context, key: String?,
        value: Boolean
    ): Boolean {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        val editor = settings.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    /**
     * 保存布尔型数据
     *
     * @param context
     * @param key
     * 键
     * @param value
     * boolean值
     * @return
     */
    fun save(context: Context, key: String?, value: Boolean): Boolean {
        return save(PREF_FILE, context, key, value)
    }

    /**
     * 获取长整型数据，默认值0
     *
     * @param prefFile
     * 文件名
     * @param context
     * @param key
     * 键
     * @return long
     */
    fun getLong(prefFile: String?, context: Context, key: String?): Long {
        return getLong(prefFile, context, key, 0L)
    }

    /**
     * 获取长整型数据，默认值0
     *
     * @param context
     * @param key
     * 键
     * @return long
     */
    fun getLong(context: Context, key: String?): Long {
        return getLong(PREF_FILE, context, key, 0L)
    }

    /**
     * 获取长整型数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return long
     */
    fun getLong(
        prefFile: String?, context: Context, key: String?,
        defValue: Long
    ): Long {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.getLong(key, defValue)
    }

    /**
     * 获取长整型数据，自定义默认值
     *
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return long
     */
    fun getLong(context: Context, key: String?, defValue: Long): Long {
        return getLong(PREF_FILE, context, key, defValue)
    }

    /**
     * 获取浮点型数据，默认值0
     *
     * @param prefFile
     * 文件名
     * @param context
     * @param key
     * 键
     * @return float
     */
    fun getFloat(prefFile: String?, context: Context, key: String?): Float {
        return getFloat(prefFile, context, key, 0f)
    }

    /**
     * 获取浮点型数据，默认值0
     *
     * @param context
     * @param key
     * 键
     * @return float
     */
    fun getFloat(context: Context, key: String?): Float {
        return getFloat(PREF_FILE, context, key, 0f)
    }

    /**
     * 获取浮点型数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return float
     */
    fun getFloat(
        prefFile: String?, context: Context, key: String?,
        defValue: Float
    ): Float {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.getFloat(key, defValue)
    }

    /**
     * 获取浮点型数据，自定义默认值
     *
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return float
     */
    fun getFloat(context: Context, key: String?, defValue: Float): Float {
        return getFloat(PREF_FILE, context, key, defValue)
    }

    /**
     * 获取字符串数据，默认值""
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @return String
     */
    fun getString(prefFile: String?, context: Context, key: String?): String? {
        return getString(prefFile, context, key, "")
    }

    /**
     * 获取字符串数据，默认值""
     *
     * @param context
     * @param key
     * 键
     * @return String
     */
    fun getString(context: Context, key: String?): String? {
        return getString(PREF_FILE, context, key, "")
    }

    /**
     * 获取字符串数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return String
     */
    fun getString(
        prefFile: String?, context: Context,
        key: String?, defValue: String?
    ): String? {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.getString(key, defValue)
    }

    /**
     * 获取字符串数据，自定义默认值
     *
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return String
     */
    fun getString(context: Context, key: String?, defValue: String?): String? {
        return getString(PREF_FILE, context, key, defValue)
    }

    /**
     * 获取整型数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @return int值
     */
    fun getInt(prefFile: String?, context: Context, key: String?): Int {
        return getInt(prefFile, context, key, 0)
    }

    /**
     * 获取整型数据，默认值0
     *
     * @param context
     * @param key
     * 键
     * @return int值
     */
    fun getInt(context: Context, key: String?): Int {
        return getInt(PREF_FILE, context, key, 0)
    }

    /**
     * 获取整型数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return int值
     */
    fun getInt(
        prefFile: String?, context: Context, key: String?,
        defValue: Int
    ): Int {
        // 读取文件,如果没有则会创建
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.getInt(key, defValue)
    }

    /**
     * 获取整型数据，自定义默认值
     *
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return int值
     */
    fun getInt(context: Context, key: String?, defValue: Int): Int {
        return getInt(PREF_FILE, context, key, defValue)
    }

    /**
     * 获取布尔型数据，默认值false
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @return boolean值
     */
    fun getBoolean(
        prefFile: String?, context: Context,
        key: String?
    ): Boolean {
        return getBoolean(prefFile, context, key, false)
    }

    /**
     * 获取布尔型数据，默认值false
     *
     * @param context
     * @param key
     * 键
     * @return boolean值
     */
    fun getBoolean(context: Context, key: String?): Boolean {
        return getBoolean(PREF_FILE, context, key, false)
    }

    /**
     * 获取布尔型数据，自定义默认值
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return boolean值
     */
    fun getBoolean(
        prefFile: String?, context: Context,
        key: String?, defValue: Boolean
    ): Boolean {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.getBoolean(key, defValue)
    }

    /**
     * 获取布尔型数据，自定义默认值
     *
     * @param context
     * @param key
     * 键
     * @param defValue
     * 默认值
     * @return boolean值
     */
    fun getBoolean(
        context: Context, key: String?,
        defValue: Boolean
    ): Boolean {
        return getBoolean(PREF_FILE, context, key, defValue)
    }

    /**
     * 判断数据是否存在
     *
     * @param prefFile
     * 记录文件名称
     * @param context
     * @param key
     * 键
     * @return true存在，false不存在
     */
    fun contains(prefFile: String?, context: Context, key: String?): Boolean {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.contains(key)
    }

    /**
     * 判断数据是否存在
     *
     * @param context
     * @param key
     * 键
     * @return true存在，false不存在
     */
    fun contains(context: Context, key: String?): Boolean {
        return contains(PREF_FILE, context, key)
    }

    /**
     * 移除指定数据
     *
     * @param prefFile
     * 记录文件名
     * @param context
     * @param key
     * 键
     * @return true已移除，false未移除
     */
    fun remove(prefFile: String?, context: Context, key: String?): Boolean {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.edit().remove(key).commit()
    }

    /**
     * 清除配置信息
     *
     * @param prefFile
     * 配置文件
     * @param context
     * @return 是否清除成功
     */
    fun clear(prefFile: String?, context: Context): Boolean {
        val settings = context.getSharedPreferences(
            prefFile,
            Context.MODE_PRIVATE
        )
        return settings.edit().clear().commit()
    }

    /**
     * 移除指定数据
     *
     * @param context
     * @param key
     * 键
     * @return 是否移除成功
     */
    fun remove(context: Context, key: String?): Boolean {
        return remove(PREF_FILE, context, key)
    }

    /**
     * 清除配置信息
     *
     * @param context
     * @return 是否清除成功
     */
    fun clear(context: Context): Boolean {
        return clear(PREF_FILE, context)
    }
}