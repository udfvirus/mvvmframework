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
package com.litesoftteam.mvvm.sample.presentation.screen.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.Characteristic
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import com.litesoftteam.mvvm.sample.presentation.adapter.CharacteristicsAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.DetailsViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val model by viewModel<DetailsViewModel>()

    private var characteristicsAdapter: CharacteristicsAdapter? = null

    private val logger = LoggerFactory.create(this.javaClass)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        val menuId = requireArguments().getInt(MENU_ITEM_ID_KEY)
        model.load(menuId)
    }

    private fun initRecyclerView() {
        characteristicsAdapter = CharacteristicsAdapter()
        characteristicsRecyclerView.adapter = characteristicsAdapter
    }

    override fun initObservers() {
        super.initObservers()
        observeEventWithProgress(model.characteristicsLiveData, object : EventWithSuccessAndError<List<Characteristic>> {

            override fun success(value: List<Characteristic>) {
                logger.d("Characteristics: $value")
                characteristicsAdapter?.addItems(value)
            }

            override fun error(throwable: Throwable) {
                logger.d("Throwable: $throwable")
            }
        })
    }


    companion object {

        private const val MENU_ITEM_ID_KEY = "MENU_ITEM_ID_KEY"

        fun newInstance(item: MenuItem) = DetailsFragment().apply {
            arguments = bundleOf(MENU_ITEM_ID_KEY to item.id)
        }
    }
}