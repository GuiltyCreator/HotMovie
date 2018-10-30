package com.example.a7279.mvvmtestrxjavaretrofit.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DataBindingRecyclerViewAdapter(
     var mContext: Context,
     var mLayoutId: Int,
     var mVarId: Int,
     var mData: MutableList<*>
) : RecyclerView.Adapter<DataBindingRecyclerViewAdapter.DataBindingViewHolder>() {
     var haveHeader = false
     var haveFooter = false
    var headerView: View?=null
    var footerView: View? = null
    private var itemClickListener: ItemClickListener? = null
     var onBindingViewHolderListener: OnBindingViewHolderListener?=null

    val allData: List<*>
        get() = mData

    fun setOnItemCkickListener(listener: ItemClickListener) {
        this.itemClickListener = listener
    }



     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        when (viewType) {
            TYPE_HEADER -> return DataBindingViewHolder(headerView, viewType)
            TYPE_FOOTER -> return DataBindingViewHolder(footerView, viewType)
            TYPE_NORMAL -> return DataBindingViewHolder(
                LayoutInflater.from(mContext).inflate(mLayoutId, parent, false),
                viewType
            )
            else -> return DataBindingViewHolder(
                LayoutInflater.from(mContext).inflate(mLayoutId, parent, false),
                viewType
            )
        }

    }

    override fun onBindViewHolder(holder: DataBindingRecyclerViewAdapter.DataBindingViewHolder, position: Int) {
        when (holder.viewType) {
            TYPE_HEADER -> {
            }
            TYPE_FOOTER -> {
            }
            TYPE_NORMAL -> {
                val binding = DataBindingUtil.bind<ViewDataBinding>(holder.itemView)
                val data: Any?
                if (haveHeader) {
                    data = mData[position - 1]
                } else {
                    data = mData[position]
                }

                if (itemClickListener != null) {
                    holder.itemView.setOnClickListener { itemClickListener!!.itemClick(holder.itemView, position) }
                }

                binding!!.setVariable(mVarId, data)
                binding.executePendingBindings()
                if (onBindingViewHolderListener != null) {
                    onBindingViewHolderListener!!.onHolderBinding(holder, position)
                }
            }
            else -> {
                val binding = DataBindingUtil.bind<ViewDataBinding>(holder.itemView)
                val data: Any?
                if (haveHeader) {
                    data = mData[position - 1]
                } else {
                    data = mData[position]
                }
                if (itemClickListener != null) {
                    holder.itemView.setOnClickListener { itemClickListener!!.itemClick(holder.itemView, position) }
                }
                binding!!.setVariable(mVarId, data)
                binding.executePendingBindings()
                if (onBindingViewHolderListener != null) {
                    onBindingViewHolderListener!!.onHolderBinding(holder, position)
                }
            }
        }

    }

    /**
     * 调用之后请调用NotifyDataSetChange 如果在setAdapter之后
     * @param view
     */
    fun addFooterView(view: View) {
        haveFooter = true
        footerView = view
    }

    /**
     * 调用之后请调用NotifyDataSetChange 如果在setAdapter之后
     * @param view
     */
    fun addHeaderView(view: View) {
        haveHeader = true
        headerView = view
    }

    fun removeFooterView() {
        footerView = null
        haveFooter = false
    }

    fun cleanData() {
        mData.clear()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        var extraCount = 0
        if (haveHeader) {
            extraCount++
        } else if (haveFooter) {
            extraCount++
        }
        return mData.size + extraCount
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 && haveHeader) {
            TYPE_HEADER
        } else if (position == mData.size && haveFooter) {
            TYPE_FOOTER
        } else {
            TYPE_NORMAL
        }
    }

    inner class DataBindingViewHolder(itemView: View?, internal var viewType: Int) : RecyclerView.ViewHolder(itemView)

    interface ItemClickListener {
        fun itemClick(view: View, position: Int)
    }

    interface OnBindingViewHolderListener {
        fun onHolderBinding(holder: DataBindingViewHolder, position: Int)
    }

    companion object {
        val TYPE_HEADER = 1
        val TYPE_FOOTER = 2
        val TYPE_NORMAL = 0
    }
}
