package com.mercadolibre.camilogo1200.products.ui.fragments

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mercadolibre.camilogo1200.products.R
import com.mercadolibre.camilogo1200.products.databinding.FragmentSplashScreenBinding
import com.mercadolibre.camilogo1200.utils.makeVisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment() {

    private lateinit var _binding: FragmentSplashScreenBinding
    private val alphaFadeInAnimation: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.splash_screen_animation_01
        )
    }

    private val TIME_BOX_ANIMATION = 1000L
    private val SPLASH_SCREEN_ANIMATION_DURATION = 3500L
    private val SPLASH_SCREEN_CHILDREN_ANIMATION_DURATION = 2500L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        startAppIntroAnimation()
        return _binding.root
    }

    private fun startAppIntroAnimation() {

        lifecycleScope.launch(Dispatchers.Main) {
            val transition: TransitionDrawable = _binding.root.background as TransitionDrawable
            transition.startTransition(SPLASH_SCREEN_ANIMATION_DURATION.toInt())
            delay(TIME_BOX_ANIMATION)
            with(_binding) {
                main.children.asIterable().onEach { view ->
                    view.apply {
                        animation = alphaFadeInAnimation
                        animation.duration = SPLASH_SCREEN_CHILDREN_ANIMATION_DURATION
                    }
                }.also {
                    it.onEach { children -> children.makeVisible() }
                }
                delay(SPLASH_SCREEN_ANIMATION_DURATION)
            }
            findNavController().navigate(R.id.action_splashScreenFragment_to_sitesListFragment)
        }
    }
}
