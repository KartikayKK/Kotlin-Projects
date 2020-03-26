package com.kkapp.recyclerview

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_expandable_header.*

class expandable_headerClass(private val title:String)
    : Item(),ExpandableItem{

    private lateinit var expendableGroup:ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    viewHolder.item_expandable_header_title.text=title
    viewHolder.item_expandable_header_icon.setImageResource(getrotatedresid())
    viewHolder.item_expandable_header_root.setOnClickListener {
        expendableGroup.onToggleExpanded()
        viewHolder.item_expandable_header_icon.setImageResource(getrotatedresid())
    }
    }

    override fun getLayout() =R.layout.item_expandable_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
expendableGroup=onToggleListener
    }
    private fun getrotatedresid()=
        if (expendableGroup.isExpanded)
            R.drawable.ic_keyboard_arrow_up_black_24dp
        else
            R.drawable.ic_keyboard_arrow_down_black_24dp

}