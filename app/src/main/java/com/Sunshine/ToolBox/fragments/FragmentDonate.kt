package com.Sunshine.ToolBox.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Sunshine.ToolBox.R
import kotlinx.android.synthetic.main.fragment_donate.*

class FragmentDonate : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_donate, container, false)

    override fun onResume() {
        super.onResume()
        // activity!!.title = getString(R.string.menu_paypal)
        activity!!.title = getString(R.string.app_name)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pay_alipay.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_link))
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }

        pay_wxpay.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=DnuSkhJ_x1lHKBxfi9GtbUijy43awAPW&authKey=RUtBy2exLLjSAM0ceIQQQP5yDusp91dAY%2BxTJDxxgvClkXBFDuFrL7XgzrFijIZi&noverify=0&group_code=813807778")))
        }
    }

    override fun onClick(v: View?) {
        // Handle other click events if needed
    }
}
