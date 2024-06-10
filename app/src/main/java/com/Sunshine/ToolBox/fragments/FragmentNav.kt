package com.Sunshine.ToolBox.fragments

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.Sunshine.Scene
import com.Sunshine.common.ui.DialogHelper
import com.Sunshine.common.ui.ThemeMode
import com.Sunshine.kr.KrScriptConfig
import com.Sunshine.kr.KrScriptConfig1
import com.Sunshine.kr.KrScriptConfig2
import com.Sunshine.kr.KrScriptConfig3
import com.Sunshine.kr.KrScriptConfig4
import com.Sunshine.kr.KrScriptConfig5
import com.Sunshine.kr.KrScriptConfig6
import com.Sunshine.library.shell.BatteryUtils
import com.Sunshine.permissions.CheckRootStatus
import com.Sunshine.shell_utils.BackupRestoreUtils
import com.Sunshine.utils.AccessibleServiceHelper
import com.Sunshine.ToolBox.R
import com.Sunshine.ToolBox.activities.*
import com.Sunshine.ToolBox.dialogs.DialogXposedGlobalConfig
import com.Sunshine.xposed.XposedCheck
import com.projectkr.shell.OpenPageHelper
import kotlinx.android.synthetic.main.fragment_nav.*

class FragmentNav : Fragment(), View.OnClickListener {
    private lateinit var themeMode: ThemeMode

    companion object {
        fun createPage(themeMode: ThemeMode): Fragment {
            val fragment = FragmentNav()
            fragment.themeMode = themeMode;
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_nav, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav = view.findViewById<LinearLayout>(R.id.nav)
        for (index in 1..nav.childCount) {
            val ele = nav.getChildAt(index)
            if (ele is GridLayout) {
                for (index2 in 0 until ele.childCount) {
                    bindClickEvent(ele.getChildAt(index2))
                }
            }
        }
    }

    private fun bindClickEvent(view: View) {
        view.setOnClickListener(this)
        if (!CheckRootStatus.lastCheckResult && "root".equals(view.getTag())) {
            view.isEnabled = false
        }
    }

    override fun onResume() {
        super.onResume()
        if (isDetached) {
            return
        }
        activity!!.title = getString(R.string.app_name)
    }

    override fun onClick(v: View?) {
        v?.run {
            if (!CheckRootStatus.lastCheckResult && "root".equals(getTag())) {
                Toast.makeText(context, "没有获得ROOT权限，不能使用本功能", Toast.LENGTH_SHORT).show()
                return
            }

            when (id) {
                R.id.nav_applictions -> {
                    val intent = Intent(context, ActivityApplistions::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_swap -> {
                    val intent = Intent(context, ActivitySwap::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_charge -> {
                    val intent = Intent(context, ActivityCharge::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_power_utilization -> {
                    val intent = Intent(context, ActivityPowerUtilization::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_img -> {
                        val intent = Intent(context, ActivityImg::class.java)
                        startActivity(intent)
                    
                    return
                }
                R.id.nav_battery_stats -> {
                    val intent = Intent(context, ActivityPowerUtilization::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_core_control -> {
                    val intent = Intent(context, ActivityCpuControl::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_miui_thermal -> {
                    val intent = Intent(context, ActivityMiuiThermal::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_app_scene -> {
                    val intent = Intent(context, ActivityAppConfig2::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_app_magisk -> {
                    val intent = Intent(context, ActivityMagisk::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_modules -> {
                    val intent = Intent(context, ActivityModules::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_processes -> {
                    val intent = Intent(context, ActivityProcess::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    return
                }
                R.id.nav_fps_chart -> {
                    val intent = Intent(context, ActivityFpsChart::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_additional -> {
                    val intent = Intent(context, ActivityAddin::class.java)
                    startActivity(intent)
                    return
                }
                R.id.nav_additional_all -> {
                    val krScriptConfig = KrScriptConfig().init(context!!)
                    val activity = activity!!
                    krScriptConfig.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_additional)
                        })
                    }
                    return
                }


                R.id.nav_freeze -> {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setClassName("com.Sunshine.ToolBox", "com.Sunshine.ToolBox.activities.ActivityFreezeApps2")
                    startActivity(intent)
                    return
                }
                
                R.id.nav_1 -> {
                    val krScriptConfig1 = KrScriptConfig1().init(context!!)
                    val activity = activity!!
                    krScriptConfig1.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_11)
                        })
                    }
                    return
                }

                R.id.nav_2 -> {
                    val krScriptConfig2 = KrScriptConfig2().init(context!!)
                    val activity = activity!!
                    krScriptConfig2.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_21)
                        })
                    }
                    return
                }

                R.id.nav_3 -> {
                    val krScriptConfig3 = KrScriptConfig3().init(context!!)
                    val activity = activity!!
                    krScriptConfig3.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_31)
                        })
                    }
                    return
                }

                R.id.nav_4 -> {
                    val krScriptConfig4 = KrScriptConfig4().init(context!!)
                    val activity = activity!!
                    krScriptConfig4.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_41)
                        })
                    }
                    return
                }

                R.id.nav_5 -> {
                    val krScriptConfig5 = KrScriptConfig5().init(context!!)
                    val activity = activity!!
                    krScriptConfig5.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_51)
                        })
                    }
                    return
                }

                R.id.nav_6 -> {
                    val krScriptConfig6 = KrScriptConfig6().init(context!!)
                    val activity = activity!!
                    krScriptConfig6.pageListConfig?.run {
                        OpenPageHelper(activity).openPage(this.apply {
                            title = getString(R.string.menu_61)
                        })
                    }
                    return
                }
                else -> {}
            }
        }
    }

    private fun installVAddin() {
        DialogHelper.warning(context!!, getString(R.string.scene_addin_miss), getString(R.string.scene_addin_miss_desc), {
            try {
                val uri = Uri.parse("http://vtools.omarea.com/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } catch (ex: Exception) {
                Toast.makeText(context, "启动在线页面失败！", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun xposedCheck(onPass: Runnable) {
        var vAddinsInstalled: Boolean
        try {
            vAddinsInstalled = context!!.packageManager.getPackageInfo("com.Sunshine.vaddin", 0) != null
        } catch (ex: Exception) {
            vAddinsInstalled = false
        }
        if (vAddinsInstalled) {
            if (XposedCheck.xposedIsRunning()) {
                onPass.run()
            } else {
                Toast.makeText(context, "请先在Xposed管理器中重新勾选“Scene”，并重启手机", Toast.LENGTH_LONG).show()
            }
        } else {
            installVAddin()
        }
    }
}
