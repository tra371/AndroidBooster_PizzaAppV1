package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp3.adapter.CartItemListAdapter
import com.example.pizzaapp3.databinding.ActivityCartBinding
import com.example.pizzaapp3.model.CartItems


class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private var pizzaName:String = ""
    private var pizzaIngredients:String = ""
    private var pizzaPrice:String = ""
    private var pizzaQuantity:String = ""
    private var pizzaCrust:String = ""
    private var pizzaPic:Int = 0
    private var cartItemsList: ArrayList<CartItems> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pizzaName = intent.getStringExtra("pizzaName").toString()
        pizzaIngredients = intent.getStringExtra("pizzaIngredients").toString()
        pizzaPrice = intent.getStringExtra("pizzaPrice").toString()
        pizzaQuantity = intent.getStringExtra("pizzaQuantity").toString()
        pizzaPic = intent.getIntExtra("pizzaPic", R.id.img_pizza_pic_detail)

        cartItemsList.add(
            CartItems(
                pizzaName,
                pizzaQuantity,
                pizzaPic,
                pizzaPrice
            )
        )
        val cartItemListAdapter = CartItemListAdapter(cartItemsList)

        binding.pizzaCart.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = cartItemListAdapter
        }

        binding.bottomNavigationCart.selectedItemId = R.id.shoppingCart

        binding.bottomNavigationCart.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    val intent = Intent(this@CartActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
                R.id.shoppingCart->{
                }
                R.id.account->{
                    val intent = Intent(this@CartActivity, AccountActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
            }
            true
        }
    }
}