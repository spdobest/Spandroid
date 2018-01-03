package spandroid.dev.common;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class FragmentUtilsMain {

	public static String TAG = FragmentUtilsMain.class.getSimpleName();

	private Fragment          fragment;
	private AppCompatActivity appcompatActivity;
	private Toast             toast;
	private ProgressDialog    myProgressDialog;

	private FragmentManager fragmentManager;
	private boolean isFromSetupTracker = false;

	public FragmentUtilsMain( Fragment fragment) {
		this.fragment = fragment;
		this.appcompatActivity = (AppCompatActivity ) fragment.getActivity();
		fragmentManager = getFragmentManager();
	}

	public FragmentUtilsMain( AppCompatActivity activity) {
		this.appcompatActivity = activity;
		fragmentManager = getFragmentManager();
	}


	public void popBackStack() {
		if (fragmentManager != null) {
			fragmentManager.popBackStackImmediate();
		}
	}

	public void popBackStack(String tag) {
		popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
	}

	public void popBackStack(String tag, int flags) {
		if (fragmentManager != null) {
			fragmentManager.popBackStackImmediate(tag, flags);
		}
	}

	public void startFragment(Fragment fragment, int containerId, boolean backStack, boolean isGAOn) {
		this.startFragmentWithTag(fragment, containerId, backStack, null, isGAOn);
	}

	public void startFragment(Fragment fragment, int containerId, boolean backStack) {
		startFragment(fragment, containerId, backStack, true);
	}

	public void startFragmentWithTag(Fragment fragment, int containerId, boolean addToBackStack, String backStackTag, boolean isGAOn) {

		String name = ((Object) fragment).getClass().getSimpleName();
		startFragmentInternal(fragment, containerId, addToBackStack, backStackTag, name, true, isGAOn);
	}

	
	private void startFragmentInternal(Fragment fragment, Integer containerId, boolean backStack, String backStackTag, String name,
									   boolean replace, boolean isGAOn) {

		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		if (containerId != null) {
			View v = this.appcompatActivity.findViewById(containerId);

			if (v == null)
				return;
		}

		if (replace) {
			if (containerId == null) {
				return;
			}

			fragmentTransaction.replace(containerId, fragment, name);
		} else {
			if (containerId != null) {
				fragmentTransaction.add(containerId, fragment, name);
			} else {
				fragmentTransaction.add(fragment, name);
			}
		}

		if (backStack) {
			fragmentTransaction.addToBackStack(backStackTag);
		}

		fragmentTransaction.commitAllowingStateLoss();
		
	
	}

	/*
	 * public void startFragment(Fragment fragment, int containerId, boolean
	 * backStack, String name,boolean isGAOn) {
	 * 
	 * startFragmentInternal(fragment, containerId, backStack, null, name,
	 * true,isGAOn); }
	 */
	public void startFragmentAdd(Fragment fragment, int containerId, boolean backStack, boolean isGAOn) {

		String name = ((Object) fragment).getClass().getSimpleName();
		startFragmentAdd(fragment, containerId, backStack, name, isGAOn);
	}

	public void startFragmentAdd(Fragment fragment, int containerId, boolean backStack, String name, boolean isGAOn) {

		startFragmentInternal(fragment, containerId, backStack, null, name, false, isGAOn);
	}

	/*
	 * public void startFragment(Fragment fragment, boolean backStack,boolean
	 * isGAOn) { startFragmentInternal(fragment, null, backStack, null, null,
	 * false,isGAOn); }
	 */



	public void replaceFragment(Fragment fragment, int containerId, boolean backStack, boolean isGAOn) {

		String name = ((Object) fragment).getClass().getSimpleName();
		startFragmentInternal(fragment, containerId, backStack, null, name, true, isGAOn);
	}

	public Fragment getFragmentFromStack(String tag) {
		return fragmentManager.findFragmentByTag(tag);

	}

	public FragmentTransaction getFragmentTransaction() {
		return fragmentManager.beginTransaction();
	}

	public void removeFragment() {
		getFragmentTransaction().remove(fragment).commitAllowingStateLoss();
	}

	public String getCurrentFragmentName() {
		if (fragmentManager.getBackStackEntryCount() != 0) {
			return fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
		} else {
			return "";
		}

	}

	public Fragment getCurrentFragment() {
		return fragmentManager.findFragmentByTag(getCurrentFragmentName());
	}

	public void removeFragment(Fragment fragment) {
		getFragmentTransaction().remove(fragment).commitAllowingStateLoss();
	}



	public void removeFragmentIfExsits(String simpleName) {
		Fragment fragment = getFragmentFromStack(simpleName);
		if (fragment != null) {
			removeFragment(fragment);
		}
	}

	public void setFragmentManager(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}



	public FragmentManager getFragmentManager() {
		return appcompatActivity.getFragmentManager();
	}

	public int getBackStackEntryCount() {
		return getFragmentManager().getBackStackEntryCount();
	}



	public static String getResponse(String responcecode, String message) {
		String res = "";
		boolean hascode = false, hasmessage = false;

		if (!TextUtils.isEmpty(responcecode))
			hascode = true;

		if (!TextUtils.isEmpty(message))
			hasmessage = true;

		if (hascode && hasmessage)
			res += "(" + responcecode + "," + message + ")";
		else if (hascode)
			res += "(" + responcecode + ")";
		else if (hasmessage)
			res += "(" + message + ")";

		return res;
	}

	public static String getResponse(String responce, String responcecode, String message) {
		String res = responce;
		res += getResponse(responcecode, message);
		return res;
	}
	
	
	/*public void switchFragment(Fragment fragment,Activity activity,boolean backstack) {
		if (activity == null)
			return;

		if (activity instanceof CharlieSlidingMenu) {
			CharlieSlidingMenu ra = (CharlieSlidingMenu) activity;
			ra.switchContent(fragment, backstack);
		}
	}*/

	public void replaceFragment (Fragment fragment, int container){
		String backStateName = fragment.getClass().getName();

		Log.i(TAG, "replaceFragment: "+backStateName);

		FragmentManager manager = getFragmentManager();
		boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);
		Log.i(TAG, "replaceFragment: "+fragmentPopped);
		if (!fragmentPopped){ //fragment not in back stack, create it.
			FragmentTransaction ft = manager.beginTransaction();
			ft.replace(container, fragment);
			ft.addToBackStack(backStateName);
			ft.commit();
		}
	}
}
