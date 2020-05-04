package com.example.fullcovid19.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fullcovid19.R
import kotlinx.android.synthetic.main.fragment_navigation.*


class NavFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val countryDataFragment = CountryDataFragment()

        btnGlobalData.setOnClickListener {

            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, GlobalFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
        btnRussiaData.setOnClickListener {

            countryDataFragment.arguments = Bundle().also {
                it.putInt("key", 1)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, countryDataFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        btnUSAData.setOnClickListener {

            countryDataFragment.arguments = Bundle().also {
                it.putInt("key", 2)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, countryDataFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        btnItalyData.setOnClickListener {

            countryDataFragment.arguments = Bundle().also {
                it.putInt("key", 3)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, countryDataFragment)
                ?.addToBackStack(null)
                ?.commit()
        }

    }

}
