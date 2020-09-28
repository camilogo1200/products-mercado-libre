package com.mercadolibre.camilogo1200.products.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.products.R
import kotlinx.android.synthetic.main.sites_item_layout.view.*

class SitesAdapter(private val listener: (Site) -> Unit) :
    RecyclerView.Adapter<SitesAdapter.SitesViewHolder>() {

    private var sitesList = listOf<Site>()

    class SitesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sites_item_layout, parent, false)
        return SitesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SitesViewHolder, position: Int) {
        val site = sitesList[position]
        with(holder) {
            itemView.sites_country_flag_title.text = site.name
            itemView.setOnClickListener { listener(site) }
        }
    }

    override fun getItemCount(): Int {
        return sitesList.count()
    }

    fun setDataList(lSites: List<Site>) {
        sitesList = lSites
        notifyDataSetChanged()
    }

}