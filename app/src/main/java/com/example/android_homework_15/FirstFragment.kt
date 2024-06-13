package com.example.android_homework_15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework_15.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val wordsDao: WordsDao = (requireActivity().application as App).db.wordsDao()
                return MainViewModel(wordsDao) as T
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope
            .launch {
                binding.buttonAdd.setOnClickListener {
                    viewModel.addWord(binding.editText.text.toString(), 0)
                    recyclerView.adapter = CustomRecyclerAdapter(fillList())
                    //binding.words.text = viewModel.allWords.toString()
                }
        }.start()
        /*binding.buttonAdd.setOnClickListener {
            viewModel.addWord(binding.editText.text.toString(), 0)
            binding.words.text = viewModel.allWords.toString()
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillList(): List<Word> {
        val data = mutableListOf<Word>()
        (0..30).forEach { i -> data.add("$i element") }
        return data
    }
}

private fun <E> MutableList<E>.add(element: String) {

}

