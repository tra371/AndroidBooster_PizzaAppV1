package com.example.pizzaapp3.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.pizzaapp3.OrderDetailActivity
import com.example.pizzaapp3.R
import com.example.pizzaapp3.databinding.MenuListBinding
import com.example.pizzaapp3.model.PizzaMenu
import com.example.pizzaapp3.util.PizzaURL
import kotlin.collections.ArrayList

class PizzaMenuAdapter(
    private var pizzaMenuArrayList: ArrayList<PizzaMenu>
):RecyclerView.Adapter<PizzaMenuAdapter.PizzaMenuHolder>() {
    inner class PizzaMenuHolder(private val binding: MenuListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pizzaMenu: PizzaMenu){
            binding.tvPizzaName.text = pizzaMenu.pizzaName
            binding.tvPizzaIngredient.text = pizzaMenu.pizzaIngredients
            binding.tvPizzaCrusts.text = pizzaMenu.pizzaCrust
            binding.tvPizzaPrice.text = pizzaMenu.pizzaPrice
            binding.imgChickenMushroomPizza.load(PizzaURL.pizzaUrls.random()){
                crossfade(true)
                placeholder(R.drawable.chicken_mushroom_pizza)
                size(100, 100)
            }

            binding.root.setOnClickListener{
                val intent = Intent(itemView.context, OrderDetailActivity::class.java)
                intent.putExtra("pizzaName", pizzaMenu.pizzaName)
                intent.putExtra("pizzaIngredients", pizzaMenu.pizzaIngredients)
                intent.putExtra("pizzaPrice", pizzaMenu.pizzaPrice)
                intent.putExtra("pizzaPic", pizzaMenu.pizzaPic)
                itemView.context.startActivity(intent)
            }
        }

    }

    fun setFilteredList(filteredList: ArrayList<PizzaMenu>){
        this.pizzaMenuArrayList = filteredList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaMenuHolder {
        return PizzaMenuHolder(
            MenuListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PizzaMenuHolder, position: Int) {
        holder.bind(pizzaMenuArrayList[position])
    }

    override fun getItemCount(): Int {
        return pizzaMenuArrayList.size
    }
}