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
 * Use the [Education.newInstance] factory method to
 * create an instance of this fragment.
 */
class Education : Fragment() {

    private lateinit var newrecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<item_edu>
    private lateinit var startdatedu: Array<String>
    private lateinit var enddatedu: Array<String>
    private lateinit var cuntryedu: Array<String>
    private lateinit var placeedu: Array<String>
    private lateinit var imageViewedu: Array<Int>



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_experience, container, false)

        imageViewedu = arrayOf(
            R.drawable.ic_logo_cambridge ,
            R.drawable.ic_logo_oxford,
            R.drawable.ic_logo_stanford,
            R.drawable.ic_logo_massachusetts
        )

        placeedu = arrayOf(
            "massachusetts",
            "oxford",
            "stanford",
            "cambridge"
        )

        cuntryedu = arrayOf(
            "United States",
            "United kingdom",
            "United States",
            "United kingdom"
        )

        startdatedu = arrayOf(
            "01/09/2020",
            "01/09/2018",
            "01/09/2016",
            "01/09/2014"

        )

        enddatedu = arrayOf(
            "Today",
            "31/08/2020",
            "31/08/2018",
            "31/08/2016"
        )

        newrecyclerView = view.findViewById(R.id.recyclerviewexperience)
        newrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newrecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()

        return view
    }

    private fun getUserdata() {
        for (i in imageViewedu.indices) {
            val edu = item_edu(
                placeedu[i],
                cuntryedu[i],
                imageViewedu[i],
                startdatedu[i],
                enddatedu[i]
            )
            newArrayList.add(edu)
        }
        newrecyclerView.adapter = Adapter_edu(newArrayList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Education.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Education().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}