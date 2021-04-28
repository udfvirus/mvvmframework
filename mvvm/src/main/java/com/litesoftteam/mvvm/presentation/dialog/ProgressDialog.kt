/*
 * Copyright (C) 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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