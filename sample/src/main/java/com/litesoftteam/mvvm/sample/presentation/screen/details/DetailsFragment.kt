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