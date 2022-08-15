package com.example.pizzaapp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.pizzaapp3.R
import com.example.pizzaapp3.databinding.CartItemListBinding
import com.example.pizzaapp3.model.CartItems
import com.example.pizzaapp3.util.PizzaURL

class CartItemListAdapter(
    private var cartItemArrayList : ArrayList<CartItems>
):RecyclerView.Adapter<CartItemListAdapter.CartItemListHolder>() {
    inner class CartItemListHolder(private val binding: CartItemListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cartItems: CartItems){
            binding.tvCartPizzaName.text =  cartItems.pizzaName
            binding.tvCartPizzaPrice.text = cartItems.pizzaPrice
            binding.tvCartPizzaQuantity.text = cartItems.pizzaQuantity
            binding.imgCartPizza.load(PizzaURL.pizzaUrls.random()){
                crossfade(true)
                placeholder(R.drawable.chicken_mushroom_pizza)
                size(175, 150)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartItemListAdapter.CartItemListHolder {
        return CartItemListHolder(
            CartItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartItemListAdapter.CartItemListHolder, position: Int) {
        holder.bind(cartItemArrayList[position])
    }

    override fun getItemCount(): Int {
        return cartItemArrayList.size
    }
}