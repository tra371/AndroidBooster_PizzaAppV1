package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp3.adapter.PizzaMenuAdapter
import com.example.pizzaapp3.adapter.PromotionAdapter
import com.example.pizzaapp3.databinding.ActivityMainBinding
import com.example.pizzaapp3.model.PizzaMenu
import com.example.pizzaapp3.util.PizzaMenuMock
import com.example.pizzaapp3.util.PromotionPizzaMock

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pizzaMenuAdapter: PizzaMenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchPizza.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrBlank()){
                    binding.pizzaList.visibility = View.VISIBLE
                }else{
                    binding.pizzaList.visibility = View.GONE

                }
                filterList(newText)
                return true
            }
        })

        binding.bottomNavigationHome.selectedItemId = R.id.home

        binding.bottomNavigationHome.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                }
                R.id.shoppingCart->{
                    val intent = Intent(this@MainActivity, CartActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
                }
                R.id.account->{
                    val intent = Intent(this@MainActivity, AccountActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
            }
            true
        }

        binding.imbFilter.setOnClickListener{
            val filterIntent = Intent(this@MainActivity, FilterActivity::class.java)
            startActivity(filterIntent)
        }

        val promotionAdapter = PromotionAdapter(PromotionPizzaMock.PromotionPizzaList)
        binding.pizzaList.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = promotionAdapter
        }
        pizzaMenuAdapter = PizzaMenuAdapter(PizzaMenuMock.PizzaMenuList)
        binding.pizzaMenu.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pizzaMenuAdapter
        }
    }

    private fun filterList(text: String?) {
        val filteredList:ArrayList<PizzaMenu> = arrayListOf()
        for (pizza in PizzaMenuMock.PizzaMenuList){
            if (text != null) {
                if(pizza.pizzaName.lowercase().contains(text.lowercase())){
                    filteredList.add(pizza)
                }
            }
        }
        pizzaMenuAdapter.setFilteredList(filteredList)
    }
}
