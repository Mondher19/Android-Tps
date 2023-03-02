package com.example.cvv2part3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [experience.newInstance] factory method to
 * create an instance of this fragment.
 */
class experience : Fragment() {

    private lateinit var newrecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<items_exp>
    private lateinit var startdatexp: Array<String>
    private lateinit var enddatexp: Array<String>
    private lateinit var cuntryexp: Array<String>
    private lateinit var Nameexp: Array<String>
    private lateinit var imageViewexp: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_experience, container, false)

        imageViewexp = arrayOf(
            R.drawable.ic_logo_esprit,
            R.drawable.ic_logo_facebook,
            R.drawable.ic_logo_amazon
        )

        Nameexp = arrayOf(
            "Esprit",
            "Facebook",
            "Amazon"
        )

        cuntryexp = arrayOf(
            "Tunisia",
            "USA",
            "France"
        )

        startdatexp = arrayOf(
            "12/02/2023",
            "12/02/2024",
            "12/02/2025"
        )

        enddatexp = arrayOf(
            "Today",
            "12/02/2026",
            "12/02/2027"
        )

        newrecyclerView = view.findViewById(R.id.recyclerviewexperience)
        newrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newrecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()

        return view
    }

    private fun getUserdata() {
        for (i in imageViewexp.indices) {
            val exp = items_exp(
                Nameexp[i],
                cuntryexp[i],
                imageViewexp[i],
                startdatexp[i],
                enddatexp[i]
            )
            newArrayList.add(exp)
        }
        newrecyclerView.adapter = Adapter_exp(newArrayList)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            experience().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}