package ir.SoudehTouraji.skilleducationstore.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import ir.SoudehTouraji.skilleducationstore.R
import ir.SoudehTouraji.skilleducationstore.databinding.FragmentHomeBinding

class HomeFragment:Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val imageList = ArrayList<SlideModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        addImageToSlider()
        setArrayImageToSlider()
        return binding.root
    }
    private fun addImageToSlider(){
        imageList.add(SlideModel("https://android-learn.ir/wp-content/uploads/2020/04/android-experts-1.jpg",ScaleTypes.FIT))
        imageList.add(SlideModel("https://www.aryatehran.com/wp-content/uploads/2018/02/anroid-programming-1.jpg",ScaleTypes.FIT))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQd4L1qp2iIirmUO7AHafbWu18jI_Xm1lr_Q&usqp=CAU",ScaleTypes.FIT))

    }
    private fun setArrayImageToSlider(){
        binding.sliderHome.setImageList(imageList)
    }
}