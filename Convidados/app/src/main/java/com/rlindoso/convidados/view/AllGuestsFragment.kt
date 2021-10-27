package com.rlindoso.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rlindoso.convidados.databinding.FragmentAllBinding
import com.rlindoso.convidados.view.adapter.GuestAdapter
import com.rlindoso.convidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private val mAdapter = GuestAdapter()
    private var _binding: FragmentAllBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel =
            ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // RecyclerView
        // 1 - Obter a recycler
        val recycler = binding.recyclerAllGuests

        // 2 - Definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        // 3 - Definir um adapter
        recycler.adapter = mAdapter

        observer()
        allGuestsViewModel.load()

        return root
    }

    private fun observer() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, {
            mAdapter.updateGuests(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}