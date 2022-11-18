package com.example.affirmations.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

// abstract is A Kotlin abstract class is similar to Java abstract class which can not be instantiated.
// This means we cannot create objects of an abstract class. However, we can inherit subclasses from a Kotlin abstract class.
// EX:    abstract fun setAge()
// extend code from abstract class RecyclerView.Adapter of type ItemAdapter.ItemViewHolder (what we created it)
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder> (){

    // itemViewHolder subclass of the RecyclerView and we pass it the view from the itemViewHolder
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    // The onCreateViewHolder()method is called by the layout manager to create new view holders for the RecyclerView (when there are no existing view holders that can be reused)
    // Remember that a view holder represents a single list item view.

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // false bcs RecyclerView add it
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ItemViewHolder(adapterLayout)
    }

    // The last method you need to override is onBindViewHolder(). This method is called by the layout manager in order to replace the contents of a list item view.
    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item = dataset[position]
       // item.stringResourceId from the datasource
       holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}