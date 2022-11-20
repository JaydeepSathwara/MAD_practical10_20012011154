package com.jaydeepsathwara.practical_10_20012011154

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaydeepsathwara.practical_10_20012011154.databinding.UserViewDesignBinding
import java.io.Serializable

class PersonViewAdapter (private val context: Context, private val array:ArrayList<Person>):
    RecyclerView.Adapter<PersonViewAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val binding: UserViewDesignBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = UserViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        with(holder){
            with(array[position]){
                binding.textViewPhoneNo.text = this.PhoneNo
                binding.textViewName.text = this.Name
                binding.textViewEmail.text = this.EmailId
                binding.textViewAddress.text = this.Address
                val obj = this as Serializable
                binding.locationBtn.setOnClickListener {
                    Intent(this@PersonViewAdapter.context, MapsActivity::class.java).apply {
                        putExtra("Object",obj)
                        this@PersonViewAdapter.context.startActivity(this)
                    }
                    //Toast.makeText(this@PersonAdapter.context, "Clicked on "+binding.textViewName+", Location: Lat:"+this.Latitude+"Long:"+this.Longitude, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}