package com.example.neco_recycleview_my2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.inflate
import com.example.neco_recycleview_my2.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    val plant_list = ArrayList<Plant>()  // Список

    class PlantHolder(item : View) : RecyclerView.ViewHolder(item)  {

        val binding = PlantItemBinding.bind(item)

        fun bind(plant: Plant) = with(binding) {
            im.setImageResource(plant.imageId)
            tvTitle.text= plant.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }


    override fun onBindViewHolder(holder: PlantHolder, position: Int) {

        holder.bind(plant_list[position])
    }

    override fun getItemCount(): Int {
        return plant_list.size
    }

    fun addPlant(plant: Plant) {
        plant_list.add(plant)
        notifyDataSetChanged()
    }
}