package com.Sunshine.ToolBox.dialogs

import android.app.Activity
import android.view.View
import com.Sunshine.common.shell.KeepShellPublic
import com.Sunshine.common.ui.DialogHelper
import com.Sunshine.ToolBox.R

class DialogPower(var context: Activity) {
    fun showPowerMenu() {
        val view = context.layoutInflater.inflate(R.layout.dialog_power_operation, null)
        val dialog = DialogHelper.customDialog(context, view)
        view.findViewById<View>(R.id.power_shutdown).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_shutdown_cmd))
        }
        view.findViewById<View>(R.id.power_reboot).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_reboot_cmd))
        }
        view.findViewById<View>(R.id.power_hot_reboot).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_hot_reboot_cmd))
        }

        view.findViewById<View>(R.id.power_recovery).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_recovery_cmd))
        }
        view.findViewById<View>(R.id.power_fastboot).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_fastboot_cmd))
        }
        view.findViewById<View>(R.id.power_emergency).setOnClickListener {
            dialog.dismiss()
            KeepShellPublic.doCmdSync(context.getString(R.string.power_emergency_cmd))
        }
    }
}
