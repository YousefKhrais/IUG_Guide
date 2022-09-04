package com.yousef.iugguide.ui.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yousef.iugguide.R;
import com.yousef.iugguide.adapters.HomeAdapter;
import com.yousef.iugguide.databinding.FragmentHomeBinding;
import com.yousef.iugguide.models.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {
    FloatingActionButton mainFab, instagramFab, facebookFab, twitterFab, telegramFab, youtubeFab, gmailFab;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView dataList = binding.dataList;
        List<HomeItem> homeItems = new ArrayList<>();

        homeItems.add(new HomeItem("button_registration_guide", "دليل الالتحاق", R.drawable.ic_guide));
//        homeItems.add(new HomeItem("button_acceptance_key", "مفتاح القبول", R.drawable.ic_key));
        homeItems.add(new HomeItem("button_university_facilities", "مرافق الجامعة", R.drawable.ic_facilities));
        homeItems.add(new HomeItem("button_map", "تجول في الجامعة", R.drawable.ic_map));
        homeItems.add(new HomeItem("button_volunteer_work", "العمل التطوعي", R.drawable.ic_volunteer));
        homeItems.add(new HomeItem("button_faq", "أسئلة شائعة", R.drawable.ic_faq3));
        homeItems.add(new HomeItem("button_about_iug", "عن الجامعة", R.drawable.ic_faq1));

        //Web-based
        homeItems.add(new HomeItem("button_student_services", "خدمات الطالب", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_library", "المكتبة المركزية", R.drawable.ic_library2));
        homeItems.add(new HomeItem("button_alumni_affairs", "شؤون الخريجين", R.drawable.ic_graduate3));
        homeItems.add(new HomeItem("button_complaints_box", "صندوق فضفضة", R.drawable.ic_complaints_box));
        homeItems.add(new HomeItem("button_business_incubator", "حاضنة الاعمال", R.drawable.ic_business_incubator));
        homeItems.add(new HomeItem("button_events", "الفعاليات", R.drawable.ic_events));
        homeItems.add(new HomeItem("button_announcements", "الاعلانات", R.drawable.ic_announcement));
        homeItems.add(new HomeItem("button_moodle", "مودل", R.drawable.ic_moodle));
        homeItems.add(new HomeItem("button_scholarships", "المنح الدراسية", R.drawable.ic_scholarships));
        homeItems.add(new HomeItem("button_admission_application", "طلب الالتحاق", R.drawable.ic_admission_application));
        homeItems.add(new HomeItem("button_university_website", "موقع الجامعة", R.drawable.ic_website));

        homeItems.add(new HomeItem("button_about_us", "تواصل معنا", R.drawable.ic_headphone));
        homeItems.add(new HomeItem("button_about_us", "انترنت الجامعة", R.drawable.ic_wifi));
        homeItems.add(new HomeItem("button_about_us", "عن التطبيق", R.drawable.ic_info));

        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), homeItems, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(homeAdapter);

        mainFab = binding.mainFab;
        instagramFab = binding.instagramFab;
        facebookFab = binding.facebookFab;
        twitterFab = binding.twitterFab;
        telegramFab = binding.telegramFab;
        youtubeFab = binding.youtubeFab;
        gmailFab = binding.gmailFab;
        ////animation
        fabOpen = AnimationUtils.loadAnimation(this.getContext(), R.anim.tap_open);
        fabClose = AnimationUtils.loadAnimation(this.getContext(), R.anim.tap_close);
        rotateBackward = AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_backwawrd);
        rotateForward = AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_forward);
        mainFab.setOnClickListener(v -> {

            animateFab();
        });

        instagramFab.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.instagram.com/iugaza.ps");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/iugaza.ps")));
            }
        });
        facebookFab.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/IUGAZA"));
            startActivity(intent);
        });
        twitterFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/iugaza"));
            startActivity(intent);
        });
        telegramFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/iugaza1"));
            startActivity(intent);
        });
        gmailFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:http://public@iugaza.edu.ps"));
            startActivity(intent);
        });
        youtubeFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/mediaiug/featured"));
            startActivity(intent);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void openRegistrationGuide() {
        Intent intent = new Intent(getActivity(), RegistrationGuide.class);
        getActivity().startActivity(intent);
    }

    private void openVolunteerWorkGuide() {
        VolunteerWorkBottomSheetDialog volunteerWorkBottomSheetDialog = new VolunteerWorkBottomSheetDialog();
        volunteerWorkBottomSheetDialog.setCancelable(true);
        volunteerWorkBottomSheetDialog.show(getChildFragmentManager(), "volunteerWorkBottomSheetDialog");
    }

    private void openAcceptanceKeyPage() {
        Intent intent = new Intent(getActivity(), AcceptanceKeys.class);
        getActivity().startActivity(intent);
    }

    private void openAboutIUGPage() {
        AboutIUGBottomSheetDialog aboutIUGBottomSheetDialog = new AboutIUGBottomSheetDialog();
        aboutIUGBottomSheetDialog.setCancelable(true);
        aboutIUGBottomSheetDialog.show(getChildFragmentManager(), "aboutIUGBottomSheetDialog");
    }

    private void openAboutUsPage() {
        AboutUsBottomSheetDialog aboutUsBottomSheetDialog = new AboutUsBottomSheetDialog();
        aboutUsBottomSheetDialog.setCancelable(true);
        aboutUsBottomSheetDialog.show(getChildFragmentManager(), "aboutUsBottomSheetDialog");
    }

    private void openFAQPage() {
        FaqBottomSheetDialog faqBottomSheetDialog = new FaqBottomSheetDialog();
        faqBottomSheetDialog.setCancelable(true);
        faqBottomSheetDialog.show(getChildFragmentManager(), "faqBottomSheetDialog");
    }

    private void openWebPageFromUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        switch ((String) view.getTag()) {
            case "button_registration_guide":
                openRegistrationGuide();
                break;

            case "button_acceptance_key":
                openAcceptanceKeyPage();
                break;

            case "button_university_facilities":
                System.out.println("button_university_facilities");
                break;

            case "button_map":
                System.out.println("button_map");
                break;

            case "button_volunteer_work":
                openVolunteerWorkGuide();
                break;

            case "button_faq":
                openFAQPage();
                break;

            case "button_about_iug":
                openAboutIUGPage();
                break;

            case "button_about_us":
                openAboutUsPage();
                break;

            case "button_moodle":
                openWebPageFromUrl("https://moodle.iugaza.edu.ps");
                break;

            case "button_university_website":
                openWebPageFromUrl("http://iugaza.edu.ps");
                break;

            case "button_admission_application":
                openWebPageFromUrl("https://eportal.iugaza.edu.ps/ords/f?p=142:LOGIN:12002841936534:::::");
                break;

            case "button_complaints_box":
                openWebPageFromUrl("https://qdev.iugaza.edu.ps/%D8%A5%D9%86%D8%AC%D8%A7%D8%B2%D8%A7%D8%AA-%D8%A7%D9%84%D8%B9%D9%85%D8%A7%D8%AF%D8%A9/%D8%B6%D9%85%D8%A7%D9%86-%D8%A7%D9%84%D8%AC%D9%88%D8%AF%D8%A9/%D8%B5%D9%86%D8%AF%D9%88%D9%82-%D8%A7%D9%84%D8%B4%D9%83%D8%A7%D9%88%D9%89-%D9%88%D8%A7%D9%84%D8%A7%D9%82%D8%AA%D8%B1%D8%A7%D8%AD%D8%A7%D8%AA");
                break;

            case "button_student_services":
                openWebPageFromUrl("https://idp.iugaza.edu.ps/idp/login.jsp");
                break;

            case "button_business_incubator":
                openWebPageFromUrl("https://bti.ps/");
                break;

            case "button_alumni_affairs":
                openWebPageFromUrl("http://gportal.iugaza.edu.ps/login.aspx");
                break;

            case "button_library":
                openWebPageFromUrl("https://library.iugaza.edu.ps");
                break;

            case "button_scholarships":
                openWebPageFromUrl("https://www.iugaza.edu.ps/%d9%85%d9%86%d8%ad-%d8%a7%d9%84%d8%ac%d8%a7%d9%85%d8%b9%d8%a9");
                break;

            case "button_events":
                openWebPageFromUrl("https://www.iugaza.edu.ps/%d8%a7%d9%84%d9%81%d8%b9%d8%a7%d9%84%d9%8a%d8%a7%d8%aa");
                break;

            case "button_announcements":
                openWebPageFromUrl("https://www.iugaza.edu.ps/e3lan");
                break;
        }
    }

    private void animateFab() {
        if (isOpen) {
            mainFab.startAnimation(rotateBackward);
            instagramFab.startAnimation(fabClose);
            facebookFab.startAnimation(fabClose);
            twitterFab.startAnimation(fabClose);
            telegramFab.startAnimation(fabClose);
            youtubeFab.startAnimation(fabClose);
            gmailFab.startAnimation(fabClose);
            instagramFab.setClickable(false);
            facebookFab.setClickable(false);
            twitterFab.setClickable(false);
            telegramFab.setClickable(false);
            youtubeFab.setClickable(false);
            gmailFab.setClickable(false);
            isOpen = false;
        } else {
            mainFab.startAnimation(rotateForward);
            instagramFab.startAnimation(fabOpen);
            facebookFab.startAnimation(fabOpen);
            twitterFab.startAnimation(fabOpen);
            telegramFab.startAnimation(fabOpen);
            youtubeFab.startAnimation(fabOpen);
            gmailFab.startAnimation(fabOpen);
            instagramFab.setClickable(true);
            facebookFab.setClickable(true);
            twitterFab.setClickable(true);
            telegramFab.setClickable(true);
            youtubeFab.setClickable(true);
            gmailFab.setClickable(true);
            isOpen = true;
        }
    }
}