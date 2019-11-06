package com.example.statsdontlie.screens.details


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayerDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentPlayerDetailBinding

    private lateinit var detailFragmentArgs: DetailFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player_detail, container, false)

        val playerDetail = binding.playerDetailText.text.toString()
        detailFragmentArgs = DetailFragmentArgs.Builder(
            playerDetail
        ).build()

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            menu.findItem(R.id.share).apply {
                isVisible = false
            }
        }
    }

    private fun getShareIntent(): Intent {
        return Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, detailFragmentArgs.playerDetail)
        }
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
