package ru.apps65.testtask.navigation.routers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.apps65.testtask.MainActivity
import ru.apps65.testtask.R

class AnimatedAppNavigator(
	activity: MainActivity,
	containerId: Int
) : AppNavigator(activity, containerId) {

	override fun setupFragmentTransaction(
		screen: FragmentScreen,
		fragmentTransaction: FragmentTransaction,
		currentFragment: Fragment?,
		nextFragment: Fragment
	) {
		super.setupFragmentTransaction(
			screen,
			fragmentTransaction.setCustomAnimations(
				R.anim.fade_id,
				R.anim.fade_out,
				R.anim.fade_id,
				R.anim.fade_out
			),
			currentFragment,
			nextFragment
		)
	}
}