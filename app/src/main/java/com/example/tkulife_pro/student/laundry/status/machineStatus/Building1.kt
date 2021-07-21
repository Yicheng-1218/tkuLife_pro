package com.example.tkulife_pro.student.laundry.status.machineStatus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tkulife_pro.databinding.FragmentBuilding1Binding
import com.example.tkulife_pro.student.laundry.status.SharedViewModel

class Building1 : Fragment(){

    private lateinit var binding: FragmentBuilding1Binding
    private lateinit var viewModel: SharedViewModel
    private lateinit var viewAdapter: StatusAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBuilding1Binding.inflate(layoutInflater)

        return binding.root
        initView()
    }

    private fun initView(){
        viewAdapter=StatusAdapter()
    }

    private fun setRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        viewModel.getRealtimeData().observe(viewLifecycleOwner,{ data->
//            TODO UPDATE UI ON HERE

        })
    }



}