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
    private lateinit var viewModel: CatListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        /*TODO Attach your "viewModel" in xml to the "CatListView"*/

        viewModel =ViewModelProviders.of(this).get(CatListView::class.java)
        binding.meow = viewModel


        /*TODO Setup data binding observers for name, cuteCount, notCuteCount and isListCompleted (see the slides for details on how to do it)*/

        val nameObserver= Observer<String> {name->
            binding.catName.text = name
        }
        val notCuteCountObserver = Observer<Int>{ notC ->
            binding.notCuteScore.text = getString(R.string.cute_score, notC)
        }
        val cuteCountObserver = Observer<Int>{ cuteC ->
            binding.cuteScore.text = getString(R.string.cute_score, cuteC)
        }

        val isListCompletedObserver = Observer<Boolean>{ completed ->
            if (completed) {
                findNavController().navigate(R.id.moveToFinal)
                viewModel.setupList()
            }
        }

        viewModel.name.observe(this, nameObserver)
        viewModel.cuteCount.observe(this, cuteCountObserver)
        viewModel.notCuteCount.observe(this, notCuteCountObserver)
        viewModel.isListCompleted.observe(this,isListCompletedObserver )



        binding.lifecycleOwner = this

        return binding.root
    }


}
