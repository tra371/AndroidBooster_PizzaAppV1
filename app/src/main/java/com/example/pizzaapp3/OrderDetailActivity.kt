package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import coil.load
import com.example.pizzaapp3.databinding.ActivityOrderDetailBinding
import com.example.pizzaapp3.util.PizzaMenuMock

class OrderDetailActivity : AppCompatActivity() {
    private var pizzaName:String = ""
    private var pizzaIngredients:String = ""
    private var pizzaPrice:String = ""
    private var pizzaPic:Int = 0
    private var quantity:Int = 0
    private lateinit var binding: ActivityOrderDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras:Intent = intent
        pizzaName = extras.getStringExtra("pizzaName").toString()
        pizzaIngredients = extras.getStringExtra("pizzaIngredients").toString()
        pizzaPrice = extras.getStringExtra("pizzaPrice").toString()
        pizzaPic = extras.getIntExtra("pizzaPic", R.drawable.chicken_mushroom_pizza)
        binding.tvPizzaNameDetail.text = pizzaName
        binding.tvPizzaIngredientDetail.text = pizzaIngredients
        binding.tvUnitPriceDetail.text = pizzaPrice
        binding.imgPizzaPicDetail.load(pizzaPic){
            crossfade(true)
            placeholder(R.drawable.chicken_mushroom_pizza)
        }
        val numberPicker:NumberPicker = binding.npPizzaCrust
        if(numberPicker != null){
            val pizzaCrusts:Array<String> = PizzaMenuMock.crusts
            numberPicker.minValue = 0
            numberPicker.maxValue = pizzaCrusts.size - 1
            numberPicker.displayedValues = pizzaCrusts
            numberPicker.wrapSelectorWheel = true
        }

        binding.imbBackOrderDetail.setOnClickListener {
            super.finish()
        }

        val unitPrice = binding.tvUnitPriceDetail.text.toString().trim().replace("$", "").toFloat()

        binding.btnIncrement.setOnClickListener{
            quantity += 1
            binding.tvQuantity.text = quantity.toString()
            val price = unitPrice * quantity
            val formattedPrice = String.format("%.2f", price)
            binding.tvPriceDetail.text = "$$formattedPrice"
        }

        binding.btnDecrement.setOnClickListener{
            if(quantity > 0){
                quantity -= 1
                binding.tvQuantity.text = quantity.toString()
                val price = unitPrice * quantity
                val formattedPrice = String.format("%.2f", price)
                binding.tvPriceDetail.text = "$$formattedPrice"
            }
        }

        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(applicationContext, CartActivity::class.java)
            intent.putExtra("pizzaName", binding.tvPizzaNameDetail.text)
            intent.putExtra("pizzaIngredients", binding.tvPizzaIngredientDetail.text)
            intent.putExtra("pizzaQuantity", binding.tvQuantity.text)
            intent.putExtra("pizzaPrice", binding.tvPriceDetail.text)
            intent.putExtra("pizzaPic", R.drawable.chicken_mushroom_pizza)
            startActivity(intent)
        }
    }

}
