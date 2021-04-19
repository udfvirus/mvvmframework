package com.litesoftteam.mvvm.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.litesoftteam.mvvm.R
import com.litesoftteam.mvvm.util.extensions.inflateView

class ProgressDialog : BaseDialog() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = inflateView(R.layout.dialog_progress, null)

        val dialog = AlertDialog.Builder(requireContext())
                .setView(view)
                .create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    fun show(manager: FragmentManager) {
        super.show(manager, ProgressDialog::class.simpleName)
    }
}