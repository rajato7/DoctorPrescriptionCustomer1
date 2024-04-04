package com.example.doctorprescriptioncustomer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorprescriptioncustomer.R
import com.example.doctorprescriptioncustomer.clickInterface.ClickInterface
import com.example.doctorprescriptioncustomer.clickInterface.ClickType
import com.example.doctorprescriptioncustomer.databinding.RequestListItemBinding
import com.example.doctorprescriptioncustomer.models.PrescriptionModel

class MyRequestsAdapter(var context: Context, var arrayList: ArrayList<PrescriptionModel>, var clicklistener: ClickInterface):RecyclerView.Adapter<MyRequestsAdapter.ViewHolder>() {

    class ViewHolder(var binding: RequestListItemBinding):RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyRequestsAdapter.ViewHolder {
        val binding=RequestListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MyRequestsAdapter.ViewHolder, position: Int) {
        holder.apply {
            binding.tvcategory.setText(arrayList[position].customerProblems)
            if (arrayList[position].doctorSolution==""){
                binding.tvStatus.setText("Pending Request")

            }else{
                binding.tvStatus.setText("Responded" )
                binding.tvStatus.setBackgroundColor(0xFF00FF00.toInt())
            }
            Glide
                .with(context)
                .load(arrayList[position].customerImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imgCandle)

            binding.llcatItemView.setOnClickListener {
                clicklistener.onClick(position, ClickType.ViewClick,binding.imgCandle)
            }
            binding.imgDelete.setOnClickListener {
                clicklistener.onClick(position,ClickType.Delete,binding.imgDelete)
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

//    interface imageSetting {
//        fun setImage(position: Int,imageView: ImageView)
//    }
}