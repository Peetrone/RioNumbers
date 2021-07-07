package com.k.riopicker

/**
 *Create by Petr on 30.06.2021
 */
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class SnapOnScrollListener(
    private val snapHelper: SnapHelper,
    private var behavior: Behavior = Behavior.NOTIFY_ON_SCROLL,
    private var onSnapPositionChangeListener: OnSnapPositionChangeListener? = null
) : RecyclerView.OnScrollListener() {

    enum class Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    private var snapPosition = RecyclerView.NO_POSITION

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (behavior == Behavior.NOTIFY_ON_SCROLL) {
            maybeNotifySnapPositionChange(recyclerView)
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        if (behavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE
            && newState == RecyclerView.SCROLL_STATE_IDLE) {
            maybeNotifySnapPositionChange(recyclerView)
        }
    }

    private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        val snapPositionChanged = this.snapPosition != snapPosition
        if(recyclerView.id == R.id.recycler_view_1) {
            if (snapPositionChanged) {
                onSnapPositionChangeListener?.onSnapPositionChange1(snapPosition)
                this.snapPosition = snapPosition
            }
        }
        if(recyclerView.id == R.id.recycler_view_2) {
            if (snapPositionChanged) {
                onSnapPositionChangeListener?.onSnapPositionChange2(snapPosition)
                this.snapPosition = snapPosition
            }
        }
        if(recyclerView.id == R.id.recycler_view_3) {
            if (snapPositionChanged) {
                onSnapPositionChangeListener?.onSnapPositionChange3(snapPosition)
                this.snapPosition = snapPosition
            }
        }
        if(recyclerView.id == R.id.recycler_view_4) {
            if (snapPositionChanged) {
                onSnapPositionChangeListener?.onSnapPositionChange4(snapPosition)
                this.snapPosition = snapPosition
            }
        }
    }
}