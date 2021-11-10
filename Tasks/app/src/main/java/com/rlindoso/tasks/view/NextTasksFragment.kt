package com.rlindoso.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rlindoso.tasks.R
import com.rlindoso.tasks.viewmodel.NextTasksViewModel

class NextTasksFragment : Fragment() {

    private lateinit var mViewModel: NextTasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(NextTasksViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_next_tasks, container, false)

        return root
    }
}
