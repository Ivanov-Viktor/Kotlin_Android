package com.example.fullcovid19.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fullcovid19.R
import com.example.fullcovid19.data.CovidRepository
import kotlinx.android.synthetic.main.fragment_global.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class GlobalFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = CovidRepository()

        launch {
            val summary = repository.getSummary().await()

            loader.visibility = View.GONE
            data.visibility = View.VISIBLE

            summary?.let { it ->
                it.global?.let {
                    newConfirmed.text =
                        getString(R.string.new_confirmed_template).format(it.newConfirmed)
                    newDeaths.text = getString(R.string.new_deaths_template).format(it.newDeaths)
                    newRecovered.text =
                        getString(R.string.new_recovered_template).format(it.newRecovered)
                    totalConfirmed.text =
                        getString(R.string.total_confirmed_template).format(it.totalConfirmed)
                }

                countriesList.adapter = CountriesGlobalDataAdapter(it.countries)
            }
        }
    }
}