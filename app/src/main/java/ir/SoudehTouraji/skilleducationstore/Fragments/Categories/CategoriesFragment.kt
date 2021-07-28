package ir.SoudehTouraji.skilleducationstore.Fragments.Categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.SoudehTouraji.skilleducationstore.databinding.FragmentCategoriesBinding

class CategoriesFragment:Fragment() {
    private lateinit var binding:FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCategoriesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}