package com.yousef.iugguide.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.R;
import com.yousef.iugguide.adapters.HomeAdapter;
import com.yousef.iugguide.databinding.FragmentHomeBinding;
import com.yousef.iugguide.models.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    private RecyclerView dataList;
    private HomeAdapter homeAdapter;
    private List<HomeItem> homeItems;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        super.onCreate(savedInstanceState);
        dataList = binding.dataList;

        homeItems = new ArrayList<>();

        homeItems.add(new HomeItem("button_university_facilities", "مرافق الجامعة", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_complaints_box", "صندوق فضفضة", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_student_services", "خدمات الطالب", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_business_incubator", "حاضنة الاعمال", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_alumni_affairs", "شؤون الخريجين", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_library", "المكتبة", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_map", "تجول في الجامعة", R.drawable.ic_bachelor_icon));
        //reeeeeeeee
        homeItems.add(new HomeItem("button_registration_guide", "دليل التسجيل", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_acceptance_key", "مفتاح القبول", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_moodle", "مودل", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_university_website", "موقع الجامعة", R.drawable.ic_bachelor_icon));
        homeItems.add(new HomeItem("button_admission_application", "طلب الالتحاق", R.drawable.ic_bachelor_icon));

        homeAdapter = new HomeAdapter(getActivity(), homeItems, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(homeAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        System.out.println("onclick: " + view.getId());
        System.out.println("tag: " + view.getTag());
        switch ((String) view.getTag()) {
            case "button_registration_guide":
                Intent intent = new Intent(getActivity(), RegistrationGuide.class);
                getActivity().startActivity(intent);
                break;
            case "button_acceptance_key":
                intent = new Intent(getActivity(), AcceptanceKeys.class);
                getActivity().startActivity(intent);
                break;
            case "button_moodle":
                String url = "https://moodle.iugaza.edu.ps";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case "button_university_website":
                url = "http://iugaza.edu.ps";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case "button_admission_application":
                url = "https://eportal.iugaza.edu.ps/ords/f?p=142:LOGIN:12002841936534:::::";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            //reeeee
            case "button_university_facilities":
                System.out.println("button_university_facilities");
                break;
            case "button_complaints_box":
                System.out.println("button_complaints_box");
                break;
            case "button_student_services":
                System.out.println("button_student_services");
                break;
            case "button_business_incubator":
                System.out.println("button_business_incubator");
                break;
            case "button_alumni_affairs":
                System.out.println("button_alumni_affairs");
                break;
            case "button_library":
                System.out.println("button_library");
                break;
            case "button_map":
                System.out.println("button_map");
                break;
        }
    }
}