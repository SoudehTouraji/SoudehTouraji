package ir.SoudehTouraji.skilleducationstore.Activity.Main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Config.PROFILE
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Fragments.Categories.CategoriesFragment
import ir.SoudehTouraji.skilleducationstore.Fragments.Home.HomeFragment
import ir.SoudehTouraji.skilleducationstore.Fragments.Profile.ProfileFragment
import ir.SoudehTouraji.skilleducationstore.Fragments.ShoppingBasket.ShoppingBasketFragment
import ir.SoudehTouraji.skilleducationstore.R
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    //var COLOR_DESELECTED=getColor(R.color.green_caribbean)
    enum class Tabs{PROFILE,SHOPPING_BASKET,CATEGORIES,HOME}
    private  var currentTab=Tabs.HOME
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()
        defaultPage()
        setOnclickListener()
    }
    private fun defineBinding(){
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun defaultPage(){
        homeClicked()

    }
    private fun deselectTab(item:Tabs){
        when(item){
            Tabs.HOME->{
                binding.bottomNavigation.llHome.setBackgroundColor(getColor(R.color.green_caribbean))
                binding.bottomNavigation.tvHome.setTextColor(getColor(R.color.yellow_light))
                binding.bottomNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_yellow))


            }
            Tabs.CATEGORIES->{
                binding.bottomNavigation.llCategories.setBackgroundColor(getColor(R.color.green_caribbean))
                binding.bottomNavigation.ivCategories.setImageDrawable(getDrawable(R.drawable.ic_category_yellow))
                binding.bottomNavigation.tvCategories.setTextColor(getColor(R.color.yellow_light))

            }
            Tabs.SHOPPING_BASKET->{
                binding.bottomNavigation.llShoppingBasket.setBackgroundColor(getColor(R.color.green_caribbean))
                binding.bottomNavigation.ivShoppingBasket.setImageDrawable(getDrawable(R.drawable.ic_shopping_basket_yellow))
                binding.bottomNavigation.tvShoppingBasket.setTextColor(getColor(R.color.yellow_light))

            }
            Tabs.PROFILE->{
                binding.bottomNavigation.llProfile.setBackgroundColor(getColor(R.color.green_caribbean))
                binding.bottomNavigation.ivProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_yellow))
                binding.bottomNavigation.tvProfile.setTextColor(getColor(R.color.yellow_light))

            }
        }

    }
    private fun profileClicked(){
        deselectTab(currentTab)
        currentTab=Tabs.PROFILE
        binding.bottomNavigation.llProfile.setBackgroundColor(getColor(R.color.yellow_light))
        binding.bottomNavigation.ivProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_green))
        binding.bottomNavigation.tvProfile.setTextColor(getColor(R.color.green_caribbean))
        changeFragment(ProfileFragment())

    }
    private fun shoppingBasketClicked(){
        deselectTab(currentTab)
        currentTab=Tabs.SHOPPING_BASKET
        binding.bottomNavigation.llShoppingBasket.setBackgroundColor(getColor(R.color.yellow_light))
        binding.bottomNavigation.ivShoppingBasket.setImageDrawable(getDrawable(R.drawable.ic_shopping_basket_green))
        binding.bottomNavigation.tvShoppingBasket.setTextColor(getColor(R.color.green_caribbean))
        changeFragment(ShoppingBasketFragment())

    }
    private fun categoriesClicked(){
        deselectTab(currentTab)
        currentTab=Tabs.CATEGORIES
        binding.bottomNavigation.llCategories.setBackgroundColor(getColor(R.color.yellow_light))
        binding.bottomNavigation.ivCategories.setImageDrawable(getDrawable(R.drawable.ic_category_green))
        binding.bottomNavigation.tvCategories.setTextColor(getColor(R.color.green_caribbean))
        changeFragment(CategoriesFragment())

    }

    private fun homeClicked(){
        deselectTab(currentTab)
        currentTab=Tabs.HOME
        binding.bottomNavigation.llHome.setBackgroundColor(getColor(R.color.yellow_light))
        binding.bottomNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_green))
        binding.bottomNavigation.tvHome.setTextColor(getColor(R.color.green_caribbean))
        changeFragment(HomeFragment())

    }
    private fun setOnclickListener(){
        binding.bottomNavigation.llProfile.setOnClickListener {
          profileClicked()
        }
        binding.bottomNavigation.llShoppingBasket.setOnClickListener {
            shoppingBasketClicked()
        }
        binding.bottomNavigation.llCategories.setOnClickListener {
            categoriesClicked()
        }
        binding.bottomNavigation.llHome.setOnClickListener {
            homeClicked()
        }

    }
}