package com.example.ivan.wallpapermanagerchw18;

import android.app.WallpaperManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    PagerAdapter pagerAdapter;
    private int chw18[]={R.drawable.chw1, R.drawable.chw2, R.drawable.chw3, R.drawable.chw4,
            R.drawable.chw5, R.drawable.chw6, R.drawable.chw7, R.drawable.chw8, R.drawable.chw9,
            R.drawable.chw10 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.container);
        pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            moveTaskToBack(true);

            super.onDestroy();

            System.runFinalizersOnExit(true);
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {WallpaperManager wallpaperManager =
            WallpaperManager.getInstance(getApplicationContext());
        try {

            wallpaperManager.setResource(chw18[mViewPager.getCurrentItem()]);

            // success toast
            Context context = getApplicationContext();
            CharSequence text = "Обои успешно установлены!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private int chw18[]={R.drawable.chw1, R.drawable.chw2, R.drawable.chw3, R.drawable.chw4,
                R.drawable.chw5, R.drawable.chw6, R.drawable.chw7, R.drawable.chw8, R.drawable.chw9,
                R.drawable.chw10 };
        private int imagesCount = chw18.length;

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return PageFragment.newInstance(chw18[i]);
        }

        @Override
        public int getCount() {
            return imagesCount;
        }



    }
}

