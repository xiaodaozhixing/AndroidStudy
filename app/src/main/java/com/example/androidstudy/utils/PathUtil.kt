package com.example.androidstudy.utils

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object PathUtil {
    fun createTxtFile(
        context: Context,
        path: String = "",
        name: String = System.currentTimeMillis().toString(),
        detail: String
    ): Boolean {
        val absolutePth = context.getExternalFilesDir(path)?.absolutePath ?: return false

        val file = File(absolutePth, name)
        if (file.exists()) return false
        val fileOutputStream = FileOutputStream(file)
        fileOutputStream.write(detail.toByteArray())
        fileOutputStream.close()
        return true
    }

}