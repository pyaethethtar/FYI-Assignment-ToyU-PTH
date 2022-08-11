package com.example.toyu.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.toyu.R
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.utils.PROMOTION_30_DISCOUNT
import com.example.toyu.utils.PROMOTION_50_DISCOUNT
import com.example.toyu.utils.PROMOTION_BO_GO
import kotlinx.android.synthetic.main.viewholder_promotion.view.*

class PromotionViewHolder(itemView: View) : BaseViewHolder<ToyVO>(itemView) {

    override fun bindData(data: ToyVO) {
        when(data.promotionType){
            PROMOTION_50_DISCOUNT -> show50DiscountToy(data)
            PROMOTION_30_DISCOUNT -> show30DiscountToy(data)
            PROMOTION_BO_GO -> showBOGODiscountToy(data)
        }
    }

    private fun show50DiscountToy(data: ToyVO){
        itemView.layout.setBackgroundColor(itemView.context.resources.getColor(R.color.colorAccentYellow))
        itemView.ivDiscount.setImageDrawable(itemView.context.getDrawable(R.drawable.group56))
        Glide.with(itemView.context).load(data.imageList.first().imageUrl).into(itemView.ivToy)
    }

    private fun show30DiscountToy(data: ToyVO){
        itemView.layout.setBackgroundColor(itemView.context.resources.getColor(R.color.colorAccentPink))
        itemView.ivDiscount.setImageDrawable(itemView.context.getDrawable(R.drawable.forward))
        Glide.with(itemView.context).load(data.imageList.first().imageUrl).into(itemView.ivToy)
    }

    private fun showBOGODiscountToy(data: ToyVO){
        itemView.layout.setBackgroundColor(itemView.context.resources.getColor(R.color.colorAccentBlue))
        itemView.ivDiscount.setImageDrawable(itemView.context.getDrawable(R.drawable.group56))
        Glide.with(itemView.context).load(data.imageList.first().imageUrl).into(itemView.ivToy)
    }
}