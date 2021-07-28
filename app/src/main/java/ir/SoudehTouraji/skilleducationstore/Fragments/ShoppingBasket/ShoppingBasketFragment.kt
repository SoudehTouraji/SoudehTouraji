package ir.SoudehTouraji.skilleducationstore.Fragments.ShoppingBasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.SoudehTouraji.skilleducationstore.databinding.FragmentProfileBinding
import ir.SoudehTouraji.skilleducationstore.databinding.FragmentShoppingBasketBinding

class ShoppingBasketFragment:Fragment() {
    private lateinit var binding: FragmentShoppingBasketBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentShoppingBasketBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}