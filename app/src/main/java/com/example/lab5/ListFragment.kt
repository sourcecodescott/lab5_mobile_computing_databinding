package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lab5.databinding.FragmentListBinding
import com.example.lab5.view.CatListView

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        /*TODO Attach your "viewModel" in xml to the "CatListView"*/

        /*TODO Setup data binding observers for name, cuteCount, notCuteCount and isListCompleted (see the slides for details on how to do it)*/

        binding.lifecycleOwner = this

        return binding.root
    }


}
