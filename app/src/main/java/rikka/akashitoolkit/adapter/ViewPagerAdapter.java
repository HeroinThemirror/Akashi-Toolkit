package rikka.akashitoolkit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rikka on 2016/3/6.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Class> mClasses = new ArrayList<>();
    private final Map<Integer, Fragment> mFragment = new HashMap<>();
    private final List<String> mTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Class c, String title) {
        mClasses.add(c);
        mTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragment.get(position);
        if (fragment != null) {
            return fragment;
        } else {
            try {
                fragment = (Fragment) mClasses.get(position).newInstance();
                mFragment.put(position, fragment);
                return fragment;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
