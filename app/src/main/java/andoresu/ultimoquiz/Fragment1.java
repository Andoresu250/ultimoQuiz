package andoresu.ultimoquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import andoresu.ultimoquiz.eventBus.MessageData;

public class Fragment1 extends Fragment {

    ListView listView;

    public Fragment1() {

    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        listView = (ListView) v.findViewById(R.id.listView);
        StudentAdapter studentAdapter = new StudentAdapter(getActivity().getApplicationContext(),Student.getAll());
        listView.setAdapter(studentAdapter);

        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageData event){
        System.out.println(">>>> " + event.getFullname());
        Student student = new Student(event.name, event.lastName);
        student.save();
        StudentAdapter studentAdapter = new StudentAdapter(getActivity().getApplicationContext(),Student.getAll());
        listView.setAdapter(studentAdapter);
        //Agregar a base de datos
    }
}
