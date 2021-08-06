package com.example.tkulife_pro.admin.packageManagement

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tkulife_pro.databinding.PackageItemBinding
import org.json.JSONArray
import org.json.JSONObject

class RecordAdapter(private val mode:Int) : RecyclerView.Adapter<RecordAdapter.ViewHolder>() {
    private lateinit var binding : PackageItemBinding
    lateinit var packageList : ArrayList<HashMap<*,*>>
    class ViewHolder(val view: PackageItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding= PackageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(mode){
            0->{
                setViewText(packageList,position,holder)
            }
            1->{
                setViewText(sortByTaken(true,packageList),position,holder)
            }
            2->{
                setViewText(sortByTaken(false,packageList),position,holder)
            }
        }
    }


    override fun getItemCount(): Int {
        var len=0
        when(mode){
            0->{
                len= packageList.size
            }
            1->{
                len= sortByTaken(true,packageList).size
            }
            2->{
                len= sortByTaken(false,packageList).size
            }
        }
        return len
    }

    @SuppressLint("SetTextI18n")
    private fun setViewText(list:ArrayList<HashMap<*,*>>, position: Int, holder: ViewHolder){
        val pkg=list[(list.size-1)-position]
        when(pkg["taken"]){
            true->{
                holder.view.textView33.apply {
                    text="已領"
                    setTextColor(Color.parseColor("#0099e5"))
                }
            }
            false->{
                holder.view.textView33.apply {
                    text="未領"
                    setTextColor(Color.parseColor("#ff4c4c"))
                }
            }
        }
        holder.view.textView32.text="${pkg["roomID"]}   後三碼:${pkg["pid"]}"
    }


    private fun sortByTaken(taken:Boolean,packageList:ArrayList<HashMap<*,*>>):ArrayList<HashMap<*,*>>{
        return ArrayList<HashMap<*,*>>().also {
            packageList.onEach { element->
                if (element["taken"] as Boolean == taken) {
                    it.add(element)
                }
            }
        }
    }
}