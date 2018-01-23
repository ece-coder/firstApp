package com.example.jibong.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;





import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;


public class MainActivity extends AppCompatActivity {

    AppComponent appComponent;

    private ViewPager mViewPager;

    private PagerAdapter mPagerAdapter;


    @Inject
    DataManager dataManager;

    @BindView(R.id.profile_image)
    ImageView profileImage;

    @BindView(R.id.profile)
    CardView profileButton;

    @BindView(R.id.review)
    CardView reviewButton;

    @BindView(R.id.txtName)
    TextView profileName;

    @BindView(R.id.txtNameSmall)
    TextView nickName;

    @BindView(R.id.review_btn_label)
    TextView reviewBntLabel;

    @BindView(R.id.profile_btn_label)
    TextView profleBtnLabel;

    @BindView(R.id.btn_review_bg)
    FrameLayout reviewBg;

    @BindView(R.id.btn_profile_bg)
    FrameLayout profileBg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        mViewPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        setOnPageChangeListenerFor(mViewPager);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);


        dataManager.doNothing();


        Iconify.with(new MaterialCommunityModule())
                .with(new IconFontDescriptor() {
                    @Override
                    public String ttfFileName() { return "sampleIcons/sampleIcons.ttf";
                    }

                    @Override
                    public Icon[] characters() { return  AppFontIcons.values();
                    }
                });


        initPages();

        sampleAPI();

    }

    ProfileFragment pf;
    ReviewFragment rf;
    private void initPages(){
        pf =  new ProfileFragment();
        rf =  new ReviewFragment();
    }


    private void clickProfile(){
        int whiteColor = 0xffffffff;
        int blueColor = 0xff0099cc;


        reviewBntLabel.setTextColor(blueColor);
        reviewBg.setBackgroundColor(whiteColor);

        profileBg.setBackgroundColor(blueColor);
        profleBtnLabel.setTextColor(whiteColor);
    }

    private void clickReview(){

        int whiteColor = 0xffffffff;
        int blueColor = 0xff0099cc;


        reviewBntLabel.setTextColor(whiteColor);
        reviewBg.setBackgroundColor(blueColor);

        profileBg.setBackgroundColor(whiteColor);
        profleBtnLabel.setTextColor(blueColor);

    }


    @OnClick(R.id.review)
    void changeToReviewTab(){
        clickReview();
        mViewPager.setCurrentItem(1);

    }

    @OnClick(R.id.profile)
    void changeToProfileTab(){
        clickProfile();
        mViewPager.setCurrentItem(0);
    }

    @OnClick(R.id.membership)
    void clickMembershipButton(){
        Log.e("EXTRAS", "clicked membership button");
        dataManager.doNothing();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                return pf;
            }else{
                return rf;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


    private void setOnPageChangeListenerFor(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0){
                    clickProfile();
                }else{
                    clickReview();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private CompositeSubscription mSubscriptions;
    private Profile mProfile;
    Subscription subscription;

    private void sampleAPI(){


        subscription = dataManager.getProfile("null")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getEventSubscriber(mProfile));

//        mSubscriptions.add(dataManager.getProfile("dummy")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(getEventSubscriber(mProfile))
//        );
    }


    private Subscriber<Profile> getEventSubscriber(Profile sample) {
        Subscriber<Profile> mSubscribe = new Subscriber<Profile>() {
            @Override
            public void onCompleted() {
                Log.e("EXTRAS", "completed");
            }

            @Override
            public void onError(Throwable e) {
                // Show error
                Log.e("EXTRAS", "error");
            }

            @Override
            public void onNext(Profile response) {

                Log.e("EXTRAS", "successful");
            }
            };

            return  mSubscribe;
    }



}


