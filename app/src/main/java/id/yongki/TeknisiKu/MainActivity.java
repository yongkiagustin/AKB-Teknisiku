package id.yongki.TeknisiKu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.yongki.TeknisiKu.adapter.ViewpagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.main_indicator)
    CircleIndicator circleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //buat fragment
        //Setup ViewPager
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewpagerAdapter.addFragment(new PagerFragment());
        viewpagerAdapter.addFragment(new PagerFragment2());
        viewpagerAdapter.addFragment(new PagerFragment3());
        viewPager.setAdapter(viewpagerAdapter);

        //setup Indicator
        circleIndicator.setViewPager(viewPager);
        viewpagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());


    }
}
