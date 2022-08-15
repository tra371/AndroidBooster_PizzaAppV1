package com.example.pizzaapp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pizzaapp3.R
import com.example.pizzaapp3.databinding.PromotionListBinding
import com.example.pizzaapp3.model.PromotionPizza

class PromotionAdapter(
    private val promotionPizzaList: ArrayList<PromotionPizza>
): RecyclerView.Adapter<PromotionAdapter.PromotionHolder>() {
    inner class PromotionHolder(private val binding: PromotionListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(PromotionPizza: PromotionPizza){
            binding.tvPromotionText.text = PromotionPizza.promotion_text
            binding.tvPromotionPrice.text = PromotionPizza.promotion_price
            binding.tvPromotionOriginalPrice.text = PromotionPizza.promotion_original_price
            binding.tvPromotionDeadLine.text = PromotionPizza.promotion_expire
            binding.imgPromotionPizza.load(PromotionPizza.promotion_pizza_pic){
                crossfade(true)
                placeholder(R.mipmap.img_promotion_pizza_background)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionHolder {
        return PromotionHolder(
            PromotionListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PromotionHolder, position: Int) {
        holder.bind(promotionPizzaList[position])
    }

    override fun getItemCount(): Int {
        return promotionPizzaList.size
    }
}